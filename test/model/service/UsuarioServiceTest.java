package model.service;

import model.dao.exceptions.DataBaseException;
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
    public void testLogin() throws DataBaseException {
        System.out.println("login");
        
        //Caso Valido
        UsuarioVO vo = new UsuarioVO();
        vo.setDni(Long.MIN_VALUE);
        vo.setNombreDeUsuario("rogelio");
        vo.setClave("vidriolo");
        
        UsuarioVO result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        
        UsuarioVO expResult = ServiceFactory.getInstance().getUsuarioService().find(vo.getDni());
        assertEquals(expResult.getDni(), result.getDni());
        
        //casos invalidos
        
        vo.setClave("vidriola");
        
        result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        expResult = null;
        assertEquals(expResult, result);
        
        //2do caso invalido
        vo.setNombreDeUsuario("roger");
        vo.setClave("vidriolo");
        
        result = ServiceFactory.getInstance().getUsuarioService().login(vo);
        expResult = null;
        assertEquals(expResult, result);
        

    }
}
