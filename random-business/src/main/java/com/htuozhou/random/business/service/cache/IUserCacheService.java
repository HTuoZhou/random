package com.htuozhou.random.business.service.cache;


import com.htuozhou.random.business.bo.UserBO;

import java.util.List;

/**
 * @author hanzai
 * @date 2023/2/3
 */
public interface IUserCacheService {

    List<UserBO> list();

    void listEvict();

}
