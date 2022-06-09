package com.cst2335.exercises;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> elements = new ArrayList<>(  );
    MyListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Your program starts here
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);

        //STEP 1:
        ListView myList = findViewById(R.id.theListView);
        //Line 37 is the same as lines 35 and 36:
        //ListAdapter myAdapter = new MyListAdapter();
        //STEP 2: myList.setAdapter( myAdapter);
        myList.setAdapter( myAdapter = new MyListAdapter());

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {

            Log.i(TAG, "addButton");
        });

    }

    // Every class that implements BaseAdapter needs to implements 4 methods
    private class MyListAdapter extends BaseAdapter {

        // returns the number of elements
        public int getCount() { return elements.size();} //elements is a list

        //what should be displayed on each of the views of the list
        public Object getItem(int position) { return "This is row " + position; }

        // for database --> keeps track of the ID of the DB
        public long getItemId(int position) { return (long) position; }


        // defines how each view will look like int the list. work together with getItem(). Returns the item on the vire
        public View getView(int position, View old, ViewGroup parent)
        {
            // inflates allows to define our view
            LayoutInflater inflater = getLayoutInflater();

            /**
             * row_layout ->
             */
            //make a new row:
            View newView = inflater.inflate(R.layout.row_layout, parent, false);

            /**
             * newView.find... --> find all the items inside the layout from (row_layout)
             * to be able to show all of the items using --> tView,setText
             */
            //set what the text should be for this row:
            TextView tView = newView.findViewById(R.id.textGoesHere);
            tView.setText( getItem(position).toString() );

            //return it to be put in the table
            return newView;
        }
    }
}

