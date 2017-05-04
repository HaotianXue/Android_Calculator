package com.example.haotian.skycalculator.Parser;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by xuehaotian on 15/05/2016.
 * Author:Haotian Xue(u5689296) & SiYu Zheng(u5538222)
 * Referencing:Idea of tokenzier by: Eric McCreath; Idea of midtoPre is from : http://www.aijava.cn/13197.html
 * Grammr:
 * <exp> ::= <number> | <binop> <exp> <exp>
 * <binop> ::= + | - | * | /
 */
public class MySimpleTokenizer extends Tokenizer {
    public String text;
    public int pos;
    public Object current;

    static final char whitespace[] = { ' ', '\n', '\t' };
    static final char symbol[] = { '(', ')', '=', ':', '?', ',', '*', '+','/','-' };
    static final char number[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};


    public MySimpleTokenizer(String text) {
//        this.text = insertSpace(midToPre(insertSpace(text)));
        this.text = (midToPre(insertSpace(text)));
        this.pos = 0;
        next();
    }

    boolean hasNext() {
        return current != null;
    }

    Object current() {
        return current;
    }
    

    public static String insertSpace(String str){
        String s = "";
        for(int i = 0;i < str.length();i ++){
            if(isin(str.charAt(i),symbol)){
                if ((str.charAt(i) == '-')){ //judge whether it is a unary operator
                    if (i>0&&!isin(str.charAt(i-1),number))
                        s+="0";
                    else if (i==0)
                        s+="0";
                }
                s+=" ";
                s+= str.charAt(i);
                s+= " ";
            } else {
                s+= str.charAt(i);
            }
        }
        return s;
    }

    public void next() {
        consumewhite();
        if (pos == text.length()) {
            current = null;

        } else if (isin(text.charAt(pos), symbol)) {
            current = "" + text.charAt(pos);
            pos++;

        } else if (Character.isDigit(text.charAt(pos))) {
            int start = pos;
            while (pos < text.length() && Character.isDigit(text.charAt(pos)) )
                pos++;
            if (pos+1 < text.length() && text.charAt(pos) == '.' &&
                    Character.isDigit(text.charAt(pos+1))) {
                pos++;
                while (pos < text.length() && Character.isDigit(text.charAt(pos)))
                    pos++;
                current = Float.parseFloat(text.substring(start, pos));
            } else {
                current = Float.parseFloat(text.substring(start, pos));
            }

        } else {
            int start = pos;
            while (pos < text.length() && !isin(text.charAt(pos), symbol)
                    && !isin(text.charAt(pos), whitespace))
                pos++;
            current = text.substring(start, pos);
        }
    }



    public  void consumewhite() {
        while (pos < text.length() && isin(text.charAt(pos), whitespace))
            pos++;
    }

    public static boolean isin(char c, char charlist[]) {
        for (char w : charlist) {
            if (w == c)
                return true;
        }
        return false;
    }

    //This method is used for converting the infix expression into prefix expression to consume the brackets
    public static String midToPre(String midSeq){
        Stack<Character> S1 = new Stack<>();
        Stack<Character> S2 = new Stack<Character>();
        int len = midSeq.length();
        int index = len - 1;
        while(index >= 0){
            char c = midSeq.charAt(index);
            switch(c){
                case ')':
                    S1.push(c);
                    break;
                case '(':
                    while(S1.peek() != ')'){
                        S2.push(S1.pop());
                    }
                    S1.pop();
                    break;
                case '*':
                case '/':
                    S1.push(c);
                    break;
                case '+':
                case '-':
                    if(S1.empty() || S1.peek().toString().matches("[+-]"))
                        S1.push(c);
                    else{
                        while(!S1.empty() && S1.peek().toString().matches("[*/]")){
                            S2.push(S1.pop());
                        }
                        S1.push(c);
                    }
                    break;
                default:
                    S2.push(c);
            }
            index--;
        }
        while(!S1.empty())
            S2.push(S1.pop());
        StringBuffer preSeq = new StringBuffer();
        Iterator<Character> iter = S2.iterator();
        while(iter.hasNext())
            preSeq.append(iter.next());
        preSeq = preSeq.reverse();
        return preSeq.toString();
    }

}
