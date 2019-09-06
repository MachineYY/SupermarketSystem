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
                <li id="active"><a href="providerList.jsp">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form class="providerAdd" action="Provider_Add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="Provider_number">供应商编码：</label>
                    <input type="text" name="Provider_number" id="Provider_number"/>
                    <span>*请输入供应商编码</span>
                </div>
                <div>
                    <label for="Provider_name">供应商名称：</label>
                    <input type="text" name="Provider_name" id="Provider_name"/>
                    <span >*请输入供应商名称</span>
                </div>
                <div>
                    <label for="Provider_contact">联系人：</label>
                    <input type="text" name="Provider_contact" id="Provider_contact"/>
                    <span>*请输入联系人</span>

                </div>
                <div>
                    <label for="Provider_tel">联系电话：</label>
                    <input type="text" name="Provider_tel" id="Provider_tel"/>
                    <span>*请输入联系电话</span>
                </div>
             <!--    <div>
                    <label for="address">联系地址：</label>
                    <input type="text" name="address" id="address"/>
                    <span></span>
                </div> -->
                <div>
                    <label for="Provider_fax">传真：</label>
                    <input type="text" name="Provider_fax" id="Provider_fax"/>
                    <span></span>
                </div>
                <div>
                    <label for="Provider_ctime">创建时间：</label>
                    <input type="text" name="Provider_ctime" id="Provider_ctime"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                   <!--  <input type="button" value="保存" onclick="history.back(-1)"/> -->
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