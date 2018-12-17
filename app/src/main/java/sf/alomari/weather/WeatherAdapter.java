package sf.alomari.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder>{


    //All the Arrays I am going to need to parse the Json

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
    public void onBindViewHolder(@NonNull WeatherHolder weatherHolder, int i) {

    }

    @Override
    public int getItemCount() {
        //chose 7 to display a whole week
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
    }

}
