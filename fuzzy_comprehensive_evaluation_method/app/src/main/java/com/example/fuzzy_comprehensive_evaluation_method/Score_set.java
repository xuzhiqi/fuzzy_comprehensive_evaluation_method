package com.example.fuzzy_comprehensive_evaluation_method;

/**
 * Created by dell on 2018-03-06.
 */

public class Score_set {
    //level_number应该和Comment_set的 level_number一样
    //mark一下，还没在代码中体现
    private int level_number;

    //最大的分数为100
    //private int max_score = 100;

    //
    public int[] N;

    public Score_set(int level_number)
    {
        int step = 0;
        this.level_number = level_number;
        this.N = new int[level_number];
        for(int i = 0;i < level_number;i++)
        {
            this.N[i] = step;
            step = (i+1)*(100/level_number);
        }

    }

    public int getlevelnumber()
    {
        return this.level_number;
    }

    public int getscore(int level)
    {
        return this.N[level];
    }
}
