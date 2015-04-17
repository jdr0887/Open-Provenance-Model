package org.renci.opm.ws.impl;

import org.renci.opm.dao.DocumentDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Document;
import org.renci.opm.ws.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentServiceImpl implements DocumentService {

    private final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

    private DocumentDAO documentDAO;

    @Override
    public Document findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Document ret = null;
        try {
            ret = documentDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Document document) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = documentDAO.save(document);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

}
