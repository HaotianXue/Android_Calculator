package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zheng
 */
public class Subtraction extends Expression {
    Expression a;
    Expression b;

    public Subtraction(Expression a,Expression b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String show() {
        if (a instanceof Num && b instanceof Num) {
            return "(" + a.show() + " - " + b.show() + ") ";
        }
        else return "";
    }

    @Override
    public float evaluate() {
        return a.evaluate()-b.evaluate();
    }

    public static void main(String[] args) {
        Expression exp = new Subtraction(new Subtraction(new Num(2),new Num(0)),new Num(1));
        System.out.println(exp.evaluate());
        System.out.println(exp.show());
    }
}
