package com.example.fuzzy_comprehensive_evaluation_method;

/**
 * Created by dell on 2018-03-06.
 */

public class Weight_set {
    //weight_number应该和Factor_set中的factro_number一样
    //mark一下在代码中没有体现
    private int weight_number;

    public double[] W;

    public Weight_set(int weight_number)
    {
        int i = 0;
        double w = 1.0/weight_number;
        this.weight_number = weight_number;
        this.W = new double[weight_number];
        for(i = 0;i < weight_number;i++)
        {
            this.W[i] = w;
        }
    }

    public int getweightnumber()
    {
        return this.weight_number;
    }

    public double getweight(int i)
    {
        return this.W[i];
    }
}
