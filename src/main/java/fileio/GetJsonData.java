package fileio;

import org.json.JSONObject;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;


public class GetJsonData implements DataReader {

    public HashSet readFile(File file) throws IOException {

        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        HashSet<String> setString = new HashSet<>();
        String line;

        while ((line = br.readLine()) != null) {
            setString.add(line);
        }

        return setString;
    }
    public HashSet<JSONObject> getJsonData(String path) {
        /*
        Convert from json file to JSON Object
        @param path: path to json file
         */
        File file = new File(path);
        HashSet<JSONObject> jsonDatas = new HashSet<>();
        HashSet<String> content = null;
        try {
            content = readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<String> i = content.iterator();
        while (i.hasNext()) {
            String line = i.next();
            JSONObject jsonData = new JSONObject(line);
            jsonDatas.add(jsonData);
        }
        return jsonDatas;
    }

}
