package com.example.count;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	 private Button newTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newTask = (Button)findViewById(R.id.button1);

        
    }
    int ct=0;
    public void  createTask(View view)
    {
    	String task="";
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);

    	alert.setTitle("Task");
    	alert.setMessage("Enter Task ");

      	final EditText input = new EditText(this);
    	alert.setView(input);

    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	  Editable value = input.getText();
    	  addToScreen(value.toString());
    	  }
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	  public void onClick(DialogInterface dialog, int whichButton) 
    	  {
    	    // Canceled.
    	  }
    	});

    	alert.show();
    	
    }
    public void addToScreen(String task)
    {
    	 Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
    	LinearLayout rr =  (LinearLayout) findViewById(R.id.ll);
    	rr.setOrientation(LinearLayout.VERTICAL);
    	TextView tv1 = new TextView(MainActivity.this);
        tv1.setId(ct);
        tv1.setText(task+"-0");
        rr.addView(tv1);
        final String t=task;
        tv1.setOnClickListener(new OnClickListener() 
    	{
    		 public void onClick(View v) 
            {
            	int ids=v.getId();
            	
            	TextView task = (TextView)findViewById(ids);
            	Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
           	String count=(String) task.getText();
           	String c=count.split("-")[1];
           	int cnt=Integer.parseInt(c);
           	cnt++;
            	Toast.makeText(getApplicationContext(),c,Toast.LENGTH_SHORT).show();
            	task.setText(t+"-"+cnt);
            	
            }
        });
        
        Button myButton = new Button(MainActivity.this);
        myButton.setId(ct);
    	myButton.setText("change");
    	myButton.setBackgroundColor(0xFFF0111);
    	myButton.setOnClickListener(new OnClickListener() 
      	{
      		 public void onClick(View v) 
              {
      			 
              }
      	});
    	rr.addView(myButton);
    	
    	 ct++;
    }	
   

}
