package com.example.howtobeastoic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LessonOneFragment extends Fragment {

    private TextView titleTV;
    private TextView contentTV;
    private TextView quoteTV;

    private LessonList lesson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();

        View v = inflater.inflate(R.layout.lesson_fragment, container, false);

        titleTV = (TextView) v.findViewById(R.id.LessonTitleTV);
        contentTV = (TextView) v.findViewById(R.id.LessonContentTV);
        quoteTV = (TextView) v.findViewById(R.id.LessonQuoteTV);

        if (bundle != null) {
            lesson  = bundle.getParcelable("LESSON");

            if (lesson != null)
            {
                titleTV.setText(lesson.getTitle());
                contentTV.setText(lesson.getContent());
                quoteTV.setText(lesson.getQuote());
            }

        }

        return v;
    }

}
