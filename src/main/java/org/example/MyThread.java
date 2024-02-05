package org.example;

public class MyThread extends Thread{//extending thraed class
    int [] values = {6,5,1,7,8};

    public void run(){
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
