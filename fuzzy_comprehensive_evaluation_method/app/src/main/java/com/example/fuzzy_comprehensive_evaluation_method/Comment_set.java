package com.example.fuzzy_comprehensive_evaluation_method;

import java.util.Vector;

/**
 * Created by dell on 2018-03-06.
 */

public class Comment_set {
    private int level_number;

    //public String comment;

    public Vector<String> V ;
    //= new Vector<String>();


    public Comment_set(int level_number)
    {
        this.level_number = level_number;
        this.V = new Vector<String>(level_number);
        for(int i = 0;i < level_number;i++)
        {
            String number = Integer.toString(i);
            String comment = "v"+number;
            V.add(i, comment);
        }
    }

    public int getlevelnumber()
    {
        return level_number;
    }

    public String getcomment(int i)
    {
        String number = Integer.toString(i);
        return "v"+number;
    }
}
