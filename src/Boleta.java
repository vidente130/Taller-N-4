public class Boleta {

    private int id;

    private Vehiculo vehiculo;

    private Mantenimiento mantenimiento;

    private String fechaEmision;

    private double pagaTotal;

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
