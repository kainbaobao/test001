<#include "common.ftl" />
<script type="text/javascript" src="${ctx}/js/account.js"></script>
<table id="adata" class="easyui-datagrid" toolbar="#tb" pagination="true" title="账户管理" fitColumns="true" border="0"
        rownumbers="true" url="${ctx}/account/queryAccountByParams.do" fit="true">   
    <thead>   
        <tr>   
            <th field="cb" checkbox="true" >id</th>   
            <th field="aname">账户名称</th>   
            <th field="money">账户金额</th>  
            <th field="type" formatter="formateType">账户类型</th>   
            <th field="createTime">创建时间</th>  
            <th field="updateTime">更新时间</th>
            <th field="remark">备注</th>     
        </tr>   
    </thead>   
</table>  

<div id="tb">
    <a href="javascript:openAddAccountDialog()"  class="easyui-linkbutton" iconCls="icon-add" plain="true" >创建账户</a>
    <a href="javascript:openUpdateAccountDialog()"  class="easyui-linkbutton" iconCls="icon-edit" plain="true" >修改账户</a>
    <a href="javascript:delAccount()"  class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除账户</a>
    <br>
    <div>
    	        账户名称:<input name="a_name" id="a_name" type="text">
        &nbsp;&nbsp;
        账户类型:
        <select class="easyui-combobox" name="a_type" id="a_type" editable="false" panelHeight="auto">
            <option value="">全部</option>
            <option value="0">工商银行</option>
            <option value="1">建设银行</option>
        </select>
        &nbsp;&nbsp;
        创建时间:<input name="a_time" id="a_time" class="easyui-datebox" >
        &nbsp;&nbsp;
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<!-- 添加对话框 -->
<div id="account" class="easyui-dialog" title="添加账户" style="width:700px;height:400px" closed="true" 
        iconCls="icon-save" resizable="true" maximizable="true" buttons="#bt">
    <form id="fm" method="post">
        <table cellspacing="8px"> 
            <tr>
                <td>账户名称：</td>
                <td><input name="aname" id="aname" type="text"></td>
                 <td></td>
                <td>账户金额：</td>
                <td><input name="money" id="money" type="text"></td>
            </tr>
            <tr>
                <td>账户类型：</td>
                <td>
                    <select class="easyui-combobox" name="type" id="type" editable="false" panelHeight="auto">
                        <option value="0">工商银行</option>
                        <option value="1">建设银行</option>
                    </select>
                    <td></td>
                </td>
                    <td>账户备注：</td>
                <td><input name="remark" id="remark" type="text"></td>
            </tr>       
    </table>
    <input name="id" id="id" type="hidden" >
    </form>
</div>
<!-- 底部按钮 -->
<div id="bt" >
    <a href="javascript:addAccount()" class="easyui-linkbutton" iconCls="icon-save">保存</a>
    <a href="javascript:cancelAccount()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>






