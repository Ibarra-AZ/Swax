package swax.webservice.entity.user;

public enum NotificationTypeEnum {
	
	Error_Synchro_Wantlist("Error Synchro Wantlist"), 
	Error_Synchro_Collection("Error Synchro Collection");
	
	private final String notificationType;
	
	private NotificationTypeEnum(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationType() {
		return notificationType;
	}

}