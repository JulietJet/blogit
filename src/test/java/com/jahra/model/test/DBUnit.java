package com.jahra.model.test;

import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;

/**
 * Created by Артём on 31.01.2016.
 */

public class DBUnit extends DBTestCase {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    protected IDataSet getDataSet() throws Exception {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        return builder.build(resourceLoader.getResource("dbunit/dataset.xml").getInputStream());
    }

    @Before
    public void setUp() throws Exception {
        IDatabaseConnection dbUnitCon = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        SessionImplementor si = (SessionImplementor) session;
        Connection conn = si.getJdbcConnectionAccess().obtainConnection();
        dbUnitCon = new DatabaseConnection(conn);
        IDataSet dataSet = this.getDataSet();
        ReplacementDataSet rDataSet = new ReplacementDataSet(dataSet);
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
        DatabaseOperation.REFRESH.execute(dbUnitCon, dataSet);
    }
}
