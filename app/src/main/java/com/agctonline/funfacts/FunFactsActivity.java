package com.agctonline.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

//added some text to test push github

public class FunFactsActivity extends Activity {

    TextView mFactText, mFactTextArray; //class's memberVariable
    TextView mNumber1, mNumber2;
    private FactBook factArrayData = new FactBook(); //initialize a new FactBook Object
    private ColorWheel colorValue = new ColorWheel(); //initialize a new ColorWheel Object

    RelativeLayout layoutColor;

    public static final String TAG = FunFactsActivity.class.getSimpleName(); //This set the variable TAG to the name of the class for use as a constant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //How to Declare variables

        //final TextView factText; //"TextView" is the datatype, "factLabel" is the variable's name
        //factText = (TextView) findViewById(R.id.factTextView); //Alt+Enter to cast variable type

        final Button showFactButton = (Button) findViewById(R.id.showFactButton);

        //Using member variable instead of local variable to setText
        //member variable does not need "final" declaration as the variables above
        //and the variable can be used by other methods outside of the anon classes
        layoutColor = (RelativeLayout) findViewById(R.id.relativeLayout);
        mFactText = (TextView) findViewById(R.id.factTextView); //Alt+Enter to cast variable type
        mFactTextArray = (TextView) findViewById(R.id.factArrayTextView);
        mNumber1 = (TextView) findViewById(R.id.numberView1);
        mNumber2 = (TextView) findViewById(R.id.numberView2);

        //new View.OnClickListener creates a new object/class named "Listener"
        //use auto-complete to fill out the method
        //View listener is different than dialog listener

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when button is clicked, update with new fact

                //String fact = "birds can fly, generally (onclicklistener method 1)";
                //factText.setText(fact);

                //Using member variable instead of local variable to setText
                //member variable does not need "final" declaration
                //and the variable can be used by other methods outside of this anon class

                //String mFact = "birds can fly, generally (onclicklistener method 1, using member variable)";

                String mFact;
                String hardCodedFact = "Hard coded fact: ";

                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(3);

                //String.valueOf(randomGenerator.nextInt(3));
                //or use Integer.toString(randomNumber)
                //or force convert by adding "" ----> randomGenerator.nextInt(5)+"";

                if (randomNumber == 0) {
                    mFact = hardCodedFact + "Birds fly";
                }
                else if (randomNumber == 1) {
                    mFact = hardCodedFact +"Water is wet";
                }
                else if (randomNumber == 2) {
                    mFact = hardCodedFact +"Pigs can fly";
                }
                else {
                    mFact = hardCodedFact +"You found a bug";
                }


                /*String [] mFacts = {
                        "array Fact 1",
                        "array Fact 2",
                        "array Fact 3",
                        "array Fact 4",
                        "array Fact 5"};
                int randomNumberFromArray = randomGenerator.nextInt(mFacts.length);
                mFact = mFact + ". " + mFacts[randomNumberFromArray];*/

                //moved the above array into its own class to demonstrate code reuse


                mFactText.setText(mFact );
                mFactTextArray.setText( factArrayData.getArrayFact().substring(0,1).toUpperCase() + factArrayData.getArrayFact().substring(1));

                //Looping through each element of array and display out the elements
                //using the for-each loop

                String [] mNumber = {
                        "1",
                        "2",
                        "3",
                        "4",
                        "5"};
                String forward="", reverse="";

                for(String i : mNumber){
                    forward = forward + i;
                    reverse = i + reverse;
                }
                mNumber1.setText(forward);
                mNumber2.setText(reverse);

                layoutColor.setBackgroundColor(colorValue.getColor());
                showFactButton.setTextColor(colorValue.getColor());
            }
        };

        //set listen when clicking on the button, must create the "Listener" object
        //above before it is available to be used
        showFactButton.setOnClickListener(Listener);

       /* showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = "birds can fly, generally (onclicklistener method 2)";
                factText.setText(fact);
            }
        });*/


        /*String toastMessage = "this is a toast message";
        Toast toastPopup = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        //the makeText method has 3 params, the context, the message, the time. In the line of code above, Show toast in this screen activity (context) a message (toastMessage) for a duration (LONG).
        toastPopup.show();*/

       Toast.makeText(this, "this is a toast message optimized", Toast.LENGTH_LONG).show();

        //Log.d("FunFactActivity.javafile","From inside the onCreate method");
        Log.d(TAG,"From inside the onCreate method using the TAG constant");

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
