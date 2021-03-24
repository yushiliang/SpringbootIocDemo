package com.hand.offshore1.springboot.demo.ioc.configuration;

import com.hand.offshore1.springboot.demo.ioc.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//申明这是一个配置类
public class MyConfiguration {

    @Bean//通过配置类的方法+@Bean注解，来将实例加载进Spring容器
    public UserBean userBean(){
        return new UserBean();
    }
    @Bean
    public UserBean userBean2(UserBean userBean){
        System.out.println(userBean.getName());
        return userBean;
    }
}
