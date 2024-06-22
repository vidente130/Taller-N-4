/**
 * Esta es la clase que crea los vehiculos del programa y ademas que es la clase hija de la clase IdVehiculo
 */
public class Vehiculo extends IdVehiculo{
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
    /**
     * Se obtiene la marca del vehiculo
     * @return retorna la marca
     */
    public String getMarca(){

        return marca;
    }

    /**
     * Se obtiene el modelo del vehiculo
     * @return retorna el modelo del vehiculo
     */
    public String getModelo(){

        return modelo;
    }

    /**
     * Se obtiene el año de fabricacion del vehiculo
     * @return retorna el año de fabricacion del vehiculo
     */
    public int getAnioFabricacion(){

        return anioFabricacion;
    }

    /**
     * Se obtiene el kilometraje del vehiculo
     * @return retorna el kilometraje del vehiculo
     */
    public int getKilometraje(){

        return kilometraje;
    }

    /**
     * Se obtiene el tipo de vehiculo
     * @return retorna el tipo de vehiculo
     */
    public String getTipoVehiculo(){

        return tipoVehiculo;
    }

    /**
     * Se obtiene el primer atributo del vehiculo
     * @return retorna el primer atributo del vehiculo
     */
    public String getAtributo1(){

        return atributo1;
    }

    /**
     * Se obtiene el segundo atributo del vehiculo
     * @return retorna el segundo atributo del vehiculo
     */
    public String getAtributo2(){

        return atributo2;
    }
}
