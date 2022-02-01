package com.test.app.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

@Controller
@SessionAttributes("data")
public class BoardController{
	
	@Autowired
	BoardService bs;
	
	final String path = "C:\\web_3\\workspaceSpring\\day11\\src\\main\\webapp\\images"; 
	
	// @RequestMapping보다 먼저 호출된다.
	// 따라서 여러 핸들러메서드에서 공통으로 쓰이며 View단에서도 꺼내 쓸 수 있다.
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap(){
		// 왜 Map을 쓰는가?=>미리 세팅해두면 View에서 나중에 편하게 값을 받아올 수 있으니까?
		Map<String, String> conditionMap = new HashMap<String, String>();
		
		conditionMap.put("제목", "title");
		conditionMap.put("작성자", "writer");
		
		return conditionMap;  // --> model객체에 해당내용이 저장. model.addAttribute("conditionMap",conditionMap)
		// 그래서 이걸 왜 쓰는가?? View에서 select태그에 option을 추가해줘도 되는데?
		// -> MVC모델로 분리해서 유지보수를 용이하게 하려고,... 이렇게 하면 Controller에서 key-value값만 변경해주면 되니까!!
	}
	
	
	@RequestMapping("/board.do")
	public String board(BoardVO vo, Model model) { // 저장할 정보가 있기때문에 ModelAndView 사용
		
		System.out.println("로그: board() @컨트롤러");
		BoardVO data = bs.selectOne(vo);
		model.addAttribute("data",data);
		
		return "board.jsp";
	}
	
	@RequestMapping(value="insertBoard.do") //HandlerMapping 대체
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("로그 : insertBoard() @Controller");
		MultipartFile file = vo.getFile();
		if(!file.isEmpty()) { // 업로드를 했다면 
			String fileName = file.getOriginalFilename();
			System.out.println("파일이름:"+fileName); // review.jpg <-예시
			
			file.transferTo(new File(path+fileName)); //파일화 시키는것 : "어디에다 풀어서 관리를 할까?" -> 파일입출력을 통해 디렉토리 경로에 저장하는 부분
			//C:\web_3\workspaceSpring\day11\src\main\webapp\images\review.jpg <- 예시
			vo.setFilepath("images/"+fileName);
		}
		else {
			vo.setFilepath("images/d.jpg");//여기서 d.jpg는 디폴트 이미지
		}
		bs.insertBoard(vo);
		return "main.do";
		//BoardDAO dao = new BoardDAO(); // 더 이상 BoardDAO를 new해줄 필요가 사라짐
	}
	
	@RequestMapping(value="/main.do")
	public String main(BoardVO vo, Model model) { //@RequestParam을 없애고 VO에 검색관련 변수를 추가시켜줌(searchCondition,searchContent)
		//public String main(@RequestParam(value="searchCondition",defaultValue="title",required=false)String searchCondition, @RequestParam(value="searchContent",defaultValue="",required=false)String searchContent, BoardVO vo, Model model) { // 저장할 정보가 있기때문에 ModelAndView 사용
		System.out.println("조건: "+ vo.getSearchCondition());
		System.out.println("내용: "+ vo.getSearchContent());
		System.out.println("로그: main() @컨트롤러");
		//*******************************************************
		//main페이지에서 검색을 필터나 검색어를 설정하지 않았을 경우 아래 두 조건문이 실행된다.
		if(vo.getSearchCondition()==null) { //default값 설정 --> 아무것도 입력받지 않았을때 경우
			vo.setSearchCondition("title");
		}
		if(vo.getSearchContent()==null) { //default값 설정 --> 아무것도 입력받지 않았을때 경우
			vo.setSearchContent("");
		}
		//*******************************************************
		List<BoardVO> datas = bs.selectAll(vo);
		model.addAttribute("datas",datas);
		//@ModelAttribute설정이 추가되면서 model객체에 Map,List 두개의 컬렉션니 저장되어 있음!
		
		//mav.setViewName("main.jsp"); // 현재는 ViewResolver설정을 하지 않았으므로 .jsp를 붙여줘야함->나중에 없앨 에정

		return "main.jsp";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {
		System.out.println("로그:updateBoard() @Controller");
		System.out.println("작성자정보 : " + vo.getWriter());
		//@ModelAttribute("data")BoardVO vo 설정을 추가함으로써 @SessionAttribute("data")에서 null방치 처리를 진행함.(null이 발생한 프로퍼티만 session데이터로 채워진다.)
		bs.updateBoard(vo);
		return "main.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("로그: deleteBoard() @컨트롤러");
		bs.deleteBoard(vo);
		return "main.do";
	}
	
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO data = dao.selectOne(vo);
		
		//HttpSession session=request.getSession();
		//session.setAttribute("data", data);
		//ModelAndView 방식을 이용하면 더이상 session에 담아두지 않아도 된다.
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", data);
		mav.setViewName("board");
		//return "board"; // 이 반환값이 DispatcherServlet에서 viewName이됨
		//ViewResolver가 viewName처리
		
		return mav;
	}*/

}
