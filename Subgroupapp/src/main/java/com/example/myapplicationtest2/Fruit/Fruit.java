package com.example.myapplicationtest2.Fruit;

/**
 * Created by 洋 on 2019/7/9.
 */

public class Fruit  {
    String fruitName;
    int fruitImgID;

    public Fruit(String name,int ImgID){
        this.fruitName = name;
        this.fruitImgID = ImgID;
    }

    public String getFruitName(){
        return fruitName;
    }

    public int getFruitImgID(){
        return fruitImgID;
    }
}
