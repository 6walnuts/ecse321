/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.homeAudioSystem.model;
import java.sql.Time;

// line 49 "../../../../../domainModel.ump"
public class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private String name;
  private Time duration;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Song(String aName, Time aDuration)
  {
    name = aName;
    duration = aDuration;
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

  public boolean setDuration(Time aDuration)
  {
    boolean wasSet = false;
    duration = aDuration;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Time getDuration()
  {
    return duration;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "duration" + "=" + (getDuration() != null ? !getDuration().equals(this)  ? getDuration().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}