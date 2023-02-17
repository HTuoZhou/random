package com.htuozhou.random.business.service.impl;

import com.htuozhou.random.business.constant.QuartzJobConstant;
import com.htuozhou.random.business.quartz.manual.Test2Job;
import com.htuozhou.random.business.service.IWebApiQuartzService;
import com.htuozhou.random.common.quartz.QuartzManager;
import com.htuozhou.random.common.quartz.SimpleJobModel;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanzai
 * @date 2023/2/17
 */
@Service
@Slf4j
public class IWebApiQuartzServiceImpl implements IWebApiQuartzService {

    @Autowired
    private QuartzManager quartzManager;

    /**
     * 开启test2Job定时任务
     * @return
     */
    @Override
    public String test2Job() {
        SimpleJobModel<Test2Job> simpleJobModel = new SimpleJobModel<>();
        simpleJobModel.setJobCls(Test2Job.class);
        simpleJobModel.setJobGroup(QuartzJobConstant.TEST2_GROUP);
        simpleJobModel.setJobName(QuartzJobConstant.TEST2_JOB);
        simpleJobModel.setJobDataMap(new JobDataMap());
        simpleJobModel.setFrequency(QuartzJobConstant.TEST2_INTERVAL);

        quartzManager.addJob(simpleJobModel);
        return "开启test2Job定时任务成功";
    }
}