<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Status</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous"/>

    <link rel="stylesheet" href="/resources/css/formStyle.css"/>
    
</head>
<body>
<jsp:include page="navigate.jsp"/>

<div class="statusbar">
    <h4>${job.pageInfoModel.applicationName}</h4>
    <hr>
    <h6>Status: ${job.status}</h6>
    <div class="form-group">
        <label for="comment"> <h6>Comment:</h6></label>
        <textarea class="form-control" rows="5" id="comment" readonly>${job.comment}</textarea>
    </div>
    <c:if test="${job.status eq 'Approved'}">
        <a href="/send/${job.pageInfoModel.id}" type="button" class="btn btn-outline-primary">Start</a>
    </c:if>
    <p>
<a class="btn btn-outline-warning btn-sm" data-toggle="collapse" href="#linkcollapse" aria-expanded="false" aria-controls="Collapse">
Logs
</a>
</p>
<div class="collapse" id="linkcollapse">
<div class="card card-block">
<c:forEach items="${logs}" var="logPart" varStatus="logCounter">
<a class="btn btn-outline-warning btn-sm" data-toggle="collapse" href="#linkcoll${logCounter.count}" aria-expanded="false" aria-controls="Collapse" style="margin-bottom: 5px;">Log ${logCounter.count} - ${logPart[2]}</a> 
<div class="collapse" id="linkcoll${logCounter.count}">
<div class="card card-block">
<code>
       <c:forEach items="${logPart}" var="line">
        ${line}<br>
       </c:forEach>
            </code>
            </div>
            </div>
            </c:forEach>
</div>
</div>

          
    
</div>



<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>