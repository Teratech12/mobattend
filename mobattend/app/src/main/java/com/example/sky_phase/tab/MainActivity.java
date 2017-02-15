package com.example.sky_phase.tab;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    FloatingActionButton fab;
    ListView listView;
    private static CustomAdapterforScreenTwo adapter;
    ArrayList<DataModelforScreenTwo> dataModels;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
                Intent intent = new Intent(String.valueOf(fragmentActivity.class));
                startActivity(intent);



            }
        });

    /*    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.myvav);
        navigationView.setNavigationItemSelectedListener(this);

*/


       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    public void addOnClickListener(){

        final Context contex = this;
     //   final Activity activity = getActivity();



        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "here there am a floating bar",Toast.LENGTH_LONG).show();
                //    Toast.makeText(SecondTab.this, "hey", Toast.LENGTH_SHORT).show();

                /*
                LayoutInflater factory = LayoutInflater.from(contex);
                final View textEntryView = factory.inflate(R.layout.text_entry, null);


                final AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());



                alert.setIcon(R.drawable.user).setTitle("Add new class").setMessage("choose one of these").setView(textEntryView);


                alert .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        TextView one = (TextView) textEntryView.findViewById(R.id.text1);
                        TextView two = (TextView) textEntryView.findViewById(R.id.text2);













                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                AlertDialog alertDialog = alert.create();

                alertDialog.show();
*/
            }
        });



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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menu_search);
       // inflater.inflate(R.menu.menu_add,menu);
        MenuItem item1 = menu.findItem(R.id.menu_add);
        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast.makeText(getBaseContext(),"myname is richard",Toast.LENGTH_LONG).show();


                LayoutInflater factory = LayoutInflater.from(context);
                final View textEntryView = factory.inflate(R.layout.text_entry, null);


                final AlertDialog.Builder alert = new AlertDialog.Builder(context);


                alert.setIcon(R.drawable.myappicon).setTitle("Add new class").setMessage("choose one of these").setView(textEntryView);


                alert .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,"this feature isnt added yet",Toast.LENGTH_LONG).show();

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
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

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




    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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

                newme me = new newme();
                return me;


                case 1:
                    ThirdTab tab3 = new ThirdTab();
                    return tab3;

                case 2:
                    StatisticsTab tab4 = new StatisticsTab();
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
                    return "ROLLCALL";
            }
            return null;
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
