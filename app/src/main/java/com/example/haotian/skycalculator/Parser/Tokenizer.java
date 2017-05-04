package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zhen
 * Referencing:Idea & code from Eric McCreath
 */
public abstract class Tokenizer {


    abstract boolean hasNext();

    abstract Object current();

    abstract void next();

    public void parse(Object o) throws ParseException {
        if (current() == null || !current().equals(o))
            throw new ParseException();
        next();
    }
}
