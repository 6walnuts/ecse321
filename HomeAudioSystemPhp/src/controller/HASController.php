<?php

require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\controller\HASController.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\controller\InputValidator.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Album.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Manager.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\persistence\PersistenceHAS.php';
class HasController {
	
	public function _construct()
	{
	}
	
	public function addAlbum($name , $genre, $releaseDate){
		$name = InputValidator::validate_input($name);
		$error ="";
		
		if($name==NULL){
			$error .="@1 name cannot be empty! ";
				
		}
		if($genre == NULL ){
			$error .="@2 genere cannot be empty! ";
				
		}
		if($releaseDate == NULL){
			$error.="@3 releaseDate cannot be empty ";
		}
		
		if($name==NULL||$genre==NULL||$releaseDate==NULL){
			throw new Exception(trim($error));
				
		}
		else{
			
			//2. load all data
			$pm = new PersistenceHAS();
			$ma = $pm->loadDataFromStore();
			
			//3. add Album
			$album = new Album($name, $genre, $releaseDate);
			
			$ma->addAlbum($album);
			
			//4 Write all of the data
			$pm->writeDataToStore($ma);
		}
		
		
	}
	
	
	
	
}
?>
