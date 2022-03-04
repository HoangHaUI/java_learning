package tutorial;


public class Main {
    public static void main(String[] args) {
        String path = "D://WINDOWS//PractiseSpace//IT//java//learn_java_vtp//data//12-52-19.json";
        String dirToBigData = "D://WINDOWS//PractiseSpace//IT//java//learn_java_vtp//data//bigdata//";
        Com.countNullWithSinggleFile(GetJsonData.getJsonData(path));
        Com.countNullBigFolder(dirToBigData, 10);
    }


}

