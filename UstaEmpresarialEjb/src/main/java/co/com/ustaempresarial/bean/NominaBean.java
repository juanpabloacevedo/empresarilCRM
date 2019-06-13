package co.com.ustaempresarial.bean;

import co.com.UstaEmpresarial.nomina.dto.LiquidacionNominaDTO;
import co.com.UstaEmpresarial.nomina.modelo.*;
import co.com.ustaempresarial.fachada.NominaFachada;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class NominaBean implements NominaFachada {

    @PersistenceContext(unitName = "PerisistenceNomina")
    private EntityManager em;

    public NominaBean() {

        super();
    }
    // ==================================================================================================================
    // -------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * @Author Oscar Gómez
     */

    @Override
    public boolean crearHojaVida(HojaVida hojaVida) throws Exception {
        if (hojaVida.getDocumento() != null && !hojaVida.getDocumento().equals("")) {
            em.persist(hojaVida);
            em.flush();
            return true;
        }
        return false;
    }

    @Override
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        HojaVida hojaVida1 = new HojaVida();
        hojaVida1 = buscarPorIdHojaVida(hojaVida.getDocumento());
        if (hojaVida1.getDocumento() > 0) {
            em.merge(hojaVida);
        } else {
            hojaVida1 = null;
        }
        return hojaVida1;
    }

    @Override
    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
        HojaVida hojaVida = buscarPorIdHojaVida(codigoHojaVida);
        boolean flag = false;
        if (hojaVida.getDocumento() > 0) {
            em.remove(hojaVida);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<HojaVida> listarHojasVida() throws Exception {
        List<HojaVida> hojaVidas = new ArrayList<>();
        Query query = em.createNamedQuery(HojaVida.FILL_ALL);
        hojaVidas = query.getResultList();
        return hojaVidas;
    }

    private HojaVida buscarPorIdHojaVida(int idHojaVida) throws Exception {
        HojaVida hojaVida = new HojaVida();
        hojaVida = em.find(HojaVida.class, idHojaVida);
        return hojaVida;
    }

    // =================================================================================================================
    // -------------------------------------------------CARGO-----------------------------------------------------------
    // =================================================================================================================

    /**
     * @autor Angie Suarez
     */
    @Override
    public List<Cargo> listarCargos() throws Exception {

        List<Cargo> cargos;

        Query q = em.createNamedQuery(Cargo.LISTAR_CARGO);
        cargos = q.getResultList();

        return cargos;

    }

    @Override
    public void crearCargo(Cargo cargo) throws Exception {

        if (cargo != null) {
            em.persist(cargo);
            em.flush();
        }
    }

    // @Override
    public void editarCargo(Cargo cargos) throws Exception {
        if (cargos != null) {
            if (cargos.getCodigo() > 0) {
                em.merge(cargos);
                em.flush();
            }
        }
    }

    @Override
    public boolean eliminarCargo(Cargo cargos) throws Exception {
        if (cargos.getCodigo() > 0) {
            em.remove(cargos);
            return true;
        }
        return false;
    }

    // =================================================================================================================
    // -------------------------------------------------DEPENDENCA-----------------------------------------------------------
    // =================================================================================================================

    /**
     * @autor Christian montes
     */
    @Override
    public List<Dependencia> listarDependencias() throws Exception {
        List<Dependencia> dependencias = new ArrayList<Dependencia>();
        Query query = em.createNamedQuery(Dependencia.FIND_ALL);
        dependencias = query.getResultList();
        return dependencias;
    }

    @Override
    public void crearDependencia(Dependencia dep) throws Exception {
        if (dep.getNombre() != null && !dep.getNombre().equals("")) {
            em.persist(dep);
            em.flush();
        }
    }

    @Override
    public void editarDependencia(Dependencia depen) throws Exception {
        Dependencia dep = new Dependencia();
        dep = buscarDependenciaPorCod(depen.getCodigo());
        if (dep.getCodigo() > 0) {
            em.merge(depen);
        } else {
            dep = null;
        }

    }

    @Override
    public boolean borrarDependencia(int codigo) throws Exception {
        Dependencia dependencias = buscarDependenciaPorCod(codigo);
        Contrato contrato = new Contrato();
        boolean flag = false;
        if (dependencias.getCodigo() > 0) {
            if (contrato.getDependenciaCod() == dependencias.getCodigo()) {
                em.remove(dependencias);
                flag = true;
            }
        }
        return flag;
    }

    private Dependencia buscarDependenciaPorCod(int codigoDependencia) throws Exception {
        Dependencia p = new Dependencia();
        p = em.find(Dependencia.class, codigoDependencia);
        return p;
    }
    // =================================================================================================================
    // -------------------------------------------------CONTRATO-----------------------------------------------------------
    // =================================================================================================================

    /**
     * @autor Mario Murcia
     */
    public boolean crearContrato(Contrato contrato) throws Exception {
        boolean flag = true;
        if (contrato.getCodigo() != null && !contrato.getCodigo().equals("")) {
            Contrato contrato1 = buscarContratoPorCodigo(contrato.getCodigo());
            if (contrato1.getCodigo() > 0) {
                if (contrato1.getFechaFin().compareTo(contrato.getFechaInicio()) < 0) {
                    em.persist(contrato);
                    em.flush();
                } else {
                    //se cruzan los contratos
                    flag = false;
                }

            }
        }
        return flag;
    }

    public Contrato editarContrato(Contrato contrato) throws Exception {
        Contrato dep = new Contrato();
        dep = buscarContratoPorCodigo(contrato.getCodigo());
        if (dep.getCodigo() > 0) {
            em.merge(contrato);
        } else {
            dep = null;
        }
        return dep;
    }

    public boolean eliminarContrato(int codigo) throws Exception {
        Contrato contrato = buscarContratoPorCodigo(codigo);
        boolean flag = false;
        if (contrato.getCodigo() > 0) {
            em.remove(contrato);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Contrato> listaContratoDependecia() throws Exception {
        List<Contrato> car = new ArrayList<Contrato>();
        Query query = em.createNamedQuery(Contrato.ENCONTRAR_POR_DEPENDENCIA);
        if (query != null) {
            car = query.getResultList();
        }
        return car;
    }

    @Override
    public List<Contrato> listaContratoCargo() throws Exception {
        List<Contrato> car = new ArrayList<>();
        Query query = em.createNamedQuery(Contrato.ENCONTRAR_POR_CARGO);
        if (query != null) {
            car = query.getResultList();
        }
        return car;
    }


    @Override
    public List<Contrato> listaContratoTodo() throws Exception {
        List<Contrato> dependencias = new ArrayList<>();
        Query query = em.createNamedQuery(Contrato.FIND_ALL);
        dependencias = query.getResultList();
        return dependencias;
    }


    private Contrato buscarContratoPorCodigo(int codigoContrato) throws Exception {
        Contrato p = new Contrato();
        p = em.find(Contrato.class, codigoContrato);
        return p;
    }

    // =================================================================================================================
    // -------------------------------------------------CONCEPTO-----------------------------------------------------------
    // =================================================================================================================

    /**
     * @autor Alejandro Parra
     */
    public List<Concepto> listarConceptos() throws Exception {
        List<Concepto> conceptos = new ArrayList<Concepto>();
        Query query = em.createNamedQuery(Concepto.FIND_ALL);
        conceptos = query.getResultList();
        return conceptos;
    }

    @Override
    public void crearConcepto(Concepto con) throws Exception {
        if (con.getNombre() != null && !con.getNombre().equals("")) {
            em.persist(con);
            em.flush();
        }
    }

    public Concepto editarConcepto(Concepto concep) throws Exception {
        Concepto con = new Concepto();
        con = buscarPorIdConcepto(concep.getCodigo());
        if (con.getCodigo() > 0) {
            em.merge(concep);
        } else {
            con = null;
        }

        return con;
    }

    @Override
    public boolean borrarConcepto(int codigo) throws Exception {
        Concepto conceptos = buscarPorIdConcepto(codigo);
        boolean flag = false;
        if (conceptos.getCodigo() > 0) {
            em.remove(conceptos);
            flag = true;
        }
        return flag;
    }

    private Concepto buscarPorIdConcepto(int codigoConcepto) throws Exception {
        Concepto c = new Concepto();
        c = em.find(Concepto.class, codigoConcepto);
        return c;
    }

    // =================================================================================================================
    // -------------------------------------------------PERIODO-----------------------------------------------------------
    // =================================================================================================================
    public List<Periodo> listarPeriodos() throws Exception {
        List<Periodo> periodos = new ArrayList<>();
        Query query = em.createNamedQuery(Periodo.FIND_ALL);
        periodos = query.getResultList();
        return periodos;
    }

    @Override
    public boolean crearPeriodo(Periodo per) throws Exception {
        if (per.getCodigo() != null && !per.getCodigo().equals("")) {
            em.persist(per);
            em.flush();
            return true;
        }
        return false;
    }

    public boolean editarPeriodo(Periodo per) throws Exception {
        if (per != null) {
            if (per.getCodigo() > 0) {
                em.merge(per);
                em.flush();
                return true;
            }
        }
        return false;

    }

    public boolean borrarPeriodo(int codigo) throws Exception {
        Periodo periodos = buscarPorCodigoPeriodo(codigo);
        boolean flag = false;
        if (periodos.getCodigo() > 0) {
            em.remove(periodos);
            flag = true;
        }
        return flag;
    }

    private Periodo buscarPorCodigoPeriodo(int codigoPeriodo) throws Exception {
        Periodo p = new Periodo();
        p = em.find(Periodo.class, codigoPeriodo);
        return p;
    }

    // =================================================================================================================
    // -------------------------------------------------NOMINA-----------------------------------------------------------
    // =================================================================================================================

    /**
     * @autor Johan Bernal
     */
    @Override
    public boolean liquidarNomina(Nomina nomina) throws Exception {
        if (nomina.getId() != null) {
            em.persist(nomina);
            em.flush();
            return true;
        }
        return false;
    }

    @Override
    public Nomina editarNomina(Nomina nomina) throws Exception {
        Nomina nomina1 = new Nomina();
        if (nomina1 != null) {
            em.merge(nomina);
        } else {
            nomina1 = null;
        }
        return nomina1;
    }


    public List<LiquidacionNominaDTO> conceptosLiquidadosNominaEmpleado(int empleadoDoc) throws Exception {
        List<LiquidacionNominaDTO> nominas = new ArrayList();
        Query query = em.createNamedQuery(Nomina.LIQUIDACION_NOMINA_EMPLEADO);

        if (empleadoDoc != 0) {
            query.setParameter(1, empleadoDoc);
            List<Object[]> resultado = query.getResultList();
            if (resultado.size() > 0) {
                for (Object[] obj : resultado) {
                    LiquidacionNominaDTO dto = new LiquidacionNominaDTO();
//                    dto.setDireccion();
                    dto.setFormula((String) obj[4]);
                    dto.setNombre((String) obj[0]);
                    dto.setResultado(String.valueOf((Float) obj[5]));
                    dto.setSalario(Double.valueOf((Integer) obj[1]));
                    dto.setTipo((String) obj[3]);
                    dto.setConcepto((String) obj[2]);
                    nominas.add(dto);
                }
            }
        }
        return nominas;
    }

    @Override
    public List<LiquidacionNominaDTO> conceptosLiquidadosPorPeriodo(int periodo) throws Exception {
        List nominas = new ArrayList();
        Query query = em.createNamedQuery(Nomina.LIQUIDACION_NOMINA_PERIODO);
        if (periodo != 0) {
            query.setParameter("periodo", periodo);
            nominas = query.getResultList();
        }
        return nominas;
    }

    //-------------------------------** regla de negocio ** ---------------------------------------------
    @Override
    public List<LiquidacionNominaDTO> compararLiquidaciones() throws Exception {
//        List peridoReciente = conceptosLiquidadosPorPeriodo(2);
//        List periodoAnterior = conceptosLiquidadosPorPeriodo(1);
//        for(Object item: peridoReciente){
////            item.get("");
//        }
//        Query query = em.createNamedQuery(Nomina.COMPARAR_LIQUIDACION_PERIODO);
//        nominas = query.getResultList();
//        return nominas;
        return null;
    }


}