# ZSE5 API #

中昇ZES5 后台API接口

## 原有数据库改造 ##

user表：新增token字段

custommer表：新增password、token字段


## 测试连接 ##

**get /test 测试服务器地址是否联通**

返回值：
	
	{
	  "success": true,
	  "message": null,
	  "data": null
	}

## 用户（站内&工地） ##

**POST /user/login 登录**
**POST /customer/login 登录**

- String name 登录名
- String pass 密码（加密）

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": {
	    "loginname": "admin",
	    "usertype": "06",
	    "id": "admin",
	    "username": "管理员",
	    "token": "LMzjo8wzCm5YL2AhNY"
	  }
	}


**GET /user/accesstoken 验证token**  
**GET /customer/accesstoken 验证token**

- String accesstoken token码


返回值：

	{success:true,data:"userid"}

**POST /user/password 修改密码**  
**POST /customer/password 修改密码**

- String accesstoken token码
- String oldPasswordCiphertext 原密码密文
- String newPasswordCiphertext 新密码密文

返回值：

	{success:true,message:"密码修改成功",data:"userid"}
	{success:true,message:"密码修改失败"}
	{success:true,message:"原密码错误，修改失败"}

## 合同工地 ##

**get /projects 工地列表**

- String accesstoken token码
- int page 当前页

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "projectID": "2",
	      "projectAddr": "麓山北路1212号",
	      "projectName": "麓山铲平工程",
	      "buildUnit": null,
	      "constructUnit": null,
	      "linkMan": "余总",
	      "tel": "15800000000",
	      "remark": "APP",
	      "contractID": "2",
	      "contractName": null,
	      "contract": {
	        "contractID": "2",
	        "contractNo": "456",
	        "contractName": "岳麓山填平合同",
	        "customerID": "1",
	        "custName": null
	      }
	    }
	  ]
	}

**post /projects 新增工地合同**

- String accesstoken token码
- String contractName 合同名称
- String projectName 工地名称
- String projectAddr 工地地址
- String linkMan 联系人
- String tel 联系电话

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": {
	    "contractID": "15099494576128",
	    "projectID": "15099844055040"
	  }
	}

**put /projects/:id 修改工地合同**

- String accesstoken token码
- String projectName 工地名称
- String projectAddr 工地地址
- String linkMan 联系人
- String tel 联系电话

返回值：

	{
	  "success": true,
	  "message": "修改成功",
	  "data": {
	    "contractID": "15099494576128",
	    "projectID": "15099844055040"
	  }
	}

**delete /projects/:id 删除工地合同**

- String accesstoken token码（URL参数）

备注：如果工地关联的合同下存在了工地计划，那么无法删除：

	{
	  "success": false,
	  "message": "该合同工程已存在工程计划",
	}

返回值：

	{
	  "success": true,
	  "message": "删除成功",
	  "data": {
	    "contractID": "15099494576128",
	    "projectID": "15099844055040"
	  }
	}

## 工地计划 ##

**get /plans/auditing 审核中的工地计划列表**

- String accesstoken token码
- int page 当前页

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "customerPlanID": "15099519893504",
	      "auditStatus": false,
	      "builder": null,
	      "modifier": null,
	      "buildTime": null,
	      "modifyTime": null,
	      "consPos": "垫层",
	      "projectName": "哭录取推荐",
	      "constructUnit": null,
	      "projectAddr": "金龙鱼",
	      "tel": null,
	      "linkMan": null,
	      "planDate": 1451520000000,
	      "conStrength": "C10",
	      "needDate": "12:00",
	      "castMode": "直卸",
	      "slump": "130±20",
	      "planCube": 0,
	      "contractID": "369296085262336"
	    }
	  ]
	}


**get /plans/audited 审核中的工地计划列表**

