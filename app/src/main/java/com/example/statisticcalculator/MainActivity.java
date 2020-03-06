package com.example.statisticcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> addArray = new ArrayList<Integer>();

    float standardDeviation=0;
    float total=0;
    float meanValue;
    double medianValue;
    int modeValue=0;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button arrange;
    private Button clear;
    private Button enter;
    private TextView result;
    private TextView list;
    private TextView mean;
    private TextView median;
    private TextView mode;
    private Button clrlist;
    private TextView standardResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"1");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"0");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"9");
            }
        });

        arrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString()+"0");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result.getText().length()>0){
                    CharSequence name = result.getText().toString();
                    result.setText(name.subSequence(0,name.length()-1));
                } else {
                    result.setText(null);
                }
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(result.getText()== null || result.getText()==""){
                    result.setText("No input");
                    result.setText(null);
                } else {

                    CharSequence getInput = result.getText().toString();
                    int num = Integer.parseInt((getInput.toString()));

                    result.setText(null);
                    list.setText(null);
                    standardResult.setText(null);
                    addArray.add(num);
                    total += num;




                    for(int i=0;i< addArray.size();i++){

                        list.setText(list.getText()+ " "+ addArray.get(i));
                    }

                    meanValue = total/addArray.size();
                    int size = addArray.size();

                    Collections.sort(addArray);
                    if(addArray.size() % 2 != 0){
                        medianValue =addArray.get(size/2);
                    } else {
                        medianValue = ((addArray.get((size-1)/2)+addArray.get(size/2))/2)+0.5;
                    }

                    int maxCount=0;
                    //mode
                    for (int k = 0; k < addArray.size(); ++k) {
                        int count = 0;
                        for (int l = 0; l < addArray.size(); ++l) {
                            if (addArray.get(l) == addArray.get(k))
                                ++count;
                        }

                        if (count > maxCount) {
                            maxCount = count;
                            modeValue = addArray.get(k);
                        }
                    }


                    float length=0;
                    float resultAns=0;
                    standardDeviation=0;
                    //standard Deviation
                for(int m=0;m<addArray.size();m++){
                   standardDeviation += Math.pow(addArray.get(m)-meanValue,2);
                }

                length = addArray.size()-1;

                resultAns = standardDeviation/length;

                standardDeviation = (float)Math.sqrt(resultAns);



                    mean.setText(Double.toString(meanValue));
                    median.setText(Double.toString(medianValue));
                    mode.setText(Integer.toString(modeValue));
                    standardResult.setText(Float.toString(standardDeviation));

            }}
        });

        arrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Collections.sort(addArray);
                result.setText(null);
                list.setText(null);

                for(int i=0;i< addArray.size();i++){

                    list.setText(list.getText()+ " "+ addArray.get(i));
                }
            }
        });

        clrlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.setText(null);
                mean.setText(null);
                median.setText(null);
                mode.setText(null);
                result.setText(null);
                standardResult.setText(null);
                addArray.clear();
                meanValue = 0;
                medianValue =0;
                modeValue = 0;
                standardDeviation=0;
                total = 0;
            }
        });




    }

    private void setup(){
        clrlist = (Button)findViewById(R.id.btnRemove) ;
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        zero = (Button)findViewById(R.id.btn0);
        arrange = (Button)findViewById(R.id.btnArrange);
        clear = (Button)findViewById(R.id.btnClear);
        enter = (Button)findViewById(R.id.btnEnter);
        result = (TextView)findViewById(R.id.result);
        list = (TextView)findViewById(R.id.list);
        mean = (TextView)findViewById(R.id.meanResult);
        median = (TextView)findViewById(R.id.medianResult);
        mode = (TextView)findViewById(R.id.modeResult);
        standardResult = (TextView)findViewById(R.id.standardResult);
    }

    private void computer(){

    }
}
