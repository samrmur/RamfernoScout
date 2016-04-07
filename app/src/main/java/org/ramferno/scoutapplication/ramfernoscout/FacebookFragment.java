package org.ramferno.scoutapplication.ramfernoscout;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//A simple {@link Fragment} subclass.
public class FacebookFragment extends Fragment {

    public FacebookFragment() {
        // Required empty public constructor
    } //End of FacebookFragment

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //Declares fragment that the website will be displayed on
        View rootView = inflater.inflate(R.layout.fragment_facebook_fragment, container, false);

        //Disables Orientation
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Declares WebView in fragment the website will be displayed on, enables JavaScript on website and gets the URL.
        WebView facebookGroup = (WebView) rootView.findViewById(R.id.facebookView);
        facebookGroup.setWebViewClient(new facebookStay());
        WebSettings webSettings = facebookGroup.getSettings();
        webSettings.setJavaScriptEnabled(true);
        facebookGroup.loadUrl("https://m.facebook.com/groups/136897116365659/");

        //Returns value(s) to fragment
        return rootView;
    } //End of onCreateView

    private class facebookStay extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        } //End of boolean
    }  //End of facebookStay
} //End of class