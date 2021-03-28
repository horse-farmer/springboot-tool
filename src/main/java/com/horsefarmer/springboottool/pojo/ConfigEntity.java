package com.horsefarmer.springboottool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/23 23:04
 */


@Component
@ConfigurationProperties(prefix = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigEntity {
    private String id;
    private Integer number;
    private String name;
    private Integer age;
    private Date birth;
    private List<String> interests;
}
