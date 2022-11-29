<%@tag description="Header of articles in knowledgeBase" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="secionName" %>
<%@attribute name="numberOfArticles" %>

<h2 class="sectionHeader" onclick="toggleList(this);">${secionName}<span id="articlesNum" style="color: var(--cpYellow); margin-left: 10px;">(${numberOfArticles})</span>
    <img class="wrench" height="30" width="30" style="margin: auto 0px auto auto; rotate: -90deg" loading="lazy" src="${pageContext.request.contextPath}/assets/images/cyberpunk_assets/cpArrow.svg" alt=""/>
</h2>