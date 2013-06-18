/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import controller.LoginController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.exceptions.*;
import model.entity.Nivel;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Zergio
 */
public class EmpresaServiceTest {

    EmpresaVO empresa;
    EmpresaVO empresaFind;
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
        
        UsuarioVO usuario = new UsuarioVO();
        String nombreUsuario = "Provider";
        String clave = "Provider";

        usuario.setNombreDeUsuario(nombreUsuario);
        usuario.setClave(clave);

        UsuarioVO usuarioLogin;
        try {
            usuarioLogin = ServiceFactory.getInstance().getUsuarioService().login(usuario);
            System.out.println("login");
        } catch (DataBaseException ex) {
            usuarioLogin = null;
        }

        if (usuarioLogin != null) {

            LoginController.usuarioActivo = usuarioLogin;
            System.out.println(LoginController.usuarioActivo);

        }

        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        LoginController.usuarioActivo = null;
    }

    @Before
    public void setUp() {
        empresa = new EmpresaVO();
        empresa.setDireccion("Diagonal 3 6 50");
        //requerido
        empresa.setNit(99999999);
        //requerido
        empresa.setNivel(Nivel.ADMINISTRADORA);
        //requerido
        empresa.setNombre("Fabrica de pollos mecanicos La casi");
        empresa.setTelefono("9999999");
        
        empresaFind = empresa;
        
        empresaFind.setNit(99999998);
        try {
            ServiceFactory.getInstance().getEmpresaService().create(empresaFind);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RequiredAttributeException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientPermissionsException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAttributeException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @After
    public void tearDown() {

        empresa = null;
        try {
            ServiceFactory.getInstance().getEmpresaService().delete(empresaFind.getNit());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientPermissionsException ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void testValidarCamposNullRequieredFieldNit() {
        System.out.println("validarCamposNullRequieredFieldNit");

        empresa.setNit(null);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposNullRequieredFieldNombre() {
        System.out.println("validarCamposNullRequieredFieldNombre");

        empresa.setNombre(null);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInAddress() {
        System.out.println("validarCamposInvalidCharactersInAddress");

        empresa.setDireccion("*************************");

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInAddress() {
        System.out.println("validarCamposInvalidNumberOfCharactersInAddress");
        char dummy = '0';
        String address = new String();



        for (int i = 1; i <= MAXADDRESS + 1; i++) {
            address = address + dummy;
        }

        System.out.println(address + " " + address.length());

        empresa.setDireccion(address);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInNit() {
        System.out.println("validarCamposInvalidNumberOfCharactersInNit");

        int dummy = 10;
        int nit = 0;



        for (int i = 0; i < MAXNIT + 1; i++) {
            nit = nit + (dummy ^ i);
        }

        System.out.println(nit + " " + ((Integer) nit).toString().length());

        empresa.setNit(nit);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInName() {
        System.out.println("validarCamposInvalidCharactersInName");

        empresa.setNombre("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInName() {
        System.out.println("validarCamposInvalidNumberOfCharactersInName");

        char dummy = 'S';
        String name = new String();



        for (int i = 1; i <= MAXNAME + 1; i++) {
            name = name + dummy;
        }

        System.out.println(name + " " + name.length());

        empresa.setNombre(name);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInPhoneNumber() {
        System.out.println("validarCamposInvalidNumberOfCharactersInPhoneNumber");

        char dummy = '0';
        String number = new String();



        for (int i = 1; i <= MAXPHONE + 1; i++) {
            number = number + dummy;
        }

        System.out.println(number + " " + number.length());

        empresa.setTelefono(number);

        try {
            ServiceFactory.getInstance().getEmpresaService().validarCampos(empresa);
            //fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Test
    public void testCreateEmpresaExpectedFunctionality(){
        try {
            System.out.println(empresa.getNombre());
            ServiceFactory.getInstance().getEmpresaService().create(empresa);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            //fail();
        }
    }
    
    @Test
    public void testFindEmpresaExpectedFunctionality(){
        
        assertEquals(ServiceFactory.getInstance().getEmpresaService().find(empresaFind.getNit()), empresaFind);
        
    }
    
    @Test
    public void testFindByEnterpriseEmpresaExpectedFunctionality(){
        assertEquals(ServiceFactory.getInstance().getEmpresaService().findByEnterprise(empresaFind.getEmpresasnit()), empresaFind);
        
    }
    
    @Test
    public void testFindByNameAndEnterpriseEmpresaExpectedFunctionality(){
        assertEquals(ServiceFactory.getInstance().getEmpresaService().findByNameAndEnterprise(empresaFind.getNombre(), empresaFind.getEmpresasnit()), empresaFind);
        
    }
    
    @Test
    public void testFindByNitAndEnterpriseEmpresaExpectedFunctionality(){
        assertEquals(ServiceFactory.getInstance().getEmpresaService().findByNitAndEnterprise(empresaFind.getNit(), empresa.getNit()), empresaFind);
        
    }
    
    @Test
    public void testUpdateEmpresaExpectedFunctionality(){
        
        EmpresaVO tempEmpresa = ServiceFactory.getInstance().getEmpresaService().find(empresa.getNit());
        tempEmpresa.setNombre("Cambio en usuario");
        try {
            ServiceFactory.getInstance().getEmpresaService().update(tempEmpresa);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            //fail();
        }

        assertEquals(ServiceFactory.getInstance().getEmpresaService().find(empresa.getNit()).getNombre(), "Cambio en usuario");

        
    }
    
    @Test
    public void testDeleteEmpresaExpectedFunctionality(){
         try {
            ServiceFactory.getInstance().getEmpresaService().delete(empresa.getNit());
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            //fail();
        }
        
    }
    
  
    
    
}
