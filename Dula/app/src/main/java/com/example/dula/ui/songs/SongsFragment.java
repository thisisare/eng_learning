package com.example.dula.ui.songs;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dula.DialogActivity;
import com.example.dula.R;
import com.example.dula.databinding.FragmentSongsBinding;
import com.google.android.material.card.MaterialCardView;

public class SongsFragment extends Fragment {
    private ProgressBar spinner;
    private FragmentSongsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_songs, container, false);

        WebView webView = myView.findViewById(R.id.webview1);
        spinner = (ProgressBar)myView.findViewById(R.id.progressBar11);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.loadUrl("https://www.amalgama-lab.com/");
        //WebViewClient webViewClient = new WebViewClient() {
        //    @SuppressWarnings("deprecation")
        //    //@Override
        //    public boolean shouldOverrideUrlLoadings(WebView view, String url) {
        //        view.loadUrl(url);
        //        return true;
        //    }
//
        //    @TargetApi(Build.VERSION_CODES.N)
        //    //@Override
        //    public boolean shouldOverrideUrlLoadings(WebView view, WebResourceRequest request) {
        //        view.loadUrl(request.getUrl().toString());
        //        return true;
        //    }
        //};
        //webView.setWebViewClient(webViewClient);

        return myView;
    }
    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            webview.setVisibility(webview.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            spinner.setVisibility(View.GONE);

            view.setVisibility(WebView.VISIBLE);
            super.onPageFinished(view, url);

        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}