package speedreadingtests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.groundzeroapp.R;

public class SpeedReadingTests extends Fragment {


    public SpeedReadingTests() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speed_reading_tests, container, false);
    }

}
