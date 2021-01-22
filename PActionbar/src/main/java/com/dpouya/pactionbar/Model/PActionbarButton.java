package com.dpouya.pactionbar.Model;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by pouyadark on 2/23/19.
 */

public class PActionbarButton {
    public String title;
    public Drawable drawable;
    public View.OnClickListener onClickListener;

    public PActionbarButton(String title, Drawable drawable, View.OnClickListener onClickListener) {
        this.title = title;
        this.drawable = drawable;
        this.onClickListener = onClickListener;
    }
}
