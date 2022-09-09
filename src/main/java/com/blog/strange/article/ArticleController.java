//package com.blog.strange.article;
//
//import java.util.Date;
//import java.util.List;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Slf4j
//@Controller
//@RequestMapping(value ={"board/{board_subject}/{pg}"})
//public class ArticleController {
//	// for boardlist at menu
////	@Autowired
////	private BoardService boardService;
//
//	// for article list at body
////	@Autowired
////	private ArticleService articleService;
//
//	@Value("${pageSize}")
//	private long pageSize;
//
//	@Value("${blockSize}")
//	private long blockSize;
//
//	@GetMapping("articleinsert")
//	public String insertArticle(
//			@PathVariable String board_subject,
//			Model model
//			) {
//		log.info("parameter of insertArticle of ArticleController"+board_subject);
//
//		model.addAttribute("board_subject",board_subject);
//
//		return "article.articleinsert";
//	}
//
//	@PostMapping("articleinsert")
//	public String insertArticle(@ModelAttribute ArticleDTO articleDTO,
//		Model model) {
//
//		log.info(articleDTO.toString());
//		try {
//			articleService.insertArticle(articleDTO);
//			return "redirect:../1/";
//		} catch (Exception e) {
//			model.addAttribute("msg", "입력 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//	// show article of selected board
//	@GetMapping("/")
//	public String list(
//		@PathVariable String board_subject,
//		@PathVariable long pg,
//		Model model) throws Exception {
//
//		try {
//			// boardlist at menu
//			List<BoardDTO> boardlist = boardService.getBoardList();
//			model.addAttribute("boardlist", boardlist);
//
//			// articlelist at body
//			// recordCount ; 전체 게시글 수
//			long recordCount = articleService.getArticleCount(board_subject);
//			// 1 페이지당 20개씩 표현할려고하는데 전체 게시글 수가 42이면 2+1페이지까지 표현해야하기에 아래와같이 처리
//			long pageCount = recordCount / pageSize;
//			if (recordCount % pageSize != 0) pageCount++;
//
//			// 게시물
//			List<ArticleDTO> list = articleService.getArticleListPage(board_subject,pg);
//			//// 게시물 시간 처리부
//			// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
//			Date now = new Date();
//			log.info("now check "+now);
//			log.info("now check "+now.getDate());
//
//			// 페이징
//			long startPage = (pg - 1)/blockSize*blockSize+1;
//			long endPage   = startPage + blockSize - 1;
//			if (endPage > pageCount) endPage = pageCount;
//
//			// 게시판 선별과 article 선별
//			// 기본적으로 boardsubject를 고려하여 select 될 예정,
//			// 추가로 boardsubject 변수를 통해 jsp에도 추가로 필터링
//			model.addAttribute("now", now);
//			model.addAttribute("board_subject", board_subject);
//			model.addAttribute("list", list);
//
//			// 페이징
//			model.addAttribute("pageCount", pageCount);
//			model.addAttribute("pg", pg);
//
//			model.addAttribute("startPage", startPage);
//			model.addAttribute("endPage", endPage);
//
//			model.addAttribute("recordCount", recordCount);
//			model.addAttribute("pageSize", pageSize);
//
//			return "article.articlelist";
//		} catch (Exception e) {
//			model.addAttribute("msg", "board list 출력 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//}