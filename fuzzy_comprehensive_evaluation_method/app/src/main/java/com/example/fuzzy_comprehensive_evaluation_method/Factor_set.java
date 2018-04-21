package com.example.fuzzy_comprehensive_evaluation_method;

import java.util.Vector;

/**
 * Created by dell on 2018-03-06.
 */

public class Factor_set {
    private int factor_number;

    public Vector<String> U ;
    //= new Vector<String>();

    public Factor_set(int factor_number)
    {
        this.factor_number = factor_number;
        this.U = new Vector<String>(factor_number);
        for(int i = 0;i < factor_number;i++)
        {
            String number = Integer.toString(i);
            String factor = "u"+number;
            U.add(i, factor);
        }
    }

    public int getfactornumber()
    {
        return this.factor_number;
    }

    public String getfactor(int i)
    {
        return this.U.get(i);
    }
}
