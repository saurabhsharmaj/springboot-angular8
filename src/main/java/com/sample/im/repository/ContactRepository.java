package com.sample.im.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.im.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
