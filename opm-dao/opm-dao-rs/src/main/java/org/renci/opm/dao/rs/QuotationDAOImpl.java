package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.QuotationDAO;
import org.renci.opm.dao.model.Quotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class QuotationDAOImpl extends BaseDAOImpl<Quotation, Long> implements QuotationDAO {

    private final Logger logger = LoggerFactory.getLogger(QuotationDAOImpl.class);

    public QuotationDAOImpl() {
        super(Quotation.class);
    }

    @Override
    public Long save(Quotation entity) throws OPMDAOException {
        logger.debug("ENTERING save(Quotation)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Quotation findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Quotation entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Quotation.class);
        return entity;
    }

}
