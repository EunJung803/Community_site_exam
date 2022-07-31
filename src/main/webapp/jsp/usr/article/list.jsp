<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>    <!-- 헤더 설정-->

<!-- 보통 구획은 이렇게 섹션으로 나눈다. -->
<section>
    <!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
    <!-- mx-auto : margin-left:auto; margin-right:auto; -->
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text=lg">게시물 리스트</h1>

        <ul class="mt-5">
            <c:forEach items="${articles}" var="article"> <!-- el에서 반복문을 쓰지 못하는 것을 보완 -->
            <li class="flex">
                <!-- id -->
                <a class="w-[60px] hover:underline hover:text-[blue]" href="/usr/article/detail/free/${article.id}">${article.id}</a>
                <!-- 제목 -->
                <a class="flex-grow hover:underline hover:text-[blue]" href="/usr/article/detail/free/${article.title}">${article.title}</a>
                <!-- 수정 -->
                <a class="hover:underline hover:text-[blue] mr-5" href="/usr/article/modify/free/${article.id}">수정</a>
                <!-- 삭제 -->
                <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[blue]" href="/usr/article/delete/free/${article.id}">삭제</a>
            </li>
            </c:forEach>
        </ul>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>    <!-- 푸터 설정 -->