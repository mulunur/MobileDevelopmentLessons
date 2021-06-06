package ru.mirea.kartamysheva.mireaprogectapp.ui.webview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebViewViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WebViewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is webView fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}