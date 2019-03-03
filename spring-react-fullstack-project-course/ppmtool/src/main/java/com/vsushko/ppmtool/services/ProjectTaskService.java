package com.vsushko.ppmtool.services;

import com.vsushko.ppmtool.domain.Backlog;
import com.vsushko.ppmtool.domain.Project;
import com.vsushko.ppmtool.domain.ProjectTask;
import com.vsushko.ppmtool.exceptions.ProjectNotFoundException;
import com.vsushko.ppmtool.repositories.BacklogRepository;
import com.vsushko.ppmtool.repositories.ProjectRepository;
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

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        try {
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
        } catch (Exception ex) {
            throw new ProjectNotFoundException("Project not found");
        }
    }

    public Iterable<ProjectTask> findBacklogById(String id) {
        Project project = projectRepository.findByProjectIdentifier(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with ID: '" + id + "' does not exist");
        }

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
        // make sure we are searching on the right backlog
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);

        if (backlog == null) {
            throw new ProjectNotFoundException("Project with ID: '" + backlog_id + "' does not exist");
        }

        // make sure that our task exists
        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);

        if (projectTask == null) {
            throw new ProjectNotFoundException("Project with ID: '" + pt_id + "' does not exist");
        }

        // make sure  that the backlog/project_id in the the path
        if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
            throw new ProjectNotFoundException("Project Task '" + pt_id + "' does not exist in project " + backlog_id);
        }

        return projectTask;
    }

    public ProjectTask updateByProjectSequence(ProjectTask updateTask, String backlogId, String ptId) {
        ProjectTask projectTask = findPTByProjectSequence(backlogId, ptId);

        projectTask = updateTask;

        return projectTaskRepository.save(projectTask);
    }

    public void deletePTByProjectSequence(String backlogId, String ptId) {
        ProjectTask projectTask = findPTByProjectSequence(backlogId, ptId);

        projectTaskRepository.delete(projectTask);
    }
}
