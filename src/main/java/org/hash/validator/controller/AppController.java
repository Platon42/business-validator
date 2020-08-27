package org.hash.validator.controller;

import org.hash.validator.dto.CompanyAdderRequest;
import org.hash.validator.dto.InnValidatorRequest;
import org.hash.validator.dto.InnValidatorResponse;
import org.hash.validator.service.CompanyManagerService;
import org.hash.validator.service.CompanyManagerServiceImpl;
import org.hash.validator.service.ValidatorInnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class AppController {

    @Autowired
    private ValidatorInnService validatorInnService;

    @Autowired
    private CompanyManagerService companyManagerService;

    @PostMapping("/inn-validator")
    public InnValidatorResponse getValidationResult (@RequestBody InnValidatorRequest validatorRequest) {
        return validatorInnService.validateInn(validatorRequest);
    }

    @PostMapping("/add-companies")
    public List<CompanyManagerServiceImpl.FieldCounter> addCompanies (@RequestBody CompanyAdderRequest adderRequest) {
        return companyManagerService.addCompany(adderRequest);
    }
}
