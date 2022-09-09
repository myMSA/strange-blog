package com.blog.strange.sample;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {
    // DB가 연결되어있다면, DB와 연결된 repository,
    // 그리고, repository와 연결된 service 객체를 거쳐서,
    // 대체로 아래와 같은 호출을 통해 DB의 데이터를 DTO로 전환한다.
    //
    // @Autowired
    // SampleService sampleservice;
    // goto 36 line.
	@GetMapping("/ex1")
	public void ex1() {
		log.info("ex1........");
	}

	@GetMapping({ "/ex2" })
	public String exModel(Model model) {

        // Here i am !!
        // List<SampleDTO> samples = sampleservice.getAllSamples();

        // 하지만 현재 진행상황을 고려하면, 한편 아래와 같은 Stream을 통해 객체를 생성할수도 있나 보다, 안쓴지 오래됨
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
			SampleDTO dto = SampleDTO.builder().sno(i).first("First.." + i).last("Last.." + i)
					.regTime(LocalDateTime.now()).build();
			return dto;
		}).collect(Collectors.toList());

		model.addAttribute("list", list);
		
		return "sample/ex2";
	}
	
    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes){

        log.info("exInline..............");

        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First..100")
                .last("Last..100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        // redirect 했다고 끝이 아니다. 이 redirect url을 받을 컨트롤러 메소드가 필요하다.
        
        return "redirect:/sample/ex3";
    }
    
    @GetMapping("/ex3")
    public void ex3(){

        log.info("ex3");

        // boot 는 똑똑해서, 자동지원해주는 게 더욱늘어나서, return 타입이 void 지만
        // 알아서 리턴타입을 수정하고, 아래와같이 리턴한다고 이해가능하다. url에 값을 넣어 체크해본다.
        // return ex3
    }

    
    @GetMapping({ "/exLink"})
    public void exModel2(Model model){

        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First.."+i)
                    .last("Last.."+i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }
    
    @GetMapping({"/exLayout1","/exLayout2"})
    public void exLayout1() {
        log.info("exLayout............");
    }
    
    @GetMapping({"/exTemplate"})
    public String exTemplate() {
        log.info("exTemplate............");

        return "sample/exTemplate";
    }
    
    @GetMapping({"/exSidebar"})
    public String exSidebar() {
    	log.info("exSidebar............");

        return "sample/exSidebar";
    }
}
