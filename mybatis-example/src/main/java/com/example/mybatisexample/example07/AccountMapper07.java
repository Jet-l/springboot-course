package com.example.mybatisexample.example07;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisexample.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper07 extends BaseMapper<Account> {

}