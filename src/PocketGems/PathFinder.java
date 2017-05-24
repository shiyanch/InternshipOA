package PocketGems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by shiyanch on 1/21/17.
 */
public class PathFinder {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "src/PocketGems/input_1.txt";
        if (args != null && args.length > 0) {
            filename = args[0];//input the filename in the commandline
        }

        List<String> answer = readFile(filename);
        System.out.println(answer);
    }

    private static List<String> readFile(String filename) throws FileNotFoundException, IOException{
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();
        return parseLines(allLines);
    }

    private static List<String> parseLines(List<String> lines) {
        String[] target = lines.get(0).split(" ");
        lines.remove(0);
        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String line : lines) {
            String[] nodes = line.trim().split(":");
            List<String> neighbors = Arrays.asList(nodes[1].trim().split(" "));
            adjacencyList.put(nodes[0].trim(), neighbors);
        }

        List<String> paths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        backtrack(paths, "", target[0].trim(), target[1].trim(), adjacencyList, visited);
        return paths;
    }

    private static void backtrack(List<String> paths, String curPath, String start, String end, Map<String, List<String>> adjacencyList, Set<String> visited) {
        if (start.equals(end)) {
            paths.add(curPath + start);
            return;
        }

        if (!adjacencyList.containsKey(start)) {
            return;
        }
        visited.add(start);
        List<String> neighbors = adjacencyList.get(start);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                backtrack(paths, curPath+start, neighbor, end, adjacencyList, visited);
            }
        }
        visited.remove(start);
    }
}
