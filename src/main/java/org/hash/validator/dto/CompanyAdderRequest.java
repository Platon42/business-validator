package org.hash.validator.dto;

import lombok.Data;
import org.hash.validator.dto.company.Company;

import java.util.List;

@Data
public class CompanyAdderRequest {
    private List<Company> companyList;
    private String formName;
}
