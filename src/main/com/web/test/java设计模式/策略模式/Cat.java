package com.web.test.java设计模式.策略模式;
import com.web.test.java设计模式.策略模式.compareor;
/**
 * Created by Administrator on 2019/4/28 0028.
 */
public class Cat implements compareble{

    private int height;

    private int weight;

    private compareor compareor=new sortHeight();

    public compareor getCompareor() {
        return compareor;
    }

    public void setCompareor(compareor compareor) {
        this.compareor = compareor;
    }



    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return compareor.compar(this,o);
    }
}
