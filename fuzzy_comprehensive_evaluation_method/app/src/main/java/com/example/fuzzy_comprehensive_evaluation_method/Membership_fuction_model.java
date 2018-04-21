package com.example.fuzzy_comprehensive_evaluation_method;

/**
 * Created by dell on 2018-03-13.
 */

public class Membership_fuction_model {
    private double xlimit,x1,x2,k,c,x;
    private int level_number;
    public double[] R_row;

    //建议的值如下：
    //x1 = 0,x2 = 0.1,xlimit = 0.7(0.5)
    public Membership_fuction_model(double xlimit,double x1,double x2,double x,int level_number)
    {
        int i = 0;
        this.xlimit = xlimit;
        this.x1 = x1;
        this.x2 = x2;
        this.x = x;
        this.level_number = level_number;
        this.k = xlimit/(level_number-1);
        this.c = xlimit/(2*(level_number-1));
        //System.out.println(this.xlimit+"  "+this.x1+"  "+this.x2+"  "+this.x+"  "+this.level_number+"  "+this.k+"  "+this.c);
        this.R_row = new double[level_number];
        for(i = 0;i < level_number;i++)
        {
            if(i == 0)
            {
                this.R_row[i] = partfirst(x);
            }

            else if(i >= 1 && i <= (level_number-2))
            {
                this.R_row[i] = partn(i, x);
            }
            else if(i == (level_number-1))
            {
                this.R_row[i] = partfinal(x);
            }
        }
    }

    //隶属度函数第一个部分
    public double partfirst(double x)
    {
        double u = 0.0;
        double t = (Math.PI/(x2-x1))*(x-((x1+x2)/2.0));

        if(x >= 0 && x <= (x1+c))
        {
            System.out.println("partfirst:1st part");
            u = 1.0;
        }
        if(x > (x1+c) && x < (x2+c))
        {
            System.out.println("partfirst:2st part");
            u = 0.5-(0.5*Math.sin(t));
        }
        if (x >= x2+c)
        {
            System.out.println("partfirst:3st part");
            u = 0.0;
        }
        return u;
    }

    //隶属度函数中间即最后的部分
    //n代表第n个部分的隶属度函数
    //中间的n：(1,level_number-2)
    public double partn(int n,double x)
    {
        double u = 0.0;
        double t = (Math.PI/(x2-x1))*(x-((x1+x2)/2));
        if(x <= (-x2+(n*k+c)) || x >= (x2+(n*k+c)))
        {
            u = 0.0;
        }
        else if (x > (-x2+(n*k+c)) && x < (-x1+(n*k+c)))
        {
            u = 0.5+(0.5*Math.sin(t));
        }
        else if (x >= (-x1+(n*k+c)) && x <= (x1+(n*k+c)))
        {
            u = 1.0;
        }
        else if (x >= (x1+(n*k+c)) && x <= (x2+(n*k+c)))
        {
            u = 0.5-(0.5*Math.sin(t));
        }
        return u;
    }

    //隶属度函数最后的部分
    //n = level_number-1;
    public double partfinal(double x)
    {
        double u = 0.0;
        double t = (Math.PI/(x2-x1))*(x-((x1+x2)/2));
        int n = level_number - 1;
        if(x >= (-x1+(n*k+c)))
        {
            u = 1.0;
        }
        else if (x > (-x2+(n*k+c)) && x < (-x1+(n*k+c)))
        {
            u = 0.5+(0.5*Math.sin(t));
        }
        else if (x <= (-x2+(n*k+c)))
        {
            u = 0.0;
        }
        return u;
    }

    public double[] getRrow()
    {
        return this.R_row;
    }

    public double getRrowelement(int i)
    {
        return this.R_row[i];
    }
}
