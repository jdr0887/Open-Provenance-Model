package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.SoftwareAgentDAO;
import org.renci.opm.dao.model.SoftwareAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class SoftwareAgentDAOImpl extends BaseDAOImpl<SoftwareAgent, Long> implements SoftwareAgentDAO {

    private final Logger logger = LoggerFactory.getLogger(SoftwareAgentDAOImpl.class);

    public SoftwareAgentDAOImpl() {
        super(SoftwareAgent.class);
    }

    @Override
    public Long save(SoftwareAgent entity) throws OPMDAOException {
        logger.debug("ENTERING save(SoftwareAgent)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public SoftwareAgent findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        SoftwareAgent entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(SoftwareAgent.class);
        return entity;
    }

}
