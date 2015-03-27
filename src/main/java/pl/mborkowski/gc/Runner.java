package pl.mborkowski.gc;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Runner {
    static ArrayList<Boolean> finished = new ArrayList<Boolean>();
    static int threadsCount = 1;    
    static int[] counters = new int[threadsCount];
    static Runnable[] runners = new Runnable[threadsCount];
    static Thread[] threads = new Thread[threadsCount];
    public static void main(final String[] args) throws InterruptedException {
    	
        
        if(args[0].equals("time")) {
            long startTime = System.nanoTime();
            for(int i = 0; i < threadsCount; i++) {
                runners[i] = new MyRun(args[0],i);
                threads[i] = new Thread(runners[i]);
                threads[i].start();
            }
            boolean finished = false;
            while(!finished) {
                for (Boolean finish : Runner.finished) {
                    if(Runner.finished.size() == 1){
                        finished = finish;
                    } else {
                        finished = finished & finish;    
                    }
                }
            }
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
        } else if(args[0].equals("count")) {
            for(int i = 0; i < threadsCount; i++) {
                runners[i] = new MyRun(args[0],i);
                threads[i] = new Thread(runners[i]);
                threads[i].start();
            }
            Thread.sleep(60000);
            int countAlloc = 0;
            for (int i = 0; i < counters.length; i++) {
                countAlloc += counters[i];
                threads[i].stop();
            }
            System.out.println(countAlloc);
        }

    }
}