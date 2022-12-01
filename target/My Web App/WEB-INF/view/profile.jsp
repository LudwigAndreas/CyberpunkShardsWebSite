<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Profile" page="profile">
    <t:headerRedLine text="Profile"/>
    <article style="width: 100%; height: calc( 100% - 100px); display: flex;">
    <section id="section1" style="max-width: 800px;">
        <div class="cyberTile" style="align-items: center; height: auto">
            <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Profile Type</h2>
            <h2 style="text-align: start">Email: <span style="color: var(--cpYellow);">${user.getEmail()}</span></h2>
            <h2 style="text-align: start">Username: <span style="color: var(--cpYellow);">${user.getUsername()}</span></h2>
            <h2 style="text-align: start; ">FirstName: <span style="color: var(--cpYellow);">${user.getFirstname()}</span></h2>
            <h2 style="text-align: start">LastName: <span style="color: var(--cpYellow);">${user.getLastname()}</span></h2>
            <h2 style="text-align: start">Role: <span style="color: var(--cpYellow);">${user.getStatus()}</span></h2>
            <h2 class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px;">
                EDIT DATABASE
            </h2>
            <h2 class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px;">
                EDIT USER LIST
            </h2>
        </div>
        <a href="${pageContext.request.contextPath}/logout">
            <h2 class="titleBox" style="margin: 10px 10px 10px 80px; align-items: center; height: 50px; width: 40%">
                LOGOUT
            </h2>
        </a>
    </section>
    <section id="textBody">
        <p style="min-height: 95vh; height: 100%; width: 100%; display: flex; margin: 0px;">
            <span style="margin: auto; font-size: 30px; color: var(--cpRed);">[No entry selected]</span>
        </p>
    </section>
    </article>

</t:mainLayout>