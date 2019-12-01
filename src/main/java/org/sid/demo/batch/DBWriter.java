package org.sid.demo.batch;

import org.sid.demo.dao.PersonneRepository;
import org.sid.demo.model.Personne;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class DBWriter implements ItemWriter<Personne> {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public void write(List<? extends Personne> personnes) throws Exception {

        for(Personne personne:personnes){
            personneRepository.save(personne);
        }

    }
}
