package com.example.sky_phase.mobattend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MobattendDatabase db1 = new MobattendDatabase(this);

    View menuItemView;
    MenuInflater menu;
    Toolbar mytoolbar;




    private SectionsPagerAdapter mSectionsPagerAdapter;
  private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mytoolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mytoolbar);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


       // Animation shake = AnimationUtils.loadAnimation(this, R.anim.shakewell);
       // menu.startAnimation(shake);




                View item = mytoolbar.findViewById(R.id.addmenu);
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shakewell);
               // item.startAnimation(shake);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mytoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final Context context = this;
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add,menu);




        MenuItem item1 = menu.findItem(R.id.addmenu);

        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)  {




                LayoutInflater factory = LayoutInflater.from(context);
                final View textEntryView = factory.inflate(R.layout.choosemanually, null);


                final AlertDialog.Builder alert = new AlertDialog.Builder(context, R.style.AlertDialCustom);


                alert.setView(textEntryView);



                alert .setPositiveButton("Insert Manually ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,CREATE_CLASS.class);
                        startActivity(intent);

                      //  Toast.makeText(MainActivity.this,"this feature isnt added yet",Toast.LENGTH_LONG).show();

                        //TextView one = (TextView) textEntryView.findViewById(R.id.text1);
                        //TextView two = (TextView) textEntryView.findViewById(R.id.text2);







/*
                        Cursor data = db.getListContents();

                        if (data.getCount() == 0){
                            Toast.makeText(MainActivity.this, "database empty", Toast.LENGTH_SHORT).show();
                        }else{
                            while(data.moveToNext()){
                                dataModels.add(new DataModel(data.getString(1), data.getString(2),data.getString(3),data.getString(4),date));
                                adapter = new CustomAdapter(dataModels,getApplicationContext());

                                listView.setAdapter(adapter);

                            }
                        }*/

                        // dataModels.add(new DataModel("sky", "022","atlanta",date,date));
                        // adapter.notifyDataSetChanged();











                    }
                }).setNegativeButton("Export from Excel       ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Intent intent = new Intent(MainActivity.this,QueryPage.class);
                        startActivity(intent);



                    }
                });
                AlertDialog alertDialog = alert.create();

                alertDialog.show();
                return false;
            }
        });
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



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {

                case 0:
                    // SecondTab me = new SecondTab();

                    ClasssFragment me = new ClasssFragment();
                    return me;


                case 1:
                    ReminderFragment tab3 = new ReminderFragment();
                    return tab3;

                case 2:
                    StatisticsFragment tab4 = new StatisticsFragment();
                    return tab4;
                case 3:
                    FirstTab me1 = new FirstTab();
                    return me1;


                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            
            switch (position) {

                case 0:
                    return "CLASS";
                case 1:
                    return "REMINDER";
                case 2:
                    return "STATISTICS";
                case 3:
                    return "SEARCH";
            }
            return null;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_help) {
            Intent intent = new Intent(MainActivity.this,Help.class);
            startActivity(intent);
        } else if (id == R.id.nav_importFromExcel) {

        } else if (id == R.id.nav_addManually) {

        } else if (id == R.id.nav_searchParticularDay) {

        } else if (id == R.id.nav_EditReminder) {

        } else if (id == R.id.nav_newReminder) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
