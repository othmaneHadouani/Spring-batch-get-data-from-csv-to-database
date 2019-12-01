package org.sid.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Personne implements Serializable {

    @Id
     private Long id;
     private String nom;
     private String prenom;
     private String dept;

}
