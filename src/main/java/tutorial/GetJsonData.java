package tutorial;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;


public class GetJsonData {


    public static HashSet<JSONObject> getJsonData(String path) {
        /*
        Convert from json file to JSON Object
        @param path: path to json file
         */
        File file = new File(path);
        HashSet<JSONObject> jsonDatas = new HashSet<>();
        HashSet<String> content = null;
        try {
            content = IOFile.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<String> i = content.iterator();
        while (i.hasNext()) {
            String test = i.next();
            JSONObject jsonData = new JSONObject(test);
            jsonDatas.add(jsonData);
        }
        return jsonDatas;
    }

}
