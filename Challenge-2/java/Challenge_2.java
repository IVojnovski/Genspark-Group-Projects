import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

		//lunch must always be at 12 and last till 1 (then afternoon sessions begin)
		//duration mapping should detect numbers and the exact word lightning
		//morning session begins at 9 and should end by 12 for lunch
		//no talk title can have numbers in it
		//no gaps between sessions
		//multiple tracks (simultaneous sessions) each with morning and afternoon sessions
		//networking starts no earlier than 4 and no later than 5

public class Challenge_2 {
	public static void main (String[] args) {
		try {
			List<String> lines = Files.readAllLines(Paths.get("C:\\Genspark-Group-Projects\\Challenge-2\\challenge-2.txt"), StandardCharsets.UTF_8);
			List<String> arl = new ArrayList<>();
			List<String> elim = new ArrayList<>(); // for getting rid of events that have already been scheduled in the function
			HashMap <String, Integer> hm = new HashMap<>();
			
			for (int i = 0;i < lines.size();i++) { //groups the contents of the stream so that the duration and name of the activity are in the same string
				if (lines.get(i).contains("min") || lines.get(i).contains("lightning")) {
					arl.add(lines.get(i));
				}
				else {
					String temp = lines.get(i) + " " + lines.get(i+1);
					arl.add(temp);
					i++; //need to add to i so that it doesnt try to add the next line since it would be redundant because of the above statements
				}
			}
			
			for (String line : arl) {
				String[] temp = line.split("   "); //splits by three spaces because that is how the text is formatted and we want to map the duration to the event
				String event = temp[0];
				String dur; //duration
				if (line.contains("lightning")) {
					dur = "5";
				}
				else {
					dur = temp[1].replace("min", "");
				}
				int duration = Integer.parseInt(dur);
				
				elim.add(event);
				hm.put(event, duration); //puts event duration in a map value relationship
				//use schedule function outside of this for loop can loop through arl again to print to the schedule function
			}
			schedule(hm, arl,elim);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void schedule (HashMap<String, Integer> map, List<String> arl,List<String> elim) {
		//scheduling functioning
		/*
		 * create a function that makes 2 tracks and fits to the constraints */
		String startTime = "9:00AM";
		String lunchTime = "12:00PM";
		String endNetwork = "5:00PM";
		int after1 = 240;
		int morn2 = 180;
		int after2 = 240;
	
		//Track1
		// 9-12 180 mins
		// 12 - 1 lunch
		// 1-5 240 mins
		// networking event
		System.out.println("Track 1: ");
		//morning
		for (int i = 0;i < elim.size();i++) {
			int morn1 = 180;
			map.get(elim.get(i));
		}
		
		System.out.println("12:00PM		Lunch");
		//afternoon
		for (int i = 0;i < elim.size();i++) {
			
		}
		
		System.out.println("5:00PM		Networking	Event");
		
		//Track2
		System.out.println("Track 2: ");
		//morning
		for (int i = 0;i < elim.size();i++) {
			
		}
		
		System.out.println("12:00PM		Lunch");
		//afternoon
		for (int i = 0;i < elim.size();i++) {
			
		}
		
		System.out.println("5:00PM		Networking	Event");
	}
}
