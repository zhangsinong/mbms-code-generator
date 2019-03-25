//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.model;

import com.sse.code.connector.sql.Column;
import com.sse.code.connector.sql.Table;
import com.sse.code.connector.util.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.springframework.util.Assert;

public class TemplatePOJO {
    List<String> uuids;
    private String tableAbbr;
    private String pkColumn;
    private String pkColumnType;
    private String pkProperty;
    private String pkPropertyType;
    private List<ModelInfo> modelInfos;
    private String tableName;
    private String modelName;
    private String tableComment;
    private String modelBasePath;
    private String modelPackage;
    private String bizBasePath;
    private String bizCodePackage;
    private String bizCodePath;
    private boolean isFlow;
    private boolean file;

    public TemplatePOJO() {
    }

    public List<String> getUuids() {
        return this.uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }

    public String getTableAbbr() {
        String[] name = this.tableName.split("_");
        String abbr = "";
        String[] var3 = name;
        int var4 = name.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            if (!"d".equals(s) && !"df".equals(s) && !"g".equals(s)) {
                abbr = abbr + s.substring(0, 1);
            }
        }

        return StringUtils.isEmpty(abbr) ? this.modelName : abbr;
    }

    public void setTableAbbr(String tableAbbr) {
        this.tableAbbr = tableAbbr;
    }

    public String getPkColumn() {
        return this.pkColumn;
    }

    public void setPkColumn(String pkColumn) {
        this.pkColumn = pkColumn;
    }

    public String getPkColumnType() {
        return this.pkColumnType;
    }

    public void setPkColumnType(String pkColumnType) {
        this.pkColumnType = pkColumnType;
    }

    public String getPkProperty() {
        return this.pkProperty;
    }

    public void setPkProperty(String pkProperty) {
        this.pkProperty = pkProperty;
    }

    public String getPkPropertyType() {
        return this.pkPropertyType;
    }

    public void setPkPropertyType(String pkPropertyType) {
        this.pkPropertyType = pkPropertyType;
    }

    public List<ModelInfo> getModelInfos() {
        return this.modelInfos;
    }

    public void setModelInfos(List<ModelInfo> modelInfos) {
        this.modelInfos = modelInfos;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTableComment() {
        return this.tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getModelBasePath() {
        return StringUtils.isEmpty(this.modelPackage) ? this.getBizCodePath() + "/model" : this.modelPackage.replace(".", File.separator);
    }

    public void setModelBasePath(String modelBasePath) {
        this.modelBasePath = modelBasePath;
    }

    public String getModelPackage() {
        return StringUtils.isEmpty(this.modelPackage) ? this.bizCodePackage + ".model" : this.modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getBizBasePath() {
        return this.bizBasePath;
    }

    public void setBizBasePath(String bizBasePath) {
        this.bizBasePath = bizBasePath;
    }

    public String getBizCodePackage() {
        return this.bizCodePackage;
    }

    public void setBizCodePackage(String bizCodePackage) {
        this.bizCodePackage = bizCodePackage;
    }

    public String getBizCodePath() {
        return this.bizCodePackage.replace(".", File.separator);
    }

    public boolean getIsFlow() {
        return this.isFlow;
    }

    public void setIsFlow(boolean isFlow) {
        this.isFlow = isFlow;
    }

    public boolean isFile() {
        return this.file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    public class TemplatePOJOBuilder {
        private TemplatePOJO pojo = new TemplatePOJO();

        public TemplatePOJOBuilder() {
        }
        public TemplatePOJOBuilder(TemplatePOJO var10002 ) {
            pojo=var10002;
        }

        public TemplatePOJO.TemplatePOJOBuilder setConfig(CodeConfig config) {
            List<String> uuids = new ArrayList();
            uuids.add(UUID.randomUUID().toString());
            uuids.add(UUID.randomUUID().toString());
            uuids.add(UUID.randomUUID().toString());
            uuids.add(UUID.randomUUID().toString());
            uuids.add(UUID.randomUUID().toString());
            this.pojo.setUuids(uuids);
            this.pojo.setModelName(config.getModelName());
            this.pojo.setModelPackage(config.getModelPackage());
            this.pojo.setBizCodePackage(config.getBizCodePackage());
            this.pojo.setIsFlow(config.getTemplate().equals("FLOW"));
            return this;
        }

        public TemplatePOJO.TemplatePOJOBuilder setTable(Table table) {
            this.pojo.setTableName(table.getTableName());
            this.pojo.setTableAbbr(table.getTableName());
            this.pojo.setTableComment(null == table.getTableComment() ? table.getTableName() : table.getTableComment());
            return this;
        }

        public TemplatePOJO.TemplatePOJOBuilder setColumns(List<Column> list) {
            List<ModelInfo> modelList = new ArrayList();
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Column column = (Column)var3.next();
                modelList.add(ModelInfo.buildFromColumn(column));
                if (column.getPrimaryKey().equals("YES")) {
                    this.setPK(column);
                }
            }

            this.pojo.setModelInfos(modelList);
            return this;
        }

        private TemplatePOJO.TemplatePOJOBuilder setPK(Column column) {
            Assert.isTrue(column.getPrimaryKey().equals("YES"), "字段不是主键");
            this.pojo.setPkColumn(column.getColumnName());
            this.pojo.setPkPropertyType(StringUtils.getJavaType(column.getDataType()));
            this.pojo.setPkColumnType(StringUtils.getJdbcType(column.getDataType()));
            this.pojo.setPkProperty(StringUtils.underlineToHump(column.getColumnName()));
            return this;
        }

        public TemplatePOJO build() {
            return this.pojo;
        }
    }
}
