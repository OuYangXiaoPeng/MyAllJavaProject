package cn.cjxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dept {
    private Integer id;
    private String name;
    private String location;
    private List<Emp> empList;
}
