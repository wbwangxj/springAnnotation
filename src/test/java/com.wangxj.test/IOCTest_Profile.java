package com.wangxj.test;

import com.wangxj.config.MainConfigOfProfile;
import com.wangxj.entity.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {
    @Test
    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        //applicationContext.getEnvironment().setActiveProfiles("prod");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();
        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println("注入Spring容器中的Bean："+string);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();
    }
}
