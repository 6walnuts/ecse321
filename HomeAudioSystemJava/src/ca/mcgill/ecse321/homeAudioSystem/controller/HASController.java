package ca.mcgill.ecse321.homeAudioSystem.controller;

import java.sql.Date;
import java.sql.Time;

import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Location;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;
import ca.mcgill.ecse321.homeAudioSystem.model.Playlist;
import ca.mcgill.ecse321.homeAudioSystem.model.Song;
import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceXstream;

/**
 * Handles the modification of data stored in the model.
 */
public class HASController
{
	public HASController() { }
	
	/**
	 * Adds a new album.
	 * @param name The name of the album
	 * @param genre The genre of the music
	 * @param releaseDate The release date
	 * @throws InvalidInputException
	 */
	public void addAlbum(String name, String genre, Date releaseDate) throws InvalidInputException
	{
		String error = "";
		
		if(name == null || name.trim().length() == 0)
		{
			error = error + "name is missing ";
		}
		
		try
		{
			Album.Genre.valueOf(genre);
		}
		catch(Exception e)
		{
			error = error + "genre is missing ";
		}
		
		if(releaseDate == null || releaseDate.toString().length() == 0)
		{
			error = error + "release date is missing ";
		}
		
		if(error.length() > 0)
		{
			throw new InvalidInputException(error);
		}
		else
		{
			Manager manager = Manager.getInstance();
			
			Album album = new Album(name, releaseDate);
			album.setGenre(Album.Genre.valueOf(genre));
			
			manager.addAlbum(album);
			
			error.trim();
			
			PersistenceXstream.saveToXMLwithXStream(manager);
		}	
	}
	
	/**
	 * Adds a new home location.
	 * @param name The name of the location
	 * @throws InvalidInputException
	 */
	public void setLocation(String name) throws InvalidInputException
	{
		String error = "";
		
		if(name == null || name.trim().length() == 0)
		{
			error = error + "location name is missing ";
		}
		
		if(error.length() > 0)
		{
			throw new InvalidInputException(error);
		}
		else
		{
			Manager manager = Manager.getInstance();
			
			int Volume = 50;
			Location location = new Location(name, Volume);
			
			manager.addLocation(location);
			
			PersistenceXstream.saveToXMLwithXStream(manager);
		}
	}
	
	/**
	 * Adds a new playlist.
	 * @param name The name of the playlist
	 * @throws InvalidInputException
	 */
	public void addPlaylist(String name) throws InvalidInputException
	{
		String error ="";
		
		if(name == null || name.trim().length() == 0)
		{
			error = error + "name is missing ";
		}
		
		if(error.length() > 0)
		{
			throw new InvalidInputException(error);
		}
		else
		{
			Manager manager = Manager.getInstance();
			Playlist playlist = new Playlist(name);
			manager.addPlaylist(playlist);
			
			PersistenceXstream.saveToXMLwithXStream(manager);
		}
	}
	
	public void addSong(String name,Time duration ) throws InvalidInputException
	{
		String error = "";
		
		if(name == null || name.trim().length() == 0){error = error + "name is missing ";}
		
		if(duration == null || duration.toString().trim().length() == 0){error = error + "duration is missing ";}
		
		if(error.length() > 0)
		{
			throw new InvalidInputException(error);
		}
		else
		{
			Manager manager = Manager.getInstance();
			Song song = new Song(name, duration);
			
			manager.addSong(song);
			
			PersistenceXstream.saveToXMLwithXStream(manager);
		}
		
		
	}
	
}

