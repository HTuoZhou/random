package com.htuozhou.random.business.service.cache.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.htuozhou.random.business.bo.UserBO;
import com.htuozhou.random.business.service.cache.IUserCacheService;
import com.htuozhou.random.persistence.po.UserPO;
import com.htuozhou.random.persistence.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hanzai
 * @date 2023/2/3
 */
@Service
@Slf4j
public class UserCacheServiceImpl implements IUserCacheService {

    @Autowired
    private IUserService userService;

    @Override
    @Cacheable(cacheNames = {"user::list"})
    public List<UserBO> list() {
        log.info("获取所有用户信息并放入缓存");
        List<UserPO> pos = userService.list(Wrappers.emptyWrapper());
        if (CollUtil.isEmpty(pos)) {
            return Collections.emptyList();
        }

        return pos.stream().map(UserBO::po2bo).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(cacheNames = {"user::list"})
    public void listEvict() {
        log.info("从缓存删除所有用户信息");
    }

}
