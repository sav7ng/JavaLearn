package gitbub.aquanlerou.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Class ScheduledTasks
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.14 17:53
 * @Version 1.0
 * Created by fangzhipeng on 2017/4/19.
 *  @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * @Scheduled(cron="  /5   ") ：通过cron表达式定义规则
 */

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    // @Scheduled(fixedRate = 5000)
    @Scheduled(cron="0/10 * * * * *")
    public void reportCurrentTime() { log.info("你调动了，时间为 {}", dataFormat.format(new Date())); }
}
