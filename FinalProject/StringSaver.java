import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StringSaver {
	public StringSaver(String dir, String str) {
		File log = new File(dir);
		try{
			if(log.exists()==false){
				System.out.println("We had to make a new file.");
			    log.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(log, true));
			out.append(str);
			out.close();
			}catch(IOException e){
				System.out.println("IO Exception!!!");
		}
	}
}
