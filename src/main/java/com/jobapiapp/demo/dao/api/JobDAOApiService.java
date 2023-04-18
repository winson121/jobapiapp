package com.jobapiapp.demo.dao.api;

import com.jobapiapp.demo.entity.Job;

import java.util.List;

public interface JobDAOApiService {

    List<Job> getJobsFromAPI();

    Job getJobFromAPI(String id);
}
