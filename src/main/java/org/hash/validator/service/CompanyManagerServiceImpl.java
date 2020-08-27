package org.hash.validator.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hash.validator.dto.CompanyAdderRequest;
import org.hash.validator.dto.company.Company;
import org.hash.validator.jpa.CompanyEntity;
import org.hash.validator.jpa.CompanyFormEntity;
import org.hash.validator.repo.CompanyFormSpringDataRepo;
import org.hash.validator.repo.CompanySpringDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyManagerServiceImpl implements CompanyManagerService {

    @Autowired
    private CompanySpringDataRepo companySpringDataRepo;

    @Autowired
    private CompanyFormSpringDataRepo companyFormSpringDataRepo;

    public List<FieldCounter> addCompany(CompanyAdderRequest adderRequest) {
        String formName = adderRequest.getFormName();
        CompanyFormEntity companyFormEntity = new CompanyFormEntity();
        companyFormEntity.setFormName(formName);

        companyFormSpringDataRepo.save(companyFormEntity);
        ArrayList<FieldCounter> fieldCounters = new ArrayList<>();
        FieldCounter fieldCounter = new FieldCounter("companyForm", companyFormSpringDataRepo.count());
        fieldCounters.add(fieldCounter);

        adderRequest.getCompanyList().forEach(company -> {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setInn(company.getInn());
            companyEntity.setCompanyName(company.getCompanyName());
            companyEntity.setCompanyFormByFormId(companyFormEntity);
            companySpringDataRepo.save(companyEntity);
        });
        FieldCounter fieldCounter2 = new FieldCounter("company", companySpringDataRepo.count());
        fieldCounters.add(fieldCounter2);
        return fieldCounters;

    }

    @AllArgsConstructor
    public static class FieldCounter{
        String tableName;
        Long count;
    }
}
