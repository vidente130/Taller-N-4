// La clase del IdVehiculo para que pueda ser la clase padre

public class IdVehiculo {

    // Son los atributos de la clase IdVehiculo los cuales son: id vehiculo
    private int id;

    // Es el constructor que deja heredar lo que tendran las clases hijas

    /**
     * Es el constructor de la clase IdVehiculo
     * @param id el id del vehiculo
     */
    public IdVehiculo(int id){
        this.id = id;
    }

    // Se usa para obtener el id del vehiculo que se instanceo en las clases hijas

    /**
     * Es el get del id del vehiculo
     * @return retorna el id del vehiculo
     */
    public int getId(){
        return id;
    }
}
