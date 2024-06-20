// La clase Boleta para que pueda ser las boletas al terminar con un mantenimiento
public class Boleta {

    // Los atributos de la clase Boleta los cuales son: id, vehiculo, mantenimiento, fechaEmision y pagoTotal
    private int id;

    private Vehiculo vehiculo;

    private Mantenimiento mantenimiento;

    private String fechaEmision;

    private double pagaTotal;

    // El constructor de la clase Boleta que deja tener los atributos de la clase

    /**
     * Es el constructor de la clase Boleta
     * @param id id del vehiculo
     * @param vehiculo el tipo de vehiculo
     * @param mantenimiento el mantenimiento del vehiculo
     * @param fechaEmision la fecha que empezo el mantenimiento del vehiculo
     * @param pagaTotal el pago total por la mantencion del vehiculo contando el iva
     */
    public Boleta(int id, Vehiculo vehiculo, Mantenimiento mantenimiento, String fechaEmision, double pagaTotal) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.mantenimiento = mantenimiento;
        this.fechaEmision = fechaEmision;
        this.pagaTotal = pagaTotal;
    }
    public int getId() {
        return this.id;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public Mantenimiento getMantenimiento() {
        return this.mantenimiento;
    }

    public String getFechaEmision() {
        return this.fechaEmision;
    }

    public double getPagaTotal() {
        return this.pagaTotal;
    }

}
