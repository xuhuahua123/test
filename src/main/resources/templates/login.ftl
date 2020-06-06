<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript">
        $(function () {
            alert("123")
        })
       /* $(function () {
            var reg = /^[a-zA-Z]\w{3,15}$/
            $("#username").blur(function () {
                if(reg.test(this.val())){
                    $("#usernameinfo").html("格式错误，3-15位，数字，和字母")
                }
            })
        })*/
    </script>
</head>
<body>
    <form action="/bookshop/login" method="post">

        账号：<input type="text" id="username" name="username"><span id="usernameinfo">*</span><br>
        密码：<input type="password" id="password" name="password"><br>
        <input type="hidden" name="id" value=" ${RequestParameters["id"]}">
        <input type="submit" value="登录">
    </form>




</body>
</html>