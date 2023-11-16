package com.example.loadjsondata_java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>
        implements JsonAsyncTask.JsonAsyncTaskListener {
    List<Character> characters;
    private final LayoutInflater mInflater;

    public MyRecyclerViewAdapter(Context context) {
        this.characters = new ArrayList<>();
        this.mInflater = LayoutInflater.from(context);
        new JsonAsyncTask(this).execute();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.tvName.setText(character.getName());
        holder.tvGender.setText("Gender: "+character.getGender());
        holder.tvBirthday.setText("Birthday: "+character.getBirthday());
        holder.tvrarity.setText("Rarity: "+ character.getRarityAsString());
        holder.tvVision.setText("Vision: "+character.getVision());
        holder.tvWeapon.setText("Weapon: "+character.getWeapon());
        holder.tvDescription.setText("Description: "+character.getDescription());
    }

    @Override
    public int getItemCount() {
        if(characters != null) {
            return characters.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onJsonDownloaded(List<Character> data) {
        characters.clear();
        characters.addAll(data);

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvGender;
        TextView tvBirthday;
        TextView tvVision;
        TextView tvWeapon;
        TextView tvDescription;

        TextView tvrarity;
        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvname);
            tvGender = itemView.findViewById(R.id.tvgender);
            tvBirthday = itemView.findViewById(R.id.tvbirthday);
            tvVision = itemView.findViewById(R.id.tvvision);
            tvrarity = itemView.findViewById(R.id.tvrarity);
            tvWeapon = itemView.findViewById(R.id.tvweapon);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}

