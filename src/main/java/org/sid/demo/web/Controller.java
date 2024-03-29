package org.sid.demo.web;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class Controller {


    @Autowired
    JobLauncher jobLauncher;

    final Job job;


    @Autowired
    public Controller(Job job){
        this.job=job;
    }

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionException{

        Map<String, JobParameter> maps = new HashMap<>();

        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters  =new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job,parameters);

        System.out.println("JobExecution: "+jobExecution.getStatus());

        System.out.println("Batch is Running ... ");
        while (jobExecution.isRunning()){

            System.out.println("....");
        }

        return jobExecution.getStatus();
    }

}
