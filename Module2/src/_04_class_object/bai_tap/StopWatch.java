package _04_class_object.bai_tap;

public class StopWatch {
    private long startTime, endTime;

    public StopWatch() {
        this.startTime=System.currentTimeMillis();
    }

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long start(){
        return this.startTime=System.currentTimeMillis();
    }

    public long stop(){
        return this.endTime=System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return this.endTime-this.startTime;
    }

    public static void main(String[] args) {
        StopWatch time=new StopWatch();
        time.start();
        System.out.println(time.start());
        int count=0;
        for (int i=0; i<100000; i++) {
            for (int j=0; j<100000; j++) {
                count++;
            }
        }
        time.stop();
        System.out.println(time.stop());
        System.out.println(time.getElapsedTime());
    }
}
