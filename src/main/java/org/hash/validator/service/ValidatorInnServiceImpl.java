package org.hash.validator.service;

import lombok.extern.slf4j.Slf4j;
import org.hash.validator.dto.InnValidatorRequest;
import org.hash.validator.dto.InnValidatorResponse;
import org.hash.validator.dto.company.Company;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class ValidatorInnServiceImpl implements ValidatorInnService {

    private static final HashMap<String,Company> companyList = new HashMap<>();

    public InnValidatorResponse validateInn(InnValidatorRequest innValidatorRequest){
        InnValidatorResponse innValidatorResponse = new InnValidatorResponse();
        String inn = innValidatorRequest.getInn();
        boolean validInn = InnCheckerService.isValidInn(inn);

        if (!validInn) {
            innValidatorResponse.setValidationResult("Inn is not valid");
            innValidatorResponse.setCompany(null);
        } else {
            Company company = companyList.get(innValidatorRequest.getInn());
            innValidatorResponse.setCompany(company);
            innValidatorResponse.setValidationResult("Inn is valid");
        }
        return innValidatorResponse;
    }

    @PostConstruct
    public void fillCompaniesFromFile () {
        try {
            String filePath = "C:\\Users\\Platon\\IdeaProjects\\TestHash\\store\\company.csv";
            List<String> strings = Files.readAllLines(Path.of(filePath));
            Company company = null;
            for (String string : strings) {
                String[] split = string.split(",");
                String inn = null;
                for (int j = 0; j < split.length; j++) {
                    company = new Company(split[0], split[1], split[2]);
                    inn = split[2];
                }
                companyList.put(inn, company);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
