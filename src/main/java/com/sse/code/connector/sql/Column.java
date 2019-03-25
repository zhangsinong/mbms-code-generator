//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.sql;

import java.math.BigInteger;

public class Column {
    private String tableName;
    private String columnName;
    private String columnComment;
    private String primaryKey;
    private String nullable;
    private BigInteger length;
    private BigInteger numberLength;
    private BigInteger numberScale;
    private String dataType;

    public Column() {
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return this.columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public BigInteger getLength() {
        return this.length;
    }

    public void setLength(BigInteger length) {
        this.length = length;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getNullable() {
        return this.nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public BigInteger getNumberLength() {
        return this.numberLength;
    }

    public void setNumberLength(BigInteger numberLength) {
        this.numberLength = numberLength;
    }

    public BigInteger getNumberScale() {
        return this.numberScale;
    }

    public void setNumberScale(BigInteger numberScale) {
        this.numberScale = numberScale;
    }
}
