package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.AttributionDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Attribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class AttributionDAOImpl extends BaseDAOImpl<Attribution, Long> implements AttributionDAO {

    private final Logger logger = LoggerFactory.getLogger(AttributionDAOImpl.class);

    public AttributionDAOImpl() {
        super(Attribution.class);
    }

    @Override
    public Long save(Attribution entity) throws OPMDAOException {
        logger.debug("ENTERING save(Attribution)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Attribution findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Attribution entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Attribution.class);
        return entity;
    }

}
