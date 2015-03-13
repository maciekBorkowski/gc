package pl.mborkowski.gc;

public class Runner {
    public static void main(String[] args) {
    	int threadsCount = 4;
        Runnable[] runners = new Runnable[threadsCount];
        Thread[] threads = new Thread[threadsCount];
        long startTime = System.nanoTime();
        
        for(int i = 0; i < threadsCount; i++) {
            runners[i] = new MyRun();
            threads[i] = new Thread(runners[i]);
            threads[i].start();
        }
        int j = 0;
        boolean finished = false;
		while(j <= threadsCount && !finished ) {
//        	runners[j].run
        	j++;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
//        runners = new Runnable[1];
//        threads = new Thread[1];
//        
//        runners[0] = new MyRun(0);
//        threads[0] = new Thread(runners[0]);
//        startTime = System.nanoTime();
//        threads[0].start();
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println(estimatedTime);
    }
}