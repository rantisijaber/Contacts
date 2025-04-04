package com.jaber.contacts.service;


import com.jaber.contacts.model.Contact;
import com.jaber.contacts.model.User;
import com.jaber.contacts.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    ContactRepo contactRepo;

    public List<Contact> getAllContacts(UUID userId) {
        return contactRepo.findAllByUserId(userId);
    }

    public Contact createContact(Contact contact, UUID userId) {
        // add s3 capability ex. if contact.getPicture != null save to bucket
        contact.setUserId(userId);
        return contactRepo.save(contact);
    }

    public void deleteContact(Contact contact) {
        contactRepo.delete(contact);

    }

    public Contact editContact(Contact contact, UUID contactId) {
            return contactRepo.findById(contactId).map(oldContact -> {
                if (contact.getFirstName() != null) oldContact.setFirstName(contact.getFirstName());
                if (contact.getLastName() != null) oldContact.setLastName(contact.getLastName());
                if (contact.getEmail() != null) oldContact.setEmail(contact.getEmail());
                if (contact.getPhone() != null) oldContact.setPhone(contact.getPhone());
                if (contact.getCity() != null) oldContact.setCity(contact.getCity());
                if (contact.getState() != null) oldContact.setState(contact.getState());
                if (contact.getNotes() != null) oldContact.setNotes(contact.getNotes());
                if (contact.getPicture() != null) oldContact.setPicture(contact.getPicture());

                return contactRepo.save(oldContact);
            }).orElseThrow(() -> new RuntimeException("Contact not found"));
        }

    public List<Contact> searchContact(String keyword) {
        return contactRepo.searchContact(keyword);

    }


}
