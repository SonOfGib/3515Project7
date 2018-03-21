package edu.temple.a3515project7;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PaletteFragment.
     */
    public static PaletteFragment newInstance() {
        return new PaletteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_palette, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.paletteGrid);
        //colors White, Red, Blue, Green, Yellow, Purple, Dark Gray, Navy,  Aqua, Lime, Maroon, Olive, Silver, Cyan
        int colors[] = {Color.WHITE,Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.parseColor("#9b42f4"),
                Color.DKGRAY, Color.parseColor("#000080"), Color.parseColor("#7fffd4"),
                Color.parseColor("#32cd32"), Color.parseColor("#b03060"), Color.parseColor("#556b2f"),
                Color.parseColor("#dcdcdc"), Color.CYAN};
        gridView.setAdapter(new PaletteAdapter(getActivity(),colors));
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onColorSelected(int color);
    }
}
