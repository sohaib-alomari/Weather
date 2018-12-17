package sf.alomari.weather;

import android.os.AsyncTask;
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

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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


        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_forecast);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        searchButton=(Button)findViewById(R.id.search_button);
        searchText=(EditText)MainActivity.this.findViewById(R.id.search_box);

        searchButton.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {

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

