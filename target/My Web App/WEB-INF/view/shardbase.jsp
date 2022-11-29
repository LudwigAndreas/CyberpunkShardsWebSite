<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="DATABASE" page="database">
    <t:headerRedLine text="ShardDataBase"/>

    <article id="layout1">
        <section id="section1">
            <label>
                <input class="shardSearch" placeholder="Search..." oninput="searchShard(this);"/>
            </label>

            <c:forEach items="${shardSectionsList}" var="section">
                <t:articlesHeader secionName="${section.getTitle()}" numberOfArticles="${section.getShardList().size()}"/>
                <div id="articlesList" style="max-height: 0px;">
                    <c:forEach items="${section.getShardList()}" var="shard" >
                        <t:articleTitle titleName="${shard.getTitle()}" articleText="${shard.getContent()}"/>
                    </c:forEach>
                </div>
            </c:forEach>
        </section>

        <section id="textBody">
            <p style="height: 100%; width: 100%; display: flex; margin: 0px;">
                <span style="margin: auto; font-size: 30px; color: var(--cpRed);">[No entry selected]</span>
            </p>
        </section>
        <div id="margin" style="max-width: 200px; width:5%;"></div>
    </article>
</t:mainLayout>