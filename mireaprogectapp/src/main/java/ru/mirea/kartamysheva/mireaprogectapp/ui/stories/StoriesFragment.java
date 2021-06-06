package ru.mirea.kartamysheva.mireaprogectapp.ui.stories;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.kartamysheva.mireaprogectapp.R;

public class StoriesFragment extends Fragment implements MyDialogFragment.OnInputSelected {

    private StoriesViewModel mViewModel;
    private static final String TAG = "StoriesFragment";
    public Button fab;

    public static StoriesFragment newInstance() {
        return new StoriesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.stories_fragment, container, false);

        fab = root.findViewById(R.id.buttonDialog);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(getActivity().getSupportFragmentManager(), "MyDialogFragment");
            }
        });
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StoriesViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void sendInput() {
        Log.d(TAG, "sendInput: FIND");
    }
}