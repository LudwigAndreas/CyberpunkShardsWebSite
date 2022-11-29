<%@tag description="Main header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="page" %>

<div class="articlesHeader"><a href="${pageContext.request.contextPath}/profile" style="color:
<c:choose>
<c:when test="${page.equals('profile')}">var(--cpBlueHL)</c:when>
<c:otherwise>var(--cpRed)</c:otherwise>
</c:choose>
        ; margin-left: 0px;">PROFILE</a></div>

<div class="articlesHeader"><a href="${pageContext.request.contextPath}/database" style="color:
<c:choose>
<c:when test="${page.equals('database')}">var(--cpBlueHL)</c:when>
<c:otherwise>var(--cpRed)</c:otherwise>
</c:choose>
        ; margin-left: 0px;">DATABASE</a></div>

<%--<div class="articlesHeader"><a href="${pageContext.request.contextPath}/usage" style="color:--%>
<%--<c:choose>--%>
<%--<c:when test="${page.equals('usage')}">var(--cpBlueHL)</c:when>--%>
<%--<c:otherwise>var(--cpRed)</c:otherwise>--%>
<%--</c:choose>--%>
<%--        ; margin-left: 0px;">USAGE</a></div>--%>

<div class="articlesHeader"><a href="${pageContext.request.contextPath}/about" style="color:
<c:choose>
<c:when test="${page.equals('about')}">var(--cpBlueHL)</c:when>
<c:otherwise>var(--cpRed)</c:otherwise>
</c:choose>
        ; margin-left: 0px;">ABOUT</a></div>