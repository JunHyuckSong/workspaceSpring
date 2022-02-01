package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.member.impl.MemberDAO;
import com.test.app.member.impl.MemberDAO2;

@Controller
@SessionAttributes("memData")
public class LoginController{
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String showLogin(@ModelAttribute("user")MemberVO vo) { //대부분 GET방식은 "페이지이동"이 목적인 경우가 많음
		System.out.println("로그: 요청방식 (GET) showLogin() @컨트롤러");
		vo.setMid("song");
		vo.setPassword("1234");
		// 여기서 생기는 의문.. vo를 다음 페이지에서 사용할 수 있는가?-> 가능하다 "Command 객체"를 사용하므로 데이터 유지가 가능(스프링컨테이너가 살아있는한)!!
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(MemberVO vo, MemberDAO dao, HttpSession session /*ModelAndView mav*/ ) {
		if(vo.getMid()==null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("아이디를 입력하지 않았습니다.");
		}
		System.out.println("로그: 요청방식 (POST) login() @컨트롤러");
		MemberVO data = ms.selectOne(vo);
		if(data!=null) {
			session.setAttribute("memData", data);//마이페이지에서 이용할 데이터를 만들 목적
			return "main.do";
		}
		else {		
			return "index.jsp";
		}
		/*System.out.println("로그: login() @컨트롤러");
		MemberVO data = dao.selectOne(vo);		
		if(data!=null) {
			mav.addObject("member", data);
			mav.setViewName("main.do");
		}
		else {		
			mav.setViewName("index.jsp");
		}		
		return mav;*/
	}
	
	@RequestMapping(value="/signin.do",method=RequestMethod.GET) // login.jsp에서 <a>를 클릭해서 들어왔을 때(GET방식) 
	public String signin() {
		System.out.println("로그 : GET방식 signin.do");
		return "signin.jsp";
	}
	
	@RequestMapping(value="/signin.do",method=RequestMethod.POST)
	public String signin(MemberVO vo) {
		System.out.println("로그 : POST방식 signin() @컨트롤러" + vo);
		ms.insertMember(vo);
		//dao.insertMember(vo);
		return "login.jsp";
	}
	
	@RequestMapping(value="/mypage.do",method=RequestMethod.GET)
	public String mypage(@ModelAttribute("memData")MemberVO vo, Model model) {
		System.out.println("로그 : GET방식 mypage,do");
		model.addAttribute("mem", ms.selectOne(vo));
		return "mypage.jsp";
	}
	
	@RequestMapping(value="/mypage.do",method=RequestMethod.POST)
	public String mypage(@ModelAttribute("memData")MemberVO vo, MemberDAO dao) {
		//@ModelAttribute("memData")MemberVO vo <- 이게 널 익셉션을 방지해준다..
		System.out.println("로그 : POST방식 mypage() @컨트롤러"+vo);
		//1.vo추출
		//2.dao로 update()
		//3.View로 전달할게 있는지 체크(model객체에 담기)
		ms.updateMember(vo);
		return "main.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그: logout() @컨트롤러");
		session.invalidate();
		return "index.jsp";
	}
	
	//@Override
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// ModelAndView ==> 정보(Model) + 목적지(View)
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.selectOne(vo);
		System.out.println("LC로깅용 : "+data);
		
		ModelAndView mav = new ModelAndView();
	
		if(data!=null) {
			//세션에 저장한 후
			//HttpSession session = request.getSession();
			//session.setAttribute("member", data);
			//main.jsp
			//response.sendRedirect("main.jsp");
			
			mav.addObject("member", data);
			mav.setViewName("redirect:main.do"); //  /WEB-INF/test/main.do.jsp 로 만들어주지 않기 위해서
			
			//return "main.do"; // main페이지에서 정보를 출력해야하므로 
		}
		else {
			//login.jsp
			//response.sendRedirect("login.jsp");
			//return "login.jsp"; // login페이지에는 별다른 내용을 출력할 필요 없으므로
			
			mav.setViewName("redirct:index.jsp");
			
			//return "login"; // 이 반환값이 DispatcherServlet에서 viewName이됨
			//ViewResolver에서는 확장자가 없으면 .jsp를 자동추가해줌
		}
		return mav;
	}*/

}
