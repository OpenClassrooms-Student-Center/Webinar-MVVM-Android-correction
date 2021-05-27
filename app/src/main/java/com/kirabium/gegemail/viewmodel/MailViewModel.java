package com.kirabium.gegemail.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kirabium.gegemail.model.Mail;
import com.kirabium.gegemail.repositories.MailRepository;

import java.util.ArrayList;

public class MailViewModel extends ViewModel {

    MailRepository mailRepository;
    ArrayList<Mail> mails;
    MutableLiveData<ArrayList<Mail>> mutableLiveData;

    public MutableLiveData<ArrayList<Mail>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void fetchMails(){
        mails = new ArrayList<>(mailRepository.getMails());
        mutableLiveData.setValue(mails);
    }

    public void deleteMail(Mail mail){
        mailRepository.deleteMail(mail);
        mails.remove(mail);
        mutableLiveData.setValue(mails);
    }

    public void addMail(Mail mail){
        mailRepository.addMail(mail);
        mails.add(mail);
        mutableLiveData.setValue(mails);
    }

    public MailViewModel(){
        mailRepository = new MailRepository();
        mutableLiveData = new MutableLiveData<>();
    }
}
