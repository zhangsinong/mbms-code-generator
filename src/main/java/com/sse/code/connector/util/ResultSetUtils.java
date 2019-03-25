//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtils {
    public ResultSetUtils() {
    }

    public static <T> List<T> convert2List(ResultSet resultSet, Class<T> clz) {
        ArrayList list = new ArrayList();

        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(resultSet.next()) {
                Object obj = clz.newInstance();

                for(int i = 1; i <= columnCount; ++i) {
                    String name = metaData.getColumnLabel(i);
                    Field field = clz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(obj, resultSet.getObject(i));
                }

                list.add(obj);
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } catch (InstantiationException var11) {
            var11.printStackTrace();
        } catch (NoSuchFieldException var12) {
            var12.printStackTrace();
        }

        return list;
    }

    public static <T> T convert2Object(ResultSet set, Class clz) throws Exception {
        ResultSetMetaData metaData = set.getMetaData();
        int columnCount = metaData.getColumnCount();
        Object obj = clz.newInstance();

        for(int i = 0; i < columnCount; ++i) {
            String name = metaData.getColumnLabel(i);
            Field field = clz.getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, set.getObject(i));
        }

        return (T) obj;
    }
}
