package com.web.test.算法_二分查找;

/**
 * Created by Administrator on 2019/6/12 0012.
 */
public class binary {

    /**
     *
     * @param a 数组
     * @param n 数组的长度
     * @param value 给定的值
     * @return
     */
    public int search(int []a,int n,int value){
//        查出第一个大于给定值的元素

        int low=0;//数组第一个元素
        int end=n-1;//数组最后一个元素


        while (low <= end){

           int center=(end+low)/2;

           if(a[center]<value){
               low=center+1;
           }else if(a[center]==value){
               low=center+1;
           }else{
               if(center==0||a[center-1]<=value){
                   return center;
               }else {
                   end =center-1;
               }
           }


        }

        return -1;
    }


    /**
     *
     * @param a 数组
     * @param n 数组的长度
     * @param value 给定的值
     * @return
     */
    public int search2(int []a,int n,int value){
//        查出第一个大于给定值的元素

        int low=0;//数组第一个元素
        int end=n-1;//数组最后一个元素


        while (low<=end){

            int center=(end+low)/2;

            if(a[center]>value){
                end =center-1;
            }else if(a[center]==value){
                end =center-1;
            }else{
                if(center==0||a[center-1]>=value){
                    return center;
                }else {
                    low= center+1;
                }
            }
        }

        return -1;
    }






    public  static void main(String [] args){

        int []a={1,2,3,4,5,6,7,8,9,10};
//        int []a1={11,2,63,4,5,126,75,82,94,110};
        binary b=new binary();
        int n= b.search(a,a.length,9);
        System.out.println("第一个大于9的值："+a[n]);


        int n2=b.search2(a,a.length,5);
        System.out.println("第一个小于5的值："+a[n]);

    }


}
