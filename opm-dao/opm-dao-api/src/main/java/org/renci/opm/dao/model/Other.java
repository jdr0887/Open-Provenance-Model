package org.renci.opm.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Other complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Other">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Other", propOrder = {})
@javax.persistence.Entity
@Table(name = "opm_other")
public class Other extends Element {

    private static final long serialVersionUID = 2127846537535332212L;

    @XmlAnyElement(lax = true)
    protected List<Object> any;

    // @XmlSchemaType(name = "anySimpleType")
    // @XmlValue
    // @Transient
    // private Object value;
    //
    // @XmlJavaTypeAdapter(QNameAdapter.class)
    // @ManyToOne
    // @JoinColumn(name = "type")
    // private QualifiedName type;

    public Other() {
        super();
        this.any = new ArrayList<Object>();
    }

    public List<Object> getAny() {
        return any;
    }

    public void setAny(List<Object> any) {
        this.any = any;
    }

}
