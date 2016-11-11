<#include "common.ftl" />
<script type="text/javascript" src="${atx}/js/payIn.js"></script>
<table id="adata" class="easyui-datagrid" toolbar="#tb" pagination="true" title="收入管理" fitColumns="true" border="0"
        rownumbers="true" url="payIn/queryPayInByParams.do" fit="true">   
    <thead>   
        <tr>   
            <th field="cb" checkbox="true" >id</th>   
            <th field="name">收入名称</th>   
            <th field="money">收入金额</th>  
            <th field="type" formatter="formateType">收入类型</th>   
            <th field="createTime">创建时间</th>  
            <th field="updateTime">更新时间</th>
            <th field="remark">备注</th>
            <th field="aname">账户名称</th>     
        </tr>   
    </thead>   
</table>  

<div id="tb">
    <a href="javascript:openAddPayInDialog()"  class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加收入</a>
    <a href="javascript:openUpdatePayInDialog()"  class="easyui-linkbutton" iconCls="icon-edit" plain="true" >修改收入</a>
    <a href="javascript:delPayIn()"  class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除收入</a>
    <br>
    <div>
    	        收入名称:<input name="name" id="name" type="text">
        &nbsp;&nbsp;
        收入类型:
        <select class="easyui-combobox" name="type" id="type" editable="false" panelHeight="auto">
            <option value="">全部</option>
            <option value="1">工资</option>
            <option value="2">外快</option>
            <option value="3">红包</option>
        </select>
        &nbsp;&nbsp;
        创建时间:<input name="time" id="time" class="easyui-datebox" >
        &nbsp;&nbsp;
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<!-- 添加对话框 -->
<div id="payIn" class="easyui-dialog" title="添加收入" style="width:700px;height:400px" closed="true" 
        iconCls="icon-save" resizable="false" maximizable="false" modal="true" buttons="#bt">
    <form id="fm" method="post">
        <table cellspacing="8px"> 
            <tr>
                <td>收入名称：</td>
                <td><input name="name" id="name" type="text"></td>
                 <td></td>
                <td>收入金额：</td>
                <td><input name="money" id="money" type="text"></td>
            </tr>
            <tr>
                <td>收入类型：</td>
                <td>
                    <select class="easyui-combobox" name="type" id="type" editable="false" panelHeight="auto">
                        <option value="1">工资</option>
                        <option value="2">外快</option>
                        <option value="3">红包</option>
                    </select>
                </td>
                <td></td>
                <td>所属账户：</td>
                <td>
                    <select class="easyui-combobox" name="aname" id="aname" editable="false" panelHeight="auto">
                        <option value="1">工资</option>
                        <option value="2">外快</option>
                        <option value="3">红包</option>
                    </select>
                </td>
                    <td>备注：</td>
                <td><input name="remark" id="remark" type="text"></td>
            </tr>       
    </table>
    <input name="id" id="id" type="hidden" >
    <input name="aid" id="aid" type="hidden" >
    </form>
</div>
<!-- 底部按钮 -->
<div id="bt" >
    <a href="javascript:addPayIn()" class="easyui-linkbutton" iconCls="icon-save">保存</a>
    <a href="javascript:cancelPayIn()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>






