package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI();
        // getRequestURI는
        // 예를 들어, 전체 url "http://localhost:8081/usr/article/list/free?page=1" 중 에서
        // 중간에 있는 "/usr/article/list/free" 딱 이 부분만 가져온다.

        switch (url) {
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;

            case "/usr/member/login":
                memberController.showLogin(rq);
                break;
        }
    }
}
