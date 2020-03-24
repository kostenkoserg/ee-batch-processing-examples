package org.kostenko.example.batch.imprt;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kostenko
 */
@Named
public class ItemJpaWriter  extends AbstractItemWriter  {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void writeItems(List<Object> list) throws Exception {
        
        for (Object obj : list) {
            ImportItem item = (ImportItem) obj;
            System.out.println("--> Persisting " + item);
            entityManager.merge(item);
        }
    }
}
