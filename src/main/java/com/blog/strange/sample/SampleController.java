package com.blog.strange.sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    SampleService sampleService;
    
    @GetMapping({"/index"})
    public String getIndex() {
    	log.info("sample index is called");

        return "sample/index";
    }

    @GetMapping({"/articles"})
    public String findArticles(Model model) throws Exception {
        
        // 현재 가정한 샘플의 구체적인 속성은 글로서 articles이라는 속성명을 부여함
        model.addAttribute("articles",sampleService.findAllSample());

        return "sample/article/articles";
    }

    @GetMapping({"/articles/{id}"})
    public String findArticleDetail(Model model, @PathVariable Long id) throws Exception {
        // service단에서 optional을 통해서 한번 감싸놨기 때문에 아래와같이
        // ifPresent를 통해 null값이 아니라면, 그 다음 화면에 올린다.
        // 현재 가정한 샘플의 구체적인 속성은 글로서 article이라는 속성명을 부여함
        sampleService.findSampleDetailById(id).ifPresent(sample -> model.addAttribute("article", sample));
        return "sample/article/articleDetail";
    }

    //////////////////////////////////////////////////////
    ////////////// article 추가를 위한 컨트롤러들
    @GetMapping("/article")
    public String findArticleForm(Model model, Sample article) throws Exception {
        // 타임리프 form 태그 object 태그 사용을 위한 속성추가
        model.addAttribute("article", article);

        return "sample/article/articleInsert";
    }

    @PostMapping("/article")
    public String addArticle(@ModelAttribute Sample article) throws Exception {
        log.info(article.toString());
        sampleService.addArticle(article);

        return "redirect:/sample/articles";
    }

    //////////////////////////////////////////////////////
    ////////////// article 수정를 위한 컨트롤러들
    @GetMapping("/article/{id}")
    public String findArticleUpdateForm(Model model, @PathVariable Long id) throws Exception {
        log.info(sampleService.findSampleDetailById(id).toString());
        sampleService.findSampleDetailById(id).ifPresent(sample -> model.addAttribute("article", sample));
        return "sample/article/articleUpdate";
    }

    @PutMapping("/article")
    public String updateArticle(@ModelAttribute Sample article) throws Exception {
        log.info(article.toString());
        sampleService.updateArticle(article);

        return "redirect:/sample/articles";
    }


    //////////////////////////////////////////////////////
    ////////////// article 삭제를 위한 컨트롤러들, 참고로 삭제의 경우 ArticleDetail에서 javascript 확인창, prompt,을 통해 처리된다.

    @DeleteMapping("article/{id}")
    public void deleteArticle(@PathVariable Long id) throws Exception {
        log.info(id.toString());
        sampleService.deleteArticleById(id);

    }
}
