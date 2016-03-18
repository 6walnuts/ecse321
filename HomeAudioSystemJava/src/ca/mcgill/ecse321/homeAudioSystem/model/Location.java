/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.homeAudioSystem.model;
import java.util.*;

// line 56 "../../../../../domainModel.ump"
// line 78 "../../../../../domainModel.ump"
public class Location
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Location Attributes
  private String name;
  private int volume;
  private boolean isMuted;

  //Location Associations
  private List<ListOfSong> listOfSongs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Location(String aName, int aVolume)
  {
    name = aName;
    volume = aVolume;
    isMuted = false;
    listOfSongs = new ArrayList<ListOfSong>();
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

  public boolean setVolume(int aVolume)
  {
    boolean wasSet = false;
    volume = aVolume;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsMuted(boolean aIsMuted)
  {
    boolean wasSet = false;
    isMuted = aIsMuted;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getVolume()
  {
    return volume;
  }

  public boolean getIsMuted()
  {
    return isMuted;
  }

  public ListOfSong getListOfSong(int index)
  {
    ListOfSong aListOfSong = listOfSongs.get(index);
    return aListOfSong;
  }

  public List<ListOfSong> getListOfSongs()
  {
    List<ListOfSong> newListOfSongs = Collections.unmodifiableList(listOfSongs);
    return newListOfSongs;
  }

  public int numberOfListOfSongs()
  {
    int number = listOfSongs.size();
    return number;
  }

  public boolean hasListOfSongs()
  {
    boolean has = listOfSongs.size() > 0;
    return has;
  }

  public int indexOfListOfSong(ListOfSong aListOfSong)
  {
    int index = listOfSongs.indexOf(aListOfSong);
    return index;
  }

  public static int minimumNumberOfListOfSongs()
  {
    return 0;
  }

  public boolean addListOfSong(ListOfSong aListOfSong)
  {
    boolean wasAdded = false;
    if (listOfSongs.contains(aListOfSong)) { return false; }
    listOfSongs.add(aListOfSong);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeListOfSong(ListOfSong aListOfSong)
  {
    boolean wasRemoved = false;
    if (listOfSongs.contains(aListOfSong))
    {
      listOfSongs.remove(aListOfSong);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addListOfSongAt(ListOfSong aListOfSong, int index)
  {  
    boolean wasAdded = false;
    if(addListOfSong(aListOfSong))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfListOfSongs()) { index = numberOfListOfSongs() - 1; }
      listOfSongs.remove(aListOfSong);
      listOfSongs.add(index, aListOfSong);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveListOfSongAt(ListOfSong aListOfSong, int index)
  {
    boolean wasAdded = false;
    if(listOfSongs.contains(aListOfSong))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfListOfSongs()) { index = numberOfListOfSongs() - 1; }
      listOfSongs.remove(aListOfSong);
      listOfSongs.add(index, aListOfSong);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addListOfSongAt(aListOfSong, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    listOfSongs.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "volume" + ":" + getVolume()+ "," +
            "isMuted" + ":" + getIsMuted()+ "]"
     + outputString;
  }
}