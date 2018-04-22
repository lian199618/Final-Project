import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class BrandeisAlumniDirectory{
	public static void main(String[] args) throws ClassNotFoundException {
		SearchDirectory contactBook = new SearchDirectory();

		JFrame window = new JFrame("Brandeis Alumni Directory");
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

		ImageIcon title = new ImageIcon("../title.png");
		JLabel logo = new JLabel(title, JLabel.CENTER);
		// JLabel title = new JLabel("<html><h1>Brandeis Alumni Directory</h1></html>");
		// title.setForeground(new Color(0, 102, 255));
		// title.setBackground(Color.WHITE);
		// title.setHorizontalAlignment(SwingConstants.CENTER);
		 content.add(logo, BorderLayout.PAGE_START);

		JPanel inputPage = new InputPage();
		JPanel searchPage = new SearchPage();
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("InputPage", inputPage);
    tabbedPane.addTab("SearchPage", searchPage);
	  content.add(tabbedPane, BorderLayout.CENTER);

		window.setContentPane(content);
		window.setSize(565,525);
		window.setLocation(100,100);
		window.setVisible(true);
		window.setResizable(false);
	}
}
