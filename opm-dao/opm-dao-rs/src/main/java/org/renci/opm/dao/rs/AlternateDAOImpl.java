package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.AlternateDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Alternate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class AlternateDAOImpl extends BaseDAOImpl<Alternate, Long> implements AlternateDAO {

    private final Logger logger = LoggerFactory.getLogger(AlternateDAOImpl.class);

    public AlternateDAOImpl() {
        super(Alternate.class);
    }

    @Override
    public Long save(Alternate entity) throws OPMDAOException {
        logger.debug("ENTERING save(Alternate)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Alternate findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Alternate entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Alternate.class);
        return entity;
    }

}
