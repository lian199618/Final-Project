
public class Directory {
  private String name;
  private String gender;
  private String year;
  private String email;
  private String phone;
  private String major;
  private String placement;

  public Directory() {

  }

  public  void setAll(String name, String gender, String year,
                   String email, String phone, String major,
                   String placement) {
    this.name = "Name: "+name;
    this.gender = "Gender: "+gender;
    this.year = "Class of: "+year;
    this.email = "Email: "+email;
    this.phone = "Phone: "+phone;
    this.major = "Major: "+major;
    this.placement = "Placement: "+placement;
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

  public String saveToFile() {
    String contact = "";
    contact+=this.name.substring(6)+"#";
    contact+=this.gender.substring(8)+"#";
    contact+=this.year.substring(10)+"#";
    contact+=this.email.substring(7)+"#";
    contact+=this.phone.substring(7)+"#";
    contact+=this.major.substring(7)+"#";
    contact+=this.placement.substring(11)+"\n";
    return contact;
  }

  public String toString() {
    String contact = "";
    contact+=this.name+"#";
    contact+=this.gender+"#";
    contact+=this.year+"#";
    contact+=this.email+"#";
    contact+=this.phone+"#";
    contact+=this.major+"#";
    contact+=this.placement+"\n";
    return contact;
  }

}
