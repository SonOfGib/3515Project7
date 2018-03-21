package edu.temple.a3515project7;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {
    boolean twoPanes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Determine if only one or two panes are visible
        twoPanes = (findViewById(R.id.canvasFragment) != null);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.paletteFragment, new PaletteFragment()).commit();

        if (twoPanes){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.canvasFragment, new CanvasFragment()).commit();
        }

    }

    @Override
    public void onColorSelected(int color) {

        if(twoPanes) {
            //In the single frag view, just update the color.
            CanvasFragment canvasFragment = (CanvasFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.canvasFragment);
            canvasFragment.updateBackgroundColor(color);
        }
        else{
            // We're in the one-pane layout and must swap frags...

            CanvasFragment newFragment = new CanvasFragment();
            Bundle args = new Bundle();
            args.putInt(CanvasFragment.ARG_COLOR, color);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.paletteFragment, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}
