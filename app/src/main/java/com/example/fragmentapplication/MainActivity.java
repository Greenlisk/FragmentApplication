package com.example.fragmentapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction ;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.fragmentapplication.Fragment1;
import com.example.fragmentapplication.Fragment2;
import com.example.fragmentapplication.R;

public class MainActivity extends Activity {

    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;
    CheckBox chbStack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientaion = getResources().getConfiguration().orientation;
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
if (orientaion== Configuration.ORIENTATION_PORTRAIT){
    Fragment2 fragment2 = new Fragment2();
    Log.d("main","Ориентация вертикальная");
    fragmentTransaction.add(R.id.list, fragment2);
    View f = findViewById(R.id.viewer);
    f.setVisibility(View.INVISIBLE);
    fragmentTransaction.commit();
}
else{
    Log.d("main","Ориентация горизонтальная");
    Fragment2 fragment2 = new Fragment2();
    fragmentTransaction.add(R.id.list, fragment2);
    Fragment1 fragment1 = new Fragment1();
    View f = findViewById(R.id.viewer);
    f.setVisibility(View.VISIBLE);
    fragmentTransaction.add(R.id.viewer, fragment1);
    fragmentTransaction.commit();
}

    }

}
