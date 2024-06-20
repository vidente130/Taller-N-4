/**
 * Esta es la clase padre de las 2 clases que hay que son "Vehiculo" y "Mantenimiento"
 */
public class IdVehiculo {

    private int id;

    /**
     * Es el constructor de la clase IdVehiculo
     * @param id el id del vehiculo
     */
    public IdVehiculo(int id){
        this.id = id;
    }

    /**
     * Es el get del id del vehiculo
     * @return retorna el id del vehiculo
     */
    public int getId(){
        return id;
    }
}
