<%@tag description="Header red line" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="text" %>

<div id="shardsHeader" style="display: flex;"><hr class="headerRedLine">
    <h1 style="margin: 0px 20px; font-size: 25px; white-space: nowrap;">${text}</h1>
    <hr class="headerRedLine">
</div>