package org.kostenko.example.batch.imprt;

import java.io.FileNotFoundException;
import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class MyDecider implements Decider {

    @Inject
    private ImportJobContext jobContext;

    @Override
    public String decide(StepExecution[] ses) throws Exception {
        if (!jobContext.getFile().isPresent()) {
            throw new FileNotFoundException();
        }
        String name = jobContext.getFile().get().getName();
        String extension = name.substring(name.lastIndexOf(".")+1);
        System.out.println("--> " + extension);
        return extension;
    }
}
