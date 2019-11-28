package com.example.richa_000.Brake_Cooling;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class MainActivity extends AppCompatActivity {


    private String flaps;
    int[] bases;
    int ii,stop;
    int metric,autoLandAddition,autoLandAdditive;
    private CheckBox checkBox,checkBox2;
    double units = 1;
    public RadioGroup radioGroup, radioGroup1;
    private RadioButton oeif15,flaps30, flaps40, tr2,tr1,tr0,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //radioGroup = (RadioGroup) findViewById(radioGroup);
        addListenerOnChkIos();
        addListenerAutoLand(); //listen for autoland checkbox

        addListenerRadioGroup();
        addListenerRadioGroup1();

        ;





        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.flaps30brakes, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        final EditText weightText = (EditText) findViewById(R.id.editText);
        weightText.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    weightText.setText("", TextView.BufferType.EDITABLE); //clears text on press
                }
            }


        });
        final EditText elevationText = (EditText) findViewById(R.id.editText2);
        elevationText.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    elevationText.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet = (EditText) findViewById(R.id.editText3);
        wet.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet1 = (EditText) findViewById(R.id.editText4);
        wet1.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet1.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet2 = (EditText) findViewById(R.id.editText5);
        wet2.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet2.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet3 = (EditText) findViewById(R.id.editText6);
        wet3.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet3.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet5 = (EditText) findViewById(R.id.editText11);
        wet3.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet3.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
        final EditText wet4 = (EditText) findViewById(R.id.editText7);
        wet4.setOnFocusChangeListener(new OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    wet4.setText("", TextView.BufferType.EDITABLE);
                }
            }


        });
    }







    public void sendMessage(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String weight = editText.getText().toString();
        if (weight.trim().equals("")) { //shows "Enter data" if nothing in first editText box
           // Toast tosdada=Toast.makeText(MainActivity.this, "Ensure all data boxes filled!!",Toast.LENGTH_SHORT);
          ///  tosdada.setGravity(Gravity.CENTER,0,0);
        //    tosdada.show();
            showTheToast();
            return; //quits method
        }
        EditText elevnText = (EditText) findViewById(R.id.editText2);

        String elevation = elevnText.getText().toString();
        if (elevation.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText tempText = (EditText) findViewById(R.id.editText3);
        String temp = tempText.getText().toString();
        if (temp.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText winddctnText = (EditText) findViewById(R.id.editText4);
        String winddctn = winddctnText.getText().toString();
        if (winddctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText windspeedtext = (EditText) findViewById(R.id.editText5);
        String windspeed = windspeedtext.getText().toString();
        if (windspeed.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText rwText = (EditText) findViewById(R.id.editText6);
        String rwdctn = rwText.getText().toString();
        if (rwdctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText spdadjustText = (EditText) findViewById(R.id.editText7);
        String spdadjust = spdadjustText.getText().toString();
        if (spdadjust.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText slopeText = (EditText) findViewById(R.id.editText11);
        String slopeAdjust = slopeText.getText().toString();
        if (slopeAdjust.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        double myNum, elevationNum, tempNum, winddctnNum, winspeedNum, rwdctnNum, spdadjustNum,slopeAdjustNum,trNum;






        myNum = Double.parseDouble(weight);//double because of decimal point
        elevationNum = Double.parseDouble(elevation);
        tempNum = Double.parseDouble(temp);
        winddctnNum = Double.parseDouble(winddctn);
        winspeedNum = Double.parseDouble(windspeed);
        rwdctnNum = Double.parseDouble(rwdctn);
        spdadjustNum = Double.parseDouble(spdadjust);
        slopeAdjustNum = Double.parseDouble(slopeAdjust);

     //  int selectedId = radioGroup.getCheckedRadioButtonId();
        int baseWeight=65000;
        int appspdadj=5;//approach spd adjust is per 5 knts -800
        double heavy;
        int stopper=0; // to control iteration
        oeif15 = (RadioButton) findViewById(R.id.radioButton6);
        flaps30 = (RadioButton) findViewById(R.id.radioButton);
        flaps40 = (RadioButton) findViewById(R.id.radioButton2);
        if(flaps30.isChecked()) {
            flaps = "thirty";
            stopper = 0;
            stop=0;
            // textView.setText("You chose 'Sound' option");
        }

         else if (flaps40.isChecked())   {
            flaps = "forty";
            ii=12; //new flap 40 start point
            stop=0;
            stopper = 12; //get iteration to end MUST CHECK
        }

        else if (oeif15.isChecked())   {
            flaps = "oeif15";
            stopper=24;
            ii=24; //need new number
            stop=0;
        }




        tr2 = (RadioButton) findViewById(R.id.radioButton4);
        tr1 = (RadioButton) findViewById(R.id.radioButton5);
        tr0 = (RadioButton) findViewById(R.id.radioButton3);
        trNum=1;
            if (tr2.isChecked()){   //obtain tr state
                trNum=1;
            }
            else if (tr1.isChecked())   {
                trNum=2;
            }
            else if (tr0.isChecked())   {
                trNum=3;
            }


        //trNum = Double.parseDouble(spdadjust);
               weight = ("" + myNum); //convert int to str
        Resources r = getResources();
        int printResult =-1;
            for ( ii = stopper; ii <= 33; ii++) {

                stop++;
                if (ii == 0) {
                    bases = r.getIntArray(R.array.f30_dry_ab3);
                    printResult++;
                    TextView textView7 = (TextView) findViewById(R.id.textView7);
                    textView7.setText("AB 3");
                }

                else if (ii == 1) {
                    bases = r.getIntArray(R.array.f30_dry_ab2);
                    printResult++;
                    TextView textView8 = (TextView) findViewById(R.id.textView8);
                    textView8.setText("AB 2");
                }

                else if (ii == 2) {
                     bases = r.getIntArray(R.array.f30_dry_ab1);
                    printResult++;
                    TextView textView14 = (TextView) findViewById(R.id.textView14);
                    textView14.setText("AB 1");
                }
                else if (ii == 3) {
                    bases = r.getIntArray(R.array.f30_dry_abmax);
                    printResult++;
                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText("AB Max");
                }
                else if (ii == 4) {
                    bases = r.getIntArray(R.array.f30_good_abmax);
                    printResult++;
                }
                else if (ii == 5) {
                    bases = r.getIntArray(R.array.f30_good_ab3);
                    printResult++;
                }
                else if (ii == 6) {
                    bases = r.getIntArray(R.array.f30_good_ab2);
                    printResult++;
                }
                else if (ii == 7) {
                    bases = r.getIntArray(R.array.f30_good_ab1);
                    printResult++;
                }
                else if (ii == 8) {
                    bases = r.getIntArray(R.array.f30_medium_abmax);
                    printResult++;
                }
                else if (ii == 9) {
                    bases = r.getIntArray(R.array.f30_medium_ab3);
                    printResult++;
                }
                else if (ii == 10) {
                    bases = r.getIntArray(R.array.f30_medium_ab2);
                    printResult++;
                }
                else if (ii == 11) {
                    bases = r.getIntArray(R.array.f30_medium_ab1);
                    printResult++;
                }
                else if (ii == 12) {
                    bases = r.getIntArray(R.array.f40_dry_ab3);
                    printResult=0;
                    TextView textView7 = (TextView) findViewById(R.id.textView7);
                    textView7.setText("AB 3");
               }
                else if (ii == 13) {
                    bases = r.getIntArray(R.array.f40_dry_ab2);
                    printResult++;
                    TextView textView8 = (TextView) findViewById(R.id.textView8);
                    textView8.setText("AB 2");
                }
                else if (ii == 14) {
                    bases = r.getIntArray(R.array.f40_dry_ab1);
                    printResult++;
                    TextView textView14 = (TextView) findViewById(R.id.textView14);
                    textView14.setText("AB 1");
                }
                else if (ii == 15) {
                    bases = r.getIntArray(R.array.f40_dry_abmax);
                    printResult++;
                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText("AB Max");
                }
                else if (ii == 16) {
                    bases = r.getIntArray(R.array.f40_good_abmax);
                    printResult++;
                }
                else if (ii == 17) {
                    bases = r.getIntArray(R.array.f40_good_ab3);
                    printResult++;
                }
                else if (ii == 18) {
                    bases = r.getIntArray(R.array.f40_good_ab2);
                    printResult++;
                }
                else if (ii == 19) {
                    bases = r.getIntArray(R.array.f40_good_ab1);
                    printResult++;
                }
                else if (ii == 20) {
                    bases = r.getIntArray(R.array.f40_medium_abmax);
                    printResult++;
                }
                else if (ii == 21) {
                    bases = r.getIntArray(R.array.f40_medium_ab3);
                    printResult++;
                }
                else if (ii == 22) {
                    bases = r.getIntArray(R.array.f40_medium_ab2);
                    printResult++;
                }
                else if (ii == 23) {
                    bases = r.getIntArray(R.array.f40_medium_ab1);
                    printResult++;
                }
                else if (ii == 24) {
                    bases = r.getIntArray(R.array.f15oei_dry_max_man);
                    printResult=0;

                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText("OEI!");
                    TextView textView7 = (TextView) findViewById(R.id.textView7);
                    textView7.setText("Max Man");
                    TextView textView9 = (TextView) findViewById(R.id.textView9);
                    textView9.setText("");
                    TextView textView13 = (TextView) findViewById(R.id.textView13);
                    textView13.setText("");
                    TextView textView21 = (TextView) findViewById(R.id.textView21);
                    textView21.setText("");
                }
                else if (ii == 25) {
                    bases = r.getIntArray(R.array.f15oei_dry_abmax);
                    printResult++;
                    TextView textView8 = (TextView) findViewById(R.id.textView8);
                    textView8.setText("AB Max");
                }

                else if (ii == 26) {
                    bases = r.getIntArray(R.array.f15oei_dry_ab2);
                    printResult++;
                    TextView textView14 = (TextView) findViewById(R.id.textView14);
                    textView14.setText("AB2");


                }
                else if (ii == 27) {
                    bases = r.getIntArray(R.array.f15oei_good_max_man);
                    printResult=printResult+3;
                }
                else if (ii == 28) {
                    bases = r.getIntArray(R.array.f15oei_good_abmax);
                    printResult++;
                }
                else if (ii == 29) {
                    bases = r.getIntArray(R.array.f15oei_good_ab2);
                    printResult++;
                }
                else if (ii == 30) {
                    bases = r.getIntArray(R.array.f15oei_medium_max_man);
                    printResult=printResult+2;
                }
                else if (ii == 31) {
                    bases = r.getIntArray(R.array.f15oei_medium_abmax);
                    printResult++;
                }
                else if (ii == 32) {
                    bases = r.getIntArray(R.array.f15oei_medium_ab3);
                    printResult++;
                }

                double ref_dist, ref_dist1, ref_dist2, ref_dist3, ref_dist4, ref_dist5, ref_dist6, ref_dist7,ref_dist8,ref_dist9,cross;

                if (flaps=="oeif15") {
                     baseWeight=65000; //to cater for different weight datum f15
                    appspdadj=5;
                }
                else baseWeight=65000; //737-800
                ref_dist = bases[0]; // get first element of array

                heavy=((myNum - baseWeight) / 5000);
                if (heavy<0) {
                    heavy=(heavy*bases[2]);
                }
                else heavy=heavy*bases[1];


                ref_dist = ref_dist + heavy;

                ref_dist1 = (elevationNum / 1000) * bases[3];
                ref_dist2 = (15 - (elevationNum / 1000) * 2) - (tempNum);



                ref_dist8=slopeAdjustNum;
                if (ref_dist8 > 0) {
                    ref_dist8 = (ref_dist8  * bases[6]);
                } else {
                    ref_dist8 = (ref_dist8  * bases[7]);
                }



                ref_dist9=0;

                if (trNum==1) {
                    ref_dist9=0;   //ref_dist9 = tr correction
                }
                    else if (trNum==2){
                    ref_dist9=(bases[11]);
                }

                    else if (trNum==3){
                    ref_dist9=(bases[12]);
                }
                if (ref_dist2 > 0) {
                    ref_dist2 = (ref_dist2 / 10) * bases[9];
                } else {
                    ref_dist2 = (ref_dist2 / 10) * bases[8];
                }
                ref_dist7 = (spdadjustNum / appspdadj) * bases[10];
                double windissue,windissue1;
                windissue = (winddctnNum - (rwdctnNum * 10));
                windissue = (windissue) * (3.14159265358979 / 180);
                windissue1=windissue;
                windissue = cos(windissue);


                ref_dist3 = (winspeedNum * windissue);
                windissue1 = sin(windissue1);
                cross=windissue1*winspeedNum;
                TextView textView19 = (TextView) findViewById(R.id.textView19);
                TextView textView18 = (TextView) findViewById(R.id.textView18);
                TextView textView16 = (TextView) findViewById(R.id.textView16);
                TextView textView17 = (TextView) findViewById(R.id.textView17);
                int b =(int)Math.round(ref_dist3); //get rid of decimal

                int c =(int)Math.round(cross); //get rid of decimal
                c=abs(c);
                textView19.setText(""+c); //show crosswind component
                textView18.setVisibility(View.VISIBLE);
                textView16.setText(""+b); //show headwind component
                textView17.setVisibility(View.VISIBLE);

                if (ref_dist3 > 0) {

                    ref_dist3 = (ref_dist3 / 10) * bases[4];


                } else {

                    ref_dist3 = (ref_dist3 / 10) * bases[5];
                }


                ref_dist = ref_dist + ref_dist1 + ref_dist2 + ref_dist3 + ref_dist7+ref_dist8+ref_dist9;
                // ref_dist=floor(ref_dist);
                int i = (int) ref_dist;
                i=i+autoLandAdditive;//add 1000' here if autoland checked
                double aa = (i/units);//convert feet to meters
                int a =(int)Math.round(aa); //get rid of decimal

                weight = ("" + a);


            if (printResult==0) {
                TextView textView1 = (TextView) findViewById(R.id.textView);//dry ab3
                textView1.setText(weight);

            }
            else if (printResult==1){
                TextView textView1 = (TextView) findViewById(R.id.textView3);//dry ab2
                textView1.setText(weight);

            }

            else if (printResult==2){
                TextView textView1 = (TextView) findViewById(R.id.textView4);//dry ab 1
                textView1.setText(weight);

            }
            else if (printResult==3){
                TextView textView1 = (TextView) findViewById(R.id.textView9);//dry abmx
                textView1.setText(weight);

            }
            else if (printResult==4) {
                TextView textView1 = (TextView) findViewById(R.id.textView13);//good abmax
                textView1.setText(weight);

            }

             else if (printResult==5){
                TextView textView1 = (TextView) findViewById(R.id.textView12);//good ab3
                textView1.setText(weight);

            }
            else if (printResult==6){
                TextView textView1 = (TextView) findViewById(R.id.textView11);//good ab2
                textView1.setText(weight);

            }
            else if (printResult==7){
                TextView textView1 = (TextView) findViewById(R.id.textView10);//good ab1
                textView1.setText(weight);

            }
            else if (printResult==8){
                TextView textView1 = (TextView) findViewById(R.id.textView21);//med abmx
                textView1.setText(weight);

            }else if (printResult==9){
                TextView textView1 = (TextView) findViewById(R.id.textView22);//good ab3
                textView1.setText(weight);

            }else if (printResult==10){
                TextView textView1 = (TextView) findViewById(R.id.textView23);//good ab2
                textView1.setText(weight);

            }else if (printResult==11){
                TextView textView1 = (TextView) findViewById(R.id.textView24);//good ab1
                textView1.setText(weight);
                if (ii==33){
                    textView1.setText("XXXX"); //because show AB3 not AB2 therefore is deleted.
                }
            }


            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);




            //================ Hide Virtual Key Board When  Clicking==================//


//======== Hide Virtual Keyboard =====================//
        if (stop==12 || stop==16) { //  || is "or"
            ii=33;

        }

    }
      //  Toast.makeText(getApplicationContext(), "Press \""+"Calculate!" + "\" again if Flaps or T/R settings changed",

      //          Toast.LENGTH_LONG).show(); not needed with this version
}


    public void showWind(View v) {  //allows view of winds only

        EditText winddctnText = (EditText) findViewById(R.id.editText4);
        String winddctn = winddctnText.getText().toString();
        if (winddctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method

        }
        EditText windspeedtext = (EditText) findViewById(R.id.editText5);
        String windspeed = windspeedtext.getText().toString();
        if (windspeed.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        EditText rwText = (EditText) findViewById(R.id.editText6);
        String rwdctn = rwText.getText().toString();
        if (rwdctn.trim().equals("")) { //shows "Enter data" if nothing in first editText box
            showTheToast();
            return; //quits method
        }
        double winddctnNum,winspeedNum,rwdctnNum;

        winddctnNum = Double.parseDouble(winddctn);
        winspeedNum = Double.parseDouble(windspeed);
        rwdctnNum = Double.parseDouble(rwdctn);

        double windissue,windissue1,ref_dist3,cross;
        windissue = (winddctnNum - (rwdctnNum * 10));
        windissue = (windissue) * (3.14159265358979 / 180);
        windissue1=windissue;
        windissue = cos(windissue);


        ref_dist3 = (winspeedNum * windissue);
        windissue1 = sin(windissue1);
        cross=windissue1*winspeedNum;
        TextView textView19 = (TextView) findViewById(R.id.textView19);
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        TextView textView17 = (TextView) findViewById(R.id.textView17);
        int b =(int)Math.round(ref_dist3); //get rid of decimal

        int c =(int)Math.round(cross); //get rid of decimal
        c=abs(c);
        textView19.setText(""+c); //show crosswind component
        textView18.setVisibility(View.VISIBLE);
        textView16.setText(""+b); //show headwind component
        textView17.setVisibility(View.VISIBLE);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            //================ Hide Virtual Key Board When  Clicking==================//

    }
    public void addListenerOnChkIos() {

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    units=3.28;
                }
                else  {
                    units=1;
                }
                sendMessage(v);// run calc again
            }
        });

    }
    public void addListenerRadioGroup () {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            // checkedId is the RadioButton selected
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 Button btn;
                btn=(Button)findViewById(R.id.button);
                btn.performClick();
            }

        });
    }

    public void addListenerRadioGroup1 () {

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            // checkedId is the RadioButton selected
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Button btn;
                btn=(Button)findViewById(R.id.button);//this simulates pressing "calculate"
                btn.performClick();  //                 button and runs code
            }

        });
    }


    public void addListenerAutoLand() {

        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        checkBox2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    autoLandAdditive=1000;
                }
                else  {
                    autoLandAdditive=0;  //add 1000' or 0' to landing distance based on checkbox
                }
                sendMessage(v);// run calc again
            }
        });

    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Rich's Landing Calculator..")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }




    public void showTheToast(){   //shows this warning

        Toast tosdada=Toast.makeText(MainActivity.this, "Ensure all data boxes filled!!",Toast.LENGTH_SHORT);
        tosdada.setGravity(Gravity.CENTER,0,0);
        tosdada.show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_option_menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intent1 = new Intent(this,About.class);
                this.startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

}