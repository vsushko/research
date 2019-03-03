package com.vsushko.ppmtool.services;

import com.vsushko.ppmtool.domain.Backlog;
import com.vsushko.ppmtool.domain.ProjectTask;
import com.vsushko.ppmtool.repositories.BacklogRepository;
import com.vsushko.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vsushko
 */
@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        // PTs to be added to a specific project, project != null
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

        // set the bl to pt
        projectTask.setBacklog(backlog);

        // we want out project sequence to be like this: IDPRO-1, IDPRO-2
        Integer backlogSequence = backlog.getPTSequence();

        // update the bl sequence
        backlogSequence++;

        backlog.setPTSequence(backlogSequence);

        // add sequence to project task
        projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + backlogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        // initial priority
        // in the future we need to handle the form
        if (projectTask.getPriority() == null) {
            projectTask.setPriority(3);
        }

        // initial status when status is null
        if (projectTask.getStatus() == null || projectTask.getStatus().isEmpty()) {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findBacklogById(String id) {
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }
}
