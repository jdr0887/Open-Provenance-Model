package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.LocationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class LocationDAOImpl extends BaseDAOImpl<Location, Long> implements LocationDAO {

    private final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

    public LocationDAOImpl() {
        super(Location.class);
    }

    @Override
    public Long save(Location entity) throws OPMDAOException {
        logger.debug("ENTERING save(Location)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Location findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Location entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Location.class);
        return entity;
    }

}
