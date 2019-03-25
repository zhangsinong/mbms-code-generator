//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.service.impl;

import com.sse.code.connector.ConnectionPool;
import com.sse.code.connector.sql.Column;
import com.sse.code.connector.sql.Table;
import com.sse.code.generator.dao.TableDao;
import com.sse.code.generator.service.TableService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableDao tableDao;

    public TableServiceImpl() {
    }

    public List<Table> findList(String name) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, ConnectionPool.getConnector().getUserName());
        params.put(2, name);
        return this.tableDao.findList(params);
    }

    public List<Column> findColumnList(String tableName) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, ConnectionPool.getConnector().getUserName());
        params.put(2, tableName);
        return this.tableDao.findColumnList(params);
    }
}
