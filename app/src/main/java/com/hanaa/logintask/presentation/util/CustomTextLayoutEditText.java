package com.hanaa.logintask.presentation.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.hanaa.logintask.R;

public class CustomTextLayoutEditText  extends TextInputEditText {

    public CustomTextLayoutEditText(Context context) {
        super(context);
    }

    public CustomTextLayoutEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextLayoutEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public Drawable getBackground() {
        return ContextCompat.getDrawable(getContext(), R.drawable.input_background);
    }
}
