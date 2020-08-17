package org.hash.validator.controller;

import org.hash.validator.dto.InnValidatorRequest;
import org.hash.validator.dto.InnValidatorResponse;
import org.hash.validator.service.ValidatorInnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class AppController {

    @Autowired
    private ValidatorInnService validatorInnService;

    @PostMapping("/inn-validator")
    public InnValidatorResponse getValidationResult (@RequestBody InnValidatorRequest validatorRequest) {
        return validatorInnService.validateInn(validatorRequest);
    }
}
