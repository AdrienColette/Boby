package com.example.boby.Model;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SmileViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SmileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("\n\n\n* BOOKIX *\n" + "-------------\n\n" + "App made by Adrien Colette\n" + "-------------------------------------------\n\n"+"4A , FSI2\n" + "-------------\n\n" +
                "ESIEA , Années : 2019/2020\n" + "-------------------------------------------\n\n\n" + "----- !   Q('_'Q )   ! -----");

    }

    public LiveData<String> getText() {
        return mText;
    }
}