package Threads.Example;

public class  Main{

    public static void Thread() {
//        Runnable printer = new Runnable() {
//            @Override
//            public void run() {
//                for(int k = 0; k < 10; k++) {
//                    try {
//                        Threads.sleep(200);
//                        if(k % 2 == 0)
//                        System.out.println(k);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        };
//        Runnable printer2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int k = 0; k <10; k++){
//                    try {
//                        Threads.sleep(10);
//                        if(k % 2 != 0)
//                            System.out.println(k);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        Threads thread1 = new Threads(printer);
//        thread1.start();
//        Threads thread2 = new Threads(printer2);
//        thread2.start();
        Integer counter=0;
        PrintRunnable p1=new PrintRunnable(counter,3);
        Thread t1= new Thread(p1);
        Thread t2 = new Thread(p1);
        t1.start();
        t2.start();
    }
    public static void main(String args[]) {
       Thread();

    }

}
