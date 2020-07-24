package com.example.howtobeastoic;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private static List<LessonList> list = new ArrayList<LessonList>();

    private TextView titleTV;
    private TextView introTV;
    private TextView quoteTV;

    private LessonList mItem;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstance == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LessonOneFragment()).commit();
            navView.setCheckedItem(R.id.nav_home);
        }
        populateLessonList();

        mItem = list.get(0);

        //titleTV = (TextView) findViewById(R.id.LessonTitleTV);
        //introTV = (TextView) findViewById(R.id.LessonContentTV);
        //quoteTV = (TextView) findViewById(R.id.LessonQuoteTV);

        //titleTV.setText("Hello World");
        //introTV.setText(mItem.getContent());
        //quoteTV.setText(mItem.getQuote());

        /*titleTV.setText(mItem.getTitle());
        introTV.setText(mItem.getContent());
        quoteTV.setText(mItem.getQuote());*/

    }


    private void populateLessonList() {
        list.add( new LessonList("menu_home","origin", "YOYOYOYOY", 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_one_title),getResources().getString(R.string.lesson_one_content), "not sure what to do here", 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_two_title),getResources().getString(R.string.lesson_two_content), getResources().getString(R.string.lesson_two_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_three_title),getResources().getString(R.string.lesson_three_content), getResources().getString(R.string.lesson_three_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_four_title),getResources().getString(R.string.lesson_four_content), getResources().getString(R.string.lesson_four_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_five_title),getResources().getString(R.string.lesson_five_content), getResources().getString(R.string.lesson_five_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_six_title),getResources().getString(R.string.lesson_six_content), getResources().getString(R.string.lesson_six_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_seven_title),getResources().getString(R.string.lesson_seven_content), getResources().getString(R.string.lesson_seven_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_eight_title),getResources().getString(R.string.lesson_eight_content), getResources().getString(R.string.lesson_eight_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_nine_title),getResources().getString(R.string.lesson_nine_content), getResources().getString(R.string.lesson_nine_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_ten_title),getResources().getString(R.string.lesson_ten_content), getResources().getString(R.string.lesson_ten_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_eleven_title),getResources().getString(R.string.lesson_eleven_content), getResources().getString(R.string.lesson_eleven_quote), 1) );
        list.add( new LessonList(getResources().getString(R.string.lesson_twelve_title),getResources().getString(R.string.lesson_twelve_content), getResources().getString(R.string.lesson_twelve_quote),  1) );

        //mItem = list.get(0);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Bundle bundle = new Bundle();

        switch (item.getItemId()) {
            case R.id.nav_home:
                bundle.putParcelable("LESSON", list.get(0));
                break;
            case R.id.nav_one:
                bundle.putParcelable("LESSON", list.get(1));
                break;
            case R.id.nav_two:
                bundle.putParcelable("LESSON", list.get(2));
                break;
            case R.id.nav_three:
                bundle.putParcelable("LESSON", list.get(3));
                break;
            case R.id.nav_four:
                bundle.putParcelable("LESSON", list.get(4));
                break;
            case R.id.nav_five:
                bundle.putParcelable("LESSON", list.get(5));
                break;
            case R.id.nav_six:
                bundle.putParcelable("LESSON", list.get(6));
                break;
            case R.id.nav_seven:
                bundle.putParcelable("LESSON", list.get(7));
                break;
            case R.id.nav_eight:
                bundle.putParcelable("LESSON", list.get(8));
                break;
            case R.id.nav_nine:
                bundle.putParcelable("LESSON", list.get(9));
                break;
            case R.id.nav_ten:
                bundle.putParcelable("LESSON", list.get(10));
                break;
            case R.id.nav_eleven:
                bundle.putParcelable("LESSON", list.get(11));
                break;
            case R.id.nav_twelve:
                bundle.putParcelable("LESSON", list.get(12));
                break;
            case R.id.send_toast:
                Toast floatToast = Toast.makeText(getApplicationContext(), "clicky!", Toast.LENGTH_LONG);
                floatToast.show();
                if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START);
                return true;
        }

        LessonOneFragment lesson_info = new LessonOneFragment();
        lesson_info.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, lesson_info).commit();

        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }

}
