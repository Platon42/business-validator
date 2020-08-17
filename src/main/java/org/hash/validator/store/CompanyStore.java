package org.hash.validator.store;

import lombok.Data;
import org.hash.validator.dto.company.Company;

import java.util.List;

@Data
public class CompanyStore {
    private List<Company> companyList;

}
