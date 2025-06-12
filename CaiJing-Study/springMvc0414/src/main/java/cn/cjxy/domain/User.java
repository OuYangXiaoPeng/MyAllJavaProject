package cn.cjxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
    private int age;

    //转换成json的时候忽略掉属性
    @JsonIgnore
    private String email;

    //    生日2000-02-03
    @JsonFormat(pattern = "yyyy-MM-dd")//将Data按照指定的格式转换为字符串
    private Date birthday;

    public User(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
