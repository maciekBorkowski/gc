package pl.mborkowski.gc;

public class MyRun implements Runnable {
	 
    public static int n = 100;
    public boolean finished = false;
 
    public void run() {
        for(int i = n; i >= 0; i--) {
            MemoryEater.alloc(1);
        }
        this.finished = true;
    }
}
