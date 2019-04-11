package com.minitoring.mapper;
import java.util.List;

import com.minitoring.pojo.User;
public interface Mapper { //定义Mapper接口

    // 查所有对象
    List<User> listAllUser();

}
