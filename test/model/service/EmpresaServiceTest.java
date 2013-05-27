/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Nivel;
import model.vo.EmpresaVO;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Zergio
 */
public class EmpresaServiceTest {

    EmpresaVO empresa;
    String VALID_CHARACTERS_ENTERPRISE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-*/.,;:`´¨¿¡'?!#$%&";
    String VALID_CHARACTERS_ADDRESS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.,:`´¨'#&";
    String VALID_CHARACTERS_PHONENUMBER = "0123456789:()+";
    int MAXNAME = 80;
    int MAXADDRESS = 20;
    int MAXPHONE = 13;
    int MAXNIT = 15;

    public EmpresaServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        empresa = new EmpresaVO();
        empresa.setDireccion("Diagonal 3 # 6-50");
        //requerido
        empresa.setNit(99999999);
        //requerido
        empresa.setNivel(Nivel.ADMINISTRADORA);
        //requerido
        empresa.setNombre("Fabrica de pollos mecanicos La casi-22");
        empresa.setTelefono("9999999");

    }

    @After
    public void tearDown() {

        empresa = null;
    }

    /**
     * Test of validarCampos method, of class EmpresaService.
     */
    @Test
    public void testValidarCamposExpectedFunctionality() throws Exception {
        System.out.println("validarCamposExpectedFunctionality");
        boolean expResult = true;
        boolean result = ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarCamposInvalidCharacersInAddress() {
        System.out.println("validarCamposInvalidCharacersInAddress");
        boolean expResult = false;
        boolean result;

        empresa.setDireccion("*************************");

        try {
            result = ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInAddress() {
        System.out.println("validarCamposInvalidNumberOfCharactersInAddress");
        boolean expResult = false;
        boolean result;

        char dummy = '0';
        String address = new String();

        

        for (int i = 1; i <= MAXADDRESS; i++) {
            address = address + dummy;
        }
        
        System.out.println(address + " " + address.length());
        
        empresa.setDireccion(address);

        try {
            result = ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Test
    public void testValidarCamposInvalidNumberOfCharactersInNit() {
        System.out.println("validarCamposInvalidNumberOfCharactersInNit");
        
        int dummy = 10;
        int nit = 0;

        

        for (int i = 0; i < MAXNIT; i++) {
            nit = nit + (dummy^i);
        }
        
        System.out.println(nit + " " + ((Integer)nit).toString().length());
        
        empresa.setNit(nit);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
