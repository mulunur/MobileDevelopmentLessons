package ru.mirea.kartamysheva.mireaprogectapp.ui.stories;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.mirea.kartamysheva.mireaprogectapp.R;

public class MyDialogFragment extends androidx.fragment.app.DialogFragment {

    public interface OnInputSelected{
        void sendInput();
    }

    public OnInputSelected onInputSelected;
    private static final String TAG = "MyDialogFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.dialog_fragment, container, false);

        Button buttonSaveNote = (Button) root.findViewById(R.id.buttonSaveNote);
        EditText editTextNote = root.findViewById(R.id.editTextNote);
        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note =editTextNote.getText().toString();
                Log.d("TAG", note);
                onInputSelected.sendInput();
                //listener.applyNote();
                //StoriesFragment storiesFragment = (StoriesFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_stories);
                //Log.d("TAG", storiesFragment.isInLayout() + "");
                //storiesFragment.fab.setText("JERE");
            }

        });
        getDialog().dismiss();
        return root;
    }

   @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onInputSelected = (OnInputSelected) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement");
        }
    }

    public interface MyDialogFragmentListener{
        void applyNote();
    }
}
