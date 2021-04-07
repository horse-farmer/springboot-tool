package com.horsefarmer.springboottool;

import com.alibaba.fastjson.JSON;
import com.horsefarmer.springboottool.pojo.Bank;
import com.horsefarmer.springboottool.pojo.Message;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description ES 7.12.0 高级客户端测试API
 * @Author horse-farmer
 * @Date 2021/4/7 21:15
 */


@SpringBootTest
public class ESTest {


    /*@Qualifier注解的作用是指向bean中方法的名字，避免配置类初始化会注入最原始的bean*/
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;


    /*索引创建*/
    @Test
    public void createIndexTest() throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("horse_index");
        // 2、客户端执行请求
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    // 测试获取索引
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest index = new GetIndexRequest("horse_index");
        boolean exists = client.indices().exists(index, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest index = new DeleteIndexRequest("horse_index");
        AcknowledgedResponse delete = client.indices().delete(index, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    // 添加文档
    @Test
    public void testAddDoc() throws IOException {
        // 创建对象
        Bank bank = new Bank();
        bank.setAccountNumber(3243);
        bank.setBalance(2332);
        bank.setFirstname("Lebron");
        bank.setLastname("horse");
        bank.setAge(26);
        bank.setGender("M");
        bank.setAddress("成都市蒲江县哈哈镇");
        bank.setEmployer("coder");
        bank.setEmail("hpeng@gamil.com");
        bank.setCity("成都");
        bank.setState("四川");
        IndexRequest request = new IndexRequest("bank");

        /*规则*/
        request.id("123");
        /*请求超时时间，下面两种设置都可以*/
        request.timeout(TimeValue.timeValueSeconds(1));
        // request.timeout("1s");

        /*将我们的数据放入json*/
        request.source(JSON.toJSONString(bank), XContentType.JSON);

        /*客户端发送请求，获取响应结果*/
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println(response.toString());
        System.out.println(response.status()); // 对应命令返回的状态

    }

    // 获取文档，判断是否存在
    @Test
    public void testIsExists() throws IOException {
        GetRequest getRequest = new GetRequest("bank", "123");
        // 不获取返回的_source的上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }


    // 获取文档信息
    @Test
    public void testGetDoc() throws IOException {
        GetRequest getRequest = new GetRequest("bank", "123");

        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        /*获取文档信息：转成了字符串*/
        String horse = response.getSourceAsString();
        System.out.println(response);
        /*转java对象*/
        Bank bank = JSON.parseObject(horse, Bank.class);
        System.out.println(bank.getAddress());

    }

    // 更新文档
    @Test
    public void testUpdateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("bank", "123");
        updateRequest.timeout("1s");

        Bank bank = new Bank();
        /*想更新什么内容，就设置什么值*/
        bank.setAddress("台湾小岛");

        updateRequest.doc(JSON.toJSONString(bank), XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());
        System.out.println(updateResponse);

    }

    // 删除文档
    @Test
    public void testDeleteDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("bank", "123");
        deleteRequest.timeout("1s");

        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }

    // 真是项目中，通常需要批量插入数据！！！
    // 添加文档
    @Test
    public void testBlukAddDoc() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        List<Message> list = new ArrayList<>();
        list.add(new Message("hhh", "ok"));
        list.add(new Message("ggg", "no"));
        list.add(new Message("mmm", "ok"));
        list.add(new Message("yyy", "wa"));
        list.add(new Message("zzz", "kao"));
        list.add(new Message("qqq", "cao"));
        list.add(new Message("jjj", "mmp"));


        for (Message message : list) {
            bulkRequest.add(
                    new IndexRequest("test_message")
                            .source(JSON.toJSONString(message), XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        // 是否有失败
        System.out.println(bulkResponse.hasFailures());

    }

    // 查询
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("bank");
        // 构建搜索的条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // 查询条件，我们可以使用QueryBuilders工具类来快速匹配
        /*
        * QueryBuilders.termQuery() 精确匹配
        * QueryBuilders.matchQuery() 普通match匹配
        * QueryBuilders.matchAllQuery() 匹配所有
        * QueryBuilders.boolQuery() bool值匹配查询
        * QueryBuilders.rangeQuery() 范围查询
        * */

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", 22);
        builder.query(termQueryBuilder);
        /*设置分页*/
        // builder.from();
        // builder.size();
        builder.timeout(new TimeValue(1, TimeUnit.SECONDS));
        searchRequest.source(builder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search.getHits()));

        /*遍历*/
        System.out.println("+++++++++++++++++++++++");
        for (SearchHit documentFields : search.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsString());
        }
    }
}
