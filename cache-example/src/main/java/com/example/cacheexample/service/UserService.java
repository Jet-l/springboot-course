package com.example.cacheexample.service;

import com.example.cacheexample.entity.User;
import com.example.cacheexample.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Cacheable(value = "user",key = "#uid")
    public User getUser(long uid){
        User user = userMapper.getUser(uid);
        log.debug("called UserService getUser(), name: {}",user.getName());
        return user;
    }

    @Cacheable(value = "users")
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @CachePut(value = "user", key = "#user.id")
    // 以键值对缓存一个集合对象时，缓存对象是一个整体。无法修改其中某一个元素
    // 因此清空整个集合缓存
    @CacheEvict(value = "users", allEntries = true)
    public User updateUser(User user) {
        User u = userMapper.updateUser(user);
        log.debug("updateUser(), user: {}", u);
        return user;
    }

    @CacheEvict(value = "user", key = "#uid")
    public void delUser(long uid) {
        // 从缓存删除，没有调用模拟的持久层删除
        // 因此会实际调用getUser()方法，重新从持久层获取
    }

}
