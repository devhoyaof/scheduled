package com.thread.scheduled.scheduler;

import com.thread.scheduled.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GMScheduled {
    private final SchedulerService schedulerService;

    @Scheduled(cron = "${cron}")
    public void execute() {
        log.info("========== w SEND START ==========");

        schedulerService.execute();

        log.info("========== w SEND END ==========");
    }
}
