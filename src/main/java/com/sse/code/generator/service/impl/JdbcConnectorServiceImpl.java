//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.service.impl;

import com.sse.code.connector.ConnectionPool;
import com.sse.code.connector.ConnectorException;
import com.sse.code.connector.JdbcConnector;
import com.sse.code.generator.service.JdbcConnectorService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class JdbcConnectorServiceImpl implements JdbcConnectorService {
    public JdbcConnectorServiceImpl() {
    }

    public JdbcConnector getConnector() {
        return ConnectionPool.getConnector();
    }

    public void setConnector(JdbcConnector connector) {
        ConnectionPool.setConnector(connector);
    }

    public void test(JdbcConnector connector) {
        try {
            Class.forName(connector.getDriver().getPath());
        } catch (ClassNotFoundException var4) {
            throw new ConnectorException(ConnectorException.DRIVER_NOT_FOUND, "驱动配置错误");
        }

        try {
            Connection var2 = DriverManager.getConnection(connector.getUrl(), connector.getUserName(), connector.getPassword());
        } catch (SQLException var3) {
            var3.printStackTrace();
            throw new ConnectorException(2, "数据库链接失败");
        }
    }
}
