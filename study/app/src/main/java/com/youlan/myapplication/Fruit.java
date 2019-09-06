package com.youlan.myapplication;

/**
 * author : Hashub小晖
 * email  : hashubng@163.com
 * date   : 2019/8/31 16:05
 * desc   :
 */
public class Fruit
{
    private String name;
    private  int imageid;

    public Fruit(String name, int imageid)
    {
        this.name = name;
        this.imageid = imageid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getImageid()
    {
        return imageid;
    }

    public void setImageid(int imageid)
    {
        this.imageid = imageid;
    }

}
