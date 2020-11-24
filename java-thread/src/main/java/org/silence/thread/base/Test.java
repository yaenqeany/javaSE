package org.silence.thread.base;

public class Test {
    public static void main(String[] args) {
        /*
        继承Thread类的多线程基本使用
            1、实例化自定义线程类
            2、调用start()方法启动线程
            注意：不能直接调用run()方法，否则只是普通的类方法的调用，不是多线程。
         */
        MyThread myThread = new MyThread();
        myThread.setName("我的thread线程");
        myThread.start();

        /*
        实现Runnable接口的多线程使用
            1、实例化自定义runnable类
            2、实例化Thread类，并将自定义runnable对象传入
            3、调用thread对象的start()方法
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread runThread = new Thread(myRunnable, "我的runnable线程");
        runThread.start();

        //主线程循环
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " ...> " + i);
        }
    }
}
