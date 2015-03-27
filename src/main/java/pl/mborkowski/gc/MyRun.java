package pl.mborkowski.gc;

public class MyRun implements Runnable {
	 
    public static int n = 100;
    public boolean finished = false;
    private String type;
    private int index;
    public int counter = 0;

    MyRun(String type, int index) {
        this.type = type;
        this.index = index;
    }
 
    public void run() {
        if(type.equals("time")) {
            for(int i = n; i >= 0; i--) {
                MemoryEater.alloc(10);
            }
            Runner.finished.add(true);
        } else if(type.equals("count")) {
            while(true) {
                MemoryEater.alloc(10);
                Runner.counters[this.index]++;
            }
        }
        
    }
}
