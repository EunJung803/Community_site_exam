package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = articleService.findAll();   // Dto == 단순 데이터 담는 역할

        rq.setAttr("articles", articleDtos);

        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

//        rq.appendBody("<div>title : %s</div>".formatted(title));
//        rq.appendBody("<div>body : %s</div>".formatted(body));

        long id = articleService.write(title, body);
        rq.print("%d번 게시물이 생성 되었습니다.".formatted(id));
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.print("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {   // id를 못찾으면
            rq.print("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.print("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.print("해당 글이 존재하지 않습니다.");
            return;
        }

        articleService.delete(id);      // 삭제 진행

        rq.print("<div>%d번 게시물이 삭제되었습니다.</div>".formatted(id));    // 삭제 안내 알림
        rq.print("<div><a href=\"/usr/article/list/free\">리스트로 이동</a></div>");   // 리스트로 이동
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.print("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.print("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);      // 세션 설정
        rq.view("usr/article/modify");
    }
    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

//        rq.appendBody("<div>id : %d</div>".formatted(id));
//        rq.appendBody("<div>title : %s</div>".formatted(title));
//        rq.appendBody("<div>body : %s</div>".formatted(body));

        articleService.modify(id, title, body);

        rq.print("<div>%d번 게시물이 수정되었습니다.</div>".formatted(id));
        rq.print("<div><a href=\"/usr/article/detail/free/%d\">수정된 글로 이동</a></div>".formatted(id));
    }
}
