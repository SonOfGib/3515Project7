package edu.temple.a3515project7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Custom adapter that changes the TextView background to the color of the text it contains.
 * Created by Sean Gibson on 2/13/2018.
 */
public class PaletteAdapter extends BaseAdapter{

    static final String SELECTED_COLOR = "SELECTED_COLOR";

    private int[] colors;
    private Context context;

    PaletteAdapter(@NonNull Context context, @NonNull int[] colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount(){
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TextView(context);
        }
        final int color = colors[i];
        TextView textView = (TextView) view;
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
        Resources res = context.getResources();
        String[] labels = res.getStringArray(R.array.grid_array);
        textView.setText(labels[i]);
        textView.setBackgroundColor(color);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaletteFragment.OnFragmentInteractionListener mListener;
                if (context instanceof PaletteFragment.OnFragmentInteractionListener) {
                    mListener = (PaletteFragment.OnFragmentInteractionListener) context;
                } else {
                    throw new RuntimeException(context.toString()
                            + " must implement OnFragmentInteractionListener");
                }
                mListener.onColorSelected(color);
                Log.d("color", ""+color);
            }
        });
        return textView;
    }
}
