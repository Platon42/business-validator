package org.hash.validator.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private String companyName;
    private String companyType;
    private String inn;
}