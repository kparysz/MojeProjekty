package fieldofviewwidening;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.groundzeroapp.R;


public class FieldOfViewFragment extends Fragment {


    public FieldOfViewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_field_of_view, container, false);
    }

}
