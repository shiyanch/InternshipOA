package PocketGems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "src/PocketGems/test1.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    private static Date convertDate(String dateString) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
        try {
            return df.parse(dateString);
        } catch (ParseException ignored) {}
        return new Date();
    }

    static String parseLines(String[] lines) {
        Map<String, Integer> status = new HashMap<>();
        status.put("START", 0);
        status.put("CONNECTED", 1);
        status.put("DISCONNECTED", -1);
        status.put("SHUTDOWN", -1);

        List<Date> times = new ArrayList<Date>();
        List<String> events = new ArrayList<String>();
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" :: ");
            if(status.containsKey(line[1])) {
                times.add(convertDate(line[0].substring(1, line[0].length()-1)));
                events.add(line[1]);
            }
        }
        long totalTime = times.get(times.size()-1).getTime() - times.get(0).getTime();
        long connectingTime = 0, lastTimePoint= 0;
        for (int i=1; i<times.size(); i++) {
            String currentEvent = events.get(i);
            long currentTime = times.get(i).getTime();

            if (status.get(currentEvent) <= 0 && lastTimePoint > 0) {
                connectingTime += currentTime - lastTimePoint;
                lastTimePoint = -1;
            }
            else if (status.get(currentEvent) > 0) {
                lastTimePoint = currentTime;
            }
        }
        return (connectingTime*100/totalTime)+"%";
//        return ((int)((double) connectingTime / totalTime * 100))+"%";
    }
}
