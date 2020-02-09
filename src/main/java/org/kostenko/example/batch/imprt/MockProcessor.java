package org.kostenko.example.batch.imprt;

import javax.batch.api.chunk.ItemProcessor;

/**
 *
 * @author kostenko
 */
public class MockProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object o) throws Exception {

        return "process";
    }
    
}
