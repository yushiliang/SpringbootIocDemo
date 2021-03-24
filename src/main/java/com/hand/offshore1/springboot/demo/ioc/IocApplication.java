package com.hand.offshore1.springboot.demo.ioc;

import com.hand.offshore1.springboot.demo.ioc.bean.*;
import com.hand.offshore1.springboot.demo.ioc.util.UserUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(IocApplication.class, args);
        //@Component
        System.out.println("单例组件示例");
        //组件被加载进Spring容器后，从容器中获取组件使用，而不是通过new
        //通过名字获取bean，默认是类的名字首字母小写
        UserComponent userComponent1 = (UserComponent)ctx.getBean("userComponent");
        //也可以通过类型匹配来获取bean
        UserComponent userComponent2 = (UserComponent)ctx.getBean(UserComponent.class);
        userComponent2.setName("hand");
        //因为默认是单例，每次拿到的都是同一个实例，所以打印出来的值和通过名称匹配拿到的是一样的
        System.out.println(userComponent1.getName());
        System.out.println(userComponent2.getName());
        //@Scope
        System.out.println("多例组件示例");
        UserScope userScope1 = (UserScope)ctx.getBean("userScope");
        userScope1.setName("hand1");
        UserScope userScope2 = (UserScope)ctx.getBean(UserScope.class);
        userScope2.setName("hand2");
        //因为@Scope指定了prototype，所以每次从容器中获取到的都是新的实例，所以打印值就不一样了
        System.out.println(userScope1.getName());
        System.out.println(userScope2.getName());
        //@Bean
        System.out.println("获取通过配置类中的@Bean方法加载进容器的实例");
        UserBean userBean = (UserBean)ctx.getBean("userBean");
        userBean.setName("hand3");
        System.out.println(userBean.getName());
        //@Value
        System.out.println("通过@Value注解给bean的属性做初始化赋值");
        UserValue userValue = (UserValue)ctx.getBean("userValue");
        System.out.println(userValue.getName());
        System.out.println("通过application.properties或者application.yml文件中的属性来给bean的属性赋值");
        UserProperties1 userProperties1 = (UserProperties1)ctx.getBean("userProperties1");
        System.out.println(userProperties1.getName());
        //@PropertySource
        System.out.println("通过其他properties文件中的属性来给bean的属性赋值");
        UserProperties2 userProperties2 = (UserProperties2)ctx.getBean("userProperties2");
        System.out.println(userProperties2.getName());
        //@ConfigurationProperties
        System.out.println("通过其他properties文件中的属性来给bean的属性赋值(使用@ConfigurationProperties设置前缀)");
        UserProperties3 userProperties3 = (UserProperties3)ctx.getBean("userProperties3");
        System.out.println(userProperties3.getName());
        //@Autowired
        System.out.println("使用@Autowired来处理bean与bean之间的相互依赖,请直接看UserUtil类的源代码以及上面的打印记录");
        UserUtil userUtil = (UserUtil)ctx.getBean("userUtil");
        //@Resource
        System.out.println("使用@Resource来自动注入");
        userUtil.printUserScope();
    }

}
