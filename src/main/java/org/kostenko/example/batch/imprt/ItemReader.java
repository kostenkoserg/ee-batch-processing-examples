package org.kostenko.example.batch.imprt;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class ItemReader  extends AbstractItemReader {
    
    @Inject
    ImportJobContext importJobContext;

    @Override
    public ImportItem readItem() throws Exception {
        
        ImportItem importItem = importJobContext.getItems().poll();
        System.out.println("--> Read item to processing " + importItem);
        return importItem;
    }
    
}
