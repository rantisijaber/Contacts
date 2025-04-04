package com.jaber.contacts.model;


import com.jaber.contacts.config.AESEncryptionConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contactId;

    @Convert(converter = AESEncryptionConverter.class)
    @Column(name = "first_name")
    private String firstName;

    @Convert(converter = AESEncryptionConverter.class)
    @Column(name = "last_name")
    private String lastName;

    @Convert(converter = AESEncryptionConverter.class)
    private String email;

    @Convert(converter = AESEncryptionConverter.class)
    @Column(name = "phone_number")
    private String phone;

    @Convert(converter = AESEncryptionConverter.class)
    @Column(name = "street_address")
    private String address;

    @Convert(converter = AESEncryptionConverter.class)
    private String city;

    @Convert(converter = AESEncryptionConverter.class)
    private String state;

    @Convert(converter = AESEncryptionConverter.class)
    private String notes;

    @Column(name = "profile_picture_url")
    private String picture;

    @Column(name = "user_id")
    private UUID userId;
}
