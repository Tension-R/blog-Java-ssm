<%--
  Created by IntelliJ IDEA.
  User: tension
  Date: 17-6-16
  Time: 下午7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人博客后台管理</title>
    <%@include file="common/head.jspf" %>
    <style type="text/css">
        body {
            font-family: "microsoft yahei";
        }
        .easyui-linkbutton{
            width: 150px;
        }
    </style>
    <script type="text/javascript">
        /**
         * 打开选项卡
         * @param text  选项卡标题
         * @param url   请求打开路径
         * @param icon  选项卡图标
         */
        function openTab(text,url) {
            //判断当前选项卡是否存在
            if($('#tabs').tabs('exists',text)){
                //如果存在 显示
                $("#tabs").tabs("select",text);
            }else{
                //如果不存在 则新建一个
                $("#tabs").tabs('add',{
                    title:text,
                    closable:true,      //是否允许选项卡摺叠。
                    // url 远程加载所打开的url
                    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${blog}/admin/"+url+"'></iframe>"
                })
            }
        }
    </script>
</head>
<body class="easyui-layout">

<div region="north" style="height: 78px; background-color: #E0ECFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <h2>博客后台系统</h2>
            </td>
            <td valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>admin</font>
            </td>
        </tr>
    </table>
</div>

<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="border:true">
        <div title="常用操作" data-options="selected:true" style="padding: 10px">
            <a href="javascript:openTab('写博客','writeBlog.jsp');"
               class="easyui-linkbutton">写博客</a>
            <a href="javascript:openTab('评论审核','commentReview.jsp')"
               class="easyui-linkbutton">评论审核</a>
        </div>
        <div title="博客管理" style="padding:10px;">
            <a href="javascript:openTab('写博客','writeBlog.jsp')"
               class="easyui-linkbutton">写博客</a>
            <a href="javascript:openTab('博客信息管理','blogManage.jsp')" class="easyui-linkbutton"
               style="width: 150px;">博客信息管理</a>
        </div>
        <div title="博客类别管理" style="padding:10px">
            <a href="javascript:openTab('博客类别信息管理','blogTypeManage.jsp')"
               class="easyui-linkbutton">博客类别信息管理</a>
        </div>
        <div title="评论管理" style="padding:10px">
            <a href="javascript:openTab('评论审核','commentReview.jsp')"
               class="easyui-linkbutton">评论审核</a>
            <a href="javascript:openTab('评论信息管理','commentManage.jsp')"
               class="easyui-linkbutton">评论信息管理</a>
        </div>
        <div title="个人信息管理" style="padding:10px">
            <a href="javascript:openTab('修改个人信息','modifyInfo.jsp')"
               class="easyui-linkbutton">修改个人信息</a>
        </div>
        <div title="系统管理" style="padding:10px">
            <a href="javascript:openTab('友情链接管理','linkManage.jsp')"
               class="easyui-linkbutton">友情链接管理</a>
            <a href="javascript:openTab('修改密码','updatePassword.jsp')"
               class="easyui-linkbutton">修改密码</a>
            <a href="javascript:openTab('刷新系统缓存','flushSystem.jsp')"
               class="easyui-linkbutton">刷新系统缓存</a>
            <a href="javascript:openTab('安全退出','quit.jsp')"
               class="easyui-linkbutton">安全退出</a>
        </div>
    </div>
</div>

<div region="center" style="background:#eee;">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页">
            <div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
        </div>
    </div>
</div>

<div region="south" style="height: 30px;padding: 5px" align="center">
    <div region="south" style="height: 25px;padding: 5px" align="center">
        Copyright © 2012-2017 tension的SSM博客系统 版权所有
    </div>
</div>
</body>
</html>
