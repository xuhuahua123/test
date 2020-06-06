<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
    <script>
        $(function () {

            $.ajax({
                url:"gerAcc",
                type:"get",
                success:function (data) {
                $.each(data,function(index,val){
                    $("#acc").append("<option value='"+val.accId+"' >"+val.accId+"</option>")

                })
            }
            })
            $("#acc").change(function(){
                $.ajax({
                    url:"balance",
                    type:"get",
                    data:{"id":$("#acc") .val()},
                    success:function(data){
                        $("#balance").html("￥"+data);
                }
            })
            })
        })
    </script>
</head>
<body>
    <form action="tobuy" id="" method="post">
        <input type="hidden" id="" name="bookId" value="${book.bookId}">

  <ul>


      <li>书名：${book.bookName}</li>
      <li>出版社${book.publicDept }</li>
      <li>单价  ￥${book.bookPrice?string('0.00')}</li>
      <li>作者${book.bookAuth }</li>
      <li>库存${storeHouse.bookCount}</li>

  </ul>
    <select name="accId" id="acc">
        <option value="" >=====选择账户id=====</option>
    </select>
    <br>
    账户余额：<span id="balance"></span>
     <input type="submit" value="购买" >
    </form>

</body>
</html>