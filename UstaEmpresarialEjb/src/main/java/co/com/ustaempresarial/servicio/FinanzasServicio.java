package co.com.ustaempresarial.servicio;

import co.com.ustaempresarial.fachada.FinanzasFachada;
import co.com.ustaempresarial.finanzas.modelo.*;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FinanzasServicio {

    @EJB
    FinanzasFachada fachada;

    /**
     * Metodo que lista las LibroDiarios de los productos
     *
     * @return listarLibroDiario Lista de las LibroDiarios de producto
     * @throws Exception Capturar errores posibles sobre ejecucion
     *                   <p>
     *                   developed by
     */
    public List<LibroDiario> listarLibroDiario() throws Exception {
        return fachada.listarLibroDiario();
    }


    /**
     * Metodo que crea LibroDiarios del producto
     *
     * @param LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public void crearLibroDiarior(LibroDiario LibroDiario) throws Exception {
        fachada.crearLibroDiario(LibroDiario);
    }


    /**
     * Metodo que actualiza LibroDiario del producto
     *
     * @param LibroDiario
     * @return Objeto LibroDiario
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public LibroDiario editarLibroDiario(LibroDiario LibroDiario) throws Exception {
        return fachada.editarLibroDiario(LibroDiario);
    }


    /**
     * Metodo que elimina el LibroDiario del producto
     *
     * @param cod
     * @return si se ejecuta el metodo, en lugar de eliminar cambia su estado. True: Activo. False: Inactivo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarLibroDiario(int cod) throws Exception {
        return fachada.eliminarLibroDiario(cod);
    }


    /**
     * Metodo que busca LibroDiario del producto por nombre
     *
     * @param nombre del LibroDiario
     * @return Objeto LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception {
        return fachada.listarLibroDiariosByNombre(nombre);
    }


    /**
     * Metodo que lista los LibroMayor
     *
     * @return List<LibroMayor> Lista de los LibroMayors
     * @throws Exception Capturar errores posibles osbre ejecucion
     */
    public List<LibroMayor> listarLibroMayor() throws Exception {
        return fachada.listarLibroMayor();
    }


    /**
     * Metodo que crea los LibroMayor
     *
     * @param LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public void crearLibroMayorr(LibroMayor LibroMayor) throws Exception {
        fachada.crearLibroMayor(LibroMayor);
    }


    /**
     * Metodo que actualiza un LibroMayor
     *
     * @param LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public LibroMayor editarLibroMayor(LibroMayor LibroMayor) throws Exception {
        return fachada.editarLibroMayor(LibroMayor);
    }


    /**
     * Metodo que elimina la LibroMayor
     *
     * @param cod
     * @return si se ejecuta el metodo, en lugar de eliminar cambia su estado. True: Activo. False: Inactivo
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public boolean eliminarLibroMayor(int cod) throws Exception {
        return fachada.eliminarLibroMayor(cod);
    }


    /**
     * Metodo que busca LibroMayor por nombre
     *
     * @param nombre del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    public List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception {
        return fachada.listarLibroMayorsByNombre(nombre);
    }


    /**
     * Metodo que crea Periodo
     *
     * @param periodo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearPeriodo(Periodo periodo) throws Exception {
        fachada.crearPeriodo(periodo);
    }


    /**
     * Metodo que actualiza un Periodo
     *
     * @param periodo
     * @return Objeto periodo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Periodo editarPeriodo(Periodo periodo) throws Exception {
        return fachada.editarPeriodo(periodo);
    }

    /**
     * Metodo que elimina un Periodo
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarPeriodo(int codigo) throws Exception {
        return fachada.eliminarPeriodo(codigo);

    }

    /**
     * Metodo que crea un Periodo
     *
     * @param Periodo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Periodo> listarPeriodo() throws Exception {
        return fachada.listarPeriodo();
    }


    /**
     * Metodo que busca Periodo por nombre
     *
     * @param nombre del Periodo
     * @return Objeto Periodo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Periodo listarPeriodoPorNombre(String nombre) throws Exception {
        return fachada.listarPeriodoPorNombre(nombre);
    }


    /**
     * Metodo que crea un Concepto
     *
     * @param concepto
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearConcepto(Concepto concepto) throws Exception {
        fachada.crearConcepto(concepto);
    }


    /**
     * Metodo que actualiza un Concepto
     *
     * @param concepto
     * @return Objeto Concepto
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Concepto editarConcepto(Concepto concepto) throws Exception {
        return fachada.editarConcepto(concepto);
    }


    /**
     * Metodo que elimina un Concepto
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarConcepto(int codigo) throws Exception {
        return fachada.eliminarConcepto(codigo);
    }


    /**
     * Metodo que lista los Conceptos
     *
     * @return List<Concepto> Lista de los Conceptos
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Concepto> listarConcepto() throws Exception {
        return fachada.listarConcepto();
    }


    /**
     * Metodo que busca un concepto por nombre
     *
     * @param nombre del Concepto
     * @return Objeto nombre
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Concepto listarConceptoPorNombre(String nombre) throws Exception {
        return fachada.listarConceptoPorNombre(nombre);
    }


    /**
     * Metodo que crea un PlanContable
     *
     * @param plan_contable
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean crearPlanContable(PlanContable plan_contable) throws Exception {
        return  fachada.crearPlanContable(plan_contable);
    }


    /**
     * Metodo que actualiza un PlanContable
     *
     * @param plan_contable
     * @return Objeto PlanContable
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public PlanContable editarPlanContable(PlanContable plan_contable) throws Exception {
        return fachada.editarPlanContable(plan_contable);
    }

    /**
     * Metodo que elimina un PlanContable
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarPlanContable(int codigo) throws Exception {
        return fachada.eliminarPlanContable(codigo);
    }


    /**
     * Metodo que lista un PlanContable
     *
     * @return List<PlanContable> Lista de los PlanContable
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<PlanContable> listarPlanContable() throws Exception {
        List<PlanContable> planContables = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            PlanContable planContable = new PlanContable();
//            planContable.setCodigo(1000000 + i);
//            planContable.setNombre("prueba");
//            planContable.setDescripcion("Es una prueba");
//            planContable.setTipo(1);
//            planContable.setVigencia(new Date());
//            planContable.setCodigoPadre(1);
//            planContables.add(planContable);
//        }
        return fachada.listarPlanContable();
//        return planContables;
    }


    /**
     * Metodo que busca PlanContable por nombre
     *
     * @param nombre del PlanContable
     * @return Objeto PlanContable
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public PlanContable listarPlanContablePorNombre(String nombre) throws Exception {
        return fachada.listarPlanContablePorNombre(nombre);
    }

    /**
     * Busca un plan contable por su código identificador
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    public PlanContable buscarPlanContable(int codigo) throws Exception {
        return fachada.buscarPlanContable(codigo);
    }


}
