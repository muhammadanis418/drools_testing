package com.drools_testing.service;

import com.drools_testing.entity.StudentDto;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DroolService {
    private final KieContainer kieContainer;

    public DroolService(KieContainer kieContainer) {
        this.kieContainer=kieContainer;
    }

    public StudentDto getDroolsFunctionalityTest( StudentDto studentDto){
        KieSession ks = kieContainer.newKieSession();
        ks.insert(studentDto);
        ks.fireAllRules();
        ks.dispose();
        return studentDto;
    }
}
