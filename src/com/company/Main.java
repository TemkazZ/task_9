package com.company;

//class JThread extends Thread {
//
//    JThread(String name){
//        super(name);
//    }
//
//    public void run(){
//
//        System.out.printf("%s started... \n", Thread.currentThread().getName());
//        try{
//            Thread.sleep(500);
//        }
//        catch(InterruptedException e){
//            System.out.println("Thread has been interrupted");
//        }
//        System.out.printf("%s finished... \n", Thread.currentThread().getName());
//    }
//}
//
//public class Main {

//    public static void main(String[] args) {
//
//        System.out.println("Main thread started...");
//        new JThread("JThread").start();
//        System.out.println("Main thread finished...");
//    }
//}


//    public static void main(String[] args) {
//
//        System.out.println("Main thread started...");
//        for (int i = 1; i < 6; i++)
//            new JThread("JThread " + i).start();
//        System.out.println("Main thread finished...");
//    }

//    public static void main(String[] args) {
//
//        System.out.println("Main thread started...");
//        JThread t = new JThread("JThread ");
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//
//            System.out.printf("%s has been interrupted", t.getName());
//        }
//        System.out.println("Main thread finished...");
//    }


//    interface Runnable{
//
//        void run();
//
//    }
//
//     class MyThread implements Runnable {
//
//
//
//        public void run(){
//
//            System.out.printf("%s started... \n", Thread.currentThread().getName());
//            try{
//                Thread.sleep(500);
//            }
//            catch(InterruptedException e){
//                System.out.println("Thread has been interrupted");
//            }
//            System.out.printf("%s finished... \n", Thread.currentThread().getName());
//        }
//    }
//
//    public class Main {
//
//        public static void main(String[] args) {
//
//            System.out.println("Main thread started...");
//            Thread myThread = new Thread( new MyThread(),"MyThread");
//            myThread.start();
//            System.out.println("Main thread finished...");
//        }
//    }
//}

//class JThread extends Thread {
//
//    JThread(String name){
//        super(name);
//    }
//    public void run(){
//
//        System.out.printf("%s started... \n", Thread.currentThread().getName());
//        int counter=1; // счетчик циклов
//        while(!isInterrupted()){
//
//            System.out.println("Loop " + counter++);
//        }
//        System.out.printf("%s finished... \n", Thread.currentThread().getName());
//    }
//}
//public class Main {
//
//    public static void main(String[] args) {
//
//        System.out.println("Main thread started...");
//        JThread t = new JThread("JThread");
//        t.start();
//        try{
//            Thread.sleep(150);
//            t.interrupt();
//
//            Thread.sleep(150);
//        }
//        catch(InterruptedException e){
//            System.out.println("Thread has been interrupted");
//        }
//        System.out.println("Main thread finished...");
//    }
//}

//public class Main {
//
//    public static void main(String[] args) {
//
//        CommonResource commonResource= new CommonResource();
//        for (int i = 1; i < 6; i++){
//
//            Thread t = new Thread(new CountThread(commonResource));
//            t.setName("Thread "+ i);
//            t.start();
//        }
//    }
//}
//
//class CommonResource{
//
//    int x=0;
//}
//
//class CountThread implements Runnable{
//
//    CommonResource res;
//    CountThread(CommonResource res){
//        this.res=res;
//    }
//    public void run(){
//        res.x=1;
//        for (int i = 1; i < 5; i++){
//            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
//            res.x++;
//            try{
//                Thread.sleep(100);
//            }
//            catch(InterruptedException e){}
//        }
//    }
//}

//class CountThread implements Runnable{
//
//    CommonResource res;
//    CountThread(CommonResource res){
//        this.res=res;
//    }
//    public void run(){
//        synchronized(res){
//            res.x=1;
//            for (int i = 1; i < 5; i++){
//                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
//                res.x++;
//                try{
//                    Thread.sleep(100);
//                }
//                catch(InterruptedException e){}
//            }
//        }
//    }
//}

