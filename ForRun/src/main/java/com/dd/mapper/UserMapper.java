package com.dd.mapper;
import com.dd.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    //通过id得到user
    User getUserById(@Param("uid")Integer uid);
    //通过name得到user
    User getUserByName(@Param("name")String name);
    //插入一个用户
    int insertUser(User user);
}
