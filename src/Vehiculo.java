public class Vehiculo extends IdVehiculo{

    private String marca;

    private String modelo;

    private int anioFabricacion;

    private int kilometraje;

    private String tipoVehiculo;

    private String atributo1;

    private String atributo2;

    public Vehiculo(int id, String marca, String modelo, int anioFabricacion, int kilometraje, String tipoVehiculo, String atributo1, String atributo2){
        super(id);
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
        this.tipoVehiculo = tipoVehiculo;
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }

    public String getMarca(){

        return marca;
    }
    public String getModelo(){

        return modelo;
    }
    public int getAnioFabricacion(){

        return anioFabricacion;
    }
    public int getKilometraje(){

        return kilometraje;
    }
    public String getTipoVehiculo(){

        return tipoVehiculo;
    }
    public String getAtributo1(){

        return atributo1;
    }
    public String getAtributo2(){

        return atributo2;
    }
}
