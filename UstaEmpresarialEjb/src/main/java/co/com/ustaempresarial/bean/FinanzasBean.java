package co.com.ustaempresarial.bean;

import co.com.ustaempresarial.fachada.FinanzasFachada;
import co.com.ustaempresarial.finanzas.modelo.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanzasBean implements FinanzasFachada {

    @PersistenceContext(unitName = "PersistenceFinanzas")
    public EntityManager em;

    public FinanzasBean() {
        super();
    }

    /**
     * Metodo que crea los libro diarios.
     *
     * @param libroDiario
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public void crearLibroDiario(LibroDiario libroDiario) throws Exception {
        if (libroDiario.getAsiento() != null && libroDiario.getValor() != null) {
            em.persist(libroDiario);
            em.flush();
        }
    }

    /**
     * Metodo que lista los libros diarios.
     *
     * @return List<LibroDiario> Lista de los libros diarios.
     * @throws Exception Capturar posibles errores sobre ejecución.
     */
    @Override
    public List<LibroDiario> listarLibroDiario() throws Exception {
        List<LibroDiario> libroDiario = new ArrayList<>();
        Query q = em.createNamedQuery(LibroDiario.LISTARLibroDiario);
        libroDiario = q.getResultList();
        return libroDiario;
    }

    /**
     * Metodo que busca libro diario por el nombre.
     *
     * @param Nombre del libro diario.
     * @return Objeto libroDiario con listado por nombre.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public LibroDiario listalibroDiarioByNombre(String nombre) throws Exception {
        LibroDiario objlibroDiario = new LibroDiario();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery

                    (LibroDiario.LISTARLibroDiarioBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objlibroDiario = (LibroDiario) obj;
        }

        return objlibroDiario;
    }

    /**
     * Metodo que busca libro diario por el nombre.
     *
     * @param nombre del libro diario.
     * @return Lista de los los libros diarios por nombre.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception {
        List<LibroDiario> listLibroDiario = new ArrayList<>();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery

                    (LibroDiario.LISTARLibroDiarioBYNAME).setParameter("nombre", nombre);

            listLibroDiario = q.getResultList();
        }
        return listLibroDiario;
    }

    /**
     * Metodo que actualiza la LibroDiario producto.
     *
     * @param libroDiario.
     * @return Objeto libroDiario.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public LibroDiario editarLibroDiario(LibroDiario libroDiario) throws Exception {
        new LibroDiario();
        LibroDiario p;
        if (libroDiario != null) {
            p = buscarLibroDiarioById(libroDiario.getAsiento());
            if (p.getAsiento() > 0) {
                em.merge(libroDiario);
                em.flush();
            } else {
                libroDiario = null;
            }
        }
        return libroDiario;
    }

    /**
     * Metodo que elimina el libro diario.
     *
     * @param codigo del libro diario.
     * @return True si se borro y false si no se borra.
     * @throws Exception Capturar errores posibles sobre ejecición.
     */
    @Override
    public boolean eliminarLibroDiario(int codigo) throws Exception {
        LibroDiario LibroDiario = buscarLibroDiarioById(codigo);
        boolean retorno = false;
        LibroDiario.setEstado(false);
        if (LibroDiario.getAsiento() > 0) {
            em.merge(LibroDiario);
            retorno = true;
        }
        return retorno;
    }

    /**
     * Metodo que busca el libro diario por nombre.
     *
     * @param Codigo del libro diario.
     * @return p, el resultado de la busqueda por nombre.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public LibroDiario buscarLibroDiarioById(int codigo) throws Exception {
        LibroDiario p = new LibroDiario();
        p = em.find(LibroDiario.class, codigo);
        return p;
    }

    /**
     * Busca un plan contable por su código identificador
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public PlanContable buscarPlanContable(int codigo) throws Exception {
        return null;
    }

    /**
     * Metodo que crea los libros mayores.
     *
     * @param libroMayor.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public void crearLibroMayor(LibroMayor libroMayor) throws Exception {
        if (libroMayor.getId() != null && libroMayor.getDebe() != null) {
            em.persist(libroMayor);
            em.flush();
        }
    }

    /**
     * Metodo que lista los libros mayores.
     *
     * @return List<LibroMayor> Lista de los libros mayores.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public List<LibroMayor> listarLibroMayor() throws Exception {
        List<LibroMayor> libroMayor;
        Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayor);
        libroMayor = q.getResultList();
        return libroMayor;
    }

    /**
     * Metodo que lista los libros mayores por nombre.
     *
     * @param Nombre del libro mayor.
     * @return Objeto LibroMayor.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public LibroMayor listarLibroMayorByNombre(String nombre) throws Exception {
        LibroMayor objLibroMayor = new LibroMayor();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayorBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objLibroMayor = (LibroMayor) obj;
        }
        return objLibroMayor;
    }

    /**
     * Metodo que lista los libros mayores por nombre.
     *
     * @param Nombre del libro mayor.
     * @return List<LibroMayor>. Listado de libros mayores.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception {
        List<LibroMayor> listLibroMayor = new ArrayList<>();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayorBYNAME).setParameter("nombre", nombre);
            listLibroMayor = q.getResultList();
        }
        return listLibroMayor;
    }

    /**
     * Metodo que actualiza un LibroMayor
     *
     * @param libroMayor.
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    @Override
    public LibroMayor editarLibroMayor(LibroMayor libroMayor) throws Exception {
        LibroMayor p = new LibroMayor();
        if (libroMayor != null) {
            p = buscarLibroMayorById(libroMayor.getId().getPeriodoCod());
            if (p.getId().getPeriodoCod() > 0) {
                em.merge(libroMayor);
                em.flush();
            } else {
                libroMayor = null;
            }
        }
        return libroMayor;
    }

    /**
     * Metodo que elimina un libro mayor.
     *
     * @param codigo del libro mayor.
     * @return True si se borro y false si no se borro.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public boolean eliminarLibroMayor(int codigo) throws Exception {
        LibroMayor LibroMayor = buscarLibroMayorById(codigo);
        boolean retorno = false;
        LibroMayor.setEstado(false);
        if (LibroMayor.getId().getPeriodoCod() > 0) {
            em.merge(LibroMayor);
            retorno = true;
        }
        return retorno;
    }

    /**
     * Metodo que busca libro mayor por ID.
     *
     * @param Codigo del libro mayor.
     * @return p, es el libro mayor buscado por ID.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public LibroMayor buscarLibroMayorById(int codigo) throws Exception {
        LibroMayor p = new LibroMayor();
        p = em.find(LibroMayor.class, codigo);
        return p;
    }

    /**
     * Metodo que busca el periodo por su codigo.
     *
     * @param Codigo del periodo.
     * @return p, es el periodo buscado por su codigo.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Periodo buscarPeriodoPorCodigo(int codigo) throws Exception {
        Periodo p = new Periodo();
        p = em.find(Periodo.class, codigo);
        return p;
    }

    /**
     * Metodo que crea un periodo.
     *
     * @param Objeto periodo.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public void crearPeriodo(Periodo periodo) throws Exception {
        if (periodo.getCodigo() != null) {
            em.persist(periodo);
            em.flush();
        }
    }

    /**
     * Metodo que actualiza el periodo.
     *
     * @param Objeto periodo.
     * @return Objeto newcampania. El periodo actualizado.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Periodo editarPeriodo(Periodo periodo) throws Exception {
        Periodo newcampania = new Periodo();
        newcampania = buscarPeriodoPorCodigo(periodo.getCodigo());
        if (newcampania.getCodigo() > 0) {
            em.merge(periodo);
        } else newcampania = null;

        return newcampania;
    }

    /**
     * Metodo que elimina el periodo.
     *
     * @param Codigo del periodo.
     * @return True si se elimina, false si no se elimina.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public boolean eliminarPeriodo(int codigo) throws Exception {
        Periodo periodo = buscarPeriodoPorCodigo(codigo);
        boolean retorno = false;
        periodo.setEstado(false);
        if (periodo.getCodigo() > 0) {
            em.merge(periodo);
            retorno = true;
        }
        return retorno;
    }

    /**
     * Metodo que lista los periodos.
     *
     * @return Lista de periodos.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public List<Periodo> listarPeriodo() throws Exception {

        List<Periodo> periodo;
        Query q = em.createNamedQuery(Periodo.LISTARPERIODO);
        periodo = q.getResultList();
        return periodo;
    }

    /**
     * Metodo que lista los periodos por su nombre.
     *
     * @param Nombre del periodo.
     * @return Objeto objPeriodo con el listdo de periodos.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Periodo listarPeriodoPorNombre(String nombre) throws Exception {
        Periodo objPeriodo = new Periodo();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(Periodo.LISTARPERIODOBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objPeriodo = (Periodo) obj;
        }
        return objPeriodo;
    }

    /**
     * Metodo que busca el concepto por su codigo.
     *
     * @param Codigo del concepto.
     * @return p, es el concepto buscado por su codigo.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Concepto buscarConceptoPorCodigo(int codigo) throws Exception {
        Concepto p = new Concepto();
        p = em.find(Concepto.class, codigo);
        return p;
    }

    /**
     * Metodo que crea un concepto.
     *
     * @param Objeto concepto.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public void crearConcepto(Concepto concepto) throws Exception {
        if (concepto.getCodigo() != null) {
            em.persist(concepto);
            em.flush();
        }
    }

    /**
     * Metodo que actualiza el concepto.
     *
     * @param Objeto concepto.
     * @return Objeto newcampania con el concepto actualizado.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Concepto editarConcepto(Concepto concepto) throws Exception {
        Concepto newcampania = new Concepto();
        newcampania = buscarConceptoPorCodigo(concepto.getCodigo());
        if (newcampania.getCodigo() > 0) {
            em.merge(concepto);
        } else newcampania = null;

        return newcampania;
    }

    /**
     * Metodo que elimina un concepto.
     *
     * @param Codigo del concepto.
     * @return True si se elimina, false si no se elimina.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public boolean eliminarConcepto(int codigo) throws Exception {
        Concepto concepto = buscarConceptoPorCodigo(codigo);
        boolean retorno = false;
        if (concepto.getCodigo() > 0) {
            em.remove(concepto);
            ;
            retorno = true;
        }
        return retorno;
    }

    /**
     * Metodo que lista los conceptos.
     *
     * @return List<Concepto> concepto. Lista de conceptos.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public List<Concepto> listarConcepto() throws Exception {
        List<Concepto> concepto;
        Query q = em.createNamedQuery(Concepto.LISTARCONCEPTO);
        concepto = q.getResultList();
        return concepto;
    }

    /**
     * Metodo que lista los conceptos por su nombre.
     *
     * @param Nombre del concepto.
     * @return Objeto objConcepto con el listado de conseptos por nombre.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public Concepto listarConceptoPorNombre(String nombre) throws Exception {
        Concepto objConcepto = new Concepto();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(Concepto.LISTARCONCEPTOBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objConcepto = (Concepto) obj;
        }
        return objConcepto;
    }

    /**
     * Metodo que busca un plan contable por su codigo.
     *
     * @param Codigo del plan contable.
     * @return Objeto p, con el plan contable buscado por su codigo.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public PlanContable buscarPlanContablePorCodigo(int codigo) throws Exception {
        PlanContable p = new PlanContable();
        p = em.find(PlanContable.class, codigo);
        return p;
    }

    /**
     * Metodo que crea un plan contable. Y a su vez hacer el ingreso de la nueva cuenta en la tabla log de cuentas Cuentas
     *
     * @param Objeto plan_contable.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public boolean crearPlanContable(PlanContable plan_contable) throws Exception {
        LogCuenta logNuevo = new LogCuenta();
        logNuevo.setCodigoCuentaNueva(plan_contable.getCodigo());
        logNuevo.setDescripcionCuentaNueva(plan_contable.getDescripcion());
        logNuevo.setNombreCuentaNueva(plan_contable.getNombre());
        logNuevo.setTipoCuentaNueva(plan_contable.getTipo());
        logNuevo.setVigenciaCuentaNueva(plan_contable.getVigencia());
        if (plan_contable.getCodigo() != null) {
            em.persist(logNuevo);
            em.persist(plan_contable);
            em.flush();
            return true;
        }
        return false;
    }

    /**
     * Metodo que actualiza un plan contable.
     *
     * @param Objeto plan_contable.
     * @return objeto newcampania con el plan_contable actualizado.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public PlanContable editarPlanContable(PlanContable plan_contable) throws Exception {
        PlanContable newcampania = new PlanContable();
        newcampania = buscarPlanContablePorCodigo(plan_contable.getCodigo());
        if (newcampania.getCodigo() > 0) {
            em.merge(plan_contable);
        } else newcampania = null;

        return newcampania;
    }

    /**
     * Metodo que elimina un plan contable.
     *
     * @param Codigo del plan contable.
     * @return True si se elimina, false si no se elimina.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public boolean eliminarPlanContable(int codigo) throws Exception {
        PlanContable plan_contable = buscarPlanContablePorCodigo(codigo);
        boolean retorno = false;
        if (plan_contable.getCodigo() > 0) {
            em.merge(plan_contable);
            retorno = true;
        }
        return retorno;
    }

    /**
     * Metodo que lista los planes contables.
     *
     * @return List<PlanContable> plan_contable, con el listado de planes contables.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public List<PlanContable> listarPlanContable() throws Exception {
        List<PlanContable> plan_contable = new ArrayList<PlanContable>();
        Query q = em.createNamedQuery(PlanContable.LISTAR_PLANCONTABLE);
        plan_contable = q.getResultList();
        return plan_contable;
    }

    /**
     * Metodo que lista los planes contables por sus nombres.
     *
     * @param Nombre del plan contable.
     * @return Objeto objPlanContable.
     * @throws Exception Capturar errores posibles sobre ejecución.
     */
    public PlanContable listarPlanContablePorNombre(String nombre) throws Exception {
        PlanContable objPlanContable = new PlanContable();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(PlanContable.LISTAR_PLANCONTABLE_BYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objPlanContable = (PlanContable) obj;
        }
        return objPlanContable;
    }


}
