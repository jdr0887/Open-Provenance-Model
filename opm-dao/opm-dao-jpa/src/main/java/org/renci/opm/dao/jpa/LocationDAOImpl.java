package org.renci.opm.dao.jpa;

import org.renci.opm.dao.LocationDAO;
import org.renci.opm.dao.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationDAOImpl extends BaseDAOImpl<Location, Long> implements LocationDAO {

    private final Logger logger = LoggerFactory.getLogger(LocationDAOImpl.class);

    public LocationDAOImpl() {
        super();
    }

    @Override
    public Class<Location> getPersistentClass() {
        return Location.class;
    }

}
