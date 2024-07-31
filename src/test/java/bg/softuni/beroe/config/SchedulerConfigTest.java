//package bg.softuni.beroe.config;
//
//import bg.softuni.beroe.service.FanService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.util.concurrent.ScheduledFuture;
//
//@Configuration
//@EnableScheduling
//public class SchedulerConfig implements SchedulingConfigurer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);
//    private final FanService fanService;
//    private String cronExpression = "*/10 * * * * *"; // Default cron expression
//    private ScheduledFuture<?> scheduledFuture;
//    private final ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//
//    public SchedulerConfig(FanService fanService) {
//        this.fanService = fanService;
//        this.taskScheduler.initialize();
//    }
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        scheduleTask(cronExpression);
//    }
//
//    public void scheduleTask(String cronExpression) {
//        stopScheduledTask(); // Stop the previous task if any
//        scheduledFuture = taskScheduler.schedule(this::executeScheduledTask, new CronTrigger(cronExpression));
//    }
//
//    private void executeScheduledTask() {
//        LOGGER.info("Executing scheduled task...");
//        fanService.updateAllFanPrices(); // Update fan prices
//        LOGGER.info("Fan prices updated.");
//    }
//
//    public void setCronExpression(String cronExpression) {
//        this.cronExpression = cronExpression;
//        scheduleTask(cronExpression); // Reschedule with the new expression
//    }
//
//    public void stopScheduledTask() {
//        if (scheduledFuture != null) {
//            scheduledFuture.cancel(false); // Cancel the current task
//            LOGGER.info("Scheduled task stopped.");
//        }
//    }
//}
