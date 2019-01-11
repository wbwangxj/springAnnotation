package com.wangxj.config;

import com.wangxj.condition.LinuxConditon;
import com.wangxj.condition.MyImportBeanDefinitionRegistrar;
import com.wangxj.condition.MyImportSelector;
import com.wangxj.condition.WindowsCondition;
import com.wangxj.entity.Color;
import com.wangxj.entity.ColorFactoryBean;
import com.wangxj.entity.Person;
import com.wangxj.entity.Red;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

@Configurable
@Conditional(WindowsCondition.class)
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
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
    @Conditional(WindowsCondition.class)
    public Person person01() {
        System.out.println("往容器中添加了Person-------------************-----------");
        return new Person("比尔盖茨", 62);
    }

    @Bean("linux")
    @Conditional(LinuxConditon.class)
    public Person person02() {
        System.out.println("往容器中添加了Person-------------************-----------");
        return new Person("linux", 61);
    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }


}