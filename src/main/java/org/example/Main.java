package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!, %d",5);
        System.out.println();

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }

        Thread t1 = new MyThread();
       // t1.run(); run normally
        t1.start(); //automatically call run whn call start

        Runnable r2= new MyThreadRunnable();
       Thread t2 = new Thread(r2);
       t2.start();

       //using annonymous class we don't need to create class
        Runnable r3 = new Runnable() {
            //also Runnable is Functional Interface so we can use lambda here
            @Override
            public void run() {
                int [] values = {6,5,1,7,8};
                for(int i=0;i<5;i++){
                    values[i]=values[i]*2;
                    System.out.println(i);
                    System.out.println(values[i]);
                    if(i==1) {

                        try {
                            Thread.sleep(2000);//static method to sleep
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        Thread t3 = new Thread(r3);
        t3.start();
/*-----------------------------------------------------------*/
        //also Runnable is Functional Interface so we can use lambda here like below
        Runnable r4 = () -> {
            int [] values = {6,5,1,7,8};
            for(int i=0;i<5;i++){
                values[i]=values[i]*2;
                System.out.println(i);
                System.out.println(values[i]);
                if(i==1) {

                    try {
                        Thread.sleep(2000);//static method to sleep
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        t1.join(); //wait for t1 to complete
        t2.join(); //wait for t2 to complete
        System.out.println("T1 is alive or not "+t1.isAlive());


        Thread t4 = new Thread(r4);
        t4.start();

        // final cleanup

        Thread t5 = new Thread(()->{
            int [] values={3,5,6,7,8};
            for(int i=0;i<5;i++){
                values[i]=values[i]*2;
                System.out.println(i);
                System.out.println(values[i]);
                if(i==1) {

                    try {
                        Thread.sleep(3000);//static method to sleep
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t5.start();
        System.out.println("T5 is alive or not "+t5.isAlive());
        t4.join();
        t5.join();
        System.out.println("Closing program after all thread join");





    }
}