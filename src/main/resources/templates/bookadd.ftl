<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
    <h3>这里是add.jsp页面</h3>
    <form action="uploadByServlet" method="post" enctype="multipart/form-data">
    书名<input type="text" id="" name="bookName"></br>
    出版社<input type="text" id="" name="publicDept"></br>
    图书价格<input type="text" id="" name="bookPrice"></br>
    出版时间<input type="date" id="" name="publicDate"></br>
    作者<input type="text" id="" name="bookAuth"></br>
    上传图片<input type="file" id="" name="file"></br>
        简介<textarea  id="" name="summary"></textarea></br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    </form>




</body>
</html>