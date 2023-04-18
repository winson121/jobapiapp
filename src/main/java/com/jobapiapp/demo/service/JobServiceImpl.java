package com.jobapiapp.demo.service;

import com.jobapiapp.demo.dao.api.JobDAOApiService;
import com.jobapiapp.demo.dto.JobDTO;
import com.jobapiapp.demo.entity.Job;
import com.jobapiapp.demo.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private Mapper mapper;

    @Autowired
    private JobDAOApiService jobDAOApiService;

    @Override
    public List<JobDTO> getJobs() {
        List<Job> jobs = jobDAOApiService.getJobsFromAPI();
        return jobs.stream().map(j -> mapper.toDto(j)).collect(Collectors.toList());
    }
}
