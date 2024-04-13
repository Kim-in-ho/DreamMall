package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import util.ScanUtil;
import util.View;

public class MainController  {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memberService = MemberService.getInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			default:
				break;
			}
		}
	}
	
	

	private View home() {
		System.out.println(("1. 로그인"));
		System.out.println(("2. 회원 가입"));
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.LOGIN;
		case 2:
			return View.SIGN;
		default:
			return View.MAIN;
		}
	}
}
