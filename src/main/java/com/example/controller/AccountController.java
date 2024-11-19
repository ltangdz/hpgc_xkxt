package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.service.AdminInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class AccountController {

    @Resource
    private AdminInfoService adminInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody Account user, HttpServletRequest request) {
        // 校验有没有数据
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "请完善输入信息");
        }

        Integer level = user.getLevel();
        Account loginUser = new Account();

        if (level == 1) {
            // 管理员登录
            loginUser = adminInfoService.login(user.getName(), user.getPassword());
        }
        if (level == 2) {
            // 教师登录
        }
        if (level == 3) {
            // 学生登录
        }

        // 在session里存一份用户信息
        request.getSession().setAttribute("user", loginUser);

        return Result.success(loginUser);
    }
}
