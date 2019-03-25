//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class ConnectionPool extends BasePooledObjectFactory<Connection> {
    static GenericObjectPool<Connection> pool = null;
    private static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static JdbcConnector connector = null;

    public ConnectionPool() {
    }

    private static synchronized GenericObjectPool getInstance() {
        if (null == pool) {
            logger.info("初始化连接池...");
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            config.setMaxIdle(100);
            config.setMaxTotal(100);
            config.setMinIdle(5);
            config.setLifo(false);
            pool = new GenericObjectPool(new ConnectionPool(), config);
            logger.info("初始化连接池完成...");
        }

        return pool;
    }

    public static JdbcConnector getConnector() {
        if (null == connector) {
            throw new ConnectorException(1, "还未配置数据库链接");
        } else {
            return connector;
        }
    }

    public static synchronized void setConnector(JdbcConnector jdbcConnector) {
        Assert.notNull(jdbcConnector, "链接为空");
        logger.info("[重新]配置连接池...");
        if (!jdbcConnector.equals(connector)) {
            connector = jdbcConnector;
            if (null != pool) {
                pool.close();
            }

            pool = null;
            getInstance();
        }

    }

    public static Connection borrowObject() throws Exception {
        return (Connection)getInstance().borrowObject();
    }

    public static void returnObject(Connection connection) {
        getInstance().returnObject(connection);
    }

    public static void close() {
        getInstance().close();
    }

    public static void clear() {
        getInstance().clear();
    }

    public Connection create() throws Exception {
        Assert.notNull(connector, "还没有配置数据库链接");
        logger.info("创建全新的链接~{}", connector);

        try {
            Class.forName(connector.getDriver().getPath());
        } catch (ClassNotFoundException var2) {
            throw new ConnectorException(ConnectorException.DRIVER_NOT_FOUND, "驱动配置错误");
        }

        Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUserName(), connector.getPassword());
        return connection;
    }

    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject(connection);
    }
}
