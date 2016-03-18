package ca.mcgill.ecse321.controllerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;


import ca.mcgill.ecse321.homeAudioSystem.controller.HASController;
import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;
import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceHAS;
import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceXstream;



public class HASControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		PersistenceXstream.setFilename("test"+File.separator+"ca"+File.separator+"mcgill"+File.separator+"ecse321"+File.separator+"controllerTest"
				+File.separator+"data.xml");
		
		PersistenceXstream.setAlias("Album", Album.class);
		
	}

	

	@After
	public void tearDown() throws Exception {
		Manager rm = Manager.getInstance();
		rm.delete();
	}

	@Test
	public void CreateNullAlbum() {
		
		Manager m = Manager.getInstance();
		assertEquals(0, m.getAlbums().size());
		
		String name = null;
		String genre = null;
		Date releaseDate = null;
		
		String error = null;
		HASController hasC = new HASController();
		
		try {
			hasC.addAlbum(name,genre,releaseDate);
		} catch (Exception e) {
			error = e.getMessage();
		}
		
		assertEquals("name is missing genre is missing release date is missing ",error);
		
		
		assertEquals(m.getAlbums().size(),0);		
	}
	
	@Test
	public void CreateEmptyAlbum()
	{
		Manager m = Manager.getInstance();
		assertEquals(0, m.getAlbums().size());
		
		String name = "";
		String genre = "";
		Date releaseDate = null;
		
		String error = null;
		HASController hasC = new HASController();
		
		try {
			hasC.addAlbum(name,genre,releaseDate);
		} catch (Exception e) {
			error = e.getMessage();
		}
		
		assertEquals("name is missing genre is missing release date is missing ",error);
		
		
		assertEquals(m.getAlbums().size(),0);
	}
	
	
	@Test
	public void CreateAlbum()
	{
		Manager m = Manager.getInstance();
		assertEquals(0,m.getAlbums().size());
		
		Calendar c = Calendar.getInstance();
		
		String name = "Yellow Submarine";
		String genre = "rock";
		Date releaseDate = new Date(c.getTimeInMillis());
		
		String error = null;
		HASController hasC = new HASController();
		
		
		try {
			hasC.addAlbum(name,genre,releaseDate);
		} catch (Exception e) {
			error = e.getMessage();
		}
		
		Manager m2 = (Manager) PersistenceXstream.loadFromXMLwithXStream();
		
		assertEquals(1, m2.getAlbums().size());
		assertEquals("Yellow Submarine", m2.getAlbum(0).getName());
		assertEquals("rock", m2.getAlbum(0).getGenre());
		assertEquals(releaseDate.toString(), m2.getAlbum(0).getReleaseDate().toString());
		
	}

}
