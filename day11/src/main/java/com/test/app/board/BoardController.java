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
	
	// @RequestMapping���� ���� ȣ��ȴ�.
	// ���� ���� �ڵ鷯�޼��忡�� �������� ���̸� View�ܿ����� ���� �� �� �ִ�.
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap(){
		// �� Map�� ���°�?=>�̸� �����صθ� View���� ���߿� ���ϰ� ���� �޾ƿ� �� �����ϱ�?
		Map<String, String> conditionMap = new HashMap<String, String>();
		
		conditionMap.put("����", "title");
		conditionMap.put("�ۼ���", "writer");
		
		return conditionMap;  // --> model��ü�� �ش系���� ����. model.addAttribute("conditionMap",conditionMap)
		// �׷��� �̰� �� ���°�?? View���� select�±׿� option�� �߰����൵ �Ǵµ�?
		// -> MVC�𵨷� �и��ؼ� ���������� �����ϰ� �Ϸ���,... �̷��� �ϸ� Controller���� key-value���� �������ָ� �Ǵϱ�!!
	}
	
	
	@RequestMapping("/board.do")
	public String board(BoardVO vo, Model model) { // ������ ������ �ֱ⶧���� ModelAndView ���
		
		System.out.println("�α�: board() @��Ʈ�ѷ�");
		BoardVO data = bs.selectOne(vo);
		model.addAttribute("data",data);
		
		return "board.jsp";
	}
	
	@RequestMapping(value="insertBoard.do") //HandlerMapping ��ü
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("�α� : insertBoard() @Controller");
		MultipartFile file = vo.getFile();
		if(!file.isEmpty()) { // ���ε带 �ߴٸ� 
			String fileName = file.getOriginalFilename();
			System.out.println("�����̸�:"+fileName); // review.jpg <-����
			
			file.transferTo(new File(path+fileName)); //����ȭ ��Ű�°� : "��𿡴� Ǯ� ������ �ұ�?" -> ����������� ���� ���丮 ��ο� �����ϴ� �κ�
			//C:\web_3\workspaceSpring\day11\src\main\webapp\images\review.jpg <- ����
			vo.setFilepath("images/"+fileName);
		}
		else {
			vo.setFilepath("images/d.jpg");//���⼭ d.jpg�� ����Ʈ �̹���
		}
		bs.insertBoard(vo);
		return "main.do";
		//BoardDAO dao = new BoardDAO(); // �� �̻� BoardDAO�� new���� �ʿ䰡 �����
	}
	
	@RequestMapping(value="/main.do")
	public String main(BoardVO vo, Model model) { //@RequestParam�� ���ְ� VO�� �˻����� ������ �߰�������(searchCondition,searchContent)
		//public String main(@RequestParam(value="searchCondition",defaultValue="title",required=false)String searchCondition, @RequestParam(value="searchContent",defaultValue="",required=false)String searchContent, BoardVO vo, Model model) { // ������ ������ �ֱ⶧���� ModelAndView ���
		System.out.println("����: "+ vo.getSearchCondition());
		System.out.println("����: "+ vo.getSearchContent());
		System.out.println("�α�: main() @��Ʈ�ѷ�");
		//*******************************************************
		//main���������� �˻��� ���ͳ� �˻�� �������� �ʾ��� ��� �Ʒ� �� ���ǹ��� ����ȴ�.
		if(vo.getSearchCondition()==null) { //default�� ���� --> �ƹ��͵� �Է¹��� �ʾ����� ���
			vo.setSearchCondition("title");
		}
		if(vo.getSearchContent()==null) { //default�� ���� --> �ƹ��͵� �Է¹��� �ʾ����� ���
			vo.setSearchContent("");
		}
		//*******************************************************
		List<BoardVO> datas = bs.selectAll(vo);
		model.addAttribute("datas",datas);
		//@ModelAttribute������ �߰��Ǹ鼭 model��ü�� Map,List �ΰ��� �÷��Ǵ� ����Ǿ� ����!
		
		//mav.setViewName("main.jsp"); // ����� ViewResolver������ ���� �ʾ����Ƿ� .jsp�� �ٿ������->���߿� ���� ����

		return "main.jsp";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {
		System.out.println("�α�:updateBoard() @Controller");
		System.out.println("�ۼ������� : " + vo.getWriter());
		//@ModelAttribute("data")BoardVO vo ������ �߰������ν� @SessionAttribute("data")���� null��ġ ó���� ������.(null�� �߻��� ������Ƽ�� session�����ͷ� ä������.)
		bs.updateBoard(vo);
		return "main.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�α�: deleteBoard() @��Ʈ�ѷ�");
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
		//ModelAndView ����� �̿��ϸ� ���̻� session�� ��Ƶ��� �ʾƵ� �ȴ�.
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", data);
		mav.setViewName("board");
		//return "board"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
		//ViewResolver�� viewNameó��
		
		return mav;
	}*/

}
