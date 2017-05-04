package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zheng
 */
public class Multiplication extends Expression {
    Expression a;
    Expression b;

    public Multiplication(Expression a,Expression b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String show() {
        if(a instanceof Num && b instanceof Num){
            return "(* "+a.show()+" "+b.show()+" ) evaluates to "+evaluate();
        }
        else return "";
    }

    @Override
    public float evaluate() {
        return a.evaluate()*b.evaluate();
    }
}

