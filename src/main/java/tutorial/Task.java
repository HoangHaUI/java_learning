package tutorial;

public class Task implements Runnable {

    private String msg;

    public Task(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println(this.msg);
        Com.countNullWithSinggleFile(GetJsonData.getJsonData(this.msg));
    }
}
