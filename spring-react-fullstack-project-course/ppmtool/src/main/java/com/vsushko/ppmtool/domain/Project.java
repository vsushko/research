package com.vsushko.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author vsushko
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_at;

    public Project() {
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    /**
     * @return the {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the {@link #id}  to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the {@link #projectName}
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the {@link #projectName}  to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the {@link #projectIdentifier}
     */
    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    /**
     * @param projectIdentifier the {@link #projectIdentifier}  to set
     */
    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    /**
     * @return the {@link #description}
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the {@link #description}  to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the {@link #start_date}
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the {@link #start_date}  to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the {@link #end_date}
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the {@link #end_date}  to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    /**
     * @return the {@link #created_at}
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the {@link #created_at}  to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the {@link #updated_at}
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the {@link #updated_at}  to set
     */
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
