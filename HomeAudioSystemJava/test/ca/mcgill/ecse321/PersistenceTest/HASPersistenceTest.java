package ca.mcgill.ecse321.PersistenceTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;
import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceXstream;

public class HASPersistenceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Manager m = Manager.getInstance();
		
		String name = "yellow sub";
		Calendar c =  Calendar.getInstance();
	
		Date date = new Date(c.getTimeInMillis());
		
		
		Album album = new Album(name, date);
		
		album.setGenre(Album.Genre.Rock);
		
		m.addAlbum(album);
		
		PersistenceXstream.saveToXMLwithXStream(m);
	}

	
	
	@After
	public void tearDown() throws Exception {
		Manager m = Manager.getInstance();
		m.delete();
	}

	@Test
	public void test() {
		
		
		
	}

}
