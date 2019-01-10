package com.wangxj.config;

import com.wangxj.entity.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

@Configurable
public class MainConfig2 {
    @Bean("person")
//    @Scope("singleton")
    /**
     * prototype:多实例
     * singleton：单实例--ioc容器启动会调用方法创建对象到IOC容器中,以后每次直接从容器中拿取
     * request：同一次请求创建一次实例
     * session:同一个session创建一个实例
     *
     * 懒加载：
     *          单实例容器默认启动时就创建对象
     *          懒加载：容器启动时不创建对象，第一次使用bean时再创建对象，并初始化
     *
     */
    @Lazy
    public Person person() {
        System.out.println("往容器中添加了Person-------------************-----------");
        return new Person("张三", 26);
    }

    /**
     * @Conditional 满足条件给容器中注册Bean
     */
    @Bean("windows")
    public Person person01() {
        System.out.println("往容器中添加了Person-------------************-----------");
        return new Person("比尔盖茨", 62);
    }

    @Bean("linux")
    public Person person02() {
        System.out.println("往容器中添加了Person-------------************-----------");
        return new Person("linux", 61);
    }
}