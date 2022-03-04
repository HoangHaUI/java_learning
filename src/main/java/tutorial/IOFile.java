package tutorial;

import java.io.*;
import java.util.HashSet;

public class IOFile {
    public static HashSet readFile(File file) throws IOException {

        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        HashSet<String> setString = new HashSet<>();
        String line;

        while ((line = br.readLine()) != null) {
            setString.add(line);
        }

        return setString;
    }
}
