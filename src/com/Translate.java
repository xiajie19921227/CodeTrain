package com;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Translate {

    public String translate(String content) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

      //  String result1 = executorService.submit();

        return "";
    }

    public String baidu(String content) {
        randomSleep();
        return "result";
    }

    public String google(String content) {
        randomSleep();
        return "result";
    }

    public String youdao(String content) {
        randomSleep();
        return "result";
    }

    private void randomSleep() {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     class ThreadBaidu implements Runnable {

        @Override
        public void run() {

            //baidu();
        }
    }

}
