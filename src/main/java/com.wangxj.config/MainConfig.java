package com.wangxj.config;

import com.wangxj.entity.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configurable
@ComponentScan(value = "com.wangxj",useDefaultFilters =false,includeFilters = {
        //@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class})
        @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MyTypeFilter.class})
         })
public class MainConfig {
    @Bean("person")
    public Person person(){
        return new Person("李四",20);
    }
}
