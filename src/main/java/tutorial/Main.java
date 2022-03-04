package tutorial;
import computor.Compute;
import fileio.GetJsonData;

public class Main {
    public static void main(String[] args) {
        String path = "D://WINDOWS//PractiseSpace//IT//java//learn_java_vtp//data//12-52-19.json";
        String dirToBigData = "D://WINDOWS//PractiseSpace//IT//java//learn_java_vtp//data//bigdata//";

        Compute compute = new Compute();
        GetJsonData getJsonData = new GetJsonData();

        // Test with single file
        compute.countNullWithSinggleFile(getJsonData.getJsonData(path));

        // Test with multiple files
        compute.countNullBigFolder(dirToBigData, 10);
    }


}

