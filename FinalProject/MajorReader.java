import java.util.*;
import java.io.*;
public class MajorReader {
	private List<String> list = new ArrayList<>();
	public MajorReader(String dir) {
		Scanner scan = new Scanner(System.in);
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
		try {
			
			scan = new Scanner(new File(dir));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Wrong Directory!!!>~<!!!");
			return;
		}
		while (scan.hasNextLine()) {
			list.add(scan.nextLine().replace("\\", ""));
		}
		
	}
	
	public String[] toArray() {
		String[] str = new String[list.size()];
		for (int i = 0; i< list.size(); i++) {
			str[i] = list.get(i);
		}
		return str;
	}
	
}
