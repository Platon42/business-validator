package org.hash.validator.dto;

import lombok.Data;
import org.hash.validator.dto.company.Company;

@Data
public class InnValidatorResponse {
    private String validationResult;
    private Company company;
}
