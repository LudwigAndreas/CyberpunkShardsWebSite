<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Sign-in" page="profile">
    <t:headerRedLine text="Sign-in"/>

    <div class="cyberTile" style="min-width: 500px; align-items: center; width: 40%; margin-left: auto; margin-right: auto;">
        <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Ay, Choomba!</h2>
        <form id="loginForm" action="${pageContext.request.contextPath}/signin" method="POST" >
        <h2 style="margin: 0 auto 0 30px; text-align: start">Username</h2>
        <label>
            <input id="username" name="username" type="text" class="inputField" placeholder="Username or email" style="text-transform: none; margin: 0 auto"/>
        </label>
        <h2 style="margin: 15px auto 0 30px; text-align: start">Password</h2>
        <label>
            <input id="password" name="password" type="password" class="inputField" placeholder="Password" style="text-transform: none; margin: 0 auto;"/>
        </label>
        <button class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px;">
            LOGIN
        </button>
        </form>
        <a href="${pageContext.request.contextPath}/signup">
            <button class="titleBox" style="align-items: center; margin: 30px auto 100px; height: 50px; ">
                REGISTER
            </button>
        </a>
    </div>

</t:mainLayout>