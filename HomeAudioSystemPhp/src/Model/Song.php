<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private $name;

  //Song Associations
  private $album;
  private $artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aArtist)
  {
    $this->name = $aName;
    $didAddArtist = $this->setArtist($aArtist);
    if (!$didAddArtist)
    {
      throw new Exception("Unable to create song due to artist");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getAlbum()
  {
    return $this->album;
  }

  public function hasAlbum()
  {
    $has = $this->album != null;
    return $has;
  }

  public function getArtist()
  {
    return $this->artist;
  }

  public function setAlbum($aAlbum)
  {
    $wasSet = false;
    $existingAlbum = $this->album;
    $this->album = $aAlbum;
    if ($existingAlbum != null && $existingAlbum !== $aAlbum)
    {
      $existingAlbum->removeSong($this);
    }
    if ($aAlbum != null && $aAlbum !== $existingAlbum)
    {
      $aAlbum->addSong($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setArtist($aArtist)
  {
    $wasSet = false;
    if ($aArtist == null)
    {
      return $wasSet;
    }
    
    $existingArtist = $this->artist;
    $this->artist = $aArtist;
    if ($existingArtist != null && $existingArtist != $aArtist)
    {
      $existingArtist->removeSong($this);
    }
    $this->artist->addSong($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    if ($this->album != null)
    {
      $this->album->removeSong($this);
    }
    $placeholderArtist = $this->artist;
    $this->artist = null;
    $placeholderArtist->removeSong($this);
  }

}
?>