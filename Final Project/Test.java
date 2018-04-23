
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorReader mr = new MajorReader("../Final Project/Majors.txt");
		String[] str = mr.toArray();
		for (String s: str) {
			System.out.println(s);
		}
		
	}

}
