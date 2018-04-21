import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BrandeisAlumniDirectory{
	public static void main(String[] args){

		ImageIcon logo = new ImageIcon("../Final Project/Brandeis_Zendesk_Logo_01.png");

		JFrame window = new JFrame("Brandeis Alumni Directory");
		JPanel content = new JPanel();
		JLabel title = new JLabel("<html><h1>Brandeis Alumni Directory</h1></html>");
		title.setForeground(new Color(0, 102, 255));
		title.setBackground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);

//		JPanel line2 = new JPanel();
//		line2.setLayout(new GridLayout(1,3));
//		final JLabel empty = new JLabel(" ");
//		final JLabel empty2 = new JLabel(" ");
//		line2.add(empty);
//		line2.add(empty2);



		final JPanel info = new JPanel();
		JLabel nameLable = new JLabel("Full Name:");
		nameLable.setHorizontalAlignment(SwingConstants.CENTER);
		nameLable.setBounds(0, 2, 250, 42);
		nameLable.setBackground(Color.WHITE);
		final JTextField name = new JTextField("Mary White");
		name.setBounds(250, 2, 200, 42);
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.LEFT);

		final JLabel genderLable = new JLabel("Gender:");
		genderLable.setHorizontalAlignment(SwingConstants.CENTER);
		genderLable.setBounds(0, 44, 250, 42);
		JPanel gender = new JPanel();
		gender.setBounds(250, 44, 250, 42);
		final JCheckBox male = new JCheckBox("Male");
		male.setBounds(6, 0, 94, 42);
		male.setBackground(Color.WHITE);
		final JCheckBox female = new JCheckBox("Female",true);
		female.setBounds(100, 0, 100, 42);
		female.setBackground(Color.WHITE);
		gender.setLayout(null);
		gender.add(male);
		gender.add(female);

		JLabel classLable = new JLabel("Class of:");
		classLable.setHorizontalAlignment(SwingConstants.CENTER);
		classLable.setBounds(0, 86, 250, 42);
		classLable.setBackground(Color.WHITE);
		final JTextField classOf = new JTextField("2010");
		classOf.setBounds(250, 86, 200, 42);
		classOf.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel emailLable = new JLabel("Email:");
		emailLable.setHorizontalAlignment(SwingConstants.CENTER);
		emailLable.setBounds(0, 128, 250, 42);
		final JTextField email = new JTextField("mwhite@gmail.com");
		email.setBounds(250, 128, 200, 42);
		email.setHorizontalAlignment(SwingConstants.LEFT);

		final JLabel phoneLable = new JLabel("Phone:");
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLable.setBounds(0, 170, 250, 42);
		final JTextField phone = new JTextField("123-456-7890");
		phone.setBounds(250, 170, 200, 42);
		phone.setHorizontalAlignment(SwingConstants.LEFT);

		final JLabel majorLable = new JLabel("Major:");
		majorLable.setHorizontalAlignment(SwingConstants.CENTER);
		majorLable.setBounds(0, 212, 146, 42);
		MajorReader mr = new MajorReader("../Final Project/Majors.txt");
		String[] major2 = mr.toArray();
		JComboBox major = new JComboBox(major2);
		major.setBounds(250, 212, 200, 42);

		final JLabel placeLable = new JLabel("Placement:");
		placeLable.setHorizontalAlignment(SwingConstants.CENTER);
		placeLable.setBounds(0, 253, 250, 42);
		String [] place2 = {"Internship", "Full-time", "Graduate School", "Home", "Have not Decide Yet"};
		JComboBox place = new JComboBox(place2);
		place.setBounds(250, 254, 200, 42);
		info.setLayout(null);


		info.add(nameLable);
		info.add(name);
		info.add(genderLable);
		info.add(gender);
		info.add(classLable);
		info.add(classOf);
		info.add(emailLable);
		info.add(email);
		info.add(phoneLable);
		info.add(phone);
		info.add(majorLable);
		info.add(major);
		info.add(placeLable);
		info.add(place);



		final JPanel info2 = new JPanel();

		JLabel nameLable2 = new JLabel("Full Name:");
		nameLable2.setHorizontalAlignment(SwingConstants.CENTER);
		nameLable2.setBounds(0, 26, 250, 42);
		nameLable2.setBackground(Color.WHITE);
		final JTextField name2 = new JTextField("Mary White");
		name2.setBounds(249, 33, 200, 28);
		name2.setBackground(Color.WHITE);
		name2.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel classLable2 = new JLabel("Class of:");
		classLable2.setHorizontalAlignment(SwingConstants.CENTER);
		classLable2.setBounds(0, 64, 249, 75);
		classLable2.setBackground(Color.WHITE);
		final JTextField classOf2 = new JTextField("2010");
		classOf2.setHorizontalAlignment(SwingConstants.CENTER);
		classOf2.setBounds(249, 90, 200, 28);
		classOf.setHorizontalAlignment(SwingConstants.LEFT);

		final JLabel majorLable2 = new JLabel("Major:");
		majorLable2.setBounds(0, 112, 249, 81);
		majorLable2.setHorizontalAlignment(SwingConstants.CENTER);
		majorLable.setHorizontalAlignment(SwingConstants.CENTER);
		majorLable.setBounds(0, 212, 250, 42);
		MajorReader mr2 = new MajorReader("../Final Project/Majors.txt");
		String[] major3 = mr.toArray();
		JComboBox major4 = new JComboBox(major3);
		major4.setBounds(249, 113, 200, 81);
		info2.setLayout(null);

		info2.add(nameLable2);
		info2.add(name2);
		info2.add(classLable2);
		info2.add(classOf2);
		info2.add(majorLable2);
		info2.add(major4);
		final JButton search = new JButton("search");
		search.setBounds(136, 271, 101, 43);
		info2.add(search);


		final JPanel middle = new JPanel();
		middle.setLayout(new CardLayout(1,2));
		middle.add(info,"Survey");

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(70, 307, 150, 42);
		info.add(btnSave);

		JButton btnIfYouWant = new JButton("Next Page");
		btnIfYouWant.setBounds(250, 308, 150, 42);
		info.add(btnIfYouWant);
		middle.add(info2,"Search");

		btnIfYouWant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c1 = (CardLayout)middle.getLayout();
				c1.show(middle,"Search");
