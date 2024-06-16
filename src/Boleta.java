public class Boleta {

    private Vehiculo vehiculo;

    private Mantenimiento mantenimiento;

    private String fechaEmision;

    private double pagaTotal;

    public Boleta(Vehiculo vehiculo, Mantenimiento mantenimiento, String fechaEmision, double pagaTotal) {
        this.vehiculo = vehiculo;
        this.mantenimiento = mantenimiento;
        this.fechaEmision = fechaEmision;
        this.pagaTotal = pagaTotal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public double getPagaTotal() {
        return pagaTotal;
    }

}
