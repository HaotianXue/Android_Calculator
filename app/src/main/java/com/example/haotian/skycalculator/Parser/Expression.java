package com.example.haotian.skycalculator.Parser;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue & SiYu Zheng
 * Referencing:Idea of expression by: Eric McCreath;
 */
public abstract class Expression {

    public abstract  float evaluate();
    public abstract  String show();

    public static Expression parse(Tokenizer tok) throws ParseException {
        Object t = tok.current();
        if (t instanceof Float) {
            float v = (Float) t;
//            tok.next();
            return new Num(v);
        }else if(t instanceof Integer){
            int v = (Integer) t;
            return new Num(v);
        }else if(t.equals("+")){
            tok.next();
            Expression exp1 = parse(tok);
            tok.next();
            Expression exp2 = parse(tok);
            return new Addition(exp1,exp2);
        }else if(t.equals("-")){
            tok.next();
            Expression exp1 = parse(tok);
            tok.next();
            Expression exp2 = parse(tok);
            return new Subtraction(exp1,exp2);
        }else if(t.equals("*")){
            tok.next();
            Expression exp1 = parse(tok);
            tok.next();
            Expression exp2 = parse(tok);
            return new Multiplication(exp1,exp2);
        }else if(t.equals("/")){
            tok.next();
            Expression exp1 = parse(tok);
            tok.next();
            Expression exp2 = parse(tok);
            return new Division(exp1,exp2);
        }
        else {
            throw new ParseException();
        }
    }
}


