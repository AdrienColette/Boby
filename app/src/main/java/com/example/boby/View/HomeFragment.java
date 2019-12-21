package com.example.boby.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boby.R;
import com.example.boby.Model.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //String[] strings = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12","13","14","15","16", "5", "6", "7","8","9","10","11","12","13","14","15","16"};
    List<Book> lstBook;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // View root = inflater.inflate(R.layout.fragment_home, container, false);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegetarian", "Categorie Book","Description book",R.drawable.album1));
        lstBook.add(new Book("The Jacksonyn", "Categorie Book","Description book",R.drawable.album2));
        lstBook.add(new Book("Bobby Carson", "Categorie Book","Description book",R.drawable.album3));
        lstBook.add(new Book("Blue Brian", "Categorie Book","Description book",R.drawable.album4));
        lstBook.add(new Book("Mandy lane", "Categorie Book","Description book",R.drawable.album5));
        lstBook.add(new Book("Carlton izi", "Categorie Book","Description book",R.drawable.album1));
        lstBook.add(new Book("Le duc", "Categorie Book","Description book",R.drawable.album2));
        lstBook.add(new Book("The Vegetarian", "Categorie Book","Description book",R.drawable.album3));
        lstBook.add(new Book("Blue Brian", "Categorie Book","Description book",R.drawable.album4));
        lstBook.add(new Book("Mandy lane", "Categorie Book","Description book",R.drawable.album5));
        lstBook.add(new Book("Carlton izi", "Categorie Book","Description book",R.drawable.album1));
        lstBook.add(new Book("Le duc", "Categorie Book","Description book",R.drawable.album2));
        lstBook.add(new Book("The Vegetarian", "Categorie Book","Description book",R.drawable.album3));

        RecyclerView myrv = new RecyclerView(getContext());
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(),lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getContext(),3));
        myrv.setAdapter(myAdapter);

        return myrv;
    }
}




        /*        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRVAdapter(strings));
        return rv;
    }

    /**
     * A Simple Adapter for the RecyclerView

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        private String[] dataSource;
        public SimpleRVAdapter(String[] dataArgs){
            dataSource = dataArgs;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = new TextView(parent.getContext());
            SimpleViewHolder viewHolder = new SimpleViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.textView.setText(dataSource[position]);
        }

        @Override
        public int getItemCount() {
            return dataSource.length;
        }
    }

    /**
     * A Simple ViewHolder for the RecyclerView

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
*/