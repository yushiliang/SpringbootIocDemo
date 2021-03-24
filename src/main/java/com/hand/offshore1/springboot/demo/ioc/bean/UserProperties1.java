package com.hand.offshore1.springboot.demo.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProperties1 {
    @Value("${userproperties1.name}")//默认可以读取application.properties或者application.yml文件中的属性
    private String name;
}
