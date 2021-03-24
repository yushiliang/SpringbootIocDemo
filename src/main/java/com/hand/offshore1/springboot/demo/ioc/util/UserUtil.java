package com.hand.offshore1.springboot.demo.ioc.util;

import com.hand.offshore1.springboot.demo.ioc.bean.UserComponent;
import com.hand.offshore1.springboot.demo.ioc.bean.UserScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Component
public class UserUtil {

    private UserComponent userComponent;
    //通过构造器+@Autowired给属性做初始化
    @Autowired
    public UserUtil(UserComponent userComponent){
        this.userComponent = userComponent;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    //加在方法上，会在这个bean装进容器的时候先执行一次该方法，并且对参数进行注入
    @Autowired
    public void printUserScope(UserScope userScope){
        System.out.println(userScope.getName());
        System.out.println("#############################################");
    }

    @Resource(name="userScope")//@Resource注解既可以指定bean名字，也可以指定bean类型
    private UserScope userScope1;
    @Resource(type=UserScope.class)//@Resource注解既可以指定bean名字，也可以指定bean类型
    private UserScope userScope2;

    public void printUserScope(){
        userScope1.setName("hand9");
        userScope2.setName("hand10");
        System.out.println(userScope1.getName());
        System.out.println(userScope2.getName());
    }
}
