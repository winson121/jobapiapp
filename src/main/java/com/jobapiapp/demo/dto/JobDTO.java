package com.jobapiapp.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({"id", "type", "url", "created_at",
        "company", "company_url", "location", "title",
        "description", "how_to_apply", "company_logo"
})
public class JobDTO {

    private String id;
    private String type;
    private String url;

    @JsonProperty("created_at")
    private String createdAt;
    private String company;

    @JsonProperty("company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;

    @JsonProperty("how_to_apply")
    private String howToApply;

    @JsonProperty("company_logo")
    private String companyLogo;

    public JobDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }


    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToApply() {
        return howToApply;
    }

    public void setHowToApply(String howToApply) {
        this.howToApply = howToApply;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", company='" + company + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", how_to_apply='" + howToApply + '\'' +
                ", company_logo='" + companyLogo + '\'' +
                '}';
    }
}
