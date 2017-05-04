package com.example.haotian.skycalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.haotian.skycalculator.Parser.Expression;
import com.example.haotian.skycalculator.Parser.MySimpleTokenizer;
import com.example.haotian.skycalculator.Parser.ParseException;

//Author:Haotian Xue & SiYu Zhen


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    String str;
    String convert;
    int anInt = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnMult).setOnClickListener(this);
        findViewById(R.id.btnEq).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnUndo).setOnClickListener(this);
        findViewById(R.id.btnSpace).setOnClickListener(this);
        findViewById(R.id.btnL).setOnClickListener(this);
        findViewById(R.id.btnR).setOnClickListener(this);
        findViewById(R.id.btn_undo).setOnClickListener(this);
        findViewById(R.id.btnBin).setOnClickListener(this);
        findViewById(R.id.btnHex).setOnClickListener(this);
        findViewById(R.id.btnOct).setOnClickListener(this);
        findViewById(R.id.btnDec).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                textView.append("0");
                break;
            case R.id.btn1:
                textView.append("1");
                break;
            case R.id.btn2:
                textView.append("2");
                break;
            case R.id.btn3:
                textView.append("3");
                break;
            case R.id.btn4:
                textView.append("4");
                break;
            case R.id.btn5:
                textView.append("5");
                break;
            case R.id.btn6:
                textView.append("6");
                break;
            case R.id.btn7:
                textView.append("7");
                break;
            case R.id.btn8:
                textView.append("8");
                break;
            case R.id.btn9:
                textView.append("9");
                break;
            case R.id.btnAdd:
                textView.append("+");
                break;
            case R.id.btnSub:
                textView.append("-");
                break;
            case R.id.btnDiv:
                textView.append("/");
                break;
            case R.id.btnEq:
                str = textView.getText().toString();
//                str = insertSpace(str);
                MySimpleTokenizer my = new MySimpleTokenizer(str);

                try {
                    Expression expression = Expression.parse(my);
                    String a = ""+expression.evaluate();
                    textView.setText(a);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //evaluate(str);
//                textView.setText();
                break;
            case R.id.btnUndo:
                textView.setText("");
                anInt = -1;
                break;
            case R.id.btnMult:
                textView.append("*");
                break;
            case R.id.btnSpace:
                textView.append(" ");
                break;
            case R.id.btnL:
                textView.append("(");
                break;
            case R.id.btnR:
                textView.append(")");
                break;
            case R.id.btn_undo:
//                str = textView.getText().toString();
//                if(str.length()>=1) {
//                    str = str.substring(0, str.length() - 1);
//                    textView.setText(str);
//                }
//                break;
                str = textView.getText().toString();
                anInt = -1;
                if(str.length()>=1) {
                    str = str.substring(0, str.length() - 1);
                    textView.setText(str);
                }
                break;
            case R.id.btnBin:
//                str = textView.getText().toString();
//                if(isInt(str) && anInt==-1){
//                    anInt = Integer.parseInt(str);
//                    String a = Integer.toBinaryString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 2);
//                    System.out.print(anInt);
//                } else if (isInt(str) && anInt != -1) {
//                    String a = Integer.toBinaryString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 2);
//                } else {
//                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
//                }
//                break;
                str = textView.getText().toString();
                if(isInt(str) && anInt==-1){
                    anInt = Integer.parseInt(str);
                    String a = Integer.toBinaryString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 2);
                    System.out.print(anInt);
                } else if (anInt != -1) {
                    String a = Integer.toBinaryString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 2);
                } else {
                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnHex:
//                str = textView.getText().toString();
//                if(isInt(str)&&anInt==-1){
//                    anInt = Integer.parseInt(str);
//                    String a = Integer.toHexString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 16);
//                }else if (isInt(str) && anInt != -1) {
//                    String a = Integer.toHexString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 16);
//                }else {
//                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
//                }
//                break;
                str = textView.getText().toString();
                if(isInt(str)&&anInt==-1){
                    anInt = Integer.parseInt(str);
                    String a = Integer.toHexString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 16);
                }else if (anInt != -1) {
                    String a = Integer.toHexString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 16);
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnOct:
//                str = textView.getText().toString();
//                if(isInt(str)&&anInt==-1){
//                    str = textView.getText().toString();
//                    anInt = Integer.parseInt(str);
//                    String a = Integer.toOctalString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 8);
//                }else if (isInt(str) && anInt != -1) {
//                    String a = Integer.toOctalString(anInt);
//                    textView.setText(a);
//                    anInt = Integer.parseInt(a, 8);
//                }else {
//                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
//                }
//                break;
                str = textView.getText().toString();
                if(isInt(str)&&anInt==-1){
                    str = textView.getText().toString();
                    anInt = Integer.parseInt(str);
                    String a = Integer.toOctalString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 8);
                }else if (anInt != -1) {
                    String a = Integer.toOctalString(anInt);
                    textView.setText(a);
                    anInt = Integer.parseInt(a, 8);
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter positive Integer!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_dot:
                textView.append(".");
                break;
            case R.id.btnDec:
//                str = textView.getText().toString();
//                if (anInt!=-1) {
//                    String a = anInt+"";
//                    textView.setText(a);
//                }
//                break;
                str = textView.getText().toString();
                if (anInt!=-1) {
                    String a = anInt+"";
                    textView.setText(a);
                }
                break;


        }
    }

//    public static Boolean isInt(String str){
//        float a = Float.parseFloat(str);
//        String string = ""+a;
//        int index = string.indexOf(".");
//        String b = string.substring(0, index);
//        int c = Integer.parseInt(b);
//        if (c == a) {
//            return true;
//        }
//        return false;
//    }
public static Boolean isInt(String str){
    if (str.contains("a")||str.contains("b")||str.contains("c")||str.contains("d")||str.contains("e")||str.contains("f"))
        return false;
    float a = Float.parseFloat(str);
    String string = ""+a;
    int index = string.indexOf(".");
    String b = string.substring(0, index);
    int c = Integer.parseInt(b);
    if (c == a && a > 0) {
        return true;
    }
    return false;
}


}
