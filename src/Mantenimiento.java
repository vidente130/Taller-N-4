//  La clase llamada mantenimniento que es heredado por la clase llamada IdVehiculo

public class Mantenimiento extends IdVehiculo{

    // Los atributos de la clase mantenimiento los cuales son: idMantenimiento, Id, fecha, tipoMantenimiento, descripcion
    private int idMantenimiento;

    private String fecha;

    private String tipoMantenimiento;

    private String descripcion;

    // El constructor de la clase Mantenimiento

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

    // Se usa para obtener el id del mantenimiento que se instanceo

    /**
     * Es el get del id del mantenimiento
     * @return retorna el id del mantenimiento
     */
    public int getIdMantenimiento(){
        return idMantenimiento;
    }

    // Se usa para obtener la fecha de un matenimiento que se instanceo

    /**
     * Es el get de la fecha del mantenimiento
     * @return retorna la fecha del mantenimiento
     */
    public String getFecha(){
        return fecha;
    }
    // Se usa para obtener el tipo de mantenimiento que se instanceo

    /**
     * Es el get del tipo de mantenimiento
     * @return retorna el tipo de mantenimiento que hay
     */
    public String getTipoMantenimiento(){
        return tipoMantenimiento;
    }
    // Se usa para obtener la descripcion que se instanceo

    /**
     * Es el get de la descripcion del mantenimiento
     * @return retorna la descripcion del mantenimiento.
     */
    public String getDescripcion(){
        return descripcion;
    }
}
