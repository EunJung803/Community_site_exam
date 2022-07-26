<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");  // 형 변환 해주기
%>

<h1>게시물 리스트</h1>

<ul>
    <% for ( ArticleDto article : articles ) { %>
    <li>
        <a href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%>. <%=article.getTitle()%></a>
    </li>
    <% } %>
</ul>