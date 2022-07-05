package com.example.a511.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.example.a511.IntroActivity;
import com.example.a511.R;

public class adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public  adapter(Context context) {
        this.context = context;
    }

    int[] imagesArray = {
            R.raw.fraglottie,
            R.raw.secondfraglottie,
            R.raw.thirdfraglottie
    };

    String[] headingArray = {
      "Say Hello to \n Global Top-Up",
            "Safe, Trusted & \n Fully Secure",
            "Easy to Use"
    };

    String[] descriptionArray = {
            "Send mobile top-up to more than 500 networks in over 140 countries.",
            "Encrypted transactions mean your payments & Privacy and protected.",
            "Pick a number, choose an amount, send your Top-up. Simple."
    };

    @Override
    public int getCount() {
        return headingArray.length;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_screen, container, false);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.lottie);
        LottieAnimationView lottieAnimationView2 = view.findViewById(R.id.lottie2);
        LottieAnimationView lottieAnimationView3 = view.findViewById(R.id.lottie3);
        TextView heading = view.findViewById(R.id.heading);
        TextView description = view.findViewById(R.id.description);

        lottieAnimationView.setAnimation(imagesArray[position]);
        lottieAnimationView2.setAnimation(imagesArray[position]);
        lottieAnimationView3.setAnimation(imagesArray[position]);
        heading.setText(headingArray[position]);
        description.setText(descriptionArray[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}

