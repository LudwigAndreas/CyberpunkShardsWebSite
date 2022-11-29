<%@tag description="Article titile box" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="titleName" %>
<%@attribute name="articleText" %>



<h3 class="titleBox" onclick="showTextArticles('${articleText}', this);">
    <img class="wrench" loading="lazy" height="30" width="30" src="${pageContext.request.contextPath}/assets/images/cyberpunk_assets/wrench.svg" alt=""/>
    <span>${titleName}</span>
</h3>