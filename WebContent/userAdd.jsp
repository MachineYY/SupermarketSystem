<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.jsp">账单管理</a></li>
                <li ><a href="providerList.jsp">供应商管理</a></li>
                <li id="active"><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form class="userAdd" action="User_Add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="User_id">用户编码：</label>
                    <input type="text" name="User_id" id="User_id"/>
                    <span>*请输入用户编码，且不能重复</span>
                </div>
                <div>
                    <label for="User_name">用户名称：</label>
                    <input type="text" name="User_name" id="User_name"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="User_password">用户密码：</label>
                    <input type="text" name="User_password" id="User_password"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="User_remi">确认密码：</label>
                    <input type="text" name="User_remi" id="User_remi"/>
                    <span>*请输入确认密码</span>
                </div>
                <div>
               	    <label for="User_sex">用户性别：</label>
                    <input type="text" name="User_sex" id="User_sex"/>
                  
                    <span></span>
                </div>
                <div>
                    <label for="User_age">用户年龄：</label>
                    <input type="text" name="User_age" id="User_age"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="User_tel">用户电话：</label>
                    <input type="text" name="User_tel" id="User_tel"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="User_address">用户地址：</label>
                    <input type="text" name="User_address" id="User_address"/>
                </div>
                <div>
                     <label for="User_flag">用户类别：</label>
                    <input type="text" name="User_flag" id="User_flag"/>
                    <span >管理员/经理/普通用户</span>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                      <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>

</html>