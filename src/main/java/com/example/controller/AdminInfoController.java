package com.example.controller;

import com.example.service.AdminInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;
}
