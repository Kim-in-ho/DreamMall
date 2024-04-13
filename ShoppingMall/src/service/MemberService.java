package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.MemberVo;

public class MemberService {
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	MemberDao memberDao = MemberDao.getInstance();
	
	public boolean memberInsert(List<Object> param, String role) {
		MemberVo member = memberDao.memberInsert(param);
		if(member == null) {
			return false;
		}
		if(!member.getMem_role().equals(role)) {
			return false;
		}
		
		if(role.equals("U")) {
			MainController.sessionStorage.put("member", member);
		}
		else if(role.equals("A")) {
			MainController.sessionStorage.put("admin", member);
		}else {
			MainController.sessionStorage.put("master", member);
		}
		return true;
	}
}
