package com.master167.michael.boardgameaid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    // First activity that the users will see. This is where you can choose game setup, round timer, and score board

    private ArrayList<String> menuItems;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuItems = new ArrayList<String>();

        // Add the items to the list
        menuItems.add("Board Game Setup");
        menuItems.add("Round Scoreboard");
        menuItems.add("Game Scoreboard");
        menuItems.add("Round Timer");

        // Populate the list view
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItems);
        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(arrayAdapter);

        // Setup listView selector
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(MainPage.this, GameSetup.class);
                        break;
                    case 1:
                        intent = new Intent(MainPage.this, RoundScoreboard.class);
                        break;
                    /*case 2:
                        intent = new Intent(MainPage.this, GameScoreboard.class);
                        break;*/
                    case 3:
                        intent = new Intent(MainPage.this, Timer.class);
                        break;
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
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
