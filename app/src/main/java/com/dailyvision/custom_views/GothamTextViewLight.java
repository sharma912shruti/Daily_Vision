package com.dailyvision.custom_views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Created by ssharma on 04,January,2019
 **/
public class GothamTextViewLight extends AppCompatTextView {
    public GothamTextViewLight(Context context) {
        super(context);
        init();
    }

    public GothamTextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GothamTextViewLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        setTypeface(TypeFaces.getTypeFace(getContext(),
                "fonts/Gotham-Light.ttf"));
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(focused)
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        if(focused)
            super.onWindowFocusChanged(focused);
    }


    @Override
    public boolean isFocused() {
        return true;
    }
}
