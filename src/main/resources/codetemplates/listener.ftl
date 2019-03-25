package ${bizCodePackage}.listener;

import org.springframework.beans.factory.annotation.Autowired;
import ${bizCodePackage}.service.${modelName}Service;
import sse.mbms.flowdata.bpm.annotation.BpmListener;
import sse.mbms.flowdata.bpm.listener.NodeListener;

import java.util.Map;

/**
 * @Author AutoGenerate
 * @Date ${.now}
 */
@BpmListener("${modelName}Listener")
public class ${modelName}Listener implements NodeListener {

    @Autowired
    ${modelName}Service ${modelName?uncap_first}Service;
    /**
     * 审批通过
     *
     * @param bizId 业务ID
     * @param data
     * @param end   是否结束
     */
    @Override
    public void agree(String bizId, Map<String, Object> data, boolean end) {
        ${modelName?uncap_first}Service.finish(bizId);
    }

    /**
     * 审批退回
     *
     * @param bizId
     * @param data
     */
    @Override
    public void reject(String bizId, Map<String, Object> data) {

    }

    /**
     * 流程撤回
     *
     * @param bizId
     * @param nodeName
     */
    @Override
    public void withDraw(String bizId, String nodeName) {

    }
}
