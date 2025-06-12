package cn.cjxy.bean_propertie.after_handler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
//要使用后置处理器，要实现 BeanPostProcessor接口
//重写postProcessBeforeInitialization或postProcessAfterInitialization
public class MyProcess implements BeanPostProcessor {

    /*
    创建完对象后执行前置方法
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行了前置方法，类型为"+bean.getClass());
        return bean;
    }

    /*
    创建完对象后执行后置方法
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行了后置方法，类型为"+bean.getClass());
        return bean;
    }
}
