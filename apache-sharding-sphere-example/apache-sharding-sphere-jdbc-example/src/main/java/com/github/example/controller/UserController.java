package com.github.example.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.example.entity.SysUser;
import com.github.example.service.ISysUserService;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author sorata 2020-08-28:15:33
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private ISysUserService sysUserService;


    @GetMapping
    public List<SysUser> user(@RequestParam String name){
        final List<SysUser> users = sysUserService.list(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, name));
        if (users != null && !users.isEmpty()){
            return users;
        }
        final long aLong = new Random().nextInt(99999);
        final String salt = Long.toHexString(aLong);
        final SysUser sysUser = new SysUser().setUsername(name).setPassword(md5(name + "1223" + salt)).setPwdSalt(salt).setCreated(new Date());
        sysUserService.save(sysUser);
        return Collections.singletonList(sysUser);
    }


    private static String md5(String str){

        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            digest.update(str.getBytes());
            return HexUtils.toHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }



}
