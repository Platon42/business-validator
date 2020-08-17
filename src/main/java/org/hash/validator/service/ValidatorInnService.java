package org.hash.validator.service;

import org.hash.validator.dto.InnValidatorRequest;
import org.hash.validator.dto.InnValidatorResponse;

public interface ValidatorInnService {
    InnValidatorResponse validateInn(InnValidatorRequest innValidatorRequest);
}
