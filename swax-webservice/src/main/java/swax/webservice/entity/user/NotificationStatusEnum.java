package swax.webservice.entity.user;

public enum NotificationStatusEnum {
	
	ToRead("To Read"), 
	Read("Read");
	
	private NotificationStatusEnum(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}
	
	private final String notificationStatus;

	public String getUserStatus() {
		return notificationStatus;
	}

}