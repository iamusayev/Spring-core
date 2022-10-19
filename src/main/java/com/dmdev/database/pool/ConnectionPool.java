package com.dmdev.database.pool;

import java.util.*;
import org.springframework.beans.factory.InitializingBean;

public class ConnectionPool implements InitializingBean {

    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private  Map<String, Object> properties;

    public ConnectionPool(String username,
                          Integer poolSize,
                          List<Object> args,
                          Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }


    @Override
    public String toString() {
        return "ConnectionPool{" +
                "username='" + username + '\'' +
                ", poolSize=" + poolSize +
                ", args=" + args +
                ", properties=" + properties +
                '}';
    }


    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }


    private void init() {
        System.out.println("Init connection pool");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("sout");
    }

    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
