package com.example.boby.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.boby.Controller.RecyclerViewAdapter;
import com.example.boby.Model.Book;
import com.example.boby.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {

    private final String JSON_URL = "https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Book> listBook;
    private RecyclerView recyclerView;


    public BookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listBook = new ArrayList<>();
        recyclerView = root.findViewById(R.id.recyclerview_id);

        jsonrequest();

        return root;
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
                        book.setLongDescription(jsonObject.getString("longDescription"));
                        book.setStatus(jsonObject.getString("status"));
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
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(myadapter);

    }
}