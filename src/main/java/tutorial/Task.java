package tutorial;

import computor.Compute;
import fileio.GetJsonData;

public class Task implements Runnable {

    private String msg;
    public GetJsonData getJsonData;
    private Compute compute;

    public Task(String msg) {
        this.msg = msg;
        this.getJsonData = new GetJsonData();
        this.compute = new Compute();
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        System.out.println(this.msg);
        compute.countNullWithSinggleFile(this.getJsonData.getJsonData(this.msg));
        System.out.println("Processing time of task " + this.msg + " : " + String.valueOf((System.nanoTime() - startTime)/1000000));
    }
}
