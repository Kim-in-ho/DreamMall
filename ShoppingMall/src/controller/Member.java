package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.MemberVo;

public class Member {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memberService = MemberService.getInstance();
	
	public static void main(String[] args) {
		new Member().start();
	}

	private void start() {
		View view = View.MEMBER_MAIN;
		while (true) {
			switch (view) {
			case MEMBER_MAIN:
				view = home();
				break;
			case MEMBER_INSERT:
				view = memberInsert();
				break;

			default:
				break;
			}
		}
	}
	
	private View memberInsert() {
		String id = ScanUtil.nextLine("ID : ");
		String pw = ScanUtil.nextLine("PASS : ");
		View view = (View)sessionStorage.get("view");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		String role = (String)sessionStorage.get("role");
		boolean login = memberService.memberInsert(param, role);
		if(login) {
			if(role.equals("1")) {
				System.out.println("<일반회원 로그인>");
				MemberVo member = (MemberVo) sessionStorage.get("member");
				System.out.println(member.getMem_name()+"님 환영합니다.");
				return view;
			}
			else {
				System.out.println("<관리자 로그인>");
				MemberVo member = (MemberVo) sessionStorage.get("admin");
				System.out.println(member.getMem_name()+"님 환영합니다.");
				return null; // 꼭 수정
			}
		}
		else {
			System.out.println("로그인에 실패 하셨습니다.");
			System.out.println("1. 재 로그인");
			System.out.println("2. 홈");
			int sel = ScanUtil.menu();
			switch (sel) {
			case 1: return View.MEMBER_LOGIN;				
			case 2: return View.MEMBER_MAIN;				
			}
		}
		return View.MAIN;
	}
	
	private View home() {
		System.out.println("<1. 로그인>");
		System.out.println("<2. 회원 가입>");
		System.out.println("<3. 회원 정보 변경>");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1: return View.MEMBER_LOGIN;
		case 2: return View.MEMBER_INSERT;
		case 3: return View.MEMBER_UPDATE;
		default: return View.MEMBER_MAIN;
		}
	}
}
