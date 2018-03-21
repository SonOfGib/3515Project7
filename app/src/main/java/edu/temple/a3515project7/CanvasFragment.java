package edu.temple.a3515project7;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {
    final static String ARG_COLOR = "color";
    int mColor = Color.WHITE;

    public CanvasFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CanvasFragment.
     */
    public static CanvasFragment newInstance() {
        return new CanvasFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mColor = (int) savedInstanceState.get(ARG_COLOR);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mColor = (int) savedInstanceState.get(ARG_COLOR);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            mColor = (int) savedInstanceState.get(ARG_COLOR);
        }
        if(getArguments() != null) {
            mColor = (int) getArguments().get(ARG_COLOR);
        }
        View rootView = inflater.inflate(R.layout.fragment_canvas, container, false);
        rootView.setBackgroundColor(mColor);
        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt(ARG_COLOR, mColor);
    }

    public void updateBackgroundColor(int color) {
        this.getView().setBackgroundColor(color);
    }
}
