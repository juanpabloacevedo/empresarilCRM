package co.com.ustaempresarial.servicio;

import co.com.UstaEmpresarial.nomina.modelo.*;
import co.com.ustaempresarial.fachada.NominaFachada;

import javax.ejb.EJB;
import java.util.List;

public class NominaServicio {
    @EJB
    NominaFachada nominaFachada;

    //==================================================================================================================
    //-------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    //==================================================================================================================

    /**
     * Crea una nueva hoja de vida con respecto a el numero de documentacion de la persona 
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public boolean crearHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.crearHojaVida(hojaVida);
    }

    /**
     * Modifica la informacion de una hoja de vida buscando la hoja de vida por el codigo de creacion 
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.modificarHojaVida(hojaVida);
    }

    /**
     * Elimina la hoja de vida correspondiente al codigo ingresado 
     *
     * @param codigoHojaVida
     * @return
     * @throws Exception
     */
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
        return nominaFachada.eliminarHojaVida(codigoHojaVida);
    }

    /**
     * Lista todas la hojas de vida existentes con sus datos registrados 
     *
     * @return Listado de las hojas de vida registradas
     * @throws Exception
     */
    public List<HojaVida> listarHojasVida() throws Exception {
        return nominaFachada.listarHojasVida();
    }

    //==================================================================================================================
    //-------------------------------------------------CARGO-----------------------------------------------------
    //==================================================================================================================

    /**
     * Lista todos los cargos que se encuentren en la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */

    public List<Cargo> listarCargos() throws Exception {
        return nominaFachada.listarCargos();
    }

    /**
     * Crea un nuevo cargo en la base de datos
     *
     * @param cargo Objeto cargo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearCargo(Cargo cargo) throws Exception {
        nominaFachada.crearCargo(cargo);
    }

    /**
     * Edita un cargo existente en la base de datos
     *
     * @param cargo Objetos cargo a editar
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void editarCargo(Cargo cargo) throws Exception {
        nominaFachada.editarCargo(cargo);
    }

    /**
     * Elimina un cargo de la base de datos
     *
     * @param cargo Objeto cargo a eliminar
     * @return true si se elimin�, false si no
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarCargo(Cargo cargo) throws Exception {
        return nominaFachada.eliminarCargo(cargo);
    }

    //==================================================================================================================
    //-------------------------------------------------DEPENDENCIA-----------------------------------------------------
    //==================================================================================================================

    /**
     * Crea una nueva Dependencia
     *
     * @param depen Tipo de objeto a crear
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearDependencia(Dependencia depen) throws Exception {
        nominaFachada.crearDependencia(depen);
    }

    /**
     * Modifica una dependencia existente que es buscada por el codigo y muestra los datos que se pueden modificar 
     *
     * @param depen
     * @return dependencia actualizada
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void editarDependencia(Dependencia depen) throws Exception {
        nominaFachada.editarDependencia(depen);
    }

    /**
     * Elimina  la dependencia correspondiente al codigo especificado
     *
     * @param codigo C�digo de la dependencia
     * @return true: borra si el c�digo de la dependencia est� en contrato
     * @throws Exception Exception Capturar errores posibles sobre ejecuci�n
     */
    public boolean borrarDependencia(int codigo) throws Exception {
        return nominaFachada.borrarDependencia(codigo);
    }

    /**
     * Lista todas las  dependencias existentes
     *
     * @return List<dependencia>: Lista de dependencias
     * @throws Exception Capturar errores posibles sobre ejecuci�n
     */
    public List<Dependencia> traerDependencia() throws Exception {
        return nominaFachada.listarDependencias();
    }

    //==================================================================================================================
    //-------------------------------------------------CONTRATO-----------------------------------------------------
    //==================================================================================================================

    /**
     * Crea un contrato asignando un codigo teniendo en cuenta las reglas de negocio
     *
     * @param contrato
     * @return true : devuleve confirmacion si se creo el contrato 
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearContrato(Contrato contrato) throws Exception {
        nominaFachada.crearContrato(contrato);
    }

    /**
     * Modifica un contrato buscanco el cotrato por el codigo y mostrando los camposmodificables 
     *
     * @param contrato
     * @return true or false si se llega a modificar 
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Contrato modificarContrato(Contrato contrato) throws Exception {
        return nominaFachada.editarContrato(contrato);
    }

    /**
     * Elimina un Contrato correspondiente al c�digo especificado
     *
     * @param codigo
     * @return true or false
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean eliminarContrato(int codigo) throws Exception {
        return nominaFachada.eliminarContrato(codigo);
    }

    /**
     * lista los contratos por -dependencias-hojavida
     *
     * @return lista las dependencias
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Contrato> listaContratoDependecia() throws Exception {
        return nominaFachada.listaContratoDependecia();
    }

    /**
     * listarContratoCargo lista los contratos por cargo
     *
     * @return lista los cargos
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Contrato> listaContratoCargo() throws Exception {
        return nominaFachada.listaContratoCargo();
    }

    /**
     * listarContratoAll lista todo el contrato
     *
     * @return lista con todos los datos
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Contrato> listaContratoTodo() throws Exception {
        return nominaFachada.listaContratoTodo();
    }

    // ==================================================================================================================
    // -------------------------------------------------CONCEPTO-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea un nuevo concepto en la base de datos
     *
     * @param conceptos Objeto concepto
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public void crearConcepto(Concepto conceptos) throws Exception {
    }

    /**
     * Edita un concepto existente en la base de datos
     *
     * @param concep editar
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Concepto editarConcepto(Concepto concep) throws Exception {
        return nominaFachada.editarConcepto(concep);

    }

    /**
     * Elimina un concepto de la base de datos
     *
     * @param codigo a eliminar
     * @return true si se elimin�, false si no
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean borrarConcepto(int codigo) throws Exception {
        return nominaFachada.borrarConcepto(codigo);
    }

    /**
     * Lista todos los conceptos de la base de datos
     *
     * @return lista de entidades de la tabla cargo
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List<Concepto> listarConceptos() throws Exception {
        return nominaFachada.listarConceptos();
    }

    //==================================================================================================================
    //-------------------------------------------------PERIODO-----------------------------------------------------
    //==================================================================================================================

    /**
     * Metodo encargado de actualizar los periodos
     *
     * @param per periodo
     * @return periodo actualizado
     * @throws Exception Capturar errores posibles sobre ejecuci�n
     */
    public boolean editarPeriodo(Periodo per) throws Exception {
        return nominaFachada.editarPeriodo(per);
    }

    /**
     * Borra el periodo correspondiente al c�digo
     *
     * @param codigo C�digo del periodo
     * @return true: donde si borra y false donde hay error de ejecuci�n
     * @throws Exception Exception Capturar errores posibles sobre ejecuci�n
     */
    public boolean eliminarPeriodo(int codigo) throws Exception {
        return nominaFachada.borrarPeriodo(codigo);
    }

    /**
     * Lista todos los periodos existentes
     *
     * @return List periodos
     * @throws Exception
     */
    public List<Periodo> listaPeriodo() throws Exception {
        return nominaFachada.listarPeriodos();
    }

    //==================================================================================================================
    //-------------------------------------------------NOMINA-----------------------------------------------------
    //==================================================================================================================

    /**
     * Genera los concepts de nomina por contrato para cada periodo
     *
     * @param nomina
     * @return true or false 
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public boolean liquidarNomina(Nomina nomina) throws Exception {
       return nominaFachada.liquidarNomina(nomina);
    }

    /**
     * Edita una nomina en la base de datos 
     *
     * @param nomina
     * @return nomnina editada
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Nomina editarNomina(Nomina nomina) throws Exception {
        return nominaFachada.editarNomina(nomina);
    }

    /**
     * Lista todos los pagos de nomina realizados por el periodo especificado
     *
     * @param empleado mes en el que se realizo la liquidacionde nomina
     * @return muestra unan lista con los emopleados 
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List conceptosLiquidadosNominaEmpleado(int empleado) throws Exception {
        return nominaFachada.conceptosLiquidadosNominaEmpleado(empleado);
    }

    /**
     * Lista todos los conceptos respecto  al pago por dias trabajados
     *
     * @param periodo
     * @return objeto liquidacion por periodos 
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public Object conceptosLiquidadosPorPeriodo(int periodo) throws Exception {
        return nominaFachada.conceptosLiquidadosPorPeriodo(periodo);
    }

    /**
     * Se debe comparar las liquidaciones del mes actual con el mes anterior y no debe superar el 10%
     * en diferencias, delo contrario se debe generar un reporte informando.
     * @return
     * @throws Exception Capturar errores posibles sobre ejecucion
     */
    public List compararLiquidaciones() throws Exception {
        return nominaFachada.compararLiquidaciones();
    }
}
