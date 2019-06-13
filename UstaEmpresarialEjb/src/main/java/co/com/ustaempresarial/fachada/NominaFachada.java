package co.com.ustaempresarial.fachada;

import co.com.UstaEmpresarial.nomina.dto.LiquidacionNominaDTO;
import co.com.UstaEmpresarial.nomina.modelo.*;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface NominaFachada {

    // ==================================================================================================================
    // -------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea una nueva hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public boolean crearHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Modifica la información de una hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Elimina la hoja de vida correspondiente al código
     *
     * @param codigoHojaVida
     * @return
     * @throws Exception
     */
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception;

    /**
     * Lista todas la hojas de vida existentes
     *
     * @return Listado de las hojas de vida registradas
     * @throws Exception
     */
    public List<HojaVida> listarHojasVida() throws Exception;
    // ==================================================================================================================
    // -------------------------------------------------CARGO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un nuevo Cargo existente en la base de datos
     *
     * @param cargo Objeto cargo
     * @throws Exception
     */
    public void crearCargo(Cargo cargo) throws Exception;

    /**
     * Edita un cargo existente en la base de datos
     *
     * @param cargo Objetos cargo a editar
     * @throws Exception
     */
    public void editarCargo(Cargo cargo) throws Exception;

    /**
     * Elimina un cargo de la base de datos
     *
     * @param cargo Objeto cargo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean eliminarCargo(Cargo cargo) throws Exception;

    /**
     * Lista todos los cargos en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Cargo> listarCargos() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------DEPENDENCIA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea una nueva Dependencia
     *
     * @param depen Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void crearDependencia(Dependencia depen) throws Exception;

    /**
     * Modifica una dependencia existente
     *
     * @param depen dependencia
     * @return dependencia actualizada
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public void editarDependencia(Dependencia depen) throws Exception;

    /**
     * Elimina  la dependencia correspondiente al código especificado
     *
     * @param codigo Código de la dependencia
     * @return true: borra si el código de la dependencia está en contrato
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean borrarDependencia(int codigo) throws Exception;

    /**
     * Lista todas las  dependencias existentes
     *
     * @return List<dependencia>: Lista de dependencias
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public List<Dependencia> listarDependencias() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------CONTRATO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un contrato
     *
     * @param contrato
     * @return true or false
     * @throws Exception
     */
    public boolean crearContrato(Contrato contrato) throws Exception;

    /**
     * Modifica un contrato
     *
     * @param contrato
     * @return true or false
     * @throws Exception
     */
    public Contrato editarContrato(Contrato contrato) throws Exception;

    /**
     * Elimina un Contrato correspondiente al código especificado
     *
     * @param codigo
     * @return true or false
     * @throws Exception
     */
    public boolean eliminarContrato(int codigo) throws Exception;

    /**
     * lista los contratos por -dependencias-hojavida
     *
     * @return lista las dependencias
     * @throws Exception
     */
    public List<Contrato> listaContratoDependecia() throws Exception;

    /**
     * listarContratoCargo lista los contratos por cargo
     *
     * @return lista los cargos
     * @throws Exception
     */
    public List<Contrato> listaContratoCargo() throws Exception;

    /**
     * listarContratoAll lista todo el contrato
     *
     * @return lista con todos los datos
     * @throws Exception
     */
    public List<Contrato> listaContratoTodo() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------CONCEPTO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un nuevo concepto en la base de datos
     *
     * @param conceptos Objeto concepto
     * @throws Exception
     */
    public void crearConcepto(Concepto conceptos) throws Exception;

    /**
     * Edita un concepto existente en la base de datos
     *
     * @param concep editar
     * @throws Exception
     */
    public Concepto editarConcepto(Concepto concep) throws Exception;

    /**
     * Elimina un concepto de la base de datos
     *
     * @param codigo a eliminar
     * @return true si se eliminó, false si no
     * @throws Exception
     */
    public boolean borrarConcepto(int codigo) throws Exception;

    /**
     * Lista todos los conceptos de la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception
     */
    public List<Concepto> listarConceptos() throws Exception;

    // ==================================================================================================================
    // -------------------------------------------------PERIODO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un Periodo
     *
     * @param per Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public boolean crearPeriodo(Periodo per) throws Exception;

    /**
     * Edita un periodo
     *
     * @param per periodo
     * @return periodo actualizado
     * @throws Exception Capturar errores posibles sobre ejecución
     */
    public boolean editarPeriodo(Periodo per) throws Exception;

    /**
     * Borra el periodo correspondiente al código
     *
     * @param codigo Código del periodo
     * @return true: donde si borra y false donde hay error de ejecución
     * @throws Exception Exception Capturar errores posibles sobre ejecución
     */
    public boolean borrarPeriodo(int codigo) throws Exception;


    /**
     * Lista todos los periodos existentes
     *
     * @return List periodos
     * @throws Exception
     */
    public List<Periodo> listarPeriodos() throws Exception;

    //==================================================================================================================
    //-------------------------------------------------NOMINA-----------------------------------------------------
    //==================================================================================================================

    /**
     * Genera los conceptos de nomina por contrato para cada periodo y por empleado
     * Sirve para saber cuanto hay que pagar por cada empleado en un periodo especifico
     *
     * @param nomina
     * @throws Exception
     */
    public boolean liquidarNomina(Nomina nomina) throws Exception;

    /**
     * Edita una nomina
     *
     * @param nomina
     * @return
     * @throws Exception
     */
    public Nomina editarNomina(Nomina nomina) throws Exception;

    /**
     * Lista todos los pagos de nomina realizados a un empleado
     *
     * @param documento documento del empleado
     * @return
     * @throws Exception
     */

    public List<LiquidacionNominaDTO> conceptosLiquidadosNominaEmpleado(int documento) throws Exception;

    /**
     * Lista todos los pagos de nomina por periodos de todos los empleados
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<LiquidacionNominaDTO> conceptosLiquidadosPorPeriodo(int id) throws Exception;

    //-------------------------------** regla de negocio ** ---------------------------------------------

    /**
     * Compara las liquidaciones del mes actual con el mes anterior las cuales en caso de  superar el 10%
     * en diferencias se debe generar un reporte informando.
     * @return
     * @throws Exception
     */
    public List<LiquidacionNominaDTO> compararLiquidaciones() throws Exception;

}