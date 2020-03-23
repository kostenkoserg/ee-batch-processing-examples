package org.kostenko.example.batch.imprt;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kostenko
 */
@Entity
@XmlRootElement(name = "item")
public class ImportItem {

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
