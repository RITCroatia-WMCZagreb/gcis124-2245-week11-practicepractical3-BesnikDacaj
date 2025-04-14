public class FunWithThreads3 {


    private int counter;
    private Object lock;


    //Constructor of FunWithThreads
    public FunWithThreads3(){
        System.out.println("MAIN START");
        counter=0;
        this.lock = new Object();

        //Creating threads
        Thread t1 = new Thread(new MyThread("1"));
        Thread t2 = new Thread(new MyThread("2"));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("COUNTER:" + this.counter);
       

        
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    //Inner Thread
    class MyThread implements Runnable{

        private String name="";

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println("Thread " + this.name + " starts looping 40000");
            for(int i=0;i<40000;i++){
               synchronized(lock){
                 counter++;//counter = counter + 1;//RACE CONDITION
               }
            }
            System.out.println("Thread " + this.name + " ends");

          
        }

    }

}

