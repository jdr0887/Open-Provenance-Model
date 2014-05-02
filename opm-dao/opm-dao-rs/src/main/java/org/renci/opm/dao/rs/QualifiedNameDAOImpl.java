package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.QualifiedNameDAO;
import org.renci.opm.dao.model.QualifiedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class QualifiedNameDAOImpl extends BaseDAOImpl<QualifiedName, Long> implements QualifiedNameDAO {

    private final Logger logger = LoggerFactory.getLogger(QualifiedNameDAOImpl.class);

    public QualifiedNameDAOImpl() {
        super(QualifiedName.class);
    }

    @Override
    public Long save(QualifiedName entity) throws OPMDAOException {
        logger.debug("ENTERING save(QualifiedName)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public QualifiedName findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        QualifiedName entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(QualifiedName.class);
        return entity;
    }

}
