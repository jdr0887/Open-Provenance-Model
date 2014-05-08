package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.ValueDAO;
import org.renci.opm.dao.model.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class ValueDAOImpl extends BaseDAOImpl<Value, Long> implements ValueDAO {

    private final Logger logger = LoggerFactory.getLogger(ValueDAOImpl.class);

    public ValueDAOImpl() {
        super(Value.class);
    }

    @Override
    public Long save(Value entity) throws OPMDAOException {
        logger.debug("ENTERING save(Value)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Value findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Value entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Value.class);
        return entity;
    }

}
