package com.kirabium.gegemail.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kirabium.gegemail.viewmodel.MailViewModel;
import com.kirabium.gegemail.R;
import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private ArrayList<Mail> mails = new ArrayList<>();
    MailViewModel mailViewModel;
    private RecyclerView mRecyclerView;

    private void initData(){
        mailViewModel = new ViewModelProvider(requireActivity()).get(MailViewModel.class);
        mailViewModel.getMutableLiveData().observe(requireActivity(), mail -> {
            mails.clear();
            mails.addAll(mail);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        });
    }

    private void initRecyclerView(View root) {
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        NotificationAdapter mAdapter = new NotificationAdapter(mails);
        // Set CustomAdapter as the adapter for RecyclerView.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        initRecyclerView(root);
        initData();
        return root;
    }
}