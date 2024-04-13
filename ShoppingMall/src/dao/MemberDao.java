package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public MemberVo memberInsert(List<Object> param) {
		String sql = "    SELECT *\r\n" + 
				"      FROM MEMBER\r\n" + 
				"     WHERE MEM_ID = 'TEST'\r\n" + 
				"       AND MEM_DELYN = 'N'";
		
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
}
