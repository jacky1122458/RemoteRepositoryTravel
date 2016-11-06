package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SIGNIN")
public class SignInBean {
	@Id
	private Integer memberid;
	private java.util.Date signdate;
	
	
	@Override
	public String toString() {
		return "SignInBean [memberid=" + memberid + ", signdate=" + signdate + "]";
	}
	
	
	@OneToOne
	@JoinColumn( name = "MEMBERID", referencedColumnName="MEMBERID",
				insertable=false, updatable=false )
	private MemberBean memberBean;
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public java.util.Date getSigndate() {
		return signdate;
	}
	public void setSigndate(java.util.Date signdate) {
		this.signdate = signdate;
	}
	
	
}