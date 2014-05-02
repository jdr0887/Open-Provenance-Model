package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.DocumentDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class DocumentDAOImpl extends BaseDAOImpl<Document, Long> implements DocumentDAO {

    private final Logger logger = LoggerFactory.getLogger(DocumentDAOImpl.class);

    public DocumentDAOImpl() {
        super(Document.class);
    }

    @Override
    public Long save(Document entity) throws OPMDAOException {
        logger.debug("ENTERING save(Document)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Document findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Document entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Document.class);
        return entity;
    }

}
