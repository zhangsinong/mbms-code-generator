//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.dao;

import com.sse.code.connector.api.BaseSelect;
import com.sse.code.connector.api.Select;
import com.sse.code.connector.sql.Column;
import com.sse.code.connector.sql.Table;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class TableDao {
    public TableDao() {
    }

    public List<Table> findList(Map<Integer, Object> map) {
        String sql = "select table_name tableName, table_comment as tableComment from information_schema.TABLES where table_schema = ?";
        if (null != map.get(2)) {
            sql = sql + " and table_name like ? ";
        }

        Select select = new BaseSelect(Table.class);
        return select.list(sql, map);
    }

    public List<Column> findColumnList(Map<Integer, Object> map) {
        String sql = "SELECT t.table_name AS tableName, t.column_name AS columnName, (case when t.column_key = 'PRI' then 'YES' else 'NO' end ) AS primaryKey, t.is_nullable AS nullable, t.data_type AS dataType, t.character_maximum_length AS length, t.numeric_precision as numberLength, t.numeric_scale as numberScale, t.column_comment AS columnComment FROM information_schema.COLUMNS t WHERE t.table_schema = ? and t.table_name = ? ";
        Select select = new BaseSelect(Column.class);
        return select.list(sql, map);
    }
}
