package cn.cjxy.userManageMent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
 private Integer   id;
 private String   username;
 private String   password;
 //日期格式化
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
 private Date  birthday;
 private String   address;

}
