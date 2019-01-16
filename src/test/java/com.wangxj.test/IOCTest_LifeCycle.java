package com.wangxj.test;

import com.wangxj.config.MainConfigOfLifeCycle;
import com.wangxj.entity.Car;
import com.wangxj.entity.Cat;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    /**
     * bean 的生命周期的测试
     */
    public void test01(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成、、、、、、、、、");
        //applicationContext.getBean(Car.class);
        //关闭容器
        applicationContext.close();
    }


}
