public interface Sistema {

    // mensajeMenu1(): esto hace que se den los mensajes de las opciones del menu principal de la pagina.

    /**
     * esta funcion permite dar los mensajes del menu principal
     */
    void mensajeMenu1();

    // mensajeMenu2(): esto hace que se puedan dar los mensajes de las opciones del submenu de la opcion de "ver Vehiculos" y haciendo lo que hay dentro

    /**
     * esta funcion permite dar las opciones del submenu de ver vehiculos
     */

    void menu2();

    // menu3(): esto hace que se puedan dar los mensajes de las opcines del submenu de la opcion "ver historial de mantenimiento" y pueda hacer cada una de las sub-opciones

    /**
     * esta funcion permite poder ver las opciones del submenu de la opcion "ver historial de vehiculos"
     */

    void menu3();


    // menu4(): esto hace que se puedan ver los mensajes de las opciones del submenu de la opcion "ver boletas" y con sus sub-opciones

    /**
     * esta funcion permite poder ver las opciones del submenu de la opcion "ver boletas"
     */

    void menu4();

    // cargarVehiculos(): esto hace que se puedan cargar el archivo "vehiculos.csv" haciendo que se puedan usar en el programa

    /**
     * esta funcion permite poder cargar el archivo "vehiculos.csv"
     */
    void cargarVehiculos();

    // cargarMantenimientos(): esto hace que se puedan cargar el archivo "mantenimiento.csv" haciendo que se pueda usar en el programa

    /**
     * esta funcion permite poder cargar el archivo "mantenimient.csv"
     */

    void cargarMantenimientos();

    // vervehiculos(): esto hace que se puedan ver todos los vehiculos del archivos vehiculos mas los que se pueden agregar.

    /**
     * esta funcion permite poder ver cada uno de los vehiculos que hay en la pagina
     */
    void verVehiculos();

    // buscarPorTipo(): esto hace que se pueda buscar un vehiculo por su tipo para eso primero hay que usar el parametro tipo para buscarlo

    /**
     * esta funcion permite buscar un vehiculo por su tipo
     */
    void buscarPorTipo();

    // buscarPorId(): esto hace que se pueda buscar un vehiculo por su id, mostrando un mensaje de que existe dentro de la pagina o mostrando que no esta en la pagina

    /**
     * esta funcion permite buscar un vehiculo por su id
     */

    void buscarPorId();


    //mostrarHistorialVehiculo(): esto hace que se pueda ver el historial de mantenimiento del vehiculo buscado por su id, mostrando su tipo, fechas de mantenimientos y su descripcion

    /**
     * esta funcion permite ver el historial del mantenimineto de un vehiculo
     */

    void mostrarHistorialVehiculo();

    //  agregarVehiculo(): esto hace que se pueda agregar un vehiculo a la pagina haciendo que se pueda agregar al archivo vehiculos.csv

    /**
     * esta funcion permite poder agregar un vehiculo
     */

    void agregarVehiculo();

    // agregarMantenimineto(): esto hace que se pueda agregar mantenimiento a un vehiculo, fecha de mantenimiento, tipo de mantenimiento y la descripcion.

    /**
     * esta funcion permite agregar un mantenimiento a un vehiculo.
     */

    void agregarMantenimineto();

    // generarBoleta(): esto hace que se pueda agregar una boleta, donde la boleta tiene id,vehiculo,mantenimiento, fecha de mantenimiento y total al realizar

    /**
     * esta funcion permite poder crear una boleta
     */

    void generarBoleta();

    // generarBoleta(): esto hace que se pueda ver las boletas que dentro del sistema

    /**
     * esta funcione permite poder ver las boletas que hay en el sistema
     */

    void verBoletas();

    // salir(): Esto hace que se pueda salir del menu principal, guardando cada uno de los archivos csv que hay en el sistema

    /**
     * esta funcion permite poder salir de la pagina y guardar los archivos que hay
     */
    void salir();
}