- String accesstoken token码
- int page 当前页

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "customerPlanID": "15099519893504",
	      "auditStatus": true,
	      "builder": null,
	      "modifier": null,
	      "buildTime": null,
	      "modifyTime": null,
	      "consPos": "垫层",
	      "projectName": "哭录取推荐",
	      "constructUnit": null,
	      "projectAddr": "金龙鱼",
	      "tel": null,
	      "linkMan": null,
	      "planDate": 1451520000000,
	      "conStrength": "C10",
	      "needDate": "12:00",
	      "castMode": "直卸",
	      "slump": "130±20",
	      "planCube": 0,
	      "contractID": "369296085262336"
	    }
	  ]
	}

**post /plans 新增工地计划**

- String accesstoken token码
- String contractName 合同名称
- String projectName 工地名称
- String projectAddr 工地地址
- String linkMan 联系人
- String tel 联系电话

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": {
	    "contractID": "15099494576128",
	    "projectID": "15099844055040"
	  }
	}

**put /plans/:id 修改工地计划**

- String accesstoken token码
- String projectName 工地名称
- String projectAddr 工地地址
- String linkMan 联系人
- String tel 联系电话

	{
	  "success": false,
	  "message": "该计划已审核，无法修改，请联系站内人员",
	  "data": null
	}

返回值：

	{
	  "success": true,
	  "message": "修改成功",
	  "data": "15099519893504"
	}

**delete /plans/:id 删除工地合同**

- String accesstoken token码（URL参数）

备注：如果工地计划已经被审核，那么无法删除：

	{
	  "success": false,
	  "message": "该计划已审核，无法删除，请联系站内人员",
	  "data": null
	}

返回值：

	{
	  "success": true,
	  "message": "删除成功",
	  "data": "1"
	}

## 发货记录/供货进度 ##

**get /shipping 查询当前用户的发货记录/供货进度**

- String accesstoken token码（URL参数）

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "lastTime": 1448531205000,
	      "conStrength": "C25",
	      "consPos": "垫层",
	      "castMode": "工地泵送",
	      "produceCubes": 44,
	      "plancube": 0,
	      "custName": "三湖联通",
	      "projectName": "三湖联通"
	    },
	    {
			......
		}
	  ]
	}

**get /shipping/:id 查询发货单**

- String accesstoken token码（URL参数）

返回值：

	{
	  "success": true,
	  "message": "查询单号'1_151004203340_00013970'成功",
	  "data": {
	    "id": "1_151004203340_00013970",
	    "signInCube": 13,
	    "exceptionInfo": null,
	    "custName": "银谷国际10#栋37-64轴",
	    "projectName": "银谷国际10#栋37-64轴",
	    "conStrength": "C30",
	    "shippingCube": 13,
	    "providedTimes": 3,
	    "provideCube": 0,
	    "modifier": null,
	    "modifyTime": null,
	    "signed": false
	  }
	}

**put /shipping/:id/sign 签收发货单**

- String accesstoken token码（URL参数）
- double signInCube 签收方量
- String exceptionInfo 异常信息
- boolean isSigned 是否签收（如果已签收，signInCube 必须大于0）

返回值：

	{
	  "success": true,
	  "message": "签收成功",
	  "data": {
	    "id": "1_151004203340_00013970",
	    "signInCube": 13,
	    "exceptionInfo": "",
	    "custName": "银谷国际10#栋37-64轴",
	    "projectName": "银谷国际10#栋37-64轴",
	    "conStrength": "C30",
	    "shippingCube": 13,
	    "providedTimes": 3,
	    "provideCube": 0,
	    "modifier": "1",
	    "modifyTime": null,
	    "signed": true
	  }
	}

如果该发货单已经签核，则返回：
	
	{
	  "success": false,
	  "message": "该发货单已经签核",
	  "data": null
	}

## 字典 ##

**get /dics 查询所有字典**

- String accesstoken token码（URL参数）

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "dicId": "CastMode01",
	      "dicName": "直卸",
	      "parentId": "CastMode"
	    },
		{
	      ......
	    },
	}

**get /dics/constrength 查询所有砼强度**

- String accesstoken token码（URL参数）

返回值：

	{
	  "success": true,
	  "message": null,
	  "data": [
	    {
	      "dicId": 1,
	      "dicName": "C10"
	    },
	    {
	      ......
	    },
	}