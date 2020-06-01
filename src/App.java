import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {
	
	
	public static void main(String[] args) {
		FileIO io = new FileIO();
		
		TreeMap<String, String> list = new TreeMap<String, String>(Collections.reverseOrder());
		
		try {
			io.readFileAndPopulateTreeMap("assets/stats.csv", list);
			String today = Time.getToday();
			
			updateStats(list, today);
			io.writeToFileFromTreeMap("assets/stats.csv", list);
				
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),
			        "Er is een fout opgetreden", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static void updateStats(TreeMap<String, String> toUpdate, String dateToUpdate) {
		if (toUpdate.get(dateToUpdate) != null) {
			int count = Integer.valueOf(toUpdate.get(dateToUpdate)) + 1;
			toUpdate.put(dateToUpdate, String.valueOf(count));
		} else {
			toUpdate.put(dateToUpdate, "1");
		}
	}
	
}
