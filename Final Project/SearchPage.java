import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.util.*;

public class SearchPage extends JPanel {

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
    String[] yearList = new String[32];
    yearList[0] = "  ";
    for(int i=2000; i<=2030; i++){
      yearList[i-1999] = Integer.toString(i);
    }
    final JComboBox year = new JComboBox(yearList);
		year.setBounds(249, 90, 200, 28);

		final JLabel majorLabel = new JLabel("Major:");
		majorLabel.setBounds(0, 109, 249, 81);
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MajorReader mr = new MajorReader("Majors.txt");
		String[] majorList = mr.toArray();
		final JComboBox major = new JComboBox(majorList);
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


    final ImageIcon iconFind = new ImageIcon("magnifying_glass.png");
    final ImageIcon iconError = new ImageIcon("red_x.png");
    search.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        SearchDirectory contactBook = new SearchDirectory();
        readFile("directory.txt", contactBook);
        String result = "";
        if (!name.getText().equals("")&& major.getSelectedItem().equals("  ")
            && year.getSelectedItem().equals("  ")){
              result = contactBook.searchName("Name: "+name.getText()).toString().replaceAll("#", "\n");
        } else if (name.getText().equals("")&& !major.getSelectedItem().equals("  ")
            && year.getSelectedItem().equals("  ")){
              result = contactBook.searchMajor("Major: "+(String)major.getSelectedItem()).replaceAll("#", "\n");
        } else if (name.getText().equals("")&& major.getSelectedItem().equals("  ")
            && !year.getSelectedItem().equals("  ")){
              result = contactBook.searchYear("Class of: "+(String)year.getSelectedItem()).replaceAll("#", "\n");
        } else {
              result = "Error";
              JOptionPane.showMessageDialog(null, "Please enter one criteria!", "Error",
                                        JOptionPane.INFORMATION_MESSAGE, iconError);
        }
        if (result.startsWith("Name:")) {
          JOptionPane.showMessageDialog(null, result, "SearchResult", JOptionPane.INFORMATION_MESSAGE, iconFind);
        } else if (result.equals("Error")) {

        } else {
          JOptionPane.showMessageDialog(null, "No match was found", "SearchResult", JOptionPane.INFORMATION_MESSAGE, iconFind);
        }
      }
    });
  }

  public static void readFile(String file, SearchDirectory contactBook) {
    try {
      Scanner input = new Scanner (new File(file));
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] str = line.split("#");
        Directory people = new Directory();
        people.setAll(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
        contactBook.save(people);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Wrong Directory!!!>~<!!!");
      return;
    }

  }
}
