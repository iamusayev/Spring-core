package com.dmdev;

import com.dmdev.dao.*;
import com.dmdev.database.pool.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        ConnectionPool pool1;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {

            pool1 = context.getBean("pool1", ConnectionPool.class);
            System.out.println(pool1);

        }
    }
}
