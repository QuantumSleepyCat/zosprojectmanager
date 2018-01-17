<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Z/OS report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous"/>

    <link rel="stylesheet" href="/resources/css/formStyle.css"/>
</head>
<body>
<jsp:include page="navigate.jsp"/>
<form:form action="sendtoftp" method="post" modelAttribute="pageInfo" id="mainForm">
<div id="input_form">


        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Application name</span>
            <form:input path="applicationName" type="text" class="form-control" name="name"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Project/CR id</span>
            <form:input path="prodect_CR_ID" type="text" class="form-control" name="prodect_CR_ID"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Requester</span>
            <form:input path="requester" type="text" class="form-control" name="requester"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Transfer date</span>
            <form:input path="transferDate" type="text" class="form-control" name="transferDate"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Region</span>
            <form:input path="region" type="text" class="form-control" name="region"/>
        </div>
        <%--  <details>
              <summary>Item for promote</summary>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item name</span>
                  <form:input path="items[0].name" type="text" class="form-control" name="item-name"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item value</span>
                  <form:input path="items[0].dataSets[0].itemValue" type="text" class="form-control" name="itemValue"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item remark</span>
                  <form:input path="items[0].dataSets[0].itemRemark" type="text" class="form-control" name="itemRemark"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[0].dataSets[0].members[0]" type="text" class="form-control" name="member"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[0].dataSets[0].members[1]" type="text" class="form-control" name="member"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[0].dataSets[0].members[2]" type="text" class="form-control" name="member"/>
              </div>
        <details>
          </details><%--
              <summary>Promote PLI sources (CEMA)</summary>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item name</span>
                  <form:input path="items[1].name" type="text" class="form-control" name="item-name" value="Promote PLI sources (CEMA)"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item value</span>
                  <form:input path="items[1].dataSets[0].itemValue" type="text" class="form-control" name="itemValue"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Item remark</span>
                  <form:input path="items[1].dataSets[0].itemRemark" type="text" class="form-control" name="itemRemark"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[1].dataSets[0].members[0]" type="text" class="form-control" name="member"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[1].dataSets[0].members[1]" type="text" class="form-control" name="member"/>
              </div>
              <div class="input-group" style="margin-bottom: 10px;">
                  <span class="input-group-addon">Member</span>
                  <form:input path="items[1].dataSets[0].members[2]" type="text" class="form-control" name="member"/>
              </div>
          </details> --%>
        <input class="btn btn-primary" style="bottom: 10px; right: 10px; position: absolute;" type="submit" value="Send"/>


    <!--<a class="btn btn-default" href="/sendtoftp" role="button">Send</a>-->

</div>

<div class="add_options">
    <input id="nitems" type="number" class="form-control" placeholder="Number of data">
    <input id="nmembers" type="number" class="form-control" placeholder="Number of members">
    <input class="btn btn-success btn-sm" type="button" value="New Item" id="addfields"/>
</div>
<div class="add_options" style="top: 20px;">
    <input type="text" class="form-control" placeholder="Server..." name="sendInfo.server">
    <input  type="text" class="form-control" placeholder="User..." name="sendInfo.username">
    <input  type="password" class="form-control" placeholder="Password..." name="sendInfo.password">
    <input  type="text" class="form-control" placeholder="Client email..." name="sendInfo.cl_email">
</div>
</form:form>
<%--<script>
    function addfields() {
        var p = d.createElement('details');
        p.innerHTML='<summary>Promote Overlays</summary>\n' +
            '            <div class="input-group" style="margin-bottom: 10px;">\n' +
            '                <span class="input-group-addon">Item name</span>\n' +
            '                <form:input path="items[0].name" type="text" class="form-control" name="item-name" value="Promote Overlays"/>\n' +
            '            </div>\n' +
            '            <div class="input-group" style="margin-bottom: 10px;">\n' +
            '                <span class="input-group-addon">Item value</span>\n' +
            '                <form:input path="items[0].dataSets[0].itemValue" type="text" class="form-control" name="itemValue"/>\n' +
            '            </div>\n' +
            '            <div class="input-group" style="margin-bottom: 10px;">\n' +
            '                <span class="input-group-addon">Item remark</span>\n' +
            '                <form:input path="items[0].dataSets[0].itemRemark" type="text" class="form-control" name="itemRemark"/>\n' +
            '            </div>\n' +
            '            <div class="input-group" style="margin-bottom: 10px;">\n' +
            '                <span class="input-group-addon">Member</span>\n' +
            '                <form:input path="items[0].dataSets[0].members[0]" type="text" class="form-control" name="member"/>\n' +
            '            </div>';

        newFields.appendChild(p);
        return false;
    }
    var d = document,
        myForm = d.getElementById('mainForm'),
        newFields = myForm.querySelector('#new_fields'),
        butAdd = d.getElementById('addfields'),
        countMain=0;
    butAdd.addEventListener('click', addfields, false);
</script>--%>
<script src="/resources/addnew.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>