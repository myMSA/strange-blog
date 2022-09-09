//package com.blog.strange.article;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.eveadam.blog.dto.article.ArticleDTO;
//import com.eveadam.blog.dto.reply.ReplyDTO;
//import com.eveadam.blog.service.article.ArticleService;
//import com.eveadam.blog.service.reply.ReplyService;
//
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@Controller
//@RequestMapping("board/{board_subject}/{pg}/{article_id}")
//public class ArticleDetailController {
//
//	@Autowired
//	private ReplyService replyService;
//
//	@Autowired
//	private ArticleService articleService;
//
//	@GetMapping(value = "/")
//	public String detail(
//			@PathVariable long pg,
//			@PathVariable long article_id,
//			Model model) {
//
//		try {
//			log.info(pg);
//			log.info(article_id);
//			// reply related
//			List<ReplyDTO> replylist = replyService.getReplyList(article_id);
//			log.info(replylist);
//
//			// article selected
//			ArticleDTO articleDTO = articleService.getDetail(article_id);
//
//			// delivering replylist of article and detail of article
//			model.addAttribute("replylist", replylist);
//			model.addAttribute("articleDTO", articleDTO);
//
//			return "article.articledetail";
//
//		} catch(RuntimeException e) {
//			model.addAttribute("msg", e.getMessage());
//			model.addAttribute("url", "../");
//
//			return "result";
//		} catch (Exception e) {
//			model.addAttribute("msg", "상세보기 에러");
//			model.addAttribute("url", "../");
//
//			return "result";
//		}
//	}
//
//	@GetMapping("articledelete")
//	public String delete(@PathVariable long article_id) {
//		return "article.articledelete";
//	}
//
//	@PostMapping("articledelete")
//	public ModelAndView delete(@ModelAttribute ArticleDTO articleDTO) {
//		log.info(articleDTO.toString());
//		ModelAndView mav = new ModelAndView("result");
//		try {
//			articleService.deleteArticle(articleDTO);
//			mav.addObject("msg", articleDTO.getArticle_id() + "번 게시물이 삭제되었습니다.");
//			mav.addObject("url", "../../1/");
//		} catch (Exception e) {
//			mav.addObject("msg", e.getMessage());
//			mav.addObject("url", "javascript:history.back();");
//		}
//		return mav;
//	}
//
//	@GetMapping("articleupdate")
//	public String update(@PathVariable long article_id, Model model) {
//		try {
//			ArticleDTO articleDTO = articleService.getDetail(article_id);
//			model.addAttribute("articleDTO", articleDTO);
//			return "article.articleupdate";
//		} catch (Exception e) {
//			model.addAttribute("msg", "해당하는 게시물이 없거나 시스템 에러입니다.");
//			model.addAttribute("url", "../../1/");
//			return "result";
//		}
//	}
//
//	@PostMapping("articleupdate")
//	public String updateBoard(@ModelAttribute ArticleDTO articleDTO,
//		Model model) {
//
//		log.info(articleDTO.toString());
//		try {
//			articleService.updateArticle(articleDTO);
//			model.addAttribute("msg", articleDTO.getArticle_id() + "번 게시물이 수정되었습니다.");
//			model.addAttribute("url", "./");
//			return "result";
//		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//}