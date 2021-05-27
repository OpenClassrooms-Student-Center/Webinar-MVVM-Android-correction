package com.kirabium.gegemail.service;


import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyMailApiService implements MailApiService {

    private final ArrayList<Mail> mails = DummyMailGenerator.generateMails();


    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Mail> getMails() {
        return mails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMail(Mail mail) {
        mails.remove(mail);
    }

    /**
     * {@inheritDoc}
     * @param mail
     */
    @Override
    public void createMail(Mail mail) {
        mails.add(mail);
    }
}
