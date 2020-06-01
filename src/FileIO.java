import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileIO {

	public void readFileAndPopulateTreeMap(String path, TreeMap<String, String> toFill) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				toFill.put(values[0], values[1]);
			}
		}finally {
			reader.close();
		}
		
	}
	
	public void writeToFileFromTreeMap(String path, TreeMap<String, String> toFillWith) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			for (Map.Entry<String, String> entry : toFillWith.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue() + ",\n");
			}
			
		}finally {
			writer.close();
		}
	}
	
}
