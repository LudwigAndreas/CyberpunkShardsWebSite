<%@tag description="Main header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="page" %>

<section id="header">
    <a id="level" class="headerText" href="${pageContext.request.contextPath}/" style="color: var(--cpBlue);">11 LEVEL</a>
    <div id="streetLevel" class="headerText" style="color: var(--cpGreen); margin-left: 0px;">9 STREET CRED</div>

    <t:menuButtons page="${page}"/>
    <div class="headerText" style="color: var(--cpRedHL);">
        <img class="wrench" height="30" width="30" style="margin: auto 15px;" loading="lazy" src="${pageContext.request.contextPath}/assets/images/cyberpunk_assets/storage.svg" alt=""/>
        126/280
    </div>
    <div id="money" class="headerText" style="color: var(--cpRedHL);">
        <img class="wrench" height="30" width="30" style="margin: auto 15px; float: right;" loading="lazy" src="${pageContext.request.contextPath}/assets/images/cyberpunk_assets/money.svg" alt=""/>
        3606454
    </div>
</section>