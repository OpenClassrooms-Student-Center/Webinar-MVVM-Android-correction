package com.kirabium.gegemail.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kirabium.gegemail.viewmodel.MailViewModel;
import com.kirabium.gegemail.R;

public class HomeFragment extends Fragment {

    TextView textView;
    MailViewModel mailViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);
        updateUI();
        return root;
    }

    private void updateUI() {
        mailViewModel = new ViewModelProvider(requireActivity()).get(MailViewModel.class);
        mailViewModel.getMutableLiveData().observe(requireActivity(), mail -> {
            String text = "Vous avez " + mail.size() + " mail" + (mail.size() > 1 ? "s" : "");
            textView.setText(text);
        });
    }

}