package vo;

import lombok.Data;

@Data
public class MemberVo {
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_email;
	private int mem_tel;
	private int mem_mileage;
	private String mem_role;
	private String mem_regdate;
	private String mem_delyn;
}
