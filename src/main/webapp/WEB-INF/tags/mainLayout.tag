<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" %>
<%@attribute name="page" %>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/favicon.png">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon32.ico"><!-- 32×32 -->
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.svg" type="image/svg+xml">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/assets/images/faviconApple.png"><!-- 180×180 -->

<%--    <link rel="manifest" href="${pageContext.request.contextPath}/assets/images/manifest.webmanifest">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap.min.js">--%>

    <link rel="preload" href="${pageContext.request.contextPath}/assets/style/fonts/BlenderPro-Book.woff2" as="font" type="font/woff2" crossorigin="anonymous">
    <link rel="preload" href="${pageContext.request.contextPath}/assets/style/fonts/BlenderPro-Bold.woff2" as="font" type="font/woff2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style/layout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style/cyberpunk.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style/glitch.css">
    <script src="${pageContext.request.contextPath}/assets/js/cyberpunk_shards.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<%--    <script src="assets/js/shardsdb.js" defer></script>--%>
<%--    <script src="assets/js/shard_search.js" defer></script>--%>
</head>
<body>
        <t:header page="${page}"/>
        <jsp:doBody/>
</body>
</html>