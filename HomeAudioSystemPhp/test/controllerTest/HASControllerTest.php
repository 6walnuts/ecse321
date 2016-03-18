<?php
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\controller\HASController.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Album.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Manager.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\persistence\PersistenceHAS.php';
class HAScontrollerTest extends PHPUnit_Framework_TestCase{

protected $c; 
protected $pm;
protected $ma;

protected function setUp()
{		
		$this->c = new HasController();
		
	    $this->pm = new PersistenceHAS();
        $this->ma = $this->pm->loadDataFromStore();
        $this->ma->delete();
        $this->pm->writeDataToStore($this->ma);
}

protected function tearDown()
{

	
}

public function testCreateEmptyAlbum(){
	$this->assertEquals(0,count($this->ma->getAlbums()));
	
	$name = null;
	$genre = null;
	$releaseDate = null;
	
	$error = "";
	try {
		$this->c->addAlbum($name, $genre, $releaseDate);
	} catch (Exception $e) {
		$error = $e->getMessage();
	}
	
	//check error
	$this->ma = $this->pm->loadDataFromStore();
	$this->assertEquals("@1 name cannot be empty! @2 genere cannot be empty! @3 releaseDate cannot be empty",$error);
	
	
	
}

}
