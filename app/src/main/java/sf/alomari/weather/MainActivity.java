package sf.alomari.weather;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WeatherAdapter adapter;
    Button searchButton;
    EditText searchText;
    String cityName;
    private RecyclerView recyclerView;
    private ProgressBar mLoadingIndicator;

    private  String Weather_URL ="http://api.openweathermap.org/data/2.5/forecast?q="+String.valueOf(cityName)+"&appid=d7c871940c676a6d8df322f124cc90a0&units=imperial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_forecast);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        searchButton = (Button) findViewById(R.id.search_button);
        searchText = (EditText) MainActivity.this.findViewById(R.id.search_box);

        searchButton.setOnClickListener(this);


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }











    @Override
    public void onClick(View view) {

        // Show spinner when starting the search
        mLoadingIndicator.setVisibility(View.VISIBLE);

        ///get the city name from EditText
        cityName = searchText.getText().toString();

        //Start a background task using AsynkTask
        new WeatherQuery().execute();

        //Hide the RecyclerView when starting a new search
        recyclerView.setVisibility(View.INVISIBLE);
    }


    public class WeatherQuery extends AsyncTask<URL, Void, String> {


        @Override
        protected String doInBackground(URL... urls) {
            String result = null;

            try {

                Log.d("citys", cityName);
                String postCity = cityName;

                // had to hardCode the URL because when i defined it as a Global variable it would Not take the city name from the EditBox, i looked it up on Stack overflow
                //people are saying it's some kind of bug in EditText.
                result = NetworkUtils.run("http://api.openweathermap.org/data/2.5/forecast?q=" + postCity + "&appid=d7c871940c676a6d8df322f124cc90a0&units=imperial");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            String postCity = cityName;

            Log.d("ReturnString", s + " " + postCity + "   " + Weather_URL);

            String result = s;
            WeatherAdapter.ExtractFeaturesFromJson(result);
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

            adapter = new WeatherAdapter();


            recyclerView.setAdapter(adapter);


        }

    }
}

