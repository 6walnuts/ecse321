/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.homeAudioSystem.model;

// line 36 "../../../../../domainModel.ump"
// line 70 "../../../../../domainModel.ump"
public class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private String name;

  //Song Associations
  private Album album;
  private Artist artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Song(String aName, Artist aArtist)
  {
    name = aName;
    boolean didAddArtist = setArtist(aArtist);
    if (!didAddArtist)
    {
      throw new RuntimeException("Unable to create song due to artist");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Album getAlbum()
  {
    return album;
  }

  public boolean hasAlbum()
  {
    boolean has = album != null;
    return has;
  }

  public Artist getArtist()
  {
    return artist;
  }

  public boolean setAlbum(Album aAlbum)
  {
    boolean wasSet = false;
    Album existingAlbum = album;
    album = aAlbum;
    if (existingAlbum != null && !existingAlbum.equals(aAlbum))
    {
      existingAlbum.removeSong(this);
    }
    if (aAlbum != null)
    {
      aAlbum.addSong(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setArtist(Artist aArtist)
  {
    boolean wasSet = false;
    if (aArtist == null)
    {
      return wasSet;
    }

    Artist existingArtist = artist;
    artist = aArtist;
    if (existingArtist != null && !existingArtist.equals(aArtist))
    {
      existingArtist.removeSong(this);
    }
    artist.addSong(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (album != null)
    {
      Album placeholderAlbum = album;
      this.album = null;
      placeholderAlbum.removeSong(this);
    }
    Artist placeholderArtist = artist;
    this.artist = null;
    placeholderArtist.removeSong(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "album = "+(getAlbum()!=null?Integer.toHexString(System.identityHashCode(getAlbum())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "artist = "+(getArtist()!=null?Integer.toHexString(System.identityHashCode(getArtist())):"null")
     + outputString;
  }
}