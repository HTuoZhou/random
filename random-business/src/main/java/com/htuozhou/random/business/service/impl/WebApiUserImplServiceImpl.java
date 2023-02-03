package com.htuozhou.random.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htuozhou.random.business.bo.UserBO;
import com.htuozhou.random.business.service.IWebApiUserService;
import com.htuozhou.random.business.service.cache.IUserCacheService;
import com.htuozhou.random.common.page.PageReq;
import com.htuozhou.random.persistence.po.UserPO;
import com.htuozhou.random.persistence.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author hanzai
 * @date 2023/2/2
 */
@Service
@Slf4j
public class WebApiUserImplServiceImpl implements IWebApiUserService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserCacheService userCacheService;

    /**
     * 添加用户信息
     * @param bo
     * @return
     */
    @Override
    public String add(UserBO bo) {
        boolean save = userService.save(bo.bo2po());
        if (save) {
            userCacheService.listEvict();
        }
        return "添加用户信息成功";
    }

    /**
     * 批量添加用户信息
     * @param bos
     * @return
     */
    @Override
    public String addBatch(List<UserBO> bos) {
        List<UserPO> pos = bos.stream().map(UserBO::bo2po).collect(Collectors.toList());
        boolean saveBatch = userService.saveBatch(pos);
        if (saveBatch) {
            userCacheService.listEvict();
        }
        return "批量添加用户信息成功";
    }

    /**
     * 修改用户信息
     * @param bo
     * @return
     */
    @Override
    public String update(UserBO bo) {
        boolean updateById = userService.updateById(bo.bo2po());
        if (updateById) {
            userCacheService.listEvict();
        }
        return "修改用户信息成功";
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public String delete(Integer id) {
        boolean removeById = userService.removeById(id);
        if (removeById) {
            userCacheService.listEvict();
        }
        return "删除用户信息成功";
    }

    /**
     * 获取所有用户信息
     * @param bo
     * @return
     */
    @Override
    public List<UserBO> list(UserBO bo) {
        String name = bo.getName();
        String nickname = bo.getNickname();

        List<UserBO> bos = userCacheService.list();
        if (StringUtils.isNotBlank(name)) {
            bos = bos.stream()
                    .filter((x) -> x.getName().contains(name))
                    .collect(Collectors.toList());
        }
        if (StringUtils.isNotBlank(nickname)) {
            bos = bos.stream()
                    .filter((x) -> x.getNickname().contains(nickname))
                    .collect(Collectors.toList());
        }

        return bos;
    }

    /**
     * 分页查询所有用户信息
     * @param pageReq
     * @return
     */
    @Override
    public IPage<UserBO> page(PageReq<UserBO> pageReq) {
        Integer pageNum = pageReq.getPageNum();
        Integer pageSize = pageReq.getPageSize();

        LambdaQueryWrapper<UserPO> wrapper = Wrappers.<UserPO>lambdaQuery();

        if (Objects.nonNull(pageReq.getQueryParam()) && StringUtils.isNotBlank(pageReq.getQueryParam().getName())) {
            wrapper.like(UserPO::getName,pageReq.getQueryParam().getName());
        }
        if (Objects.nonNull(pageReq.getQueryParam()) && StringUtils.isNotBlank(pageReq.getQueryParam().getNickname())) {
            wrapper.like(UserPO::getNickname,pageReq.getQueryParam().getNickname());
        }

        IPage<UserPO> page = userService.page(new Page<>(pageNum, pageSize), wrapper);
        return page.convert(UserBO::po2bo);
    }

}
