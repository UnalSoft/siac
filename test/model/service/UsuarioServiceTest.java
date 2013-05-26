package model.service;

import controller.LoginController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DAOFactory;
import model.dao.exceptions.*;
import model.entity.Nivel;
import model.entity.Rol;
import model.vo.EmpresaVO;
import model.vo.ErrorVO;
import model.vo.UsuarioVO;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Zergio
 */
public class UsuarioServiceTest {

    public UsuarioServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {


        UsuarioVO usuario = new UsuarioVO();
        String nombreUsuario = "admin";
        String clave = "admin";

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

        EmpresaVO empresa = new EmpresaVO();
        empresa.setDireccion("Esta es la dirección");

        empresa.setNit(404);
        empresa.setNivel(Nivel.DISTRIBUIDORA);
        empresa.setNombre("Industrias Bayer");
        empresa.setTelefono("88888888");

        if (ServiceFactory.getInstance().getEmpresaService().find(404) == null) {

            try {
                ServiceFactory.getInstance().getEmpresaService().create(empresa);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RequiredAttributeException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InsufficientPermissionsException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        UsuarioVO usuario = new UsuarioVO();
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
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RequiredAttributeException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InsufficientPermissionsException ex) {
                Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @After
    public void tearDown() {

        try {
            ServiceFactory.getInstance().getUsuarioService().delete(new Long("404"));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ServiceFactory.getInstance().getEmpresaService().delete(404);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public void testValidarCampos() {
    }
}
