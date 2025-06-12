package cn.cjxy.pojo;

import cn.cjxy.domain.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCondition {
    private Emp emp;
    private long start;
    private long end;
}
