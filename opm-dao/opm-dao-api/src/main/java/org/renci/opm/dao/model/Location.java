package org.renci.opm.dao.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Location", propOrder = {})
@javax.persistence.Entity
@Table(name = "location")
@XmlJavaTypeAdapter(type = Location.class, value = LocationAdapter.class)
public class Location extends TypedValue {

    private static final long serialVersionUID = 4363715241382468954L;

    public Location() {
        super();
    }

}
