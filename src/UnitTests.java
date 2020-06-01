import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class UnitTests {

	private final FileIO io = new FileIO();
	private TreeMap<String, String> list = new TreeMap<String, String>(Collections.reverseOrder());
	private TreeMap<String, String> clone;
	
	@Test
	void read() throws IOException {
		io.readFileAndPopulateTreeMap("assets/stats.csv", list);
		if(list.isEmpty()) {
			fail("lijst is leeg");
		}
		clone = (TreeMap<String, String>) list.clone();
	}
	
	@Test
	void today() {
		String today = Time.getToday();
		assertEquals("2020-05-26", today);
	}
	
	@Test
	void update(){
		String today = Time.getToday();
		App.updateStats(list, today);
		assertEquals(list.get(today), "3");
	}
	
	

}
