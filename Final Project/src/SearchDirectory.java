import java.util.*;

public class SearchDirectory {
  private TreeMap<String, Directory> nameDirectory;
  private TreeMap<String, Directory> classDirectory;
  private TreeMap<String, Directory> majorDirectory;

  public SearchDirectory() {
    this.nameDirectory = new TreeMap<String, Directory>();
    this.classDirectory = new TreeMap<String, Directory>();
    this.majorDirectory = new TreeMap<String, Directory>();
  }

  public void save(Directory person1) {
    this.nameDirectory.put(person1.getName(), person1);
    this.classDirectory.put(person1.getClass(), person1);
    this.majorDirectory.put(person1.getMajor(), person1);
  }

  public Directory searchName(String name){
    return this.nameDirectory.get(name);
  }

  public ArrayList<Directory> searchClass(String class){

  }
}
