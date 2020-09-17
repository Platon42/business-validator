package org.hash.validator.dto;

import lombok.Data;
import org.hash.validator.dto.company.Company;

import java.util.ArrayList;
import java.util.HashSet;

@Data
public class InnValidatorRequest {
    private String inn;
}
