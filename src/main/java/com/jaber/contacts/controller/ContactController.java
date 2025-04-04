package com.jaber.contacts.controller;


import com.jaber.contacts.model.Contact;
import com.jaber.contacts.model.User;
import com.jaber.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Contact>> getAllContacts(@PathVariable UUID userId) {
        return ResponseEntity.ok(contactService.getAllContacts(userId));
    }

    @PostMapping("/{userId}/create")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact, @PathVariable UUID userId) {
        System.out.println("Working");
        return ResponseEntity.ok(contactService.createContact(contact, userId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteContact(@RequestBody Contact contact) {
        contactService.deleteContact(contact);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{contactId}")
    public ResponseEntity<Contact> editContact(@RequestBody Contact contact, @PathVariable UUID contactId) {
        Contact updatedContact = contactService.editContact(contact, contactId);
        return ResponseEntity.ok(updatedContact);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContact(@RequestParam String query) {
        return ResponseEntity.ok(contactService.searchContact(query));
    }




}

