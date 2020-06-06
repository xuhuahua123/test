<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
    <script>
        function gopage(nowpage){

            var totalpage = parseInt(document.getElementById("totalpage").value);

            if(parseInt(nowpage)<=0){
                alert("已经是第一页了");
            }else if(parseInt(nowpage)>totalpage){
                alert("已经是最后一页了");
            }else{
                splitform.index.value = nowpage;
                splitform.submit();
            }
        }

        $(function () {
            $("#btn").click(function () {

                $.ajax({
                    url:"mainlogin",
                    type:"post",
                    data:{"username":$("#username").val(),"password":$("#password").val()},
                    success:function (data) {
                    $("#login").css("display","none")
                    $("#info").html("欢迎你"+data);
                }

            })
            })
        })

         $(function () {
             var reg = /^\w{3,11}$/

             $("#username").blur(function () {
                 var name = $("#username").val()

                 if(reg.test(name)){
                     $("#usernameinfo").css("color","green").html("格式正确")
                 }else{

                     $("#usernameinfo").css("color","red").html("格式错误，3-11位，数字，和字母")
                 }
             })
         })
    </script>
</head>
<body>      <#if  Session['user']?exists>
                欢迎你${Session.user.loginName}
            <#else >
                <div id="info"></div>
                <div id="login" >
                    <form class="form-inline">
                    您还没有登录请登录<br>
                         账号：
                  <input id="username" class="form-control" type="text" name="username"><span id="usernameinfo" >*</span><br>
                          密码：
                  <input id="password" class="form-control" type="password" name="password">
                    <input  id="btn" class="btn btn-success" type="submit" value="登录" style="color: green">
                    </form>
                </div>
            </#if>


    <h3>这里是main页面</h3>
<a class="btn btn-default" href="gotoupload">新增</a>
<table class="table table-striped table-bordered"  >
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>出版社</th>
        <th>价格</th>
        <th>出版日期</th>
        <th>作者</th>
        <th>简介</th>
        <th>操作</th>
    </tr>
    <#list booklist as bl>
        <tr>
            <td>${bl.bookId }</td>
            <td>
                <a href="byid?id=${bl.bookId }" >${bl.bookName }</a>
            </td>
            <td>${bl.publicDept }</td>
            <td>
                ￥${bl.bookPrice?string('0.00')}
                <#--  <fmt:formatNumber value="${bl.bookPrice }" pattern="￥00.00" ></fmt:formatNumber>-->
            </td>
            <td>
                ${bl.publicDate?string("yyyy-MM-dd ")}
                <#--<fmt:formatDate value="${}" pattern="yyyy-MM-dd" />-->
            </td>
            <td>${bl.bookAuth }</td>
            <#-- <td>${bl.summary.substring(0,15) }...</td> -->
            <td>
               <#if bl.summary?length <15>
                    ${bl.summary}
                <#else >
                    ${bl.summary?substring(0,15)}...
                </#if>

              <#-- ${fn:substring(bl.summary,0,15) }${fn:length(bl.summary)>15?"...":"" }-->
            </td>
            <td></td>
        </tr>
    </#list>
</table>

    <form name="splitform" action="page" method="post" >
        <input type="hidden" value="${totalpage }" name="totalpage" id="totalpage" />
        <input type="hidden" value="${count }" name="count" id="count" />
        <input type="hidden" value="${index }" name="index" id="index" />
        <input type="hidden" value="${pageSize }" name="pageSize" id="pageSize" />


        <input type="button"  class="btn btn-primary" value="首页" onclick="gopage('1');" />
        <input type="button"   class="btn btn-default" value="上一页" onclick="gopage('${index-1}');" />

        <a href="javascript:void(0);" >${index }</a>

        <input type="button"  class="btn btn-default" value="下一页" onclick="gopage('${index+1}');" />
        <input type="button"  class="btn btn-primary" value="尾页" onclick="gopage('${totalpage}');" />
        <span class="splitinfo">
		共计有<b>${count }</b>行数据，分为<b>${totalpage }</b>页，每页显示<b>${index }</b>行,当前是第<b>${pageSize }</b>页
	</span>
    </form>
</body>
</html>