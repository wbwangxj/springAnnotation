package com.wangxj.test;

import com.wangxj.config.MainConfig;
import com.wangxj.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
        System.out.println("---------************************-------------------");
       String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:namesForType
             ) {
            System.out.println(name);
        }
        System.out.println("---------************************-------------------");
    }


}
