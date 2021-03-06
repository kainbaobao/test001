

/**
 * 打开添加账户对话框
 */
function openAddPayInDialog(){
	$("#payIn").dialog("open");
}


/**
 * 关闭添加对话框
 */
function cancelPayIn(){
	$("#payIn").dialog("close");
	initData();
}

/**
 * 初始化表单数据
 */
function initData(){
	$("input").val("");
	
	
}


/**
 * 添加方法
 */
function addPayIn(){
	$("#fm").form("submit",{
		url:ctx+"/payIn/saveOrUpdatePayIn.do",
		onSubmit:function(){
			return $("#fm").form("validate");// 返回校验结果	
		},
		success:function(data){
			var result=JSON.parse(data);//json 转换为js 对象
			
			if(result.code==200){
				$.messager.alert("来自挖财",result.msg);
				cancelPayIn();//操作成功  关闭对话框
				initData();// 清空表单数据
				$("#adata").datagrid("reload");
			}else{
				$.messager.alert("来自挖财",result.msg);
			}
		}
	})
}

/**
 * 格式化类型数据显示
 */
function formateType(value,row,index){
	if (row.type==1){
		return "工资";
	} else if(row.type==2){
		return "外快";
	}else{
		return "红包";
	}
}


function search(){
	$("#adata").datagrid("reload",{
		name:$("#name").val(),
		type:$("#type").combobox("getValue"),
		time:$("#time").datebox("getValue")
	})
}

function openUpdatePayInDialog(){
	var rows = $("#adata").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自挖财","请选择一条记录进行更新");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自挖财","只能选择一条记录进行更新")
		return;
	}
	
	$("#fm").form("load",rows[0]);
	
	$("#id").val(rows[0].id);
	
	$("#account").dialog("setTitle","编辑收入");
	
	openAddPayInDialog();
}

function delPayIn(){
	var rows = $("#adata").datagrid("getSelections");
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
				url:ctx+"/account/delPayIn.do",
				data:ids,
				dataType:"json",
				success:function(data){
					if(data.code==200){
						 $.messager.alert("来自挖财",data.msg);
						 $("#adata").datagrid("reload");
					}else{
						 $.messager.alert("来自挖财",data.msg);
					}
				}
			})
		}
	})
}