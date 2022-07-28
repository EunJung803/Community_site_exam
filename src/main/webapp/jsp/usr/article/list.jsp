<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");  // 형 변환 해주기
%>

<%@ include file="../common/head.jspf"%>    <!-- 헤더 설정-->

<!-- 보통 구획은 이렇게 섹션으로 나눈다. -->
<section>
    <!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
    <!-- mx-auto : margin-left:auto; margin-right:auto; -->
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text=lg">게시물 리스트</h1>

        <ul class="mt-5">
            <% for ( ArticleDto article : articles ) { %>
            <li class="flex">
                <!-- id -->
                <a class="w-[60px] hover:underline hover:text-[blue]" href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%></a>
                <!-- 제목 -->
                <a class="flex-grow hover:underline hover:text-[blue]" href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getTitle()%></a>
                <!-- 수정 -->
                <a class="hover:underline hover:text-[blue] mr-5" href="/usr/article/modify/free/<%=article.getId()%>">수정</a>
                <!-- 삭제 -->
                <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[blue]" href="/usr/article/delete/free/<%=article.getId()%>">삭제</a>
            </li>
            <% } %>
        </ul>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>    <!-- 푸터 설정 -->