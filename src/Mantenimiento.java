public class Mantenimiento extends IdVehiculo{

    private int idMantenimiento;

    private String fecha;

    private String tipoMantenimiento;

    private String descripcion;

    public Mantenimiento(int id, int idMantenimiento, String fecha, String tipoMantenimiento, String descripcion) {
        super(id);
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
        this.tipoMantenimiento = tipoMantenimiento;
        this.descripcion = descripcion;
    }

    public int getIdMantenimient(){
        return idMantenimiento;
    }
    public String getFecha(){
        return fecha;
    }
    public String getTipoMantenimiento(){
        return tipoMantenimiento;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
