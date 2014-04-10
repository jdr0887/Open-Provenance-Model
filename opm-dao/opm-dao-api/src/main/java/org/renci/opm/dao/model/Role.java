package org.renci.opm.dao.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Role")
@javax.persistence.Entity
@Table(name = "role")
public class Role extends TypedValue {

    private static final long serialVersionUID = 8309857214675278140L;

    public Role() {
        super();
    }

}
