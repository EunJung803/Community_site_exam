package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);    // 리포지터리에게 넘기기
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();     // 리포지터리에게 넘기기
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }
}
