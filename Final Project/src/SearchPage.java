import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SearchPage extends JPanel {
  int count = 0;
  public static void main(String[] args) {
      JFrame window = new JFrame("SearchPage");
      JPanel content = new SearchPage();
      window.setContentPane(content);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocation(120,70);
      window.setSize(450,500);
      window.setVisible(true);
  }
  public SearchPage(){
    SearchPage content = this;
    content.setLayout(null);

		JLabel nameLabel = new JLabel("Full Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(0, 27, 250, 42);
		nameLabel.setBackground(Color.WHITE);
		final JTextField name = new JTextField("");
		name.setBounds(249, 33, 200, 28);
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.LEFT);

    JLabel classLabel = new JLabel("Class of:");
    classLabel.setHorizontalAlignment(SwingConstants.CENTER);
    classLabel.setBounds(0, 84, 250, 42);
    classLabel.setBackground(Color.WHITE);
    String[] yearList = new String[22];
    yearList[0] = "  ";
    for(int i=2000; i<=2020; i++){
      yearList[i-1999] = Integer.toString(i);
    }
    final JComboBox year = new JComboBox(yearList);
		year.setBounds(249, 90, 200, 28);

		final JLabel majorLabel = new JLabel("Major:");
		majorLabel.setBounds(0, 109, 249, 81);
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MajorReader mr = new MajorReader("../Majors.txt");
		String[] majorList = mr.toArray();
		JComboBox major = new JComboBox(majorList);
		major.setBounds(249, 113, 200, 81);

    final JButton search = new JButton("Search");
		search.setBounds(90, 271, 150, 43);
    final JButton clear = new JButton("Clear");
    clear.setBounds(270, 271, 150, 43);
		content.add(nameLabel);
		content.add(name);
		content.add(classLabel);
		content.add(year);
		content.add(majorLabel);
		content.add(major);
		content.add(search);
    content.add(clear);

    clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        name.setText("");
        year.setSelectedItem("  ");
        major.setSelectedItem("  ");
      }
    });

    search.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        //把之前存的txt文件提取出来，存到一个SearchDirectory的object里
        try {
          Scanner input = new Scanner ("result.txt");;
        } catch (FileNotFoundException e) {
          e.printStackTrace();
          System.err.println("Wrong Directory!!!>~<!!!");
          return;
        }
        while (input.hasNextLine()) {
          //Capture the next line
          String line = input.nextLine();
          Scanner nextLine = new Scanner (line);
          String name = nextLine.next();
          String gender = nextLine.next();
          String year = nextLine.next();
          String email = nextLine.next();
          String phone = nextLine.next();
          String major = nextLine.next();
          String placement = nextLine.next();
          Directory people = new Directory();
          people.setAll(name, gender, year, email, phone, major, placement);
          SearchDirectory.save(person);
          count++;
      }
    });

  }
}
