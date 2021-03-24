package com.hand.offshore1.springboot.demo.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinitions;

@Component//申明这是一个组件，会被加载到Spring容器中
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComponent {
    private String name;
}
