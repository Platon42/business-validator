package org.hash.validator.repo;

import org.hash.validator.jpa.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanySpringDataRepo extends JpaRepository<CompanyEntity,Integer> {
}
