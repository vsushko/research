package com.vsushko.ppmtool.repositories;

import com.vsushko.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vsushko
 */
@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}
