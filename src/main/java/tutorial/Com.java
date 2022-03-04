package tutorial;

import org.json.JSONObject;

import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Com {
    public static void countNullWithSinggleFile(HashSet<JSONObject> jsonObjects) {
        /*
        Sumary: Count null values from json files
        @param jsonObjects: json data reading from json file
         */
        long startTime = System.nanoTime();
        JSONObject jsonObject;
        Set<String> keys = new HashSet<>(jsonObjects.iterator().next().keySet());
        Iterator<JSONObject> dataIter = jsonObjects.iterator();
        HashMap<String, Integer> countMap = new HashMap<>();

        int count = 0; // Total of null values in file

        // Init countMap
        for (String key : keys) {
            countMap.put(key, Integer.valueOf(0));
        }

        // Start counting
        do {
            jsonObject = dataIter.next();
            for (String key : keys) {
                if (jsonObject.get(key).equals(null)) {
                    count += 1;
                    countMap.replace(key, countMap.get(key) + 1);
                }
            }
        }
        while (dataIter.hasNext());
        System.out.println(countMap);
        System.out.println("Count is : " + count);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Processing time of countNull : " + totalTime / 1000000);
    }

    // Run with 30000 files
    // Create new task for run multithreads
    public static int countNullBigFolder(String dir, Integer maxT) {
        /*
        Sumary: Count null value of json data from json file
        @param dir: directory to list of json files
        @param maxT: max number of threads
         */

        // Get list files in dir
        File directoryPath = new File(dir);
        String paths[] = directoryPath.list();
        ArrayList<String> _pathList = new ArrayList<>();

        // Check number of threads
        if (maxT < 1 || maxT > 12) {
            return -1;
        }

        // Initial task with hashset
        ExecutorService pool = Executors.newFixedThreadPool(maxT);

        for (String path : paths) {
            Runnable task = new Task(dir + path);
            pool.execute(task);
            Com.countNullWithSinggleFile(GetJsonData.getJsonData(dir.concat(path)));
        }

        return 0;
    }
}