//		    	System.out.println(a.reversePhoneBook.toString());
		     }
		});

		JLabel lblWriteInClass = new JLabel("Write in Class year or select major to find the corresponding people.");
		lblWriteInClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriteInClass.setBounds(0, 195, 498, 16);
		info2.add(lblWriteInClass);

		JButton btnIfYouWant2 = new JButton("Previous Page");
		btnIfYouWant2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c2 = (CardLayout)middle.getLayout();
				c2.show(middle, "Survey");
			}
		});
		btnIfYouWant2.setBounds(249, 271, 113, 43);
		info2.add(btnIfYouWant2);



//		JPanel bottum = new JPanel();
//		bottum.setLayout(new GridLayout(1,4));
//		final JLabel empty = new JLabel(" ");
//		empty.setBackground(Color.WHITE);
//		final JLabel empty2 = new JLabel(" ");
//		final JButton save = new JButton("save");
//		save.setBackground(Color.WHITE);
//		final JButton search = new JButton("search");
////		line2Right.setLayout(new GridLayout(1,2));
//		bottum.add(empty);
//		bottum.add(save);
//		bottum.add(search);
//		bottum.add(empty2);
////		line2.add(line2Right);



//
//		save.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){

//		     }
//		});
//

//		search.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//
//
//		     }
//		});

//		content.setLayout(new GridLayout(8,1));
//		content.add(logo);
//		content.add(title);
//		content.add(line2);
//		content.add(info);
//		content.add(line4);

		content.setLayout(new BorderLayout());
		content.add(title,BorderLayout.PAGE_START);
		content.add(middle,BorderLayout.CENTER);
//		content.add(bottum,BorderLayout.PAGE_END);

		window.setContentPane(content);

//		JProgressBar progressBar = new JProgressBar();
//
//		content.add(progressBar);
		window.setSize(500,450);
		window.setLocation(100,100);
		window.setVisible(true);

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

		btnSave.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent e){
    	String name1 = name.getText();
			String gender1;
			if(male.isSelected()){
				gender1 = "male";
			}
			else{
				gender1 = "female";
			}
			String class1 = classOf.getText();
			String email1 = email.getText();
			String phone1 = phone.getText();
    	String major5 = major2.getSelectedItem().toString();
			String placement1 = place.getSelectedItem().toString();
			Directory person = new Directory(name1, gender1, class1,
																				email1, phone1, major5,placement1);
			ContactBook.save(person);
		}
		});

		search.addActionListener(){
			public void actionperformed(ActionEvent e){
			if(!name.getText().equals("")){

			}
			}
		};

	}
}
