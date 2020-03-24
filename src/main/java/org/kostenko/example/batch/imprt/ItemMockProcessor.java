package org.kostenko.example.batch.imprt;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class ItemMockProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object o) throws Exception {
        System.out.println("--> processing " + o);
        return o;
    }
    
}
