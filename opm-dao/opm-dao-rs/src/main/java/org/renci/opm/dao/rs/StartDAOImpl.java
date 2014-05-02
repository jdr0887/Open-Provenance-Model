package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.StartDAO;
import org.renci.opm.dao.model.Start;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class StartDAOImpl extends BaseDAOImpl<Start, Long> implements StartDAO {

    private final Logger logger = LoggerFactory.getLogger(StartDAOImpl.class);

    public StartDAOImpl() {
        super(Start.class);
    }

    @Override
    public Long save(Start entity) throws OPMDAOException {
        logger.debug("ENTERING save(Start)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Start findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Start entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Start.class);
        return entity;
    }

}
