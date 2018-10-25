package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("f_user")
public class User {
    private Long id;
    @TableField("name")
    private String userName;
    private Integer age;
    private String email;
}
