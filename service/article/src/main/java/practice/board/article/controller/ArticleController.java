package practice.board.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.board.article.service.ArticleService;
import practice.board.article.service.request.ArticleCreateRequest;
import practice.board.article.service.request.ArticleUpdateRequest;
import practice.board.article.service.response.ArticlePageResponse;
import practice.board.article.service.response.ArticleResponse;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/v1/articles/{articleId}")
    public ArticleResponse read(@PathVariable("articleId") Long articleId) {
        return articleService.read(articleId);
    }

    @GetMapping("/v1/articles")
    public ArticlePageResponse readAll(
            @RequestParam("boardId") Long boardId,
            @RequestParam("page") Long page,
            @RequestParam("pageSize") Long pageSize
    ) {
        return articleService.readAll(boardId, page, pageSize);
    }

    @PostMapping("/v1/articles")
    public ArticleResponse create(@RequestBody ArticleCreateRequest request) {
        return articleService.create(request);
    }

    @PutMapping("/v1/articles/{articleId}")
    public ArticleResponse update(@PathVariable("articleId") Long articleId, @RequestBody ArticleUpdateRequest request) {
        return articleService.update(articleId, request);
    }

    @DeleteMapping("/v1/articles/{articleId}")
    public void delete(@PathVariable("articleId") Long articleId) {
        articleService.delete(articleId);
    }
}
