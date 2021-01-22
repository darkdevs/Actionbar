package com.dpouya.pactionbar.Ui.Cell;

import android.content.Context;
import android.graphics.Typeface;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dpouya.pactionbar.Model.PActionbarButton;
import com.dpouya.pactionbar.Ui.Adapter.PActionbarButtonListAdapter;
import com.dpouya.pactionbar.helper.AndroidUtilities;
import com.dpouya.pactionbar.helper.LayoutUtilities;
import com.dpouya.pactionbar.helper.SpacesItemDecoration;


/**
 * Created by pouyadark on 2/23/19.
 */

public class PActionbarButtonListCell extends RecyclerView {
    private final Typeface typeface;
    private PActionbarButtonListAdapter adapter;

    public PActionbarButtonListCell(Context context, Typeface typeface) {
        super(context);
        this.typeface = typeface;
        init();
    }

    private void init() {
        setLayoutParams(LayoutUtilities.createFrame(LayoutUtilities.WRAP_CONTENT,LayoutUtilities.MATCH_PARENT));
        adapter = new PActionbarButtonListAdapter(getContext(),typeface);
        setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        addItemDecoration(new SpacesItemDecoration(AndroidUtilities.dp5,AndroidUtilities.dp5,0,0));
        setAdapter(adapter);

    }
    public void addItem(PActionbarButton actionbarButton){
        adapter.addItem(actionbarButton);
    }

    public void ClearButtons() {
        adapter.ClearButtons();
    }
}
