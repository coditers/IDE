<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/image/0630_favicon_beige.ico">
    <title>instruction</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/materialize-custom.css"
          media="screen,projection"/>
</head>

<body class="orange lighten-5 flexbody">
<jsp:include page="/WEB-INF/views/header_light.jsp"></jsp:include>
<div class="section no-pad-bot" id="index-banner">
    <br>
    <br>
    <div class="row ">
        <div class="col s6 offset-s3">
            <div class="card-panel white">
                <h4 class="header center black-text bold">test instructions</h4>
                <br>
                <div class="row">
                    <div class="col s8 offset-s2">
                        <h6>1. Once you start test, you can not manualy stop this test<br>
                            <br>2. A sourcecode you finally saved will be marked<br>
                            <br>3. You can use other editor<br>
                            <br>4. NO cheating. Don't be evil</h6>
                    </div>
                </div>
                <div class="row center">
                    <br>
                    <br>
                    <div class="col s3 offset-s3">
                        <a href="${pageContext.request.contextPath}/practice">
                            <button class="btn brown white-text">Practice test</button>
                        </a>
                    </div>
                    <div class="col s3 ">
                        <a href="${pageContext.request.contextPath}/test">
                            <button class="btn brown white-text">Start test</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
