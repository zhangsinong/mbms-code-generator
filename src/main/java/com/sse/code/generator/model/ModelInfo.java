//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.model;

import com.sse.code.connector.sql.Column;
import com.sse.code.connector.util.StringUtils;

public class ModelInfo {
    private boolean isPrimary;
    private String column;
    private String columnType;
    private Integer len;
    private Integer fraction;
    private String columnComment;
    private String property;
    private String propertyType;

    public ModelInfo() {
    }

    public static ModelInfo buildFromColumn(Column column) {
        ModelInfo modelInfo = new ModelInfo();
        modelInfo.setColumn(column.getColumnName());
        modelInfo.setColumnComment(column.getColumnComment());
        modelInfo.setColumnType(StringUtils.getJdbcType(column.getDataType()));
        modelInfo.setIsPrimary(column.getPrimaryKey().equals("YES"));
        if (null != column.getLength()) {
            modelInfo.setLen(column.getLength().intValue());
        } else if (null != column.getNumberLength()) {
            modelInfo.setLen(column.getNumberLength().intValue());
        }

        if (null != column.getNumberScale()) {
            modelInfo.setFraction(column.getNumberScale().intValue());
        }

        modelInfo.setProperty(StringUtils.underlineToHump(column.getColumnName()));
        modelInfo.setPropertyType(StringUtils.getJavaType(column.getDataType()));
        return modelInfo;
    }

    public boolean getIsPrimary() {
        return this.isPrimary;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Integer getLen() {
        return this.len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getFraction() {
        return this.fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public String getColumnComment() {
        return this.columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
