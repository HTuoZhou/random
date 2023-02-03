package com.htuozhou.random.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.htuozhou.random.business.bo.UserBO;
import com.htuozhou.random.common.page.PageReq;

import java.util.List;

/**
 * @author hanzai
 * @date 2023/2/2
 */
public interface IWebApiUserService {

    /**
     * 添加用户信息
     * @param bo
     * @return
     */
    String add(UserBO bo);

    /**
     * 批量添加用户信息
     * @param bos
     * @return
     */
    String addBatch(List<UserBO> bos);

    /**
     * 修改用户信息
     * @param bo
     * @return
     */
    String update(UserBO bo);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    String delete(Integer id);

    /**
     * 获取所有用户信息
     * @param bo
     * @return
     */
    List<UserBO> list(UserBO bo);

    /**
     * 分页查询所有用户信息
     * @param pageReq
     * @return
     */
    IPage<UserBO> page(PageReq<UserBO> pageReq);

}
