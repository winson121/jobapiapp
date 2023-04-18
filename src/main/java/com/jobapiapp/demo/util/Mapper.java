package com.jobapiapp.demo.util;

import com.jobapiapp.demo.dto.JobDTO;
import com.jobapiapp.demo.dto.UserDTO;
import com.jobapiapp.demo.entity.Job;
import com.jobapiapp.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDTO toDto(User user) {
        String name = user.getUsername();

        return new UserDTO(name);
    }

    public JobDTO toDto(Job job) {
        JobDTO jobDto = new JobDTO();
        jobDto.setId(job.getId());
        jobDto.setType(job.getType());
        jobDto.setUrl(job.getUrl());
        jobDto.setCreatedAt(job.getCreatedAt());
        jobDto.setCompany(job.getCompany());
        jobDto.setCompanyUrl(job.getCompanyUrl());
        jobDto.setLocation(job.getLocation());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setHowToApply(job.getHowToApply());
        jobDto.setCompanyLogo(job.getCompanyLogo());

        return jobDto;
    }

    public User toEntity(UserDTO userDto) {
        String name = userDto.getUsername();
        String password = userDto.getPassword();

        return new User(name, password);
    }
}
