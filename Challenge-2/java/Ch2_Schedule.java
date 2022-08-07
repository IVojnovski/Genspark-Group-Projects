import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public  class Ch2_Schedule {

    public static void main (String[] args) {
    	//gets an instance of a schedule to use in this class
        Map<String, Integer> eventAndDuration = Challenge_2_File.textToSchedule();
        Map<String, Integer> eadCopy = new HashMap<String, Integer>(eventAndDuration); //copy of event and duration to use temp map
        Map<String, Integer> track1Morn = getTrackMap(eventAndDuration, 180);
        Map<String, Integer> track1Noon = getTrackMap(eventAndDuration, 240);
        Map<String, Integer> track2Morn = getTrackMap(eventAndDuration, 180);
        Map<String, Integer> track2Noon = getTrackMap(eventAndDuration, 240);

        //handles possibility of an empty text file
        if (!eventAndDuration.isEmpty()) {
            Map<String, Integer> tempMap = new HashMap<String, Integer>(eadCopy);
            
             while (!tempMap.isEmpty()){
                tempMap = new HashMap<String, Integer>(eadCopy);
                track1Morn = getTrackMap(tempMap, 180);
                track1Noon = getTrackMap(tempMap, 240);
                track2Morn = getTrackMap(tempMap, 180);
                track2Noon = getTrackMap(tempMap, 240);
            }
        }

        System.out.println("Track 1:");
        
        printMornSchedule(track1Morn);
        printNoonSchedule(track1Noon);
        
        System.out.println("Track 2:");
        
        printMornSchedule(track2Morn);
        printNoonSchedule(track2Noon);

    }

    public static void printMornSchedule(Map<String, Integer> trackMap) {
        int sumTime = 0;
        int res = 0;
        String remStr = "00";
        
        for (Entry<String, Integer> entry : trackMap.entrySet()) {
            String title = entry.getKey();
            int time = entry.getValue();
            String timeStr;
            
          //if time is lightning, makes sure it is displayed as "5min"
            if (time == 5) {
             	timeStr = "5";
            }
            else {
             	timeStr = time + "";
            }
            
             switch (res) {
             case 0:
                System.out.println( "09:" + remStr + "AM " + title + " " + timeStr + "min" );
                 break;
             case 1:
                System.out.println( "10:" + remStr + "AM " + title + " " + timeStr + "min" );
                 break;
             case 2:
                System.out.println( "11:" + remStr + "AM " + title + " " + timeStr + "min" );
                 break;
             default:
                 break;
            }
             
            sumTime += time;
            res = sumTime / 60;
            int rem = sumTime % 60;
             
            if (rem / 10 == 0) {
                remStr = "0" + rem;
            } 
            else {
                remStr = rem + "";
            }
             
        }
        
        System.out.println( "12:00PM Lunch");
    }

    public static void printNoonSchedule(Map<String, Integer> trackMap) {
        int sumTime = 0;
        int res = 0;
        String remStr = "00";
        
        //prints the Schedule
        for (Entry<String, Integer> entry : trackMap.entrySet()) {
        	
            String event = entry.getKey();
            int time = entry.getValue();
            String timeStr;
            
           //if time is lightning, makes sure it is displayed as "5min"
            if (time == 5) {
             	timeStr = "5";
            }
            else {
             	timeStr = time + "";
            }
            
            //switches the number on the print statement by res because res = sumTime/60 and this translates to a displayable time
            switch (res) {
            case 0:
                 System.out.println("01:" + remStr + "PM " + event + " " + timeStr + "min");
                 break;
            case 1:
                 System.out.println("02:" + remStr + "PM " + event + " " + timeStr + "min");
                 break;
            case 2:
                 System.out.println("03:" + remStr + "PM " + event + " " + timeStr + "min");
                 break;
            case 3:
                System.out.println("04:" + remStr + "PM " + event + " " + timeStr + "min");
                break;
            default:
                break;
           }
             
           sumTime += time;
           res = sumTime / 60;
           int rem = sumTime % 60;
            
           //adds a zero to the beginning of times that need to be displayed that aren't double digits like 04:00
           if (rem / 10 == 0) {
               remStr = "0" + rem;
           } 
           else {
               remStr = rem + "";
           }
             
        }
         
        System.out.println( "05:00PM Networking Event" );
    }

    //retrieves the tracks for track 1 and 2
    public static Map<String, Integer> getTrackMap(Map<String, Integer> eventAndDuration, int eventMinutes) {
        Map<String, Integer> trackMap = new HashMap<String, Integer>();
        List<String> titleList = new ArrayList<String> (eventAndDuration.keySet());
        
        Random random = new Random();
        int randomIndex = 0;
        String randomTitle = null;
        int time = 0;
        int sumTime = 0;
         
        //selects random keys from eventAndDuration to input into the map that will create the proper schedule
        while (sumTime < eventMinutes && titleList.size() > 0) {
            randomIndex = random.nextInt(titleList.size());
            randomTitle = titleList.get(randomIndex);
            time = eventAndDuration.get(randomTitle);
            sumTime += time;
            
            if (sumTime <= eventMinutes) {
                trackMap.put(randomTitle, time);
            }
             
            titleList.remove(randomTitle);
        }

        //removes entry that is input to track so that it is not reused
        Set<String> trackMapKeySet = trackMap.keySet();
        Iterator<Entry<String, Integer>> it = eventAndDuration.entrySet().iterator();
        
        while (it.hasNext()) {
        	
            if (trackMapKeySet.contains(it.next().getKey())) {
                it.remove();
            }
             
        }
         
        return trackMap;
    }
}