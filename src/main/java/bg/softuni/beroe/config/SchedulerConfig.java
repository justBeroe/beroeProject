package bg.softuni.beroe.config;

import bg.softuni.beroe.service.FanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.scheduling.annotation.SchedulingConfigurer;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ScheduledFuture;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    private final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);
    private final FanService fanService;
    private String cronExpression = "*/10 * * * * *"; // Default cron expression
   // private String cronExpression = "0 0 * * * *"; // Default cron expression
    private ScheduledFuture<?> scheduledFuture;
    private ThreadPoolTaskScheduler taskScheduler;

    public SchedulerConfig(FanService fanService) {
        this.fanService = fanService;
        this.taskScheduler = new ThreadPoolTaskScheduler();
        this.taskScheduler.initialize();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        scheduleTask(cronExpression);
    }

    public void scheduleTask(String cronExpression) {
        stopScheduledTask(); // Stop existing task

        // Schedule the new task
        scheduledFuture = taskScheduler.schedule(this::executeScheduledTask, new CronTrigger(cronExpression));
    }

    public void executeScheduledTask() {
        LOGGER.info("Cron time check!!!");

        // Update the Fan item price every 10 seconds by 1. Bonus
        fanService.updateAllFanPrices();
        LOGGER.info("Price was updated wih 1!");
        //Ideas
        // Price Updates
        // Sales and Promotions [for example twice a day]
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
        scheduleTask(cronExpression); // Reschedule with new expression
    }

    public void stopScheduledTask() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false); // Cancel the current task
            System.out.println("Scheduled task stopped.");
        }
    }
}



