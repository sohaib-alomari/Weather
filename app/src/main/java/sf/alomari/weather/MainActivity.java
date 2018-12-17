package sf.alomari.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WeatherAdapter adapter;
    Button searchButton;
    EditText searchText;
    String cityName;
    private RecyclerView recyclerView;
    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public class WeatherQuery extends AsyncTask<URL,Void ,String>
    {

        @Override
        protected String doInBackground(URL... urls) {
             return null;
        }


        @Override
        protected void onPostExecute(String s) {





        }
    }

}

