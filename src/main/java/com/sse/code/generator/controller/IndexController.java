//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.controller;

import com.sse.code.connector.JdbcConnector;
import com.sse.code.generator.model.CodeConfig;
import com.sse.code.generator.model.Result;
import com.sse.code.generator.service.JdbcConnectorService;
import com.sse.code.generator.service.TableService;
import com.sse.code.generator.service.TemplateService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private JdbcConnectorService connectorService;
    @Autowired
    private TableService tableService;
    @Autowired
    private TemplateService templateService;

    public IndexController() {
    }

    @RequestMapping({"/"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/connpath"})
    public String connPath(Model model) {
        return "conn";
    }

    @RequestMapping({"/tablePath"})
    public String tablePath(Model model) {
        try {
            model.addAttribute("tableList", this.tableService.findList((String)null));
            return "table";
        } catch (Exception var3) {
            var3.printStackTrace();
            System.err.println("操作失败");
            model.addAttribute("msg", var3.getMessage());
            return "error";
        }
    }

    @RequestMapping({"/help"})
    public String help(Model model) {
        return "help";
    }

    @RequestMapping(
            value = {"/test"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Result testConnection(JdbcConnector jdbcConnector) {
        this.connectorService.test(jdbcConnector);
        return Result.success();
    }

    @RequestMapping(
            value = {"/conn"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Result setConnection(JdbcConnector jdbcConnector) {
        this.connectorService.test(jdbcConnector);
        this.connectorService.setConnector(jdbcConnector);
        return Result.success();
    }

    @RequestMapping(
            value = {"/conn"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public Result getConnection() {
        return Result.success(this.connectorService.getConnector());
    }

    @RequestMapping(
            value = {"/generator"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public void generator(CodeConfig config, HttpServletResponse response, HttpServletRequest request) {
        try {
            String zipName = config.getModelName() + ".zip";
            response.reset();
            response.setHeader("Content-Disposition", "attachment;filename=\"" + zipName + "\"");
            response.setContentType("application/zip;charset=UTF-8");
            this.templateService.generate(config, response.getOutputStream());
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    @RequestMapping(
            value = {"/table/list"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public Result tableList(String name) {
        return Result.success(this.tableService.findList(name));
    }
}
