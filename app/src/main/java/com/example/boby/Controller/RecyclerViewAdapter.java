package com.example.boby.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.boby.R;
import com.example.boby.View.BookActivity;
import com.example.boby.Model.Book;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    RequestOptions option;
    private List<Book> listBook;

    public RecyclerViewAdapter(Context mContext, List<Book> listBook) {
        this.mContext = mContext;
        this.listBook = listBook;

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(listBook.get(position).getTitle());
        Glide.with(mContext).load(listBook.get(position).getThumbnailUrl()).apply(option).into(holder.img_book_thumbnail);


        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, BookActivity.class);

                intent.putExtra("Title",listBook.get(position).getTitle());
                intent.putExtra("ThumbnailUrl",listBook.get(position).getThumbnailUrl());
                intent.putExtra("LongDescription",listBook.get(position).getLongDescription());
                intent.putExtra("Status",listBook.get(position).getStatus());

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;
        TextView tvstat;
        TextView tvdesc;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            tvstat = (TextView) itemView.findViewById(R.id.txtstat);
            tvdesc = (TextView) itemView.findViewById(R.id.txtdesc);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
