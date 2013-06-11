package model.service;

import controller.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.exceptions.*;
import model.entity.Nivel;
import model.entity.Rol;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Zergio
 */
public class UsuarioServiceTest {

    UsuarioVO usuario;
    UsuarioVO pruebasPersistencia;
    EmpresaVO empresa;
    //sizes
    int MAXPASS = 255;
    int MAXMAIL = 30;
    int MAXNAME = 80;
    int MAXUSERNAME = 20;
    String VALID_CHARACTERS_NAME = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-`´¨";
    String VALID_CHARACTERS_PASS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String VALID_CHARACTERS_MAIL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.@";
    String VALID_CHARACTERS_USERNAME = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.@";

    public UsuarioServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {


        UsuarioVO usuario = new UsuarioVO();
        String nombreUsuario = "FirstAdministrator";
        String clave = "FirstAdministrator";

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

        System.out.println(LoginController.usuarioActivo);

        empresa = new EmpresaVO();
        empresa.setDireccion("Esta es la direccion");

        empresa.setNit(404);
        empresa.setNivel(Nivel.DISTRIBUIDORA);
        empresa.setNombre("Industrias Bayer");
        empresa.setTelefono("88888888");

        if (ServiceFactory.getInstance().getEmpresaService().find(404) == null) {

            try {
                ServiceFactory.getInstance().getEmpresaService().create(empresa);
            } catch (PreexistingEntityException | NonexistentEntityException | RequiredAttributeException | InsufficientPermissionsException | InvalidAttributeException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        usuario = new UsuarioVO();
        usuario.setNombre("Rogelio");
        usuario.setRol(Rol.PRIMER_ADMINISTRADOR);
        usuario.setCorreo("rogelio@bayer.com");
        usuario.setDni(new Long("404"));
        usuario.setNombreDeUsuario("rogelio");
        usuario.setClave("vidriolo");
        usuario.setEmpresasNIT(404);

        if (ServiceFactory.getInstance().getUsuarioService().find(new Long("404")) == null) {

            try {
                ServiceFactory.getInstance().getUsuarioService().create(usuario);
            } catch (PreexistingEntityException | NonexistentEntityException | RequiredAttributeException | InsufficientPermissionsException | InvalidAttributeException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        pruebasPersistencia = new UsuarioVO();
        pruebasPersistencia.setNombre("Rogelio");
        pruebasPersistencia.setRol(Rol.PRIMER_ADMINISTRADOR);
        pruebasPersistencia.setCorreo("rogelio@bayer.com");
        pruebasPersistencia.setDni(new Long("405"));
        pruebasPersistencia.setNombreDeUsuario("rogelio");
        pruebasPersistencia.setClave("vidriolo");
        pruebasPersistencia.setEmpresasNIT(404);
    }

    @After
    public void tearDown() {

        try {
            ServiceFactory.getInstance().getUsuarioService().delete(new Long("404"));
        } catch (NonexistentEntityException | InsufficientPermissionsException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ServiceFactory.getInstance().getEmpresaService().delete(404);
        } catch (NonexistentEntityException | InsufficientPermissionsException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        usuario = null;
        pruebasPersistencia = null;
        empresa = null;

    }

    /**
     * Test of login method, of class UsuarioService.
     */
    @Test
    public void testLoginExpectedFunctionality() {


        //Caso Valido
        UsuarioVO vo = new UsuarioVO();
        vo.setDni(new Long("404"));
        vo.setNombreDeUsuario("rogelio");
        vo.setClave("vidriolo");

        UsuarioVO result = null;


        try {
            result = ServiceFactory.getInstance().getUsuarioService().login(vo);
            System.out.println("login");
        } catch (DataBaseException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        UsuarioVO expResult = ServiceFactory.getInstance().getUsuarioService().find(vo.getDni());
        assertEquals(expResult.getDni(), result.getDni());


    }

    @Test
    public void testLoginWrongPassword() {

        UsuarioVO vo = new UsuarioVO();
        vo.setDni(new Long("404"));
        vo.setNombreDeUsuario("rogelio");
        vo.setClave("vidriola");

        UsuarioVO result = null;

        try {
            result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        } catch (DataBaseException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioVO expResult = null;
        assertEquals(expResult, result);


    }

    @Test
    public void testLoginInexistentUser() {

        UsuarioVO vo = new UsuarioVO();
        vo.setDni(new Long("404"));
        vo.setNombreDeUsuario("roger");
        vo.setClave("vidriolo");

        UsuarioVO result = null;

        try {
            result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        } catch (DataBaseException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioVO expResult = null;
        assertEquals(expResult, result);


    }

    @Test
    public void testValidarCamposExpectedFunctionality() throws Exception {
        System.out.println("validarCamposExpectedFunctionality");
        boolean expResult = true;
        boolean result = ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarCamposNullRequieredFieldDni() {
        System.out.println("validarCamposNullRequieredFieldDni");

        usuario.setDni(null);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposNullRequieredFieldPass() {
        System.out.println("validarCamposNullRequieredFieldPass");

        usuario.setClave(null);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposNullRequieredFieldMail() {
        System.out.println("validarCamposNullRequieredFieldMail");

        usuario.setCorreo(null);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposNullRequieredFieldName() {
        System.out.println("validarCamposNullRequieredFieldName");

        usuario.setNombre(null);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposNullRequieredFieldUserName() {
        System.out.println("validarCamposNullRequieredFieldUserName");

        usuario.setNombreDeUsuario(null);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInPass() {
        System.out.println("validarCamposInvalidCharactersInPass");

        usuario.setClave("**********");

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInName() {
        System.out.println("validarCamposInvalidCharactersInName");

        usuario.setNombre("*************************");

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInUserName() {
        System.out.println("validarCamposInvalidCharactersInUserName");

        usuario.setNombre("***********");

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidCharactersInMail() {
        System.out.println("validarCamposInvalidCharactersInMail");

        usuario.setNombre("***********");

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInPass() {
        System.out.println("validarCamposInvalidNumberOfCharactersInPass");
        char dummy = '0';
        String pass = new String();



        for (int i = 1; i <= MAXPASS; i++) {
            pass = pass + dummy;
        }

        System.out.println(pass + " " + pass.length());

        usuario.setClave(pass);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInMail() {
        System.out.println("validarCamposInvalidNumberOfCharactersInMail");
        char dummy = '0';
        String mail = new String();



        for (int i = 1; i <= MAXMAIL; i++) {
            mail = mail + dummy;
        }

        System.out.println(mail + " " + mail.length());

        usuario.setCorreo(mail);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInName() {
        System.out.println("validarCamposInvalidNumberOfCharactersInName");
        char dummy = '0';
        String name = new String();



        for (int i = 1; i <= MAXNAME; i++) {
            name = name + dummy;
        }

        System.out.println(name + " " + name.length());

        usuario.setNombre(name);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testValidarCamposInvalidNumberOfCharactersInUserName() {
        System.out.println("validarCamposInvalidNumberOfCharactersInUserName");
        char dummy = '0';
        String username = new String();



        for (int i = 1; i <= MAXNAME; i++) {
            username = username + dummy;
        }

        System.out.println(username + " " + username.length());

        usuario.setNombreDeUsuario(username);

        try {
            ServiceFactory.getInstance().getUsuarioService().validarCampos(usuario);
            fail();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testCreateUsuarioExpectedFunctionality() {
        try {
            ServiceFactory.getInstance().getUsuarioService().create(pruebasPersistencia);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }

    @Test
    public void testFindUsuarioExpectedFunctionality() {
        assertEquals(ServiceFactory.getInstance().getUsuarioService().find(pruebasPersistencia.getDni()), pruebasPersistencia);
    }

    @Test
    public void testFindByEnterpriseUsuarioExpectedFunctionality() {
        assertEquals(ServiceFactory.getInstance().getUsuarioService().findByEnterprise(pruebasPersistencia.getEmpresasNIT()), pruebasPersistencia);
    }

    @Test
    public void testFindByNameAndEnterpriseUsuarioExpectedFunctionality() {
        assertEquals(ServiceFactory.getInstance().getUsuarioService().findByNameAndEnterprise(pruebasPersistencia.getNombre(), empresa.getEmpresasnit()), pruebasPersistencia);
    }

    @Test
    public void testFindByDNIAndEnterpriseUsuarioExpectedFunctionality() {
        assertEquals(ServiceFactory.getInstance().getUsuarioService().findByDNIAndEnterprise(pruebasPersistencia.getDni(), empresa.getNit()), pruebasPersistencia);
    }

    @Test
    public void testUpdateUsuarioExpectedFunctionality() {

        UsuarioVO tempUsuario = ServiceFactory.getInstance().getUsuarioService().find(pruebasPersistencia.getDni());
        tempUsuario.setNombre("Cambio en usuario");
        try {
            ServiceFactory.getInstance().getUsuarioService().update(tempUsuario);
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }

        assertEquals(ServiceFactory.getInstance().getUsuarioService().find(pruebasPersistencia.getDni()).getNombre(), "Cambio en usuario");

    }

    @Test
    public void testDeleteUsuarioExpectedFunctionality() {
        try {
            ServiceFactory.getInstance().getUsuarioService().delete(pruebasPersistencia.getDni());
        } catch (Exception ex) {
            Logger.getLogger(ErrorServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
}
