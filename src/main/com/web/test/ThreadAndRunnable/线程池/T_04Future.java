package com.web.test.ThreadAndRunnable.线程池;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
class T_04Future {

        public static void main(String [] args) throws ExecutionException, InterruptedException {

            FutureTask<Integer> task=new FutureTask<Integer>(()->{

                TimeUnit.MILLISECONDS.sleep(1000);

                return 1000;
            });

            new Thread(task).start();

            System.out.println(task.get());

            ExecutorService service= Executors.newFixedThreadPool(5);

            Future<Integer> future=service.submit(()->{

                TimeUnit.MILLISECONDS.sleep(500);

                return 1;
            });




        }





}
