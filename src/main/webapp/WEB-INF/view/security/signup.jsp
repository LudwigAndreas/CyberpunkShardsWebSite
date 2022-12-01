<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Sign-Up" page="profile">
    <t:headerRedLine text="Sign-Up"/>

    <div class="cyberTile" style="min-width: 500px; align-items: center; width: 40%; margin-left: auto; margin-right: auto;">
        <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Welcome</h2>
        <form id="signUpForm" action="${pageContext.request.contextPath}/signup" method="POST" >
            <h2 style="margin: 15px auto 0 30px; text-align: start">Firstname</h2>
            <label>
                <input name="firstname" type="text" class="inputField" placeholder="Firstname" style="margin: 0 auto"/>
            </label>
            <h2 style="margin: 15px auto 0 30px; text-align: start">Lastname</h2>
            <label>
                <input name="lastname" type="text" class="inputField" placeholder="Lastname" style="margin: 0 auto"/>
            </label>
            <h2 style="margin: 15px auto 0 30px; text-align: start">Username</h2>
            <label>
                <input name="username" type="text" class="inputField" placeholder="Username" style="margin: 0 auto"/>
            </label>
            <h2 style="margin: 15px auto 0 30px; text-align: start">Email</h2>
            <label>
                <input name="email" type="email" class="inputField" placeholder="Email" style="margin: 0 auto"/>
            </label>
            <h2 style="margin: 15px auto 0 30px; text-align: start">Password</h2>
            <label>
                <input name="password" id="password" type="password" class="inputField" placeholder="Password" style="margin: 0 auto;"/>
            </label>
            <h2 style="margin: 15px auto 0 30px; text-align: start">Password Repeat</h2>
            <label>
                <input name="passwordRepeat" id="passwordRepeat" type="password" class="inputField" placeholder="Password" style="margin: 0 auto;"/>
            </label>
            <button class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px; ">
                REGISTER
            </button>
        </form>
        <a href="${pageContext.request.contextPath}/signin">
            <button class="titleBox" style="align-items: center; margin: 30px auto 30px; height: 50px; ">
                BACK TO LOGIN
            </button>
        </a>
    </div>

</t:mainLayout>