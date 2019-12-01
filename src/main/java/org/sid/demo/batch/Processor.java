package org.sid.demo.batch;

import org.sid.demo.model.Personne;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class Processor implements ItemProcessor<Personne,Personne> {

    private static final Map<String,String>  DEPT_NAMES =new HashMap<>();

    public Processor(){

        DEPT_NAMES.put("001","Technology");
        DEPT_NAMES.put("002","Operations");
        DEPT_NAMES.put("003","Accounts");
    }


    @Override
    public Personne process(Personne personne) throws Exception {

        String deptCode = personne.getDept();
        String dept = DEPT_NAMES.get(deptCode);

        personne.setDept(dept);
        System.out.println(String.format("Converted from [%s] ro [%s]",deptCode,dept));
        return personne;
    }
}
