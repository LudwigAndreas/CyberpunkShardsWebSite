<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Sign-in" page="profile">
    <t:headerRedLine text="Sign-in"/>

    <div class="cyberTile" style="align-items: center; width: 40%; height: 50%; margin-left: auto; margin-right: auto;">
        <h2 style="margin: 10% auto;font-size: 30px; white-space: nowrap;">Welcome</h2>
        <h2 style="margin: 0 auto 0 30px; text-align: start">Username</h2>
        <label>
            <input type="text" class="inputField" placeholder="Username or email" oninput="searchShard(this);" style="margin: 0 auto"/>
        </label>
        <h2 style="margin: 15px auto 0 30px; text-align: start">Password</h2>
        <label>
            <input type="text" class="inputField" placeholder="Password" oninput="searchShard(this);" style="margin: 0 auto;"/>
        </label>
        <h3 class="titleBox" style="align-items: center; margin: 30px auto 0; height: 50px;" onclick="login();">
            LOGIN
        </h3>
    </div>

</t:mainLayout>