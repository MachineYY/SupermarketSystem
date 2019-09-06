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
                <li id="active"><a href="billList.jsp">账单管理</a></li>
                <li><a href="providerList.jsp">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form class="billAdd" action="Bill_Add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="Bill_number">订单编码：</label>
                    <input type="text" name="Bill_number" id="Bill_number" />
                    <span>*请输入订单编码</span>
                </div>
                <div>
                    <label for="Bill_Pname">商品名称：</label>
                    <input type="text" name="Bill_Pname" id="Bill_Pname" />
                    <span >*请输入商品名称</span>
                </div>
                <div>
                    <label for="Bill_Punit">商品单位：</label>
                    <input type="text" name="Bill_Punit" id="Bill_Punit" />
                    <span>*请输入商品单位</span>

                </div>
                <div>
                    <label for="Bill_Pquantity">商品数量：</label>
                    <input type="text" name="Bill_Pquantity" id="Bill_Pquantity" />
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label for="Bill_Total">总金额：</label>
                    <input type="text" name="Bill_Total" id="Bill_Total" />
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label for="Bill_Pprovider">供应商：</label>
                    <input type="text" name="Bill_Pprovider" id="Bill_Provider" />
                   
                    <span>*请选择供应商</span>
                </div>
                <div>
                    <label >是否付款：</label>
                  <input type="text" name="Bill_State" id="Bill_State" />
                    
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
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