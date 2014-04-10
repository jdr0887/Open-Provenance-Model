package org.renci.opm.dao.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Revision complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Revision">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/ns/prov#}Derivation">
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Revision")
@javax.persistence.Entity
@Table(name = "revision")
public class Revision extends Derivation {

    private static final long serialVersionUID = 4536787894684669428L;

    public Revision() {
        super();
    }

    
}
