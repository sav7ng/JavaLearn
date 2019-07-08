package cn.eunji.aquan.springbootmybatis.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Class RequestListenter
 * @Description TODO
 * @Author Aquan
 * @Date 2019.7.8 11:38
 * @Version 1.0
 **/

@WebListener
public class RequestListenter implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("---------------------------->请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("---------------------------->请求创建");
    }

}
