package com.bartovapps.materialtabs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartovapps.materialtabs.R;
import com.bartovapps.materialtabs.utils.Utils;
import com.squareup.picasso.Picasso;

/**
 * Created by BartovMoti on 11/23/16.
 */
public class ImagePageFragment extends Fragment {

    private TextView tvTitle;
    private TextView tvSubtitle;
    private ImageView ivImage;

    public ImagePageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_page_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        tvSubtitle = (TextView)view.findViewById(R.id.tvSubtitle);
        ivImage = (ImageView) view.findViewById(R.id.ivImage);

        tvTitle.setText(getArguments().getString(Utils.JSON_TITLE));
        String subtitle = getArguments().getString(Utils.JSON_SUBTITLE);
        if(subtitle != null){
            tvSubtitle.setText(subtitle);
        }

        Picasso.with(getActivity()).load(getArguments().getString(Utils.JSON_CONTENT_URL)).error(R.mipmap.ic_launcher).into(ivImage);


    }
}
