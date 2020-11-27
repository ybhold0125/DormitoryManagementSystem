package dms.boot.user.domain;

public class Identity {
	private Integer Id;
	private String identityName;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	@Override
	public String toString() {
		return "Identity [Id=" + Id + ", identityName=" + identityName + "]";
	}
}
