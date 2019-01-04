package com.dailyvision.custom_views;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by ssharma on 04,January,2019
 **/
public class GothamTextViewBook extends AppCompatTextView {
    public GothamTextViewBook(Context context) {
        super(context);
        init();
    }

    public GothamTextViewBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GothamTextViewBook(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        setTypeface(TypeFaces.getTypeFace(getContext(),
                "fonts/GothamBook.ttf"));
    }
}
