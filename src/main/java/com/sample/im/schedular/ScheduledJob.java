package com.sample.im.schedular;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.sample.im.common.Metrics;

public class ScheduledJob {

    private static final Logger log = LoggerFactory.getLogger(ScheduledJob.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
	Metrics metrics;
    
    @Scheduled(cron = "${jobs.cpu.cronSchedule}")
    public void saveCPUStatatic() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date())+": "+metrics.getBasicInfo());
    }
}