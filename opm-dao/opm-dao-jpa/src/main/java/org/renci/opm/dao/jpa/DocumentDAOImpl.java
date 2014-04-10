package org.renci.opm.dao.jpa;

import org.renci.opm.dao.DocumentDAO;
import org.renci.opm.dao.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentDAOImpl extends BaseDAOImpl<Document, Long> implements DocumentDAO {

    private final Logger logger = LoggerFactory.getLogger(DocumentDAOImpl.class);

    public DocumentDAOImpl() {
        super();
    }

    @Override
    public Class<Document> getPersistentClass() {
        return Document.class;
    }

}
