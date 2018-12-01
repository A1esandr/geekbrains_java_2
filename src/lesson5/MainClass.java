package lesson5;

import java.util.Arrays;

public class MainClass {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args){
        MainClass mainClass = new MainClass();
        mainClass.methodOne();
        mainClass.methodTwo();
    }

    private void methodOne(){
        System.out.println("Старт метода 1");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Завершение метода 1. Время выполнения %s", String.valueOf(end - start)));
    }

    private void methodTwo(){
        System.out.println("Старт метода 2");
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long split = System.currentTimeMillis();
        System.out.println(String.format("Время выполнния разделения массива %s", String.valueOf(split - start)));

        Thread thread1 = new Thread(() ->this.methodTwoInternal(arr1, 1));
        Thread thread2 = new Thread(() ->this.methodTwoInternal(arr2, 2));

        thread1.start();
        thread2.start();

        while(thread1.getState().equals(Thread.State.RUNNABLE) || thread2.getState().equals(Thread.State.RUNNABLE)){}

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Время выполнния склейки массива %s", String.valueOf(end - connect)));
        System.out.println("Завершение метода 2");
    }

    private void methodTwoInternal(float[] arr, int number){
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Время выполнния потока %d равно %s", number, String.valueOf(end - start)));
    }
}
