package com.github.example.service.impl;

import com.github.example.entity.SysUser;
import com.github.example.mapper.SysUserMapper;
import com.github.example.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sorata
 * @since 2020-08-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
