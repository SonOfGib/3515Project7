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

        //  Load palette fragment by default

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.paletteFragment, new PaletteFragment()).commit();

        /*
         *  Check if details pain is visible in current layout (e.g. large or landscape)
         *  and load fragment if true.
         */
        if (twoPanes){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.canvasFragment, new CanvasFragment()).commit();
        }

    }

    @Override
    public void onColorSelected(int color) {

        if(twoPanes) {
            CanvasFragment canvasFragment = (CanvasFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.canvasFragment);
            canvasFragment.updateBackgroundColor(color);
        }
        else{
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
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
