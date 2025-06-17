package com.buidangnguyen.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.buidangnguyen.model.Food;
import com.buidangnguyen.test.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    Activity context;
    int layout;
    List<Food> foodList;

    public FoodAdapter(Activity context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtTitle, txtDesc, txtRating, txtPromo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.imgItem = convertView.findViewById(R.id.imgItem);
            holder.txtTitle = convertView.findViewById(R.id.txtTitle);
            holder.txtDesc = convertView.findViewById(R.id.txtDesc);
            holder.txtRating = convertView.findViewById(R.id.txtRating);
            holder.txtPromo = convertView.findViewById(R.id.txtPromo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Food food = foodList.get(position);
        holder.imgItem.setImageResource(food.getImageResId());
        holder.txtTitle.setText(food.getName());
        holder.txtDesc.setText(food.getDescription());
        holder.txtRating.setText("⭐ " + food.getRating() + " (" + food.getReview() + ")");
        holder.txtPromo.setVisibility(food.isPromo() ? View.VISIBLE : View.GONE);

        convertView.setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog_food_detail);

            ImageView img = dialog.findViewById(R.id.imgDialog);
            TextView name = dialog.findViewById(R.id.txtDialogName);
            TextView rating = dialog.findViewById(R.id.txtDialogRating);
            TextView address = dialog.findViewById(R.id.txtDialogAddress);

            img.setImageResource(food.getImageResId());
            name.setText(food.getName());
            rating.setText("⭐ " + food.getRating());
            address.setText(food.getAddress());

            dialog.show();
        });

        return convertView;
    }
}