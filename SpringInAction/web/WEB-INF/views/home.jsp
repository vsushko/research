<%--
  Created by IntelliJ IDEA.
  User: vsa
  Date: 20.11.14
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <h2>A global community of friends and strangers spitting out their
        inner-most and personal thoughts on the web for everyone else to
        see.
    </h2>
    <h3>Look at what these people are spitting right now...</h3>

    <ol class="spittle-list">
        <%-- по всему списку сообщений --%>
        <c:forEach var="spittle" items="${spittles}">
            <s:url value="/spitters/{spitterName}" var="spitter_url">
                <s:param name="spitterName" value="${spittle.spitter.username}"/>
            </s:url>
            <li>
                <span class="spittleListImage">
                    <img src="http://s3.amazonaws.com/spitterImages/${spittle.spitter.id}.jpg"
                            width="40"
                            border="0"
                            align="middle"
                            onerror="this.scr='<s:url value="/resources/images"/>/spitter_avatar.png';"/>
                </span>
                <span class="spittleListText">
                    <a href="${spittle_url}">
                        <c:out value="${spittle.spitter.username}"/>
                        <c:out value="${spittle.text}"/><br/>
                        <small><fmt:formatDate value="${spittle.when}" pattern="hh:mma MMM d, yyyy"/></small>
                    </a>
                </span>
            </li>
        </c:forEach>
    </ol>
</div>