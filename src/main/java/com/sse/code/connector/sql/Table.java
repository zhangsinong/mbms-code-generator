//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.sql;

import java.util.List;

public class Table {
    private String tableName;
    private String tableComment;
    private List<Column> columnList;

    public Table() {
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return this.tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<Column> getColumnList() {
        return this.columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Table{");
        sb.append("tableName='").append(this.tableName).append('\'');
        sb.append(", tableComment='").append(this.tableComment).append('\'');
        sb.append(", columnList=").append(this.columnList);
        sb.append('}');
        return sb.toString();
    }
}
