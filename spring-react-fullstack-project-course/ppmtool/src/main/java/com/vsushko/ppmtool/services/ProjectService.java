package com.vsushko.ppmtool.services;

import com.vsushko.ppmtool.domain.Backlog;
import com.vsushko.ppmtool.domain.Project;
import com.vsushko.ppmtool.exceptions.ProjectIdException;
import com.vsushko.ppmtool.repositories.BacklogRepository;
import com.vsushko.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vsushko
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            String identifier = project.getProjectIdentifier().toUpperCase();

            project.setProjectIdentifier(identifier);

            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if (project.getId() != null) {
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toLowerCase() + "' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId) {

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectId + "'doesn't exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Cannot Project with ID '" + projectId + "'. This project does not exist ");
        }
        projectRepository.delete(project);
    }
}
