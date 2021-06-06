package ru.mirea.kartamysheva.mireaprogectapp.ui.music;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.kartamysheva.mireaprogectapp.R;

public class MusicFragment extends Fragment {

    private MusicViewModel mViewModel;
    private PlayerService playerService;
    private Button btnPlay;
    private Button btnStop;

    public static MusicFragment newInstance() {
        return new MusicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MusicViewModel.class);
        playerService = new PlayerService();
        View root = inflater.inflate(R.layout.music_fragment, container, false);

        btnPlay = root.findViewById(R.id.buttonPlay);
        btnStop = root.findViewById(R.id.buttonStop);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MEOW", "НАЖАЛА И ВСЕ ИСЧЕЗЛО");
                getActivity().startService(
                        new Intent(getActivity(), PlayerService.class)
                );
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(
                        new Intent(getActivity(), PlayerService.class)
                );
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MusicViewModel.class);
        // TODO: Use the ViewModel
    }


}