package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zhen
 */
public class Addition extends Expression {
    //    Expression exp;
    Expression a;
    Expression b;

    public Addition(Expression a, Expression b) {
        this.a = a;
        this.b = b;

    }

    @Override
    public String show() {
        return "( " + a.show() + " + " + b.show() + " )";
    }

    @Override
    public float evaluate() {
        return a.evaluate() + b.evaluate();

    }
}
