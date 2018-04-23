import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class InputPage extends JPanel {

  public static void main(String[] args) {
      JFrame window = new JFrame("InputPage");
      JPanel content = new InputPage();
      window.setContentPane(content);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocation(120,70);
      window.setSize(450,200);
      window.setVisible(true);
  }

  public InputPage(){
    InputPage content = this;
    content.setLayout(null);
    JLabel nameLabel = new JLabel("Full Name:");
    nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    nameLabel.setBounds(0, 2, 250, 42);
    nameLabel.setBackground(Color.WHITE);
    final JTextField name = new JTextField("");
    name.setBounds(250, 4, 200, 28);
    name.setBackground(Color.WHITE);
    name.setHorizontalAlignment(SwingConstants.LEFT);

    final JLabel genderLabel = new JLabel("Gender:");
    genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
    genderLabel.setBounds(0, 44, 250, 42);
    JPanel gender = new JPanel();
    gender.setBounds(250, 44, 250, 42);
    final JCheckBox male = new JCheckBox("Male", true);
    male.setBounds(6, 0, 94, 42);
    male.setBackground(Color.WHITE);
    final JCheckBox female = new JCheckBox("Female");
    female.setBounds(100, 0, 100, 42);
    female.setBackground(Color.WHITE);
    gender.setLayout(null);
    gender.add(male);
    gender.add(female);

    JLabel classLabel = new JLabel("Class of:");
    classLabel.setHorizontalAlignment(SwingConstants.CENTER);
    classLabel.setBounds(0, 170, 250, 42);
    classLabel.setBackground(Color.WHITE);
    String[] yearList = new String[32];
    yearList[0] = "  ";
    for(int i=2000; i<=2030; i++){
      yearList[i-1999] = Integer.toString(i);
    }
    final JComboBox year = new JComboBox(yearList);
    year.setBounds(250, 170, 200, 42);

    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
    emailLabel.setBounds(0, 128, 250, 42);
    final JTextField email = new JTextField("");
    email.setBounds(250, 128, 200, 28);
    email.setHorizontalAlignment(SwingConstants.LEFT);

    final JLabel phoneLabel = new JLabel("Phone:");
    phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
    phoneLabel.setBounds(0, 86, 250, 42);
    final JTextField phone = new JTextField("");
    phone.setBounds(250, 86, 200, 28);
    phone.setHorizontalAlignment(SwingConstants.LEFT);

    final JLabel majorLabel = new JLabel("Major:");
    majorLabel.setHorizontalAlignment(SwingConstants.CENTER);
    majorLabel.setBounds(0, 212, 250, 42);
    MajorReader mr = new MajorReader("Majors.txt");
    String[] majorList = mr.toArray();
    final JComboBox major = new JComboBox(majorList);
    major.setBounds(250, 212, 200, 42);

    final JLabel placeLabel = new JLabel("Placement:");
    placeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    placeLabel.setBounds(0, 253, 250, 42);
    String [] placementList = {"  ", "Internship", "Full-time", "Graduate School", "Home", "Have not Decide Yet"};
    final JComboBox placement = new JComboBox(placementList);
    placement.setBounds(250, 254, 200, 42);

    final JButton save = new JButton("Save");
		save.setBounds(100, 307, 150, 42);
    final JButton clear = new JButton("Clear");
    clear.setBounds(280, 307, 150, 42);

    content.add(nameLabel);
    content.add(name);
    content.add(genderLabel);
    content.add(gender);
    content.add(classLabel);
    content.add(year);
    content.add(emailLabel);
    content.add(email);
    content.add(phoneLabel);
    content.add(phone);
    content.add(majorLabel);
    content.add(major);
    content.add(placeLabel);
    content.add(placement);
    content.add(save);
    content.add(clear);

    male.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          female.setSelected(false);
        } else {
          female.setSelected(true);
        }
      }
    });
    female.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            male.setSelected(false);
        } else {
          male.setSelected(true);
        }
      }
    });

    clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        name.setText("");
        male.setSelected(true);
        year.setSelectedItem("  ");
        email.setText("");
        phone.setText("");
        major.setSelectedItem("  ");
        placement.setSelectedItem("  ");
      }
    });
    final ImageIcon iconSave = new ImageIcon("check-green.png");
    final ImageIcon iconError = new ImageIcon("red_x.png");
    save.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Directory person = new Directory();
        if (name.getText().equals("")||year.getSelectedItem().equals("  ")||
            email.getText().equals("")||phone.getText().equals("")||
            major.getSelectedItem().equals("  ")||placement.getSelectedItem().equals("  ")) {

              JOptionPane.showMessageDialog(null, "Information is imcomplete!", "Message",
                                            JOptionPane.INFORMATION_MESSAGE, iconError);
        } else {

          if (male.isSelected()){
          person.setAll(name.getText(), "Male", (String)year.getSelectedItem(),
                      email.getText(), phone.getText(), (String)major.getSelectedItem(),
                      (String)placement.getSelectedItem());
          } else {
            person.setAll(name.getText(), "Female", (String)year.getSelectedItem(),
                      email.getText(), phone.getText(), (String)major.getSelectedItem(),
                      (String)placement.getSelectedItem());
          }
          StringSaver ss = new StringSaver("directory.txt",person.toString());
          JOptionPane.showMessageDialog(null, "Information successfully saved!", "Message",
                                      JOptionPane.INFORMATION_MESSAGE, iconSave);
        }
      }
    });

  }
}
