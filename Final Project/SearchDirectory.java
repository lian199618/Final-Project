import java.util.*;

public class SearchDirectory {
  private ArrayList<Directory> directoryList;

  public SearchDirectory() {
    this.directoryList = new ArrayList<Directory>();
  }

  public void save(Directory person1) {
    this.directoryList.add(person1);
  }

  public String searchName(String name){
    String result = "";
    for (Directory person:directoryList){
      if (person.getName().equals(name)){
        result+= person.toString()+"\n";
      }
    }
    return result;
  }

  public String searchYear(String year){
    String result = "";
    for (Directory person:directoryList){
      if (person.getYear().equals(year)){
        result+= person.toString()+"\n";
      }
    }
    return result;
  }

  public String searchMajor(String major){
    String result = "";
    for (Directory person:directoryList){
      if (person.getMajor().equals(major)){
        result+= person.toString()+"\n";
      }
    }
    return result;
  }
  public String toString() {
    String result ="";
    for (Directory person:directoryList){
        result+= person.toString()+"\n";
    }
    return result;
  }
}
