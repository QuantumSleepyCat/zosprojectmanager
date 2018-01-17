<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Promote</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous"/>
    <style>
        .report_form
        {
            width: 70%;
            left: 15%;
            position: relative;
            border: 1px solid black;
            border-radius: 10px;
            padding: 20px;
            top: 50px;
        }
    </style>
</head>
<body>
<div class="report_form">
        <c:forEach items="${items}" var="item">
        <table class="table" style="border: 1px solid #a6aba4;">
            <thead>
            <tr class="bg-success" style="color: white;">
                <th colspan="2">${item.name}</th>
            </tr>
            </thead>

                <c:forEach items="${item.dataSets}" var="dataset">
                <thead class="thead-inverse">
                <tr>
                    <th>From</th>
                    <th>To</th>
                </tr>
                </thead>
                <tr>
                    <th>${dataset.itemValue}</th>
                    <th>${dataset.itemRemark}</th>
                </tr>

                    <c:forEach items="${dataset.members}" var="member">
                    <tr>
                        <td>${member}</td>
                        <td></td>
                    </tr>
                    </c:forEach>

                </c:forEach>
        </table>
        </c:forEach>
    <form action="/answer" method="post">
        <p>Report id <input class="form-control" type="text" readonly="readonly" value="${id}" name="idrep"/> </p>
        <textarea name="comment" class="form-control" placeholder="Comment..."></textarea>
        <input type="submit" name="approve" value="Approve" class="btn btn-success btn-sm"/>
        <input type="submit" name="reject" value="Reject" class="btn btn-danger btn-sm"/>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>