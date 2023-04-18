package com.jobapiapp.demo.controller;

import com.jobapiapp.demo.dto.JobDTO;
import com.jobapiapp.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDTO>> getJobs() {
        List<JobDTO> jobs = jobService.getJobs();

        if (jobs != null) {
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
