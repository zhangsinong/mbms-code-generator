/*
 * Powered By xTOOLs
 * Dev by tao.li8@pactera.com
 * Copyright ©2009-2018 pactera.com All rights reserved.
 * Generated at ${.now}
 */

package ${modelPackage};

import com.pactera.jep.web.entity.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;
import java.math.BigDecimal;

import com.pactera.jep.commons.DateUtils;
import com.pactera.jep.entity.PO;

/**
 * ${tableComment}实体类
 * @Author YourName
 * @Date ${.now}
 */
@ApiModel(value = "${modelName}" , description = "${tableComment}")
@Entity
@Table(name = "${tableName}")
public class ${modelName} implements PO {

<#if modelInfos?exists>
    <#list modelInfos as model>
    @ApiModelProperty("${model.columnComment}")
        <#if model.isPrimary>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        </#if>
        <#if model.columnType == 'VARCHAR'>
    @Length(max = ${model.len}, message = "${model.columnComment}长度最多${model.len}位")
        </#if>
        <#if model.columnType == 'DECIMAL'>
    @Digits(integer = ${model.len-model.fraction}, fraction = ${model.fraction}, message = "${model.columnComment}不能超过${model.len}位")
        </#if>
        <#if model.columnType == 'INTEGER'>
    @Digits(integer = ${model.len}, fraction = 0, message = "${model.columnComment}不能超过${model.len}位")
        </#if>
        <#if model.columnType == 'TIMESTAMP'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        </#if>
        <#if model.columnType == 'DATE'>
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
        </#if>
    @Column(name = "${model.column}")
    private ${model.propertyType} ${model.property};

    </#list>
</#if>
<#if modelInfos?exists>
    <#list modelInfos as model>
    public ${model.propertyType} get${model.property?cap_first}(){
        return ${model.property};
    }

    public void set${model.property?cap_first}(${model.propertyType} ${model.property}){
        this.${model.property} = ${model.property};
    }
    </#list>
</#if>
}

