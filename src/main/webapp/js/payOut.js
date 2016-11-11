$(function(){
	/**
	 * 加载页面时加载账户类型
	 */
	loadAccountData();
	/**
	 * 加载页面时加载支出类型
	 */
	loadPayOutTypePar();
})

/**
 * 加载账户类型
 */
function loadAccountData(){
	$("#aid").combobox({
		url:"account/queryAccountByUser.do",
		valueField:"id",
		textField:"aname",
		panelHeight:"auto"
	})
}

/**
 * 加载支出父类型
 */
function loadPayOutTypePar(){
	$("#t1").combobox({
		url:"payOutType/queryPayOutTypeByPid.do?pid=0",
		valueField:"id"
		textField:"name"
		panelHeight:"auto"
		onsubmit:function(s){
			var pid=s.id;
			/**
			 * 级联加载子类型
			 */
			loadPayOutTypeSub(pid);
		}
	})
}

/**
 * 加载支出子类型
 * @param pid
 */
function loadPayOutTypeSub(pid){
	$("#t2").combobox({
		url:"payOutType/queryPayOutTypeByPid.do?pid="+pid,
		valueField:"id",
		textFidle:"name",
		panelHeight:"auto"
	})
}

/**
 * 多条件查询
 */
function search(){
	$("#pdata").datagrid("reload",{
		p_name:$("#p_name").val(),
		p_type:$("#p_type").combobox("getValue"),
		p_time:$("#p_time").datebox("getText")
	})
}

/**
 * 打开添加与更新对话框
 */
function openAddOrUpdatePayOutDialog(){
	$("#payOut").dialog("open");
}

/**
 * 关闭添加对话框
 */
function close(){
	$("#payOut").dialog("close");
	initData();
}

/**
 * 初始化表单数据
 */
function initData(){
	$("#fm").form("clear");
}

/**
 * 添加与更新支出记录
 */
function addOrUpdatePayOut(){
	$("#fm").form("submit",{
		url:"payOut/saveOrUpdatePayOut.do",
		onSubmit:function(){
			return $("#fm").form("validate");// 返回校验结果	
		},
		success:function(data){
			var result=JSON.parse(data);	//json 转换为js对象
			
			if(result.code==200){
				$.messager.alert("来自挖财",result.msg);
				close();	// 关闭对话框
				initData();		// 清空表单数据
				$("#pdata").datagrid("reload");
			}else{
				$.messager.alert("来自挖财",result.msg);
			}
		}
	})
}

/**
 * 编辑支出
 */
function editPdata(){
	var rows = $("#pdata").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自挖财","请选择一条记录进行更新");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自挖财","只能选择一条记录进行更新")
		return;
	}
	
	$("#fm").form("load",rows[0]);
	
	var type=rows[0].type.split(",");
	
	$("#t1").combobox("select",type[0]);
	
	$("#t2").combobox("select",type[1]);
	
	$("#id").val(rows[0].id);
	
	$("#oldAid").val(rows[0].aid)
	
	$("#oldMoney").val(rows[0].money);
	
	$("#payOut").dialog("setTitle","编辑支出");
	
	/**
	 * 打来添加与更新对话框
	 */
	openAddOrUpdatePayOutDialog();
}

/**
 * 删除支出
 */
function delPayOut(){
	var rows = $("#pdata").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自挖财","请至少选择一条记录进行删除");
		return;
	}
	
	var ids= "ids=";
	for(var i=0;i<rows.length;i++){
		 if(i<rows.length-1){
			 ids=ids+rows[i].id+"&ids="; 
		 }else{
			 ids=ids+rows[i].id;
		 } 
	 }
	
	$.messager.confirm("来自挖财","确定删除？"+ids,function(r){
		if(r){
			$.ajax({
				type:"post",
				url:"payOut/delPayOut.do",
				data:ids,
				dataType:"json",
				success:function(data){
					if(data.code==200){
						 $.messager.alert("来自挖财",data.msg);
						 $("#pdata").datagrid("reload");
					}else{
						 $.messager.alert("来自挖财",data.msg);
					}
				}
			})
		}
	})
}