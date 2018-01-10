package swax.webservice.entity;

public enum UserStatusEnum {
	
	Authorized("Authorized"), 
	Banned("Banned");
	
	private UserStatusEnum(String userStatus) {
		this.userStatus = userStatus;
	}
	
	private final String userStatus;

	public String getUserStatus() {
		return userStatus;
	}

}
