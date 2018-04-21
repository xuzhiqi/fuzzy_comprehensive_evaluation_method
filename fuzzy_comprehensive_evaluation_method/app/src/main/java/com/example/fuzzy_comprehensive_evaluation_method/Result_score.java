package com.example.fuzzy_comprehensive_evaluation_method;

import java.util.Arrays;

/**
 * Created by dell on 2018-03-06.
 */

public class Result_score {
    //R的行数，应该与Factor_set的factor_number一样
    //mark一下，在代码中还没有体现
    private int row;

    //R的列数，应该与Comment_set的level_number一样
    //mark一下，在代码中还没有体现
    private int column;

    public double[][] R;

    //mkind = 1:要求传入的二维数组r行数为row,列数为column
    //mkind = 2:要求传入的二维数组r行数为factor_number(=row),列数为5(!=column)
    //          并且每一行传入顺序为double xlimit,double x1,double x2,double x,int level_number
    //mark一下，在代码中还没有体现
    //mkind：1代表专家评测法，2代表隶属度函数法
    public Result_score(int row,int column,double[][] r,int mkind)
    {
        double sum = (double)row*column;
        this.row = row;
        this.column = column;
        this.R = new double[row][column];

        if(mkind == 1)
        {
            setR1(r);
        }

        else if(mkind == 2)
        {
            setR2(r);
        }
		/*
		for(int i = 0;i < row;i++)
		{
			for(int j = 0;j < column;j++)
			{
				this.R[i][j] = r[i][j]/sum;
			}
		}
		*/

    }

    //mkind = 1,专家评测法建立R
    //要求传入的二维数组r行数为row,列数为column
    public void setR1(double[][] r)
    {
        int i =0,j=0;
        double sum=0.0;
        for(j = 0;j < this.column;j++)
        {
            sum = sum+r[0][j];
        }
        j = 0;
        for(i = 0;i< this.row;i++)
            for(j = 0;j < this.column;j++)
            {
                this.R[i][j] = r[i][j]/sum;
            }

    }


    //mkind = 2，隶属度函数法建立R
    //要求传入的二维数组r行数为factor_number(=row),列数为4(!=column)
    //并且每一行传入顺序为double xlimit,double x1,double x2,double x,int level_number
    public void setR2(double[][] r)
    {
        int i = 0 ,j = 0,level_number = this.column;
        double xlimit = 0.0,x1 = 0.0,x2 = 0.0,x = 0.0;
        //System.out.println("the r[][] are: ");
        //System.out.println(Arrays.deepToString(r));
        for(i = 0 ;i < this.row;i++)
        {
            xlimit = r[i][0];
            x1 = r[i][1];
            x2 = r[i][2];
            x = r[i][3];
            //System.out.println(xlimit+"  "+x1+"  "+x2+"  "+x+"  ");
            Membership_fuction_model M = new Membership_fuction_model(xlimit, x1, x2, x, level_number);
            System.out.println("the Ms are: ");
            System.out.println(Arrays.toString(M.R_row));
            for(j = 0;j < this.column;j++)
            {
                this.R[i][j] = M.getRrowelement(j);
            }
        }
    }


    public Result_score()
    {
    }


    public int getrow()
    {
        return this.row;
    }

    public int getcolumn()
    {
        return this.column;
    }

    public double getRelement(int i,int j)
    {
        return this.R[i][j];
    }
}
