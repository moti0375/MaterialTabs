package com.bartovapps.materialtabs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartovapps.materialtabs.R;
import com.bartovapps.materialtabs.utils.Utils;

/**
 * Created by BartovMoti on 11/23/16.
 */
public class TextPageFragment extends Fragment {

    TextView tvTitle;
    TextView tvSubtitle;
    TextView tvContent;

    public TextPageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.text_page_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        tvSubtitle = (TextView)view.findViewById(R.id.tvSubtitle);
        tvContent = (TextView)view.findViewById(R.id.tvContent);

        String title = getArguments().getString(Utils.JSON_TITLE);
        tvTitle.setText(title);

        String subtitle = getArguments().getString(Utils.JSON_SUBTITLE, null);
        if(subtitle != null){
            tvSubtitle.setText(subtitle);
        }

        String content = getArguments().getString(Utils.JSON_CONTENT);
        tvContent.setText(content);
    }
}
