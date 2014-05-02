package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.PrimarySourceDAO;
import org.renci.opm.dao.model.PrimarySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class PrimarySourceDAOImpl extends BaseDAOImpl<PrimarySource, Long> implements PrimarySourceDAO {

    private final Logger logger = LoggerFactory.getLogger(PrimarySourceDAOImpl.class);

    public PrimarySourceDAOImpl() {
        super(PrimarySource.class);
    }

    @Override
    public Long save(PrimarySource entity) throws OPMDAOException {
        logger.debug("ENTERING save(PrimarySource)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public PrimarySource findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        PrimarySource entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(PrimarySource.class);
        return entity;
    }

}
