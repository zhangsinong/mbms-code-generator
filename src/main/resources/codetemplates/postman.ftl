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
			"url": "{{urlflow}}${modelName?lower_case}/",
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
			"rawModeData": "{\n<#list modelInfos as model><#if model.column?lower_case != "create_time" && model.column?lower_case != "create_by" && model.column?lower_case != "last_update_time" && model.column?lower_case != "last_update_by" && model.column?lower_case != "version" && model.column?lower_case != "rowstate">    \"${model.property}\": <#if model.columnType == 'DECIMAL' || model.columnType == 'INTEGER'>0<#else>\"string\"</#if>,\n</#if></#list><#if file>    \"attachFiles\":[            \n\t\t{\n\t\t\t\"id\":\"\",                 \n\t\t\t\"bizType\":\"证券投资证书\",                     \n\t\t\t\"fileName\":\"index1.html\",                     \n\t\t\t\"fileCategory\":\"证券投资证书\",                \n\t\t\t\"fileId\":\"f5158532d59a4516a93b596fc378e06e\",  \n\t\t\t\"sequence\":\"1\"                               \n\t\t}\n\t],\n</#if>    \"dataModel\":1,                                        \n\t\"instanceId\":\"6049528\",                               \n    \"status\":\"39\",                                        \n    \"approveUsers\":[],\n    \"businessData\":{},                       \n    \"operateOrgName\":\"hz\",                                \n    \"operateName\":\"第三方\",                               \n    \"operatePhone\":\"15696231232\"                          \n}"
		},
		{
			"id": "cbc76d8f-8e71-a806-1c35-d606e59ff45d",
			"headers": "",
			"headerData": [],
			"url": "{{urlflow}}fundcreate/:id",
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