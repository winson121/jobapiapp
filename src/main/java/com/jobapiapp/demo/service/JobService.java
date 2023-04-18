package com.jobapiapp.demo.service;

import com.jobapiapp.demo.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> getJobs();
}
