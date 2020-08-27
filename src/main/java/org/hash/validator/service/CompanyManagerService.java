package org.hash.validator.service;

import org.hash.validator.dto.CompanyAdderRequest;

import java.util.List;

public interface CompanyManagerService {
    List<org.hash.validator.service.CompanyManagerServiceImpl.FieldCounter> addCompany(CompanyAdderRequest adderRequest);
}
