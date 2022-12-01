<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Profile" page="profile">
    <t:headerRedLine text="Profile"/>
    <article style="width: 100%; height: calc( 100% - 100px); display: flex;">
    <section id="section1">
        <div class="cyberTile" style="align-items: center; height: auto;">
            <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Profile Type</h2>
            <h2 style="text-align: start">Email: <span style="color: var(--cpYellow);">${user.getEmail()}</span></h2>
            <h2 style="text-align: start">Username: <span style="color: var(--cpYellow);">${user.getUsername()}</span></h2>
            <h2 style="text-align: start; ">FirstName: <span style="color: var(--cpYellow);">${user.getFirstname()}</span></h2>
            <h2 style="text-align: start">LastName: <span style="color: var(--cpYellow);">${user.getLastname()}</span></h2>
            <h2 style="text-align: start">Role: <span style="color: var(--cpYellow);">${user.getStatus()}</span></h2>
            <c:if test="${user.getStatusId() < 3}" >
                <h2 class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px;" onclick="loadDataBase(this)">
                    EDIT DATABASE
                </h2>
            </c:if>
            <c:if test="${user.getStatusId() < 2}" >
                <h2 class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px;" onclick="loadUserList(this)">
                    EDIT USER LIST
                </h2>
            </c:if>
        </div>
        <a href="${pageContext.request.contextPath}/logout">
            <h2 class="titleBox" style="margin: 10px 10px 10px 80px; align-items: center; height: 50px; width: 40%">
                LOGOUT
            </h2>
        </a>
    </section>
        <template id="createShardTemplate">
            <div id = "createShardForm" class="cyberTile" style="min-width: 500px; align-items: center; width: 100%; margin-left: auto; margin-right: auto;">
                <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Add new shard</h2>
                <form id="signUpForm" action="${pageContext.request.contextPath}/signup" method="POST" >
                    <h2 style="margin: 15px auto 0 30px; text-align: start">Section</h2>
                    <label>
                        <select class="inputField" name="hero[]" style="margin: 0 auto">
                            <option>Option 1</option>
                            <option selected>Option 2</option>
                            <option>Option 3</option>
                        </select>
                    </label>
                    <h2 style="margin: 15px auto 0 30px; text-align: start">Title</h2>
                    <label>
                        <textarea class="inputField" name="title"></textarea>
                    </label>
                    <h2 style="margin: 15px auto 0 30px; text-align: start">Text</h2>
                    <label>
                        <textarea class="inputField" name="title"></textarea>
                    </label>
                    <button class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px; ">
                        ADD
                    </button>
                </form>
            </div>
        </template>
    <section id="textBody">
        <p id="noEntry" style="min-height: 95vh; height: 100%; width: 100%; display: flex; margin: 0px;">
            <span style="margin: auto; font-size: 30px; color: var(--cpRed);">[No entry selected]</span>
        </p>
    </section>
    </article>

</t:mainLayout>