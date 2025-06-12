package cn.cjxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private String addr;
    private Double salary;
    private Integer dept_id;

    private Dept dept;
}