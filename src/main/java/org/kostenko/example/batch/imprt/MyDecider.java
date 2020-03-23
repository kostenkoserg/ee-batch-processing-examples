package org.kostenko.example.batch.imprt;

import java.io.FileNotFoundException;
import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.inject.Inject;

/**
 *
 * @author kostenko
 */
public class MyDecider implements Decider {

    @Inject
    private ImportJobContext jobContext;

    @Override
    public String decide(StepExecution[] ses) throws Exception {
        if (!jobContext.getFile().isPresent()) {
            throw new FileNotFoundException();
        }
        String name = jobContext.getFile().get().getName();
        return name.substring(name.lastIndexOf("."));
    }
}
