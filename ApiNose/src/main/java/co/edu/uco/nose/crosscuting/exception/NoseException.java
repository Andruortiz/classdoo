package co.edu.uco.nose.crosscuting.exception;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public final class NoseException extends RuntimeException {


	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String techicalMessage;
	
	
	private NoseException (final Throwable rootException, final String userMessage) {
		
		setRootException(rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(TechnicalMessage)
	}
	
	public static NoseException create(final Throwable rootException, final String userMessage, final  String technicalMessage) {
		
		return new NoseException(rootException, userMessage, technicalMessage);
		
	}
	
	
	
	public Throwable getRootException() {
		return rootException;
	}
	public void setRootException(Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception);
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage)
	}
	public String getTechicalMessage() {
		return techicalMessage;
	}
	public void setTechicalMessage(final String  techicalMessage) {
		this.techicalMessage = TextHelper.getDefaultWithTrim(techicalMessage);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
