import java.util.Date;

/**
 * Esta es la clase boleta que son las boletas que se crean dentro del programa
 */
public class Boleta {
    private int id;

    private Vehiculo vehiculo;

    private Mantenimiento mantenimiento;

    private Date fechaEmision;

    private double pagaTotal;

    /**
     * Es el constructor de la clase Boleta
     * @param id es el id de la boleta
     * @param vehiculo es el vehiculo
     * @param mantenimiento el mantenimiento del vehiculo
     * @param fechaEmision la fecha que empezo el mantenimiento del vehiculo
     * @param pagaTotal el pago total por la mantencion del vehiculo contando el iva
     */
    public Boleta(int id, Vehiculo vehiculo, Mantenimiento mantenimiento, Date fechaEmision, double pagaTotal) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.mantenimiento = mantenimiento;
        this.fechaEmision = fechaEmision;
        this.pagaTotal = pagaTotal;
    }

    /**
     * Se obtiene el id de la boleta
     * @return retorna el id de la boleta
     */
    public int getId() {
        return this.id;
    }

    /**
     * Se obtiene el vehiculo
     * @return retorna el vehiculo
     */
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /**
     * Se obtiene el mantenimiento
     * @return retorna el mantenimiento
     */
    public Mantenimiento getMantenimiento() {
        return this.mantenimiento;
    }

    /**
     * Se obtiene la fecha que se creo la boleta
     * @return retonra la fecha de creacion de la boleta
     */
    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    /**
     * Se obtiene la paga total por los mantenimiento del vehiculo
     * @return retorna la pagaTotal de la boleta contando el IVA
     */
    public double getPagaTotal() {
        return this.pagaTotal;
    }

}
