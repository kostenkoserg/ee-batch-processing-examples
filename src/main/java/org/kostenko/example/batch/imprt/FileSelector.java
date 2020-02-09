package org.kostenko.example.batch.imprt;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class FileSelector extends AbstractBatchlet {

    @Override
    public String process() throws Exception {

        return "OK";
    }
    
}
