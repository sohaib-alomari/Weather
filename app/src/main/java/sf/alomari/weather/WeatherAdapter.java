package sf.alomari.weather;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder>{


    @NonNull
    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherHolder weatherHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WeatherHolder extends RecyclerView.ViewHolder{

         public WeatherHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
