package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/")
    public void print() {
        System.out.println("first");

        log.info("가나다");

        MemberDTO member = new MemberDTO();
        member.setUserId("가나다");
        log.info("data: {}", member.toString());

        BoardDTO board = new BoardDTO(5, "title", "content");
        log.info("board: {}", board.toString());

        BoardDTO board1 = BoardDTO
                .builder()
                .idx(5)
                .title("제목1")
                .content("내용1")
                .build();

        log.info("board1: {}", board1.toString());

    }

    @GetMapping("/data")
    public String data() {
        return "hello World";
    }

    @GetMapping("/member")
    public MemberDTO member() {
        MemberDTO member = new MemberDTO();
        member.setUserId("superamn");
        member.setUserPw("1234");

        return member;

    }

    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request) {
        String id = request.getParameter("userId");
        //DB


        MemberDTO member = new MemberDTO();
        member.setUserId(id);

        return member;
    }
}
