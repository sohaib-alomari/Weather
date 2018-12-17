package sf.alomari.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {

// all the values I am going to need for my recycler View
    public static String [] Icon_ids;
    public  static String [] DateArr;
    public static String [] condition;
    public static String [] highTemp;
    public static String [] lowTemp;




    @NonNull
    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        int LayoutId=R.layout.adapter;
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(LayoutId,viewGroup,false);
        WeatherHolder wHolder=new WeatherHolder( view);

        return wHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherHolder weatherHolder, int position) {

        weatherHolder.bind(position);
    }




    @Override
    public int getItemCount() {
        return 7;
    }










    class WeatherHolder extends RecyclerView.ViewHolder{

        TextView date_xml,desc,hi,lo;

        ImageView img;



        public WeatherHolder(@NonNull View itemView) {
            super(itemView);



            img =(ImageView) itemView.findViewById((R.id.weather_icon));
            date_xml=(TextView)itemView.findViewById(R.id.date_xml);
            desc=(TextView)itemView.findViewById(R.id.condition_xml);
            hi=(TextView)itemView.findViewById(R.id.high_xml);
            lo =(TextView)itemView.findViewById(R.id.low_xml);


        }

        void bind(int positon){

            try {
                String imgPath="http://openweathermap.org/img/w/"+Icon_ids[positon]+".png";

                Picasso.get().load(imgPath).into(img);
                Log.d("imgpath",imgPath);
                date_xml.setText(DateArr[positon]);
                desc.setText(condition[positon]);
                hi.setText(highTemp[positon].substring(0,2));
                lo.setText(lowTemp[positon].substring(0,2));


            } catch (Exception e) {

            }
        }

    }



    public static void  ExtractFeaturesFromJson(String JsonResponse) {
    MainActivity main=new MainActivity();



        try {

            JSONObject jsonObject = new JSONObject(JsonResponse);

            /* Is there an error? */
            if (jsonObject.has("cod")) {
                int errorCode = jsonObject.getInt("cod");

                switch (errorCode) {
                    case HttpURLConnection.HTTP_OK:
                        break;
                    case HttpURLConnection.HTTP_NOT_FOUND:
                        /* Location invalid */

                        break;
                    default:
                        /* Server probably down */
                        break;
                }
            }









            JSONArray jsonArr = jsonObject.getJSONArray("list");



            // initialize the Arrays with the size of the fetched JsonArray
            Icon_ids= new String[jsonArr.length()];
            DateArr= new String[jsonArr.length()];
            condition= new String[jsonArr.length()];
            highTemp= new String[jsonArr.length()];
            lowTemp= new String[jsonArr.length()];
            String DateString="Date";


            for (int i = 0; i < jsonArr.length(); i++) {

                JSONObject listrObj = jsonArr.getJSONObject(i);
                JSONObject mainObj=listrObj.getJSONObject("main");
                JSONArray weatherArr=listrObj.getJSONArray("weather");
                JSONObject finalObj=weatherArr.getJSONObject(0);


                DateString=listrObj.getString("dt_txt");
                String s=DateString.substring(5,10);

                //Parse the Json and add the value to the correspondant Arrays
                highTemp[i]=mainObj.getString("temp_max");
                lowTemp[i]=mainObj.getString("temp_min");
                condition[i]=finalObj.getString("description");
                Icon_ids[i]=finalObj.getString("icon");
                DateArr[i]=DateString.substring(5,10);


            }



        } catch (JSONException e) {

            e.printStackTrace();
        }


    }


}
