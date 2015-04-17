package org.renci.opm.ws.impl;

import org.renci.opm.dao.LocationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Location;
import org.renci.opm.ws.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationServiceImpl implements LocationService {

    private final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    private LocationDAO locationDAO;

    @Override
    public Location findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Location ret = null;
        try {
            ret = locationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Location Location) {
        logger.info("ENTERING save(Location)");
        Long ret = null;
        try {
            ret = locationDAO.save(Location);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

}
