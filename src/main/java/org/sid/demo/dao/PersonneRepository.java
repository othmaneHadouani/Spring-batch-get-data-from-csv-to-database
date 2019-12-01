package org.sid.demo.dao;

import org.sid.demo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;


public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
