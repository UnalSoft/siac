package model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DAOFactory;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
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
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        
        
        
        
//        EmpresaVO empresa = new EmpresaVO();
//        empresa.setDireccion("Esta es la dirección");
//        
//        empresa.setNit(1);
//        empresa.setNivel(Nivel.ADMINISTRADORA);
//        empresa.setNombre("Industrias Bayer");
//        empresa.setTelefono("88888888");
//        
//        try {
//            ServiceFactory.getInstance().getEmpresaService().create(empresa);
//        } catch (PreexistingEntityException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (RequiredAttributeException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//

//        UsuarioVO usuario = new UsuarioVO();
//        usuario.setNombre("Rogelio");
//        usuario.setRol(Rol.OTRO);
//        usuario.setCorreo("rogelio@bayer.com");
//        usuario.setDni(Long.MIN_VALUE);
//        usuario.setNombreDeUsuario("rogelio");
//        usuario.setClave("vidriolo");
//        usuario.setEmpresasNIT(1);
//
//        try {
//            ServiceFactory.getInstance().getUsuarioService().create(usuario);
//        } catch (PreexistingEntityException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NonexistentEntityException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (RequiredAttributeException ex) {
//            Logger.getLogger(UsuarioServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class UsuarioService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        UsuarioVO vo = new UsuarioVO();
        vo.setDni(Long.MIN_VALUE);
        vo.setNombreDeUsuario("rogelio");
        vo.setClave("vidriolo");
        
        UsuarioVO result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        
        UsuarioVO expResult = ServiceFactory.getInstance().getUsuarioService().find(vo.getDni());
        assertEquals(expResult.getDni(), result.getDni());

    }
}
