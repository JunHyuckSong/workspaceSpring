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
	public String showLogin(@ModelAttribute("user")MemberVO vo) { //��κ� GET����� "�������̵�"�� ������ ��찡 ����
		System.out.println("�α�: ��û��� (GET) showLogin() @��Ʈ�ѷ�");
		vo.setMid("song");
		vo.setPassword("1234");
		// ���⼭ ����� �ǹ�.. vo�� ���� ���������� ����� �� �ִ°�?-> �����ϴ� "Command ��ü"�� ����ϹǷ� ������ ������ ����(�����������̳ʰ� ����ִ���)!!
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(MemberVO vo, MemberDAO dao, HttpSession session /*ModelAndView mav*/ ) {
		if(vo.getMid()==null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("���̵� �Է����� �ʾҽ��ϴ�.");
		}
		System.out.println("�α�: ��û��� (POST) login() @��Ʈ�ѷ�");
		MemberVO data = ms.selectOne(vo);
		if(data!=null) {
			session.setAttribute("memData", data);//�������������� �̿��� �����͸� ���� ����
			return "main.do";
		}
		else {		
			return "index.jsp";
		}
		/*System.out.println("�α�: login() @��Ʈ�ѷ�");
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
	
	@RequestMapping(value="/signin.do",method=RequestMethod.GET) // login.jsp���� <a>�� Ŭ���ؼ� ������ ��(GET���) 
	public String signin() {
		System.out.println("�α� : GET��� signin.do");
		return "signin.jsp";
	}
	
	@RequestMapping(value="/signin.do",method=RequestMethod.POST)
	public String signin(MemberVO vo) {
		System.out.println("�α� : POST��� signin() @��Ʈ�ѷ�" + vo);
		ms.insertMember(vo);
		//dao.insertMember(vo);
		return "login.jsp";
	}
	
	@RequestMapping(value="/mypage.do",method=RequestMethod.GET)
	public String mypage(@ModelAttribute("memData")MemberVO vo, Model model) {
		System.out.println("�α� : GET��� mypage,do");
		model.addAttribute("mem", ms.selectOne(vo));
		return "mypage.jsp";
	}
	
	@RequestMapping(value="/mypage.do",method=RequestMethod.POST)
	public String mypage(@ModelAttribute("memData")MemberVO vo, MemberDAO dao) {
		//@ModelAttribute("memData")MemberVO vo <- �̰� �� �ͼ����� �������ش�..
		System.out.println("�α� : POST��� mypage() @��Ʈ�ѷ�"+vo);
		//1.vo����
		//2.dao�� update()
		//3.View�� �����Ұ� �ִ��� üũ(model��ü�� ���)
		ms.updateMember(vo);
		return "main.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α�: logout() @��Ʈ�ѷ�");
		session.invalidate();
		return "index.jsp";
	}
	
	//@Override
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// ModelAndView ==> ����(Model) + ������(View)
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.selectOne(vo);
		System.out.println("LC�α�� : "+data);
		
		ModelAndView mav = new ModelAndView();
	
		if(data!=null) {
			//���ǿ� ������ ��
			//HttpSession session = request.getSession();
			//session.setAttribute("member", data);
			//main.jsp
			//response.sendRedirect("main.jsp");
			
			mav.addObject("member", data);
			mav.setViewName("redirect:main.do"); //  /WEB-INF/test/main.do.jsp �� ��������� �ʱ� ���ؼ�
			
			//return "main.do"; // main���������� ������ ����ؾ��ϹǷ� 
		}
		else {
			//login.jsp
			//response.sendRedirect("login.jsp");
			//return "login.jsp"; // login���������� ���ٸ� ������ ����� �ʿ� �����Ƿ�
			
			mav.setViewName("redirct:index.jsp");
			
			//return "login"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
			//ViewResolver������ Ȯ���ڰ� ������ .jsp�� �ڵ��߰�����
		}
		return mav;
	}*/

}
