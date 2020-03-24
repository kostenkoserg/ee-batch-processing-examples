package org.kostenko.example.batch.imprt;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kostenko
 */
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportItems {

    @XmlElement(name = "item")
    private List<ImportItem> items;

    public List<ImportItem> getItems() {
        return items;
    }

    public void setItems(List<ImportItem> items) {
        this.items = items;
    }
    
}
