<?php
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\controller\HASController.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\controller\InputValidator.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Album.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\Model\Manager.php';
require_once 'C:\Users\User\workspace2\Ecse321GroupProject\src\persistence\PersistenceHAS.php';

class PersistenceEventRegistrationTest extends PHPUnit_Framework_TestCase
{
	protected $pm;

	protected  function setUp()
	{
		$this->pm = new PersistenceHAS();
	}

	protected function  tearDown()
	{
	}

	public function testPersistence()
	{
		//1.Create test data
		$ma= Manager::getInstance();
		$album = new Album("first","akon","2016-12-21");
		$ma->addAlbum($album);

		// 2. Write all of the data
		$this->pm->writeDataToStore($ma);

		//3.Clear the data from memory
		$ma->delete();

		//4. Load it back in
		$ma=$this->pm->loadDataFromStore();

		//5. Check that we got it back
		$this->assertEquals(1, count($ma->getAlbums()));
		$albumName= $ma->getAlbum_index(0)->getName();
		$this->assertEquals("first", $albumName);
	}


}