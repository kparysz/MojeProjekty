package fieldofviewwidening;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.groundzeroapp.Pyramids;
import com.example.android.groundzeroapp.R;


public class FieldOfViewFragment extends Fragment {

    ImageView firstGrid;

    public FieldOfViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_field_of_view, container, false);
        firstGrid = (ImageView) view.findViewById(R.id.field_of_view_grid_one);
        firstGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Pyramids.class));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.v("MILTEK", "onAttach FieldOf");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v("MILTEK", "onCreate FieldOf");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v("MILTEK", "onCreateView FieldOf");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.v("MILTEK", "onActCreated FieldOf");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.v("MILTEK", "onStart FieldOf");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.v("MILTEK", "onResume FieldOf");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v("MILTEK", "onPause FieldOf");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.v("MILTEK", "onStop FieldOf");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.v("MILTEK", "onDestroyView FieldOf");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.v("MILTEK", "onDestroy FieldOf");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.v("MILTEK", "onDetach FieldOf");
        super.onDetach();
    }
}
























