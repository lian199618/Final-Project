
public class Directory {
  private String name;
  private String gender;
  private String year;
  private String email;
  private String phone;
  private String major;
  private String placement;

  public Directory(String name, String gender, String year,
                   String email, String phone, String major,
                   String placement) {
    this.name = name;
    this.gender = gender;
    this.year = year;
    this.email = email;
    this.phone = phone;
    this.major = major;
    this.placement = placement;
  }

  public String getName() {
    return this.name;
  }

  public String getMajor() {
    return this.major;
  }

  public String getYear() {
    return this.year;
  }

  public String toString() {
    String contact = "";
    contact+=this.name+"\n";
    contact+=this.gender+"\n";
    contact+=this.year+"\n";
    contact+=this.email+"\n";
    contact+=this.phone+"\n";
    contact+=this.major+"\n";
    contact+=this.placement+"\n";
    return contact;
  }

}
