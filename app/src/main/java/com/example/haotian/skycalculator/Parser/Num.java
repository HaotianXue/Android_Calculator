package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zheng
 */
public class Num extends Expression {
    float value;

    public Num(float a){
        this.value = a;
    }
    @Override
    public String show() {
        return ""+value;
    }

    @Override
    public float evaluate() {
        return value;
    }
}
