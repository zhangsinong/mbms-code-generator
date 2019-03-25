/*
 * Powered By xTOOLs
 * Dev by tao.li8@pactera.com
 * Copyright ©2009-2018 pactera.com All rights reserved.
 *
 * Generated at ${.now}
 */

package ${bizCodePackage}.mapper;

import com.pactera.jep.orm.mybatis.annotation.MyBatisMapper;
import com.pactera.jep.orm.mybatis.mapper.Mapper;
import ${modelPackage}.${modelName};


/**
* ${tableComment}Dao层接口
*
* @author YourName
* @Date ${.now}
* @since 1.0
*/
@MyBatisMapper
public interface ${modelName}Mapper extends Mapper<${modelName}, String>{
}