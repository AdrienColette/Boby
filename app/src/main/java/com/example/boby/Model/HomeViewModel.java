package com.example.boby.Model;

import android.provider.MediaStore;
import android.view.View;
import android.view.LayoutInflater;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.boby.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private View mview;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}