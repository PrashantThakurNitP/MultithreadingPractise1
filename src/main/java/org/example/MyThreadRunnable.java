package org.example;

public class MyThreadRunnable implements Runnable{
    int [] values = {6,5,1,7,8};

    @Override
    public void run() {

            for(int i=0;i<5;i++){
                values[i]=values[i]*2;
                System.out.println(i);
                if(i==1) {
                    try {
                        Thread.sleep(2000);//static method to sleep
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
}
