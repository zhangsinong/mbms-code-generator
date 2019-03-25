package ${bizCodePackage}.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.pactera.jep.orm.Filter;
import com.pactera.jep.orm.Order;
import com.pactera.jep.orm.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pactera.jep.core.exception.ServiceException;
import com.pactera.jep.web.controller.CrudController;
import org.springframework.web.bind.annotation.*;

import ${modelPackage}.${modelName};
import ${bizCodePackage}.service.${modelName}Service;


/**
 *
 * @Author YouName
 * @Date ${.now}
 */
@RestController
@RequestMapping("/${modelName?lower_case}")
@Api(description = "${tableComment}")
public class ${modelName}Controller extends CrudController<${modelName}> {

    @Autowired
    ${modelName}Service ${modelName?uncap_first}Service;

    @GetMapping("/{id}")
    @ApiOperation("查询${tableComment}")
    public Result get(@PathVariable("id") ${pkPropertyType} ${pkProperty}) {
        return Result.success(${modelName?uncap_first}Service.get(${pkProperty}));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除${tableComment}")
    public Result delete(@PathVariable("id") ${pkPropertyType} ${pkProperty}) {
        return Result.success(${modelName?uncap_first}Service.deleteByPrimaryKey(${pkProperty}));
    }

    @PostMapping("/save")
    @ApiOperation("插入${tableComment}")
    public Result insert(@RequestBody ${modelName} ${modelName?uncap_first}) {
        return Result.success(${modelName?uncap_first}Service.insert(${modelName?uncap_first}));
    }

    @PostMapping("/update")
    @ApiOperation("更新${tableComment}")
    public Result update(@RequestBody ${modelName} ${modelName?uncap_first}) {
        return Result.success(${modelName?uncap_first}Service.update(${modelName?uncap_first}));
    }

    /**
     * 为列表页面做数据准备
     */
    @Override
    protected void prepareQuery(Page<${modelName}> page, List<Filter> filters, List<Order> orders, HttpServletRequest    request) {
        ${modelName?uncap_first}Service.query(page, filters, orders);
    }
}