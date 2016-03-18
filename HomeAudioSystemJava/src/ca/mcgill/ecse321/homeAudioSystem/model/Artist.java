/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.homeAudioSystem.model;
import java.util.*;

// line 34 "../../../../../domainModel.ump"
// line 83 "../../../../../domainModel.ump"
public class Artist extends ListOfSong
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Artist Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Artist(String aName)
  {
    super();
    name = aName;
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

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}