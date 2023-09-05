package com.drools_testing.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;

@Configuration
public class DroolsConfig {

    //    @Value("${drl.internal.file}")
//    private String internalDrlFile;
//@Value("${drl.external.file}")
//    private String externalDrlFile;

    private final Environment environment;

    public DroolsConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public KieContainer kieContainer() {
        KieServices ke = KieServices.Factory.get();
        KieFileSystem kf = ke.newKieFileSystem();

        kf.write(ResourceFactory.newClassPathResource(environment.getProperty("drl.internal.file")));

             /*
            For External File
            kf.write(ResourceFactory.newFileResource(environment.getProperty("drl.external.file")));
          */

        // kf.write(ResourceFactory.newFileResource(new File(externalDrlFile)));
        //  kf .write(ResourceFactory.newClassPathResource(internalDrlFile));
        KieBuilder kb = ke.newKieBuilder(kf);
        kb.buildAll();
        KieModule km = kb.getKieModule();
        return ke.newKieContainer(km.getReleaseId());
    }
}
