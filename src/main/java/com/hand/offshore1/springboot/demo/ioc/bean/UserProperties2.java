package com.hand.offshore1.springboot.demo.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:UserProperties2.properties")//引入其他properties文件，不能用于yml文件
public class UserProperties2 {
    @Value("${userproperties2.name}")
    private String name;
}
