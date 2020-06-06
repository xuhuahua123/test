<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
    <h3>这里是add页面</h3>
    <form action="upload" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="bookName">书名</label>
    <input type="text" class="form-control" id="bookName" name="bookName" style="width: 249px">
    </div>
    <div class="form-group">
        <label for="bookName">出版社</label>
    <input class="form-control" type="text" id="" name="publicDept"  style="width: 249px">
    </div>

    <div class="form-group">
        <label for="bookName">图书价格</label>
    <input class="form-control" type="text" id="" name="bookPrice"  style="width: 249px">
    </div>
    <div class="form-group">
        <label for="bookName">出版时间</label>
    <input  class="form-control" type="date" id="" name="publicDate" style="width: 249px">
    </div>
     <div class="form-group">
         <label for="bookName"> 作者</label>
   <input class="form-control" type="text" id="" name="bookAuth" style="width: 249px">
     </div>
    <div class="form-group">
        <label for="bookName">上传图片</label>
    <input class="form-control" type="file" id="" name="pic" style="width: 249px">
    </div>
        <div class="form-group">
            <label for="bookName"> 简介</label>
       <textarea  class="form-control"  id="" name="summary" style="height: 130px" ></textarea>
        </div>
    <input type="submit" class="btn btn-success" value="提交">
    <input type="reset" class="btn btn-warning" value="重置">
    </form>




</body>
</html>