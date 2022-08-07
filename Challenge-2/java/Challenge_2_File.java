import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge_2_File {
	
	/* reads the challenge 2 text file and formats data for use in Ch2_Schedule
	Configure to allow the user to input any file text file they want but put in instructions the exact text formatting needed
	for the program to properly create a schedule */

    public static Map<String, Integer> textToSchedule() {
        Map<String, Integer> eventAndDuration = new HashMap<String, Integer>();
        File file = new File("C:\\Genspark-Group-Projects\\Challenge-2\\challenge-2.txt");
        //edit this file so that the user can input their own file
        BufferedReader reader = null;
         try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int numTime = 0;
            
            //analyze what this while function actually does
            while ((line = reader.readLine()) != null) {
                int lastBlank = line.lastIndexOf(" ");
                String title = line.substring(0 , lastBlank);
                String time = line.substring(lastBlank + 1);
                
                //find out why it still printing lightningmin even if it detects and stores 5 instead of lightning
                 if (time.equals("lightning")) {
                    numTime = 5;
                } 
                 else {
                    numTime = Integer.parseInt(time.substring(0, time.length() - 3));
                    //extracts the number from being attached to the "min" string
                }
                 
                eventAndDuration.put(title, numTime);
            }
            
            reader.close();
        } 
         catch (IOException e) {
            e.printStackTrace();
        } 
         
        return eventAndDuration;
    }
}