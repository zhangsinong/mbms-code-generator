//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.api;

import com.sse.code.connector.ConnectionPool;
import com.sse.code.connector.util.ResultSetUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BaseSelect implements Select {
    private Class clz;

    public BaseSelect(Class clz) {
        this.clz = clz;
    }

    public <T> T get(String sql) {
        try {
            Connection connection = ConnectionPool.borrowObject();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Object obj = ResultSetUtils.convert2Object(resultSet, this.clz);
            ConnectionPool.returnObject(connection);
            return (T) obj;
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public <T> T get(String sql, Map<Integer, Object> params) {
        try {
            Connection connection = ConnectionPool.borrowObject();
            PreparedStatement statement = connection.prepareStatement(sql);
            Iterator var5 = params.entrySet().iterator();

            while(var5.hasNext()) {
                Entry<Integer, Object> param = (Entry)var5.next();
                statement.setObject((Integer)param.getKey(), param.getValue());
            }

            ResultSet resultSet = statement.executeQuery();
            Object obj = ResultSetUtils.convert2Object(resultSet, this.clz);
            statement.close();
            resultSet.close();
            ConnectionPool.returnObject(connection);
            return (T) obj;
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public <T> List<T> select(String sql) {
        try {
            Connection connection = ConnectionPool.borrowObject();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Object obj = ResultSetUtils.convert2List(resultSet, this.clz);
            statement.close();
            resultSet.close();
            ConnectionPool.returnObject(connection);
            return (List)obj;
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public <T> List<T> list(String sql, Map<Integer, Object> params) {
        try {
            Connection connection = ConnectionPool.borrowObject();
            PreparedStatement statement = connection.prepareStatement(sql);
            Iterator var5 = params.entrySet().iterator();

            while(var5.hasNext()) {
                Entry<Integer, Object> param = (Entry)var5.next();
                if (null != param.getValue()) {
                    statement.setObject((Integer)param.getKey(), param.getValue());
                }
            }

            ResultSet resultSet = statement.executeQuery();
            List list = ResultSetUtils.convert2List(resultSet, this.clz);
            statement.close();
            resultSet.close();
            ConnectionPool.returnObject(connection);
            return list;
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}
