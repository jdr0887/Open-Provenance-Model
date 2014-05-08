package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.InfluenceDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Influence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class InfluenceDAOImpl extends BaseDAOImpl<Influence, Long> implements InfluenceDAO {

    private final Logger logger = LoggerFactory.getLogger(InfluenceDAOImpl.class);

    public InfluenceDAOImpl() {
        super(Influence.class);
    }

    @Override
    public Long save(Influence entity) throws OPMDAOException {
        logger.debug("ENTERING save(Influence)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Influence findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Influence entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Influence.class);
        return entity;
    }

}
