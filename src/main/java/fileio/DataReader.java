package fileio;

import org.json.JSONObject;

import java.io.*;
import java.util.HashSet;

public interface DataReader {
    public HashSet readFile(File file) throws IOException;
    public HashSet<JSONObject> getJsonData(String path);
}
