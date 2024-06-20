public interface Sistema {

    /**
     * esta funcion permite dar los mensajes del menu principal
     */
    void mensajeMenu1();


    /**
     * esta funcion permite dar las opciones del submenu de ver vehiculos
     */

    void menu2();

    /**
     * esta funcion permite poder ver las opciones del submenu de la opcion "ver historial de vehiculos"
     */

    void menu3();


    /**
     * esta funcion permite poder ver las opciones del submenu de la opcion "ver boletas"
     */

    void menu4();

    /**
     * esta funcion permite poder cargar el archivo "vehiculos.csv"
     */
    void cargarVehiculos();


    /**
     * esta funcion permite poder cargar el archivo "mantenimient.csv"
     */

    void cargarMantenimientos();

    /**
     * esta funcion permite poder ver cada uno de los vehiculos que hay en la pagina
     */
    void verVehiculos();

    /**
     * esta funcion permite buscar un vehiculo por su tipo
     */
    void buscarPorTipo();

    /**
     * esta funcion permite buscar un vehiculo por su id
     */

    void buscarPorId();

    /**
     * esta funcion permite ver el historial del mantenimineto de un vehiculo
     */

    void mostrarHistorialVehiculo();

    /**
     * esta funcion permite poder agregar un vehiculo
     */

    void agregarVehiculo();


    /**
     * esta funcion permite agregar un mantenimiento a un vehiculo.
     */

    void agregarMantenimineto();


    /**
     * esta funcion permite poder crear una boleta
     */

    void generarBoleta();

    /**
     * esta funcione permite poder ver las boletas que hay en el sistema
     */

    void verBoletas();

    /**
     * esta funcion permite poder salir de la pagina y guardar los archivos que hay
     */
    void salir();
}
