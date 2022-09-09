//package com.blog.strange.board;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.eveadam.blog.dto.board.BoardDTO;
//import com.eveadam.blog.service.board.BoardService;
//
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@Controller
//@RequestMapping(value = { "board/" })
//public class BoardController {
//
//	@Autowired
//	private BoardService boardService;
//
//	// 게시판들 보여주기
//	@GetMapping("boardlist")
//	public String getBoardlist(Model model){
//
//		try {
//			// 게시판 읽기
//			List<BoardDTO> boardlist = boardService.getBoardList();
//
//			// 게시물
//			model.addAttribute("boardlist", boardlist);
//
//			return "board.boardlist";
//		} catch (Exception e) {
//			model.addAttribute("msg", "list 출력 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//	// 게시판 추가화면 보여주기
//	@GetMapping("boardinsert")
//	public String boardinsert(Model model){
//
//		try {
//			log.info("##boardinsert##");
//			return "board.boardinsert";
//		} catch (Exception e) {
//			model.addAttribute("msg", "list 출력 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//	// 게시판 추가
//	@PostMapping("boardinsert")
//	public String boardinsert(@ModelAttribute BoardDTO boardDTO, Model model) {
//
//		log.info("boardinsert " + boardDTO);
//		try {
//			boardService.insertBoard(boardDTO);
//			return "redirect:./boardlist";
//		} catch (Exception e) {
//			model.addAttribute("msg", "이미 존재하는 board인지 아닌지 확인하세요");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//	// 게시판 삭제화면 보여주기
//	@GetMapping("boarddelete")
//	public String boarddelete(Model model){
//
//		try {
//			return "board.boarddelete";
//		} catch (Exception e) {
//			model.addAttribute("msg", "list 출력 에러");
//			model.addAttribute("url", "index");
//			return "result";
//		}
//	}
//
//	// 게시판 삭제
//	@PostMapping("boarddelete")
//	public String boarddelete(@ModelAttribute BoardDTO boardDTO, Model model) {
//
//		log.info("check input of boarddelete " + boardDTO);
//		try {
//			boardService.deleteBoard(boardDTO);
//			return "redirect:./boardlist";
//		} catch (Exception e) {
//			model.addAttribute("msg", "delete 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return "result";
//		}
//	}
//
//	// jquery를 통한 접근, 그리고 현재 게시판 내역 조회용 메소드
//	@RequestMapping(value = "/current_boardlist", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public ArrayList<BoardDTO> getCurrentBoardlist(Model model){
//
//		try {
//			// 게시판 읽기
//			ArrayList<BoardDTO> boardlist = boardService.getBoardList();
//
//			return boardlist;
//
//		} catch (Exception e) {
//			model.addAttribute("msg", "jsonboardlist 출력 에러");
//			model.addAttribute("url", "javascript:history.back();");
//			return null;
//		}
//	}
//}