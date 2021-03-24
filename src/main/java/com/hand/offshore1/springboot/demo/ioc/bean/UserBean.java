package com.hand.offshore1.springboot.demo.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

//这里没有用@Component之类的注解，所以这个类本身不会被加载到Spring容器中
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    @Value("hand9999")//这是为了测试带参数的@Bean方法中参数的注入加的
    private String name;
}