//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Store store=new Store();
//        Producer producer = new Producer(store);
//        Consumer consumer = new Consumer(store);
//        new Thread(producer).start();
//        new Thread(consumer).start();
//    }
//}
//// Класс Магазин, хранящий произведенные товары
//class Store{
//    private int product=0;
//    public synchronized void get() {
//        while (product<1) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {
//            }
//        }
//        product--;
//        System.out.println("Покупатель купил 1 товар");
//        System.out.println("Товаров на складе: " + product);
//        notify();
//    }
//    public synchronized void put() {
//        while (product>=3) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {
//            }
//        }
//        product++;
//        System.out.println("Производитель добавил 1 товар");
//        System.out.println("Товаров на складе: " + product);
//        notify();
//    }
//}
//// класс Производитель
//class Producer implements Runnable{
//
//    Store store;
//    Producer(Store store){
//        this.store=store;
//    }
//    public void run(){
//        for (int i = 1; i < 6; i++) {
//            store.put();
//        }
//    }
//}
//// Класс Потребитель
//class Consumer implements Runnable{
//
//    Store store;
//    Consumer(Store store){
//        this.store=store;
//    }
//    public void run(){
//        for (int i = 1; i < 6; i++) {
//            store.get();
//        }
//    }
//}

//import java.util.concurrent.Semaphore;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Semaphore sem = new Semaphore(1); // 1 разрешение
//        CommonResource res = new CommonResource();
//        new Thread(new CountThread(res, sem, "CountThread 1")).start();
//        new Thread(new CountThread(res, sem, "CountThread 2")).start();
//        new Thread(new CountThread(res, sem, "CountThread 3")).start();
//    }
//}
//class CommonResource{
//
//    int x=0;
//}
//
//class CountThread implements Runnable{
//
//    CommonResource res;
//    Semaphore sem;
//    String name;
//    CountThread(CommonResource res, Semaphore sem, String name){
//        this.res=res;
//        this.sem=sem;
//        this.name=name;
//    }
//
//    public void run(){
//
//        try{
//            System.out.println(name + " ожидает разрешение");
//            sem.acquire();
//            res.x=1;
//            for (int i = 1; i < 5; i++){
//                System.out.println(this.name + ": " + res.x);
//                res.x++;
//                Thread.sleep(100);
//            }
//        }
//        catch(InterruptedException e){System.out.println(e.getMessage());}
//        System.out.println(name + " освобождает разрешение");
//        sem.release();
//    }
//}

//import java.util.concurrent.Semaphore;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Semaphore sem = new Semaphore(2);
//        for(int i=1;i<6;i++)
//            new Philosopher(sem,i).start();
//    }
//}
//// класс философа
//class Philosopher extends Thread
//{
//    Semaphore sem; // семафор. ограничивающий число философов
//    // кол-во приемов пищи
//    int num = 0;
//    // условный номер философа
//    int id;
//    // в качестве параметров конструктора передаем идентификатор философа и семафор
//    Philosopher(Semaphore sem, int id)
//    {
//        this.sem=sem;
//        this.id=id;
//    }
//
//    public void run()
//    {
//        try
//        {
//            while(num<3)// пока количество приемов пищи не достигнет 3
//            {
//                //Запрашиваем у семафора разрешение на выполнение
//                sem.acquire();
//                System.out.println ("Философ " + id+" садится за стол");
//                // философ ест
//                sleep(500);
//                num++;
//
//                System.out.println ("Философ " + id+" выходит из-за стола");
//                sem.release();
//
//                // философ гуляет
//                sleep(500);
//            }
//        }
//        catch(InterruptedException e)
//        {
//            System.out.println ("у философа " + id + " проблемы со здоровьем");
//        }
//    }
//}

import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}

class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }
//    public void run(){
//
//        System.out.println(name + " выполняет фазу " + phaser.getPhase());
//        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
//
//        System.out.println(name + " выполняет фазу " + phaser.getPhase());
//        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
//
//        System.out.println(name + " выполняет фазу " + phaser.getPhase());
//        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
//    }
public void run(){

    System.out.println(name + " выполняет фазу " + phaser.getPhase());
    phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
    try{
        Thread.sleep(200);
    }
    catch(InterruptedException ex){
        System.out.println(ex.getMessage());
    }

    System.out.println(name + " выполняет фазу " + phaser.getPhase());
    phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
    try{
        Thread.sleep(200);
    }
    catch(InterruptedException ex){
        System.out.println(ex.getMessage());
    }
    System.out.println(name + " выполняет фазу " + phaser.getPhase());
    phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
}
}

