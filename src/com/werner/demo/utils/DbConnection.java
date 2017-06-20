package com.werner.demo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.beans.PropertyVetoException;


public class DbConnection {
    private static volatile DbConnection instance = null;

    private ComboPooledDataSource dataSource;

    private DbConnection() {
        if (dataSource == null) {
            dataSource = new ComboPooledDataSource();
            try {
                dataSource.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
                dataSource.setUser("wleiy");
                dataSource.setPassword("wleiy");
                dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

    }

    public static DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    public QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }


}


