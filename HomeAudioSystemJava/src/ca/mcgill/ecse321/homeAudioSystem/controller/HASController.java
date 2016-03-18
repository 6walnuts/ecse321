package ca.mcgill.ecse321.homeAudioSystem.controller;

import java.sql.Date;


import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;
import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceXstream;


public class HASController {
	
	public HASController()
	{
		
	}
	
	public void addAlbum(String name , String genre, Date releaseDate  ) throws Exception
	{
		String error = "";
		
		if(name == null || name.trim().length() == 0){error = error + "name is missing ";}
		if(genre == null || genre.trim().length() == 0 ){error = error + "genre is missing ";}
		if(releaseDate == null || releaseDate.toString().length() == 0 ){error = error + "release date is missing ";}
		
		if(error.length()>0){
		throw new InvalidInputException(error);
		}else
		{
			Manager manager = Manager.getInstance();
			
			Album album = new Album(name, genre, releaseDate);
			
			manager.addAlbum(album);
			
			error.trim();
			
			PersistenceXstream.saveToXMLwithXStream(manager);
		}
		
		
	}
	
	public void addPlaylist(String name){
		
		String error ="";
		
		if(name == null || name.trim().length() == 0){error = error  "name is missing";}
		if(error.length() > 0){
			throw new InvalidInputExcpetion(error);
			
		}
		else{
			
			Manager manager = Manager.getInstance();
			Playlist playlist = new Playlist(name);
			manager.addPlaylist(playlist);
			
			PersistenceXstream.saveToXMLwithXStream(manager);
			
		}
	
	}

}
