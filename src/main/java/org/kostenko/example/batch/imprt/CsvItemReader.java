package org.kostenko.example.batch.imprt;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class CsvItemReader extends AbstractItemReader{

    @Override
    public Object readItem() throws Exception {
        return "item";
    }
    
}
