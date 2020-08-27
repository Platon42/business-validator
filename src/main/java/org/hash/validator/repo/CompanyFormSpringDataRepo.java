package org.hash.validator.repo;

import org.hash.validator.jpa.CompanyFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyFormSpringDataRepo extends JpaRepository<CompanyFormEntity,Integer> {
}
