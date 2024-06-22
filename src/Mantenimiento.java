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
     * Se obtiene el id del mantenimiento
     * @return retorna el id del mantenimiento
     */
    public int getIdMantenimiento(){
        return idMantenimiento;
    }


    /**
     * Se obtiene la fecha del mantenimiento
     * @return retorna la fecha del mantenimiento
     */

    public String getFecha(){
        return fecha;
    }

    /**
     * Se obtiene el tipo de mantenimiento
     * @return retorna el tipo de mantenimiento que hay
     */

    public String getTipoMantenimiento(){
        return tipoMantenimiento;
    }

    /**
     * Se obtiene la descripcion del mantenimiento
     * @return retorna la descripcion del mantenimiento.
     */
    public String getDescripcion(){
        return descripcion;
    }
}
