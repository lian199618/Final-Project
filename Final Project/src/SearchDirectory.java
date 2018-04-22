import java.util.*;

public class SearchDirectory {
  private TreeMap<String, Directory> nameDirectory;
  private ArrayList<Directory> directoryList;

  public SearchDirectory() {
    this.nameDirectory = new TreeMap<String, Directory>();
    this.directoryList = new ArrayList<Directory>();
  }

  public void save(Directory person1) {
    this.nameDirectory.put(person1.getName(), person1);
    this.directoryList.add(person1);
  }

  public Directory searchName(String name){
    return this.nameDirectory.get(name);
  }

  public ArrayList<Directory> searchYear(String year){
    ArrayList<Directory> result = new ArrayList<Directory>();
    for(Directory person: directoryList) {
      if (year.equals(person.getYear())){
        result.add(person);
      }
    }
    return result;
  }

  public ArrayList<Directory> searchMajor(String major){
    ArrayList<Directory> result = new ArrayList<Directory>();
    for(Directory person: directoryList) {
      if (major.equals(person.getMajor())){
        result.add(person);
      }
    }
    return result;
  }
}
