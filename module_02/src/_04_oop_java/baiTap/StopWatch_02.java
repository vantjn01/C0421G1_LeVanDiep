package _04_oop_java.baiTap;

import java.text.SimpleDateFormat;
import java.util.Date;


    public class StopWatch_02 {
        private long startTime;
        private long endTime;
        public StopWatch_02(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        public StopWatch_02() {
        }
        public long getStartTime() {
            return startTime;
        }
        public long getEndTime() {
            return endTime;
        }
        public long startTime() {
            return System.currentTimeMillis();
        }
        public void start() {
            this.startTime = System.currentTimeMillis();
        }
        public void stop() {
            this.endTime = System.currentTimeMillis();
        }
        public long getElapsedTime() {
            long elapsed;
            elapsed = this.endTime - this.startTime;
            return elapsed;
        }
        public static void main(String[] args) {
            StopWatch_02 stopWatch = new StopWatch_02();
            stopWatch.start();
            stopWatch.stop();
            long result = stopWatch.getElapsedTime();
            System.out.println(result);
        }
    }