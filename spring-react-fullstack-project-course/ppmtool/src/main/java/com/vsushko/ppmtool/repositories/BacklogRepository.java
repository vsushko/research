package com.vsushko.ppmtool.repositories;

import com.vsushko.ppmtool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vsushko
 */
@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String Identifier);
}
