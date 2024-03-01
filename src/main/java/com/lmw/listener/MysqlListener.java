package com.lmw.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.SneakyThrows;

import java.sql.DriverManager;

@WebListener
public class MysqlListener implements ServletContextListener {

    @SneakyThrows
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        while (DriverManager.getDrivers().hasMoreElements()) {
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
