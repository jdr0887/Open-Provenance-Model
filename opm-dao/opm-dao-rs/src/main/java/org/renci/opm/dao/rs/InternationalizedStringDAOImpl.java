package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.InternationalizedStringDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.InternationalizedString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class InternationalizedStringDAOImpl extends BaseDAOImpl<InternationalizedString, Long> implements
        InternationalizedStringDAO {

    private final Logger logger = LoggerFactory.getLogger(InternationalizedStringDAOImpl.class);

    public InternationalizedStringDAOImpl() {
        super(InternationalizedString.class);
    }

    @Override
    public Long save(InternationalizedString entity) throws OPMDAOException {
        logger.debug("ENTERING save(InternationalizedString)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public InternationalizedString findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        InternationalizedString entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(InternationalizedString.class);
        return entity;
    }

}
