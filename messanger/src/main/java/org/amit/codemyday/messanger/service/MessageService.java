package org.amit.codemyday.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.amit.codemyday.messanger.database.DatabaseClass;
import org.amit.codemyday.messanger.model.Message;

public class MessageService {
	
	public MessageService(){
		messages.put(1L,new Message(1, "Hello Sky" ,"Abhishek"));
		messages.put(2L,new Message(2, "Hello Earth" ,"Abhay"));
		
	}
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	

	public List<Message>  getAllMessage(){
		return new ArrayList<>(messages.values());		
	}
	
	public List<Message> getAllMessage(int year){
		List<Message> msgForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				msgForYear.add(message);
			}
		}
		return msgForYear;
	}
	
	public List<Message> getAllMessagePaginated(int start, int size){
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <=0 ){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
