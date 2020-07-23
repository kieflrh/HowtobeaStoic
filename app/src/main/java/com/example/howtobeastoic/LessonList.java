package com.example.howtobeastoic;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;


public class LessonList implements Parcelable {


    private String m_title;
    private String m_content;
    private String m_quote;
    private int m_iconID;

    private String nameSTR;


    public LessonList( String title, String content, String quote, int icon) {
        super();
        this.m_content = content;
        this.m_title = title;
        this.m_quote = quote;
        this.m_iconID = icon;
    }

    protected LessonList(Parcel in) {
        m_title = in.readString();
        m_content = in.readString();
        m_quote = in.readString();
        m_iconID = in.readInt();
    }

    public static final Creator<LessonList> CREATOR = new Creator<LessonList>() {
        @Override
        public LessonList createFromParcel(Parcel in) {
            return new LessonList(in);
        }

        @Override
        public LessonList[] newArray(int size) {
            return new LessonList[size];
        }
    };

    public String getTitle() { return m_title; }

    public String getContent() { return m_content; }

    public String getQuote() {return m_quote; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_title);
        dest.writeString(m_content);
        dest.writeString(m_quote);
        dest.writeInt(m_iconID);
    }

}
