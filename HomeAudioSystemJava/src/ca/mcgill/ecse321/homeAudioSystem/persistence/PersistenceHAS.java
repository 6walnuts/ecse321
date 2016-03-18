package ca.mcgill.ecse321.homeAudioSystem.persistence;

import java.util.Iterator;

import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;


public class PersistenceHAS {
	
	private static void initializeXStream()
	{
		PersistenceXstream.setFilename("HASsetting.xml");
		PersistenceXstream.setAlias("Album", Album.class);
			
	}
	
	public static void loadEventRegistrationModel()
	{
		Manager rm = Manager.getInstance();
		PersistenceHAS.initializeXStream();
		Manager rm2 = (Manager) PersistenceXstream.loadFromXMLwithXStream();
		
		if(rm2 != null)
		{
			Iterator<Album> pIt = rm2.getAlbums().iterator();
			while( pIt.hasNext())
				rm.addAlbum(pIt.next());
			
			
		}
		
	}
	

}
