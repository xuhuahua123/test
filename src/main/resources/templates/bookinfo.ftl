<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script>
        function buybook(val) {
            window.location.href ="check/order?id="+val;
        }
    </script>
</head>
<body>
    <h3>这里是bookinfo页面</h3>

<table class="table table-striped table-bordered">
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

        <tr>
            <td>${book.bookId }</td>
            <td>
                ${book.bookName }
            </td>
            <td>${book.publicDept }</td>
            <td>
                ￥${book.bookPrice?string('0.00')}
                <#--  <fmt:formatNumber value="${bl.bookPrice }" pattern="￥00.00" ></fmt:formatNumber>-->
            </td>
            <td>
                ${book.publicDate?string("yyyy-MM-dd")}
                <#--<fmt:formatDate value="${}" pattern="yyyy-MM-dd" />-->
            </td>
            <td>${book.bookAuth }</td>
            <#-- <td>${bl.summary.substring(0,15) }...</td> -->
            <td>
                ${book.summary}

              <#-- ${fn:substring(bl.summary,0,15) }${fn:length(bl.summary)>15?"...":"" }-->
            </td>
            <td></td>
        </tr>
        <img src="/bookshop/${book.imgPath}" width="220px">
        <a  class="btn btn-warning" href="download?filename=${book.imgPath }" >下载</a>
        <input type="button" class="btn btn-success" value="购买" onclick="buybook('${book.bookId }');" />
</table>


</body>
</html>