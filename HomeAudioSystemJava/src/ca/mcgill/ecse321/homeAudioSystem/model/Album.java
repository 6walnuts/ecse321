/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.homeAudioSystem.model;
import java.sql.Date;
import java.util.*;

// line 4 "../../../../../domainModelJava.ump"
// line 26 "../../../../../domainModel.ump"
// line 88 "../../../../../domainModel.ump"
public class Album extends ListOfSong
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Album Attributes
  private String name;
  private Date releaseDate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Album(String aName, Date aReleaseDate)
  {
    super();
    name = aName;
    releaseDate = aReleaseDate;
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

  public boolean setReleaseDate(Date aReleaseDate)
  {
    boolean wasSet = false;
    releaseDate = aReleaseDate;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Date getReleaseDate()
  {
    return releaseDate;
  }

  public void delete()
  {
    super.delete();
  }

  // line 13 "../../../../../domainModelJava.ump"
   public void setGenre(Genre aGenre){
    genre = aGenre;
  }

  // line 18 "../../../../../domainModelJava.ump"
   public Genre getGenre(){
    return genre;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "releaseDate" + "=" + (getReleaseDate() != null ? !getReleaseDate().equals(this)  ? getReleaseDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 6 ../../../../../domainModelJava.ump
  public enum Genre {Pop, EDM, Hiphop, Country, Rock, Indie,
	 RnB, Jazz, Soul, Classical, Kpop, Metal, Punk, Reggae, Blues, Funk};
// line 9 ../../../../../domainModelJava.ump
  private Genre genre ;

  
}