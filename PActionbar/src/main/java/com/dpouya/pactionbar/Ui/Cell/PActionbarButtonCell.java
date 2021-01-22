package com.dpouya.pactionbar.Ui.Cell;

import android.content.Context;

import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dpouya.pactionbar.Model.PActionbarButton;
import com.dpouya.pactionbar.R;
import com.dpouya.pactionbar.helper.LayoutUtilities;


/**
 * Created by pouyadark on 2/23/19.
 */

public class PActionbarButtonCell extends LinearLayout implements View.OnClickListener {
    private PActionbarButton pactionbarButton;
    private ImageView imageView;
    private TextView txtTitle;
    private Typeface typeface;

    public PActionbarButtonCell(Context context, Typeface typeface) {
        super(context);
        this.typeface=typeface;
        init();
    }

    private void init() {
        setLayoutParams(LayoutUtilities.createFrame(LayoutUtilities.WRAP_CONTENT,LayoutUtilities.MATCH_PARENT));
        setOrientation(HORIZONTAL);
        setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.pactionbar_button_background));
        txtTitle=new TextView(getContext());
        txtTitle.setTextColor(0xffffffff);
        txtTitle.setTypeface(this.typeface);
        txtTitle.setVisibility(GONE);
        txtTitle.setLines(1);
        txtTitle.setMaxLines(1);
        txtTitle.setGravity(Gravity.CENTER);
        txtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        addView(txtTitle, LayoutUtilities.createLinear(50,LayoutUtilities.MATCH_PARENT));
        imageView=new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(GONE);
        addView(imageView,LayoutUtilities.createLinear(30,30,Gravity.CENTER_VERTICAL));
        setOnClickListener(this);
    }

    public void setPActionbarButton(PActionbarButton pactionbarButton) {
        this.pactionbarButton = pactionbarButton;
        if(pactionbarButton.title==null) {
            txtTitle.setVisibility(GONE);
        }else{
            txtTitle.setText(pactionbarButton.title);
            txtTitle.setVisibility(VISIBLE);
        }
        imageView.setImageDrawable(pactionbarButton.drawable);

        if(pactionbarButton.drawable!=null) {
            imageView.setVisibility(VISIBLE);
        }else{
            imageView.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View view) {
        pactionbarButton.onClickListener.onClick(view);
    }
}
