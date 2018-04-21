package com.example.fuzzy_comprehensive_evaluation_method;

/**
 * Created by dell on 2018-03-06.
 */

public class First_order_fuzzy_decision {
    private Factor_set U;
    private Comment_set V;
    private Weight_set W;
    private Result_score R;
    private Score_set N;
    private Membership_degree_vector S;

    public First_order_fuzzy_decision(int factor_number,int level_number,double[][] r,int kind,int mkind)
    {
        this.U = new Factor_set(factor_number);
        this.V = new Comment_set(level_number);
        this.W = new Weight_set(factor_number);
        this.R = new Result_score(factor_number, level_number, r,mkind);
        this.N = new Score_set(level_number);
        this.S = new Membership_degree_vector(this.W, this.R, kind);//没有归一化
    }

    public double countscore()
    {
        int[] n = N.N;
        int level_number = N.getlevelnumber(),i = 0;
        double[] s = S.normalization(S.S, level_number);
        double F = 0.0;
        for(i = 0;i < level_number;i++)
        {
            F = F+(double)n[i]*s[i];
        }
        return F;
    }

    public void show_factor_set()
    {
        int i=0,factor_number = U.getfactornumber();
        for(i = 0 ; i < factor_number; i++)
        {
            System.out.print(U.getfactor(i));
            System.out.printf("%s", " ");
        }
        System.out.print("\n");

    }

    public void show_comment_set()
    {
        int i = 0,level_number = V.getlevelnumber();
        for(i = 0;i < level_number;i++)
        {
            System.out.print(V.getcomment(i));
            System.out.printf("%s", " ");
        }
        System.out.print("\n");
    }

    public void show_weight_set()
    {
        int i = 0,factor_number = W.getweightnumber();
        for(i = 0;i < factor_number;i++)
        {
            System.out.print(W.getweight(i));
            System.out.printf("%s", " ");
        }
        System.out.print("\n");
    }

    public void show_result_score()
    {
        int i = 0,j = 0,factor_number = R.getrow(),level_number = R.getcolumn();
        for(i = 0;i < factor_number;i++)
        {
            for(j = 0;j < level_number;j++)
            {
                System.out.print(R.getRelement(i, j));
                System.out.printf("%s", " ");

            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void show_score_set()
    {
        int i = 0,level_number = N.getlevelnumber();
        for(i = 0;i < level_number;i++)
        {
            System.out.print(N.getscore(i));
            System.out.printf("%s", " ");
        }
        System.out.print("\n");
    }

    public void show_membership_degree_vector()
    {
        int i = 0,level_number = S.getmembershipnumber();
        double[] n = S.normalization(this.S.S, level_number);
        for(i = 0;i < level_number;i++)
        {
            System.out.print(n[i]);
            System.out.printf("%s", " ");
        }
        System.out.print("\n");

    }
}
