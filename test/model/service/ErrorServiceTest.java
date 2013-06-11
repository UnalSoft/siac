/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.vo.ErrorVO;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Zergio
 */
public class ErrorServiceTest {

    ErrorVO error;

    public ErrorServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        error = new ErrorVO();

        error.setError("Descripción error");
        error.setUsuariosDNI(new Long("0"));
        error.setInterfaz("Interfaz de incidencia");
        error.setId(1);


    }

    @After
    public void tearDown() {

        error = null;

    }

    @Test
    public void testCreateErrorExpectedFunctionality() {

        try {
            ServiceFactory.getInstance().getErrorService().create(error);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }

    }

    @Test
    public void testFindErrorExpectedFunctionality() {

        assertEquals(ServiceFactory.getInstance().getErrorService().find(error.getId()), error);

    }

    @Test
    public void testUpdateErrorExpectedFunctionality() {

        ErrorVO tempError = ServiceFactory.getInstance().getErrorService().find(error.getId());
        tempError.setError("Cambio en error");
        try {
            ServiceFactory.getInstance().getErrorService().update(tempError);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }

        assertEquals(ServiceFactory.getInstance().getErrorService().find(error.getId()).getError(), "Cambio en error");


    }

    @Test
    public void testDeleteErrorExpectedFunctionality() {
        try {
            ServiceFactory.getInstance().getErrorService().delete(error.getId());
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
}