package com.magaz.service;

public interface MailSenderService {
	
	void sendEmail(String theme,String mailBody,String email);

}
