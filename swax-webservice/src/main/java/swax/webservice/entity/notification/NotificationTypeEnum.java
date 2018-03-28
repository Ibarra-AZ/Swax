package swax.webservice.entity.notification;

public enum NotificationTypeEnum {
	
	Error_Synchro_Wantlist("Error synchronizing wantlist "), 
	Error_Synchro_Collection("Error synchronizing collection");
	
	private final String notificationType;
	
	private NotificationTypeEnum(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationType() {
		return notificationType;
	}

}