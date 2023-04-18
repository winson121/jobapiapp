package com.jobapiapp.demo.dao.api;

import com.jobapiapp.demo.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class JobDAOApiServiceImpl implements JobDAOApiService{

    private String jobRecruitmentPositionUrl;

    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    public JobDAOApiServiceImpl(@Value("${job.recruitment.position.url}") String url) {
        this.jobRecruitmentPositionUrl = url;

        logger.info("Loaded property: job.recruitment.position.url= " + jobRecruitmentPositionUrl);
    }
    @Override
    public List<Job> getJobsFromAPI() {

        String positionsUrl = jobRecruitmentPositionUrl+".json";

        WebClient client = WebClient.create(positionsUrl);
        Flux<Job> jobFlux = client.get()
                               .accept(MediaType.APPLICATION_JSON)
                               .retrieve()
                               .bodyToFlux(Job.class);

        // Collect the Flux into a list
        List<Job> jobPositions = jobFlux.collectList().block();

        return jobPositions;
    }

    @Override
    public Job getJobFromAPI(String id) {

        String positionUrl = jobRecruitmentPositionUrl+"/"+id;

        Job job;

        WebClient client = WebClient.create(positionUrl);
        Mono<Job> jobMono = client.get()
                                .accept(MediaType.APPLICATION_JSON)
                                .retrieve()
                                .bodyToMono(Job.class);
        job = jobMono.block();
        
        return job.getId() == null ? null : job;
    }
}
