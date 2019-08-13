package com.company.project.configurer;

/**
 * @Class StepExecutorConfig
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.12 21:40
 * @Version 1.0
 **/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动时自动打开http://localhost:9036/swagger-ui.html
 */
@Component
public class StepExecutorConfig  implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(StepExecutorConfig.class);

    @Value("${spring.web.loginurl}")
    private String loginUrl;

    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;

    @Value("${spring.web.isopenurl}")
    private boolean isOpen;
    @Override
    public void run(ApplicationArguments args){
        //先判断当前环境
        if (!exitisVersion()){
            //启动swagger-ui
            application();
        }
    }

    private Boolean exitisVersion() {
        String osName = System.getProperties().getProperty("os.name");
        if(osName.equals("Linux")) {
            LOG.info("running in Linux");
            return true;
        }
        else{
            LOG.info("don't running in Linux");
            return false;
        }
    }

    private void application() {
        if (isOpen){
            String cmd = googleExcutePath +" "+ loginUrl;
            LOG.info("Swagger地址：" + cmd);
            Runtime run = Runtime.getRuntime();
            try{
                run.exec(cmd);
                LOG.info("启动浏览器打开项目成功");
            }catch (Exception e){
                e.printStackTrace();
                LOG.error(e.getMessage());
            }
        }
    }
}