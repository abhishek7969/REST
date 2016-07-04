package org.amit.codemyday.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.amit.codemyday.messanger.database.DatabaseClass;
import org.amit.codemyday.messanger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Lord rama" , new Profile(1L, "testing" ,"one","two"));
	}
	
	public List<Profile>  getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());		
	}
	
	public Profile getProfile(String id){
		return profiles.get(id);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String profileName){
		return profiles.remove(profileName);
	}

}
