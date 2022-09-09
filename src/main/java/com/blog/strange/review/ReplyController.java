//package com.blog.strange.review;
//
//
//import java.util.HashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.eveadam.blog.dto.reply.ReplyDTO;
//import com.eveadam.blog.service.reply.ReplyService;
//
//import lombok.extern.log4j.Log4j;
//
///**
// * @author devsacti
// *
// */
//@Log4j
//@Controller
//public class ReplyController {
//
//	@Autowired
//	private ReplyService replyService;
//
//	/**
//	 * @param replyDTO
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/replyinsert", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public HashMap<String, String> insertReply(@ModelAttribute ReplyDTO replyDTO,
//			Model model) throws Exception{
//
//		log.info("insertReply "+replyDTO.toString());
//
//		replyService.insertReply(replyDTO);
//
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("insert_reply_Success", "True");
//
//		return map;
//	}
//
//	@RequestMapping(value = "/replydelete", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public HashMap<String, String> deleteReply(@ModelAttribute ReplyDTO replyDTO) throws Exception {
//
//		log.info("replydelete "+replyDTO.toString());
//
//		replyService.deleteReply(replyDTO);
//
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("delete_reply_Success", "True");
//
//		return map;
//	}
//
//	@RequestMapping(value = "/selectreply", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public HashMap<String, String> selectReply(@ModelAttribute ReplyDTO replyDTO) throws Exception {
//
//		log.info("selectReply "+replyDTO.toString());
//
//		replyService.selectReply(replyDTO);
//
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("select_reply_Success", "True");
//
//		return map;
//	}
//}