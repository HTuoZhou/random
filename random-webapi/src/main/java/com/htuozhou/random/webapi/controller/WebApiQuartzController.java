package com.htuozhou.random.webapi.controller;

import com.htuozhou.random.business.service.IWebApiQuartzService;
import com.htuozhou.random.common.aop.WebLog;
import com.htuozhou.random.common.result.ApiFinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanzai
 * @date 2023/2/17
 */
@RestController
@RequestMapping("/webapi/quartz")
public class WebApiQuartzController {

    @Autowired
    private IWebApiQuartzService webApiQuartzService;

    /**
     * 添加test2Job定时任务
     * @return
     */
    @GetMapping("/addTest2Job")
    @WebLog
    public ApiFinalResult<String> test2Job(){
        return ApiFinalResult.success(webApiQuartzService.addTest2Job());
    }

    /**
     * 删除test2Job定时任务
     * @return
     */
    @GetMapping("/deleteTest2Job")
    @WebLog
    public ApiFinalResult<String> deleteTest2Job(){
        return ApiFinalResult.success(webApiQuartzService.deleteTest2Job());
    }

}
