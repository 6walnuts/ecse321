package ca.mcgill.ecse321.homeAudioSystem.persistence;

import java.util.Iterator;

import ca.mcgill.ecse321.homeAudioSystem.model.Album;
import ca.mcgill.ecse321.homeAudioSystem.model.Manager;

/**
 * Responsible for managing the Saving and Loading
 */
public class PersistenceHAS
{
	/**
	 * Initializes Xstream
	 */
	private static void initializeXStream()
	{
		PersistenceXstream.setFilename("HASsetting.xml");
		PersistenceXstream.setAlias("Album", Album.class);
	}
	
	/**
	 * Replaces the current model data with one saved to storage if available
	 */
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
