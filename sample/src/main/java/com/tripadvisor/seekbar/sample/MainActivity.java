package com.tripadvisor.seekbar.sample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tripadvisor.seekbar.ClockView;

import org.joda.time.DateTime;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final ClockView minDepartTime = (ClockView) rootView.findViewById(R.id.min_depart_time_clock_view);
            DateTime minTime = new DateTime(2014, 4, 25, 7, 0);
            DateTime maxTime = new DateTime(2014, 4, 26, 4, 0);
            minDepartTime.setBounds(minTime, maxTime, false);

            final ClockView maxDepartTime = (ClockView) rootView.findViewById(R.id.max_depart_time_clock_view);
            maxDepartTime.setBounds(minTime, maxTime, true);

            minDepartTime.setClockTimeUpdateListener(new ClockView.ClockTimeUpdateListener() {
                @Override
                public void onClockTimeUpdate(DateTime currentTime) {
                    Log.e("New Current Time :" , String.valueOf(currentTime));
                }
            });


            return rootView;
        }
    }
}
