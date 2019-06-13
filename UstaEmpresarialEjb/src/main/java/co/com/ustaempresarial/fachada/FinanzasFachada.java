package co.com.ustaempresarial.fachada;

import co.com.ustaempresarial.finanzas.modelo.*;

import javax.ejb.Remote;
import java.util.List;

@Remote
public
interface FinanzasFachada {

    /**
     * Metodo que lista las LibroDiarios
     *
     * @return List<LibroDiario> Lista de las LibroDiarios de
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroDiario> listarLibroDiario() throws Exception;

    /**
     * Metodo que crea las LibroDiarios de
     *
     * @param LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    void crearLibroDiario(LibroDiario LibroDiario) throws Exception;

    /**
     * Metodo que actualiza la LibroDiario
     *
     * @param LibroDiario
     * @return Objeto LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroDiario editarLibroDiario(LibroDiario LibroDiario) throws Exception;

    /**
     * Metodo que elimina la LibroDiario
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    boolean eliminarLibroDiario(int codigo) throws Exception;

    /**
     * Metodo que busca LibroDiario  por nombre
     *
     * @param nombre de la categor�a
     * @return Objeto categor�a
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroDiario listalibroDiarioByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroDiario  por nombre
     *
     * @param nombre de la categor�a
     * @return Objeto categor�a
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception;


    /**
     * Metodo que lista los LibroMayors
     *
     * @return List<LibroMayor> Lista de los LibroMayors
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroMayor> listarLibroMayor() throws Exception;

    /**
     * Metodo que crea los LibroMayors
     *
     * @param LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    void crearLibroMayor(LibroMayor LibroMayor) throws Exception;

    /**
     * Metodo que actualiza un LibroMayor
     *
     * @param LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroMayor editarLibroMayor(LibroMayor LibroMayor) throws Exception;

    /**
     * Metodo que elimina la LibroMayor
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    boolean eliminarLibroMayor(int codigo) throws Exception;

    /**
     * Metodo que busca LibroMayor por nombre
     *
     * @param nombre del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroMayor listarLibroMayorByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroMayor por nombre
     *
     * @param nombre del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception;


    /**
     * Metodo que lista los Periodo
     *
     * @return List<Periodo> Lista de los Periodo
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    List<Periodo> listarPeriodo() throws Exception;

    /**
     * Metodo que crea los Periodo
     *
     * @param Periodo
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    void crearPeriodo(Periodo periodo) throws Exception;

    /**
     * Metodo que actualiza un Periodo
     *
     * @param Periodo
     * @return Objeto Periodo
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    Periodo editarPeriodo(Periodo periodo) throws Exception;

    /**
     * Metodo que elimina la Periodo
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    boolean eliminarPeriodo(int codigo) throws Exception;

    /**
     * Metodo que busca Periodo por nombre
     *
     * @param nombre del Periodo
     * @return Objeto Periodo
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    Periodo listarPeriodoPorNombre(String nombre) throws Exception;


    /**
     * Metodo que lista los Concepto
     *
     * @return List<Concepto> Lista de los Concepto
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    List<Concepto> listarConcepto() throws Exception;

    /**
     * Metodo que crea los Concepto
     *
     * @param Concepto
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    void crearConcepto(Concepto concepto) throws Exception;

    /**
     * Metodo que actualiza un Concepto
     *
     * @param Concepto
     * @return Objeto Concepto
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    Concepto editarConcepto(Concepto concepto) throws Exception;

    /**
     * Metodo que elimina la Concepto
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    boolean eliminarConcepto(int codigo) throws Exception;

    /**
     * Metodo que busca Concepto por nombre
     *
     * @param nombre del Concepto
     * @return Objeto Concepto
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    Concepto listarConceptoPorNombre(String nombre) throws Exception;


    /**
     * Metodo que lista los PlanContable
     *
     * @return List<PlanContable> Lista de los PlanContable
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    List<PlanContable> listarPlanContable() throws Exception;

    /**
     * Metodo que crea los PlanContable
     *
     * @param PlanContable
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    boolean crearPlanContable(PlanContable plan_contable) throws Exception;

    /**
     * Metodo que actualiza un PlanContable
     *
     * @param PlanContable
     * @return Objeto PlanContable
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    PlanContable editarPlanContable(PlanContable plan_contable) throws Exception;

    /**
     * Metodo que elimina la PlanContable
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    boolean eliminarPlanContable(int codigo) throws Exception;

    /**
     * Metodo que busca PlanContable por nombre
     *
     * @param nombre del PlanContable
     * @return Objeto PlanContable
     * @throws Exception Capturar errores posibles sobre ejecicion
     */
    PlanContable listarPlanContablePorNombre(String nombre) throws Exception;

    /**
     * Busca un registro del libro diario por su código
     * @param codigo
     * @return
     * @throws Exception
     */
    LibroDiario buscarLibroDiarioById(int codigo) throws Exception;

    /**
     * Busca un plan contable por su código identificador
     * @param codigo
     * @return
     * @throws Exception
     */
    PlanContable buscarPlanContable(int codigo) throws Exception;


}
