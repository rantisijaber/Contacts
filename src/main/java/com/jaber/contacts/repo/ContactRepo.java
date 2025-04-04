package com.jaber.contacts.repo;


import com.jaber.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepo extends JpaRepository<Contact, UUID> {


    List<Contact> findAllByUserId(UUID userId);


    @Query("SELECT c FROM Contact c WHERE" + " lower(c.firstName) LIKE lower(CONCAT('%', :query, '%')) or " +
    "lower(c.lastName) like lower(concat('%', :query, '%')) or " +
    "lower(c.email) like lower(concat('%', :query, '%')) or " +
    "lower(c.phone) like lower(concat('%', :query, '%'))")
    List <Contact> searchContact(String query);
}
