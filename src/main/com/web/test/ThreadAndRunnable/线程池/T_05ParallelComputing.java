package com.web.test.ThreadAndRunnable.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
public class T_05ParallelComputing {
//    线程池的作用一般是用来做并行计算的

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        //计算一个数的质数----只能被2和自身整除

//    使用普通方法
    Long start=System.currentTimeMillis();
    List<Integer> list=getparall(1,20000);
    Long end=System.currentTimeMillis();
        System.out.println("普通的时间"+(end-start));



//     使用线程池进行并行计算
        ExecutorService service= Executors.newFixedThreadPool(4);

        Mypool m1=new Mypool(1,8000);
        Mypool m2=new Mypool(8001,13000);
        Mypool m3=new Mypool(13001,17000);
        Mypool m4=new Mypool(17001,20000);

        Future<List<Integer>> f1=service.submit(m1);
        Future<List<Integer>> f2=service.submit(m2);
        Future<List<Integer>> f3=service.submit(m3);
        Future<List<Integer>> f4=service.submit(m4);

        start=System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end=System.currentTimeMillis();

        System.out.println("使用线程池的计算时间"+(end-start));
    }







    static class Mypool implements Callable<List<Integer>>{
        int start,end;

          Mypool(int s,int e){
            start=s;
            end=e;
        }
        @Override
        public List<Integer> call() throws Exception {
            return getparall(start,end);
        }
    }


    static public boolean isparall(int num){

        for(int i=2;i<=num/2;i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }


    static public List getparall(int start,int end){
        List list=new ArrayList();

        for(int i=start;i<end;i++){

            if(isparall(i)){
                list.add(i);
            }
        }
        return list;
    }


}
