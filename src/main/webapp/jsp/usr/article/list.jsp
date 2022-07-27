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
        <a href="/usr/article/detail/free/<%=article.getId()%>"></a>
        <a href="/usr/article/modify/free/<%=article.getId()%>">수정</a>
        <a href="/usr/article/delete/free/<%=article.getId()%>">삭제</a>
    </li>
    <% } %>
</ul>