package com.dpouya.pactionbar.Ui.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;

import com.dpouya.pactionbar.Model.PActionbarButton;
import com.dpouya.pactionbar.Ui.Cell.PActionbarButtonCell;

import java.util.ArrayList;



/**
 * Created by pouyadark on 2/23/19.
 */

public class PActionbarButtonListAdapter extends RecyclerView.Adapter<PActionbarButtonListAdapter.ViewHolder> {
    ArrayList<PActionbarButton> actionbarButtons=new ArrayList<>();
    Context mContext;
    Typeface typeface;

    public PActionbarButtonListAdapter(Context mContext, Typeface typeface) {
        this.mContext = mContext;
        this.typeface = typeface;
    }

    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(new PActionbarButtonCell(mContext,typeface));
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        ((PActionbarButtonCell)holder.itemView).setPActionbarButton(actionbarButtons.get(position));
    }

    @Override
    public int getItemCount() {
        return actionbarButtons.size();
    }

    public void addItem(PActionbarButton actionbarButton){
        actionbarButtons.add(actionbarButton);
        notifyDataSetChanged();
    }

    public void ClearButtons() {
        actionbarButtons.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
