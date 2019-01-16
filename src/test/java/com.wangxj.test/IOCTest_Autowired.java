package com.wangxj.test;

import com.wangxj.config.MainConfigOfAutowired;
import com.wangxj.dao.BookDao;
import com.wangxj.entity.Boss;
import com.wangxj.entity.Car;
import com.wangxj.entity.Color;
import com.wangxj.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService);
//
//        BookDao bean = applicationContext.getBean(BookDao.class);
//        System.out.println(bean);

//        Boss boss = applicationContext.getBean(Boss.class);
//        System.out.println("容器boss中获取的car："+boss);
//        Car car = applicationContext.getBean(Car.class);
//        System.out.println("容器car:"+car);
//
//        Color color = applicationContext.getBean(Color.class);
//        System.out.println("容器Color中的car:"+color);
        System.out.println(applicationContext);

        applicationContext.close();



    }
}
