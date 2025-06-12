package cn.cjxy.domain;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
public class Article {
    private Integer id;
    private String title;
    private String author;

    // 初始化方法
    @PostConstruct
    public void init() {
        System.out.println("Article Bean 初始化完成，执行 init 方法");
    }

    // 销毁方法
    @PreDestroy
    public void destroy() {
        System.out.println("Article Bean 即将销毁，执行 destroy 方法");
    }

}
