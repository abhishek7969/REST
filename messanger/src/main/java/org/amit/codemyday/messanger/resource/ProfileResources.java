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

import org.amit.codemyday.messanger.model.Profile;
import org.amit.codemyday.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResources {

	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
		public Profile updateMessage(@PathParam("profileName") long id,Profile profile){
		profile.setId(id);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
		public void deleteMessage(@PathParam("profileName") String id){
		profileService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{profileName}")
		public Profile text(@PathParam("profileName") String id) {
			return profileService.getProfile(id);			
	}
}
