//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.service.impl;

import com.sse.code.connector.sql.Column;
import com.sse.code.connector.sql.Table;
import com.sse.code.connector.util.ZipFileUtils;
import com.sse.code.generator.model.CodeConfig;
import com.sse.code.generator.model.TemplatePOJO;
import com.sse.code.generator.model.TemplatePOJO.TemplatePOJOBuilder;
import com.sse.code.generator.service.TableService;
import com.sse.code.generator.service.TemplateService;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class TemplateServiceImpl implements TemplateService {
    private static Configuration configuration;
    @Autowired
    private TableService tableService;

    public TemplateServiceImpl() {
    }

    public void generate(CodeConfig config, OutputStream outputStream) {
        String path = System.getProperty("user.home") + "/codeGen/";
        ZipFileUtils.deleteAllFile(path);
        Table table = (Table)this.tableService.findList(config.getTableName()).get(0);
        List<Column> columns = this.tableService.findColumnList(config.getTableName());
        TemplatePOJO templatePOJO = this.toPOJO(config, table, columns);
        templatePOJO.setBizBasePath(path);

        try {
            this.generateController(templatePOJO);
            this.generateService(templatePOJO);
            this.generateServiceImpl(templatePOJO);
            this.generateDao(templatePOJO);
            this.generateMapper(templatePOJO);
            this.generateModel(templatePOJO);
            if (templatePOJO.getIsFlow()) {
                this.generateListener(templatePOJO);
            }

            this.generatePostman(templatePOJO);
            this.generateYapi(templatePOJO);
            ZipFileUtils.toZip(path, "codeTemplate", outputStream);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    private TemplatePOJO toPOJO(CodeConfig config, Table table, List<Column> columns) {
        TemplatePOJO var10002 = new TemplatePOJO();
        var10002.getClass();
        TemplatePOJO.TemplatePOJOBuilder builder = var10002.new TemplatePOJOBuilder(var10002);
        return builder.setConfig(config).setTable(table).setColumns(columns).build();
    }

    private void generateFile(TemplatePOJO templatePOJO, Template template, String pkg, String filepath) throws TemplateException, IOException {
        File file = new File(pkg);
        file.mkdirs();
        FileOutputStream fos = new FileOutputStream(filepath);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        template.process(templatePOJO, out);
        fos.close();
    }

    private void generateYapi(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("yapi.ftl");
        String pkg = templatePOJO.getBizBasePath();
        String filepath = pkg + templatePOJO.getTableComment() + "yapi.json";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generatePostman(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("postman.ftl");
        String pkg = templatePOJO.getBizBasePath();
        String filepath = pkg + templatePOJO.getTableComment() + "postman.json";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateController(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("controller.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/controller/";
        String filepath = pkg + templatePOJO.getModelName() + "Controller.java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateServiceImpl(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("serviceimpl.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/service/impl/";
        String filepath = pkg + templatePOJO.getModelName() + "ServiceImpl.java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateService(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("service.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/service/";
        String filepath = pkg + templatePOJO.getModelName() + "Service.java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateDao(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("dao.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/mapper/";
        String filepath = pkg + templatePOJO.getModelName() + "Mapper.java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateMapper(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("mapper.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/mapper/";
        String filepath = pkg + templatePOJO.getModelName() + "Mapper.xml";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateModel(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("model.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getModelBasePath() + "/";
        String filepath = pkg + templatePOJO.getModelName() + ".java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    private void generateListener(TemplatePOJO templatePOJO) throws IOException, TemplateException {
        Template template = configuration.getTemplate("listener.ftl");
        String pkg = templatePOJO.getBizBasePath() + "/java/" + templatePOJO.getBizCodePath() + "/listener/";
        String filepath = pkg + templatePOJO.getModelName() + "Listener.java";
        this.generateFile(templatePOJO, template, pkg, filepath);
    }

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/codetemplates"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setCacheStorage(NullCacheStorage.INSTANCE);
    }
}
