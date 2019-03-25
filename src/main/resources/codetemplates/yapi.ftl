{
	"id": "${uuids[0]}",
	"name": "v0.0.4 ${tableComment}",
	"description": "",
	"order": [
		"${uuids[1]}",
		"${uuids[2]}"
	],
	"folders": [],
	"folders_order": [],
	"timestamp": 1540174861112,
	"owner": 0,
	"public": false,
	"events": [],
	"variables": [],
	"auth": null,
	"requests": [
		{
			"id": "${uuids[1]}",
			"headers": "Content-Type: application/json\n",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"enabled": true
				}
			],
			"url": "/flow/${modelName?lower_case}/",
			"queryParams": [],
			"events": [],
			"pathVariables": {},
			"pathVariableData": [],
			"method": "POST",
			"data": [],
			"dataMode": "raw",
			"auth": null,
			"time": 1540175073403,
			"name": "新增、修改、保存${tableComment}",
			"description": "",
			"collectionId": "${uuids[0]}",
			"responses": [],
			"currentHelper": "bearerAuth",
			"helperAttributes": {
				"id": "bearer",
				"token": "{{token}}"
			},
			"rawModeData": "{\n<#list modelInfos as model><#if model.column?lower_case != "create_time" && model.column?lower_case != "create_by" && model.column?lower_case != "last_update_time" && model.column?lower_case != "last_update_by" && model.column?lower_case != "version" && model.column?lower_case != "rowstate">    \"${model.property}\": <#if model.columnType == 'DECIMAL' || model.columnType == 'INTEGER'>0<#else>\"string\"</#if>,<#list 1..(60-model.property?length) as a> </#list>//${model.columnComment}\n</#if></#list><#if file>    \"attachFiles\":[            \n\t\t{\n\t\t\t\"id\":\"\",                 \n\t\t\t\"bizType\":\"证券投资证书\",                     \n\t\t\t\"fileName\":\"index1.html\",                     \n\t\t\t\"fileCategory\":\"证券投资证书\",                \n\t\t\t\"fileId\":\"f5158532d59a4516a93b596fc378e06e\",  \n\t\t\t\"sequence\":\"1\"                               \n\t\t}\n\t],\n</#if>    \"dataModel\":1,<#list 1..(60-17) as a> </#list>//0-保存 1-提交 中间流程涉及到保存的都要设置为0\n\t\"instanceId\":\"6049528\",<#list 1..(60-26) as a> </#list>//流程id  流程启动或者创建草稿之后需要传入\n    \"status\":\"39\",<#list 1..(60-17) as a> </#list>//流程状态  流程启动或者创建草稿之后需要传入\n    \"approveUsers\":[],<#list 1..(60-21) as a> </#list>//下个节点的审批人列表\n    \"businessData\":{},<#list 1..(60-21) as a> </#list>//流程中用的业务数据\n    \"operateOrgName\":\"hz\",<#list 1..(60-25) as a> </#list>//操作人机构\n    \"operateName\":\"第三方\",<#list 1..(60-26) as a> </#list>//操作人姓名\n    \"operatePhone\":\"15696231232\"<#list 1..(60-31) as a> </#list>//操作人电话\n}"
		},
		{
			"id": "cbc76d8f-8e71-a806-1c35-d606e59ff45d",
			"headers": "",
			"headerData": [],
			"url": "/flow/${modelName?lower_case}/:id",
			"queryParams": [],
			"pathVariables": {},
			"pathVariableData": [],
			"events": [],
			"auth": null,
			"method": "GET",
			"collectionId": "${uuids[0]}",
			"data": null,
			"dataMode": "params",
			"name": "查询${tableComment}业务流程信息",
			"description": "",
			"descriptionFormat": "html",
			"time": 1540175082824,
			"version": 2,
			"responses": [],
			"currentHelper": "bearerAuth",
			"helperAttributes": {
				"id": "bearer",
				"token": "{{token}}"
			}
		}
	]
}