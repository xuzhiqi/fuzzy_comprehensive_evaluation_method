package com.example.fuzzy_comprehensive_evaluation_method;

/**
 * Created by dell on 2018-03-06.
 */

public class Membership_degree_vector {
    //应该和Comment_set的level_number一样
    //mark一下，代码中还没有体现
    private int membership_number;
    //w应该和Factor_set中的factro_number一样
    //mark一下在代码中没有体现
    private int w_number;

    //算子种类
    //算子（> - <）公式：
    //s[j] = (w[1]<r[1][j])>(w[2]<r[2][j])...>(w[n]<r[n][j])
    private int kind;

    public double[] S;

    //Weight_set W = new Weight_set(w_number);
    //Result_score R = new Result_score();

    //构造函数
    //注意，初始化过程中不包括归一化，其他函数调用时需要归一化
    public Membership_degree_vector(Weight_set weight,Result_score result,int kind)
    {
        this.membership_number = result.getcolumn();
        this.w_number = weight.getweightnumber();
        this.S = new double[result.getcolumn()];
        this.kind = kind;
        int wr = 1;
        int wc = weight.getweightnumber();
        int rr = result.getrow();
        int rc = result.getcolumn();

        if(kind == 1 )
        {
            this.S = operator1(weight, result);
        }
        else if(kind == 2)
        {
            this.S = operator2(weight, result);
        }
        else if(kind == 3)
        {
            this.S = operator3(weight, result);
        }
        else if(kind == 4)
        {
            this.S = operator4(weight, result);
        }

        /**
         for(int i = 0 ; i < wr ; i++)
         {
         for(int j = 0 ; j < rc ; j++)
         {
         double sum = 0.0;
         for(int k = 0 ; k < rr; k++)
         {
         sum = sum + weight.getweight(k)*result.getRelement(k, j);
         }
         this.S[j] = sum;
         }

         }
         **/

    }
    //归一化
    public double[] normalization(double S[],int length)
    {
        double sum = 0.0;
        double[] N = new double[length];
        int i = 0;
        for(i = 0 ; i < length; i++)
        {
            sum = sum+S[i];
        }
        i = 0;
        for(i = 0 ; i < length; i++)
        {
            N[i] = S[i]/sum;
        }
        return N;

    }


    //算子1(取大-取小)
    public double[] operator1(Weight_set weight,Result_score result)
    {
        int wr = 1;
        int wc = weight.getweightnumber();
        int rr = result.getrow();
        int rc = result.getcolumn();
        int i = 0,j = 0;
        double[] temp = new double[wc];
        double[] S = new double[result.getcolumn()];
        for(j = 0;j < rc;j++)
        {
            double tempj = 0.0;
            for(i = 0;i < wc;i++)
            {
                if(weight.getweight(i)<result.getRelement(i, j))
                    temp[i] = weight.getweight(i);
                else {
                    temp[i] = result.getRelement(i, j);
                }
            }
            i = 0;
            tempj = temp[i];
            for(i = 0;i < wc;i++)
            {
                if(tempj<temp[i])
                {
                    tempj = temp[i];
                }
                else {
                    tempj = tempj;
                }
            }
            S[j] = tempj;
        }
        return S;
    }


    //算子2（取大-乘）
    public double[] operator2(Weight_set weight,Result_score result)
    {
        int wr = 1;
        int wc = weight.getweightnumber();
        int rr = result.getrow();
        int rc = result.getcolumn();
        int i = 0,j = 0;
        double[] temp = new double[wc];
        double[] S = new double[result.getcolumn()];
        for(j = 0;j < rc;j++)
        {
            double tempj = 0.0;
            for(i = 0;i < wc;i++)
            {
                temp[i] = weight.getweight(i)*result.getRelement(i, j);
            }
            i = 0;
            tempj = temp[i];
            for(i = 0;i < wc;i++)
            {
                if(tempj<temp[i])
                    tempj = temp[i];
                else
                    tempj = tempj;
            }
            S[j] = tempj;
        }
        return S;
    }


    //算子3（加-取小）
    public double[] operator3(Weight_set weight,Result_score result)
    {
        int wr = 1;
        int wc = weight.getweightnumber();
        int rr = result.getrow();
        int rc = result.getcolumn();
        int i = 0,j = 0;
        double[] temp = new double[wc];
        double[] S = new double[result.getcolumn()];
        for(j = 0;j < rc;j++)
        {
            double tempj = 0.0;
            for(i = 0;i < wc;i++)
            {
                if(weight.getweight(i)<result.getRelement(i, j))
                    temp[i] = weight.getweight(i);
                else
                    temp[i] = result.getRelement(i, j);
            }
            i = 0;
            for(i = 0;i < wc;i++)
            {
                tempj = tempj+temp[i];
            }
            S[j] = tempj;
        }
        return S;
    }

    //算子4（加-乘）
    public double[] operator4(Weight_set weight,Result_score result)
    {
        int wr = 1;
        int wc = weight.getweightnumber();
        int rr = result.getrow();
        int rc = result.getcolumn();
        int i = 0,j = 0;
        double[] temp = new double[wc];
        double[] S = new double[result.getcolumn()];
        for(j = 0;j < rc;j++)
        {
            double tempj = 0.0;
            for(i = 0;i < wc;i++)
            {
                temp[i] = weight.getweight(i)*result.getRelement(i, j);
            }
            i = 0;
            for(i = 0;i < wc;i++)
            {
                tempj = tempj+temp[i];
            }
            S[j] = tempj;
        }
        return S;
    }

    //返回membership_number
    //即S中元素个数
    //即评语集的级别个数（level_number）
    public int getmembershipnumber()
    {
        return this.membership_number;
    }
}
