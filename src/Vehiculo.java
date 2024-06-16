// La clase vehiculo que se hereda de la clase IdVehiculo
public class Vehiculo extends IdVehiculo{

    // Los atributos de la clase Vehiculos los cuales son: marca, modelo, anioFabricacion, kilometraje, tipoVehiculo, atributo1 y atributo2
    private String marca;

    private String modelo;

    private int anioFabricacion;

    private int kilometraje;

    private String tipoVehiculo;

    private String atributo1;

    private String atributo2;

    /**
     * Este es el construcitor de la clase Vehiculo
     * @param id id del vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param anioFabricacion año de fabricacion del vehiculo
     * @param kilometraje kilometraje del vehiculo
     * @param tipoVehiculo los tipos de vehiculos que hay
     * @param atributo1 el primer atributo del vehiculo
     * @param atributo2 el segundo atributo del vehiculo
     */

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
    //  getters de la clase vehiculo

    // Se usa para obtener la marca del vehiculo que se instanceo
    /**
     * Es el get de marca
     * @return retorna la marca
     */
    public String getMarca(){

        return marca;
    }

    // Se usa para tener el modelo del vehiculo que se instanceo

    /**
     * Es el get del modelo
     * @return retorna el modelo del vehiculo
     */
    public String getModelo(){

        return modelo;
    }

    // Se usa para obtener el año de fabricacion del vehiculo que se instanceo

    /**
     * Es el get del año de fabricacion
     * @return retorna el año de fabricacion del vehiculo
     */
    public int getAnioFabricacion(){

        return anioFabricacion;
    }

    // Se usa para obtener el kilometraje del vehiculo que se instanceo

    /**
     * Es el get del kilometraje
     * @return retorna el kilometraje del vehiculo
     */
    public int getKilometraje(){

        return kilometraje;
    }

    // Se usa para tener el tipo de vehiculo que se instanceo

    /**
     * Es el get del tipo de vehiculo
     * @return retorna el tipo de vehiculo
     */
    public String getTipoVehiculo(){

        return tipoVehiculo;
    }

    // Se usa para obtener el primer atributo del vehiuclo que se instanceo

    /**
     * Es el get del primer atributo
     * @return retorna el primer atributo del vehiculo
     */
    public String getAtributo1(){

        return atributo1;
    }

    // Se usa para obtener el segundo atributo del vehiculo que se instanceo

    /**
     * Es el get del segundo atributo
     * @return retorna el segundo atributo del vehiculo
     */
    public String getAtributo2(){

        return atributo2;
    }
}
