package com.example.springbootbasis.mapper;

import com.example.springbootbasis.component.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    public User query(Long id);
    public void save(User user);

    @Select("select * from user where username = #{userName}")
    public List<User> queryInfoByName(String userName);
}
