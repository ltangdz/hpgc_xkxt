package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminInfoService {
    @Resource
    private AdminInfoDao adminInfoDao;

    public Account login(String name, String password) {

        // 通过用户名和密码去数据库查一条记录
        AdminInfo adminInfo = adminInfoDao.findByNameAndPassword(name, password);

        if (ObjectUtil.isEmpty(adminInfo)) {
            throw new CustomException("1", "用户名，密码或角色错误");
        }

        return null;
    }
}
