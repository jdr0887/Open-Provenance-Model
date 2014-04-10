package org.renci.opm.dao.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.time.DateFormatUtils;

public abstract class AbstractTypedValueAdapter<T extends TypedValue> extends XmlAdapter<Object, T> {

    public static DocumentBuilder builder;

    static void initBuilder() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setNamespaceAware(true);
            builder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
    }

    static {
        initBuilder();
    }

    public AbstractTypedValueAdapter() {
        super();
    }

    @Override
    public Object marshal(T typedValue) throws Exception {
        org.w3c.dom.Document doc = builder.newDocument();
        JAXBContext context = JAXBContext.newInstance(typedValue.getClass());

        QName locationQName = context.createJAXBIntrospector().getElementName(typedValue);

        org.w3c.dom.Element el = doc.createElementNS(locationQName.getNamespaceURI(), locationQName.getLocalPart());

        if (typedValue.getPrimaryKey() != null) {
            el.setAttribute("pk", typedValue.getPrimaryKey().toString());
        }

        el.setAttributeNS("http://www.w3.org/2001/XMLSchema", "xsi:type",
                String.format("%s:%s", typedValue.getType().getPrefix(), typedValue.getType().getLocalPart()));
        String typedValueTypeLocalPart = typedValue.getType().getLocalPart();
        switch (typedValueTypeLocalPart) {
            case "string":
                el.appendChild(doc.createTextNode(typedValue.getString()));
                break;
            case "int":
                el.appendChild(doc.createTextNode(typedValue.getInteger().toString()));
                break;
            case "float":
                el.appendChild(doc.createTextNode(typedValue.get_float().toString()));
                break;
            case "dateTime":
                String dateTime = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(typedValue.getDateTime());
                el.appendChild(doc.createTextNode(dateTime));
                break;
            case "QName":
                String qname = typedValue.getType().toQName().toString();
                el.appendChild(doc.createTextNode(qname));
                break;
        }
        doc.appendChild(el);
        return el;
    }
}
