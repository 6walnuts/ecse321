package ca.mcgill.ecse321.homeAudioSystem.application;

import ca.mcgill.ecse321.homeAudioSystem.persistence.PersistenceHAS;
import ca.mcgill.ecse321.homeAudioSystem.view.HASPage;

public class HomeAudioSystem {
	
	public static void main(String[] args)
	{
		PersistenceHAS.loadEventRegistrationModel();
		
		java.awt.EventQueue.invokeLater(new Runnable(){
			
			public void run(){ new HASPage().setVisible(true);
			
			}
		});
		
	}

}
