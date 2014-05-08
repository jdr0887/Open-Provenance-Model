package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.UsageDAO;
import org.renci.opm.dao.model.Usage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class UsageDAOImpl extends BaseDAOImpl<Usage, Long> implements UsageDAO {

    private final Logger logger = LoggerFactory.getLogger(UsageDAOImpl.class);

    public UsageDAOImpl() {
        super(Usage.class);
    }

    @Override
    public Long save(Usage entity) throws OPMDAOException {
        logger.debug("ENTERING save(Usage)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Usage findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Usage entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Usage.class);
        return entity;
    }

}
