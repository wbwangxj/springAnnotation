package com.wangxj.test;

import com.wangxj.config.MainConfig;
import com.wangxj.config.MainConfig2;
import com.wangxj.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCtest {
    @Test
    public  void  test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names =  applicationContext.getBeanDefinitionNames();
        System.out.println("------------------------****************-------------------");
        for (String name:
                names) {
            System.out.println("------------------------**name*******-------------------");
            System.out.println(name);
        }

    }

    @Test
    public  void  test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] names =  applicationContext.getBeanDefinitionNames();
        System.out.println("------------------------****************-------------------");
        System.out.println("------ioc容器创建完成---------------------------");
//        for (String name:
//                names) {
//            System.out.println("------------------------**name*******-------------------");
//            System.out.println(name);
//        }
        Object bean =  applicationContext.getBean("person");
//        Object bean2 =  applicationContext.getBean("person");
//        System.out.println("第一次与第二次是否相等："+(bean==bean2));

    }

    @Test
    public  void  test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        ConfigurableEnvironment environment=applicationContext.getEnvironment();
//        String property = environment.getProperty("os.name");
        String[] namesForType = applicationContext.getBeanNamesForType(MainConfig2.class);
        for (String name:
                namesForType ) {
            System.out.println("---------------*****name****----------------------");
            System.out.println(name);
        }

        Map<String, Person> personMap =  applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);

    }
}
