package com.example.boby.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.boby.R;
import com.example.boby.Model.HomeViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private final String JSON_URL = "https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Book> listBook;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    // private GridLayoutManager mLayoutManager;

    // List<Book> lstBook;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);



        // listBook.add(new Book("The Vegetarian", "Categorie Book","Description book","eeeee"));
        //recyclerView = (RecyclerView)root.findViewById(R.id.recyclerview_id);
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        //setuprecyclerview(listBook);

        listBook = new ArrayList<>();
        recyclerView = root.findViewById(R.id.recyclerview_id);

        // LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        // recyclerview.setLayoutManager(layoutManager);
        //mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        // recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        // recyclerview.setLayoutManager(new GridLayoutManager(getContext(),3));
        // listBook = new ArrayList<>();
        // RecyclerViewAdapter myadapter = new RecyclerViewAdapter(getContext(), listBook);
        // recyclerview.setAdapter(myadapter);

        jsonrequest();
        return root;


        /* lstBook = new ArrayList<>();
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


        listBook = new ArrayList<>();
        RecyclerView myrv = new RecyclerView(getContext());
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(getContext(), listBook);
        myrv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        myrv.setAdapter(myadapter);
        jsonrequest();
        return myrv; */
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Book book = new Book();
                        book.setTitle(jsonObject.getString("title"));
                        book.setThumbnailUrl(jsonObject.getString("thumbnailUrl"));
                        listBook.add(book);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(listBook);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }

        });

        requestQueue = Volley.newRequestQueue(getContext().getApplicationContext());
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Book> listBook) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(getContext(),listBook);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myadapter);

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