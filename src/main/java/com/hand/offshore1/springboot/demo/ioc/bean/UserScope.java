package com.hand.offshore1.springboot.demo.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserScope {
    @Value("hand8")//这个是为了测试@Autowired加的
    private String name;
}
