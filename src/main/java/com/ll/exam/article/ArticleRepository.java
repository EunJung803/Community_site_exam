package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static List<ArticleDto> datum;
    private static long lastID;

    static {
        datum = new ArrayList<>();
        lastID = 0;

        makeTestData();     // 프로그램 실행 시 데이터가 채워진다.
    }

    // 매번 테스트를 하기 번거로우니 생성
    private static void makeTestData() {
        // for문과 같음, 이 함수가 10번 반복된다.
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "제목 %d".formatted(id);
            String body = "내용 %d".formatted(id);
            write(title, body);
        });
    }

    public static long write(String title, String body) {
        long id = ++lastID;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);
        datum.add(newArticleDto);

        return id;
    }

    public static List<ArticleDto> findAll() {
        return datum;
    }

    public static ArticleDto findById(long id) {
        for ( ArticleDto articleDto : datum ) {
            if ( articleDto.getId() == id ) {
                return articleDto;
            }
        }

        return null;
    }
}
