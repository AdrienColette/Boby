package com.example.boby.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.boby.Model.HomeViewModel;
import com.example.boby.R;
import com.example.boby.View.Book;
import com.example.boby.Book_Activity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    RequestOptions option;
    private List<Book> listBook;

    public RecyclerViewAdapter(Context mContext, List<Book> listBook) {
        this.mContext = mContext;
        this.listBook = listBook;

        // Request option Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.color_ic_launcher).error(R.drawable.color_ic_launcher);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(listBook.get(position).getTitle());
        Glide.with(mContext).load(listBook.get(position).getThumbnailUrl()).apply(option).into(holder.img_book_thumbnail);

        // holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnailUrl());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Book_Activity.class);

                intent.putExtra("Title",listBook.get(position).getTitle());
                intent.putExtra("Description",listBook.get(position).getShortDescription());
                intent.putExtra("Thumbnail",listBook.get(position).getThumbnailUrl());

                mContext.startActivity(intent);

            }
        });
        // Set click Listener
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
