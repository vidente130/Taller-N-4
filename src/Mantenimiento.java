/**
 * Es la clase que deja crear los vehiculos del programa y es la clase hija de la clase IdVehiculo
 */

public class Mantenimiento extends IdVehiculo{

    private int idMantenimiento;

    private String fecha;

    private String tipoMantenimiento;

    private String descripcion;

    /**
     * Es el constructor de la clase mantenimiento para poder instancear
     * @param id id del vehiculo
     * @param idMantenimiento id del mantenimiento
     * @param fecha fecha que se dio en el mantenimiento
     * @param tipoMantenimiento el tipo de mantenimiento
     * @param descripcion la descripcion del mantenimiento
     */

    public Mantenimiento(int idMantenimiento,int id, String fecha, String tipoMantenimiento, String descripcion) {
        super(id);
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
        this.tipoMantenimiento = tipoMantenimiento;
        this.descripcion = descripcion;
    }

    /**
     * Es el get del id del mantenimiento
     * @return retorna el id del mantenimiento
     */
    public int getIdMantenimiento(){
        return idMantenimiento;
    }


    /**
     * Es el get de la fecha del mantenimiento
     * @return retorna la fecha del mantenimiento
     */

    public String getFecha(){
        return fecha;
    }

    /**
     * Es el get del tipo de mantenimiento
     * @return retorna el tipo de mantenimiento que hay
     */

    public String getTipoMantenimiento(){
        return tipoMantenimiento;
    }

    /**
     * Es el get de la descripcion del mantenimiento
     * @return retorna la descripcion del mantenimiento.
     */
    public String getDescripcion(){
        return descripcion;
    }
}
