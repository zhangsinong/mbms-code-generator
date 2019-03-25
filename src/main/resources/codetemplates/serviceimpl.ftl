/*
 * Powered By xTOOLs
 * Dev by tao.li8@pactera.com
 * Copyright ©2009-2018 pactera.com All rights reserved.
 *
 * Generated at ${.now}
 */

package ${bizCodePackage}.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;

import ${bizCodePackage}.mapper.${modelName}Mapper;
import ${bizCodePackage}.service.${modelName}Service;
import ${modelPackage}.${modelName};

/**
 * 服务层实现
 * @author YourName
 * @date ${.now}
 */
@Service
@Transactional(readOnly = true)
public class ${modelName}ServiceImpl extends MyBatisCRUDService<${modelName}, String> implements ${modelName}Service {

    Logger logger =  LoggerFactory.getLogger(getClass());

    @Autowired
    private ${modelName}Mapper			${modelName?uncap_first}Mapper;

    @Override
    public Mapper<${modelName}, String> getMapper() {
         return ${modelName?uncap_first}Mapper;
    }
}
