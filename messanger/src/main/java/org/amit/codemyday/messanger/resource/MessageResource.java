package org.amit.codemyday.messanger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.amit.codemyday.messanger.model.Message;
import org.amit.codemyday.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	
	@GET
	public List<Message> getMessages(){
		return messageService.getAllMessage();
	}
	
	@POST	
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageID}")
		public Message updateMessage(@PathParam("messageID") long messageID,Message message){
		message.setId(messageID);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
		public void deleteMessage(@PathParam("messageID") long id){
			messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageID}")
		public Message text(@PathParam("messageID") long messageID) {//auto conversion of string messageID to long by jaxRS
			return messageService.getMessage(messageID);				
	}

}
