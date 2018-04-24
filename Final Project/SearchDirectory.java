import java.util.*;

public class SearchDirectory {
  private HashMap<String, Directory> nameDirectory;
  private ArrayList<Directory> directoryList;

  public SearchDirectory() {
    this.nameDirectory = new HashMap<String, Directory>();
    this.directoryList = new ArrayList<Directory>();
  }

  public void save(Directory person1) {
    this.nameDirectory.put(person1.getName(), person1);
    this.directoryList.add(person1);
  }

  public String searchName(String name){
    String result;
    Directory person2 = this.nameDirectory.get(name);
    if (person2 == null) {
      result = "  ";
    } else {
      result = person2.toString();
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
