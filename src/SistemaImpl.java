import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.Out;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Esta clase es el que deja iniciar el menu principal del programa
 */
public class SistemaImpl implements Sistema {

    private ArrayList<Vehiculo> vehiculos;

    private ArrayList<Mantenimiento> mantenimientos;

    private ArrayList<Boleta> boletas;

    /**
     * Es el constructor de la clase SistemaImpl que deja crear y cambiar las ArrayList que son "vehiculos" y "mantenimientos"
     */
    public SistemaImpl() {
        this.vehiculos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
        this.boletas = new ArrayList<>();
    }

    // La creacion del Scanner llamado "opcion"
    Scanner opcion = new Scanner(System.in);

    /**
     * Es el menu principal del programa
     */
    public void menu() {

        // Se cargar los archivos.csv en el momento que se activa el programa.

        cargarVehiculos();
        cargarMantenimientos();

        // Se abre la funcion mensajeMenu1 que muestra el titulo y las opciones del programa

        mensajeMenu1();

        // Se abre la opcion para elegir (son numeros del 1 al 7)

        String pregunta = opcion.nextLine();

        // Se abre el ciclo while para que no se termine el programa

        while (true){

            // El switch que deja ver que opcion eligio la persona y la busca por cada caso

            switch(pregunta){
                case "1" :

                    menu2();
                    break;

                case "2" :

                    menu3();
                    break;

                case "3" :

                    agregarVehiculo();
                    break;

                case "4" :

                    agregarMantenimineto();
                    break;

                case "5" :

                    generarBoleta();
                    break;

                case "6" :

                    menu4();
                    break;

                case "7" :

                    System.out.println("Nos vemos buen señor/ita que tenga un buen dia");
                    return;
            }
            mensajeMenu1();
            pregunta = opcion.nextLine();
        }


    }

    @Override
    public void mensajeMenu1() {

        // Mensajes de titulo y opciones para el menu principal

        System.out.println("------{ Bienvenido a AutoFleet }-------");
        System.out.println("1.- Ver vehiculos.");
        System.out.println("2.- Ver historial de mantenimiento.");
        System.out.println("3.- Agregar vehiculo.");
        System.out.println("4.- Registrar mantenimiento.");
        System.out.println("5.- Generar boleta de mantenimiento.");
        System.out.println("6.- Ver boletas.");
        System.out.println("7.- Salir.");
        System.out.println("Elija una opcion: ");
    }

    @Override
    public void menu2() {

        // Titulo y opciones(que son 4 opciones) para el submenu de la opcion 1 (Ver vehiculos).

        System.out.println("-------( Ver vehiculos )-------");
        System.out.println("1.- Listar todos los vehiculos.");
        System.out.println("2.- Buscar vehiculo por tipo.");
        System.out.println("3.- Buscar vehiculo por ID.");
        System.out.println("4.- Volver al menu pricipal.");
        System.out.println("Elija una opcion: ");

        // Se abre la opcion para dejar que la persona elija la opcion

        String pregunta2 = opcion.nextLine();

        // Se inicia el ciclo while para que no termine esa parte del programa

        while (true){

            // El segundo switch que es para que vea que opcion elijio la persona

            switch (pregunta2){
                case "1" :

                    verVehiculos();
                    break;

                case "2" :

                    buscarPorTipo();
                    break;

                case "3" :

                    buscarPorId();
                    break;

                case "4" :

                    System.out.println("Saliendo...");
                    return;
            }
            System.out.println("------- ( Ver vehiculos ) -------");
            System.out.println("1.- Listar todos los vehiculos.");
            System.out.println("2.- Buscar vehiculo por tipo.");
            System.out.println("3.- Buscar vehiculo por ID.");
            System.out.println("4.- Volver al menu principal.");
            System.out.println("Elija una opcion: ");
            pregunta2 = opcion.nextLine();
            pregunta2 = opcion.nextLine();
        }

    }

    @Override
    public void menu3() {

        // Titulo y opciones(que son 2 opciones) para el submenu de la opcion 2 (Ver historial de mantenimiento)
        System.out.println("-------( Ver historial de mantenimiento )-------");
        System.out.println("1.- Mostrar historial por vehiculo.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");

        // Se inicia la opcion para dejar que la persona elija la opcion del submenu

        String pregunta3 = opcion.nextLine();

        // Se inicia un ciclo casi infinito para que no termine el programa

        while (true){

            // El tercer switch que ve que opcion elijio la persona y la busca dentro de los case

            switch (pregunta3){

                case "1" :

                    mostrarHistorialVehiculo();
                    break;

                case "2" :

                    System.out.println("Saliendo...");
                    return;
            }
            System.out.println("-------( Ver historial de mantenimiento )-------");
            System.out.println("1.- Mostrar historial por vehiculo.");
            System.out.println("2.- Volver al menu principal.");
            System.out.println("Elija una opcion: ");
            pregunta3 = opcion.nextLine();
        }

    }

    @Override
    public void menu4() {

        // Titulo y opciones(que son 2) para el submenu de la opcion 6(Ver boletas)

        System.out.println("-------( Ver boletas )-------");
        System.out.println("1.- Listado de todas las boletas.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");

        // Se activa la opcion para dejar que la persona elija las 2 opciones que hay

        String pregunta4 = opcion.nextLine();

        // Se activa el while para que no termine el programa

        while (true){

            // el cuarto switch para que busque la opcion que elijio la persona y la busque dentro de los case

            switch (pregunta4){

                case "1" :
                    verBoletas();
                    break;

                case "2" :

                    System.out.println("Saliendo...");
                    return;
            }

            System.out.println("-------( Ver boletas )-------");
            System.out.println("1.- Listado de todas las boletas.");
            System.out.println("2.- Volver al menu principal.");
            System.out.println("Elija una opcion: ");
            pregunta4 = opcion.nextLine();
        }

    }

    @Override
    public void cargarVehiculos() {

        // Se inicia la cargar de los vehiculos

        In in = new In ("vehiculos.csv");

        // Lee la linea del archivo

        String linea = in.readLine();

        // Se inicia el ciclo para que lea hasta la ultima linea del archivo vehiculos.csv

        while(linea != null) {

            // Se crear campos para que pueda separa las partes del archivo que son como ","

            String[] campos = linea.split(",");

            // Se inicia la separacion de los archivos.

            int id = Integer.parseInt(campos[0]);
            String marca = campos[1];
            String modelo = campos[2];
            int anioFabricacion = Integer.parseInt(campos[3]);
            int kilometraje = Integer.parseInt(campos[4]);
            String tipo = campos[5];
            String atributo1 = campos[6];
            String atributo2 = campos[7];

            // Se instancia la clase vehiculo para crear y agregarlo a la lista vehiculos

            Vehiculo vehiculo1 = new Vehiculo(id,marca,modelo,anioFabricacion,kilometraje,tipo,atributo1,atributo2);
            vehiculos.add(vehiculo1);

            // vuelve a leer la siguiente linea del archivo

            linea = in.readLine();
        }

    }

    @Override
    public void cargarMantenimientos() {

        // Se iniciar la lectura del archivo "mantenimientos.csv"

        In in2 = new In ("mantenimientos.csv");

        // Se empieza a leer la primera linea del archivo

        String linea = in2.readLine();

        // Se inicia el ciclo while para que empiece a leer el archivo hasta que no haya vacio

        while (linea != null){

            // Se crea campos para que pueda separar las partes del archivos que esten con ","

            String[] campos = linea.split(",");

            // Se crea las partes del archivo

            int idMantenimiento = Integer.parseInt(campos[0]);
            int idVehiculo = Integer.parseInt(campos[1]);
            String fecha = campos[2];
            String tipoMantenimiento = campos[3];
            String descripcion = campos[4];

            // Se instancia la clase mantenimiento para crear un mantenimiento y agregarlo a la lista de matenimientos

            Mantenimiento mantenimiento = new Mantenimiento(idMantenimiento,idVehiculo  ,fecha,tipoMantenimiento,descripcion);
            mantenimientos.add(mantenimiento);

            // Empiza a leer la siguiente lista
            linea = in2.readLine();
        }

    }
    @Override
    public void verVehiculos() {

        // Se crean 2 cosas para hacer la primera opcion(Ver todos los vehiculos) del primer submenu(Ver vehiculos), los cuales son "i" que es el indice para mostrar cada atributo de la lista vehiculos
        // y "pagina" que sera el numero de la pagina que se mostrara en esa opcion

        int i = 0;
        int pagina = 1;

        // Se empieza a mostrar el numero del vehiculo dentro de la lista, sus atributos( hasta el cuarto vehiculo)  y su pagina

        if(i >= 0) {
            System.out.println("---------( Vehiculo " + (i + 1) + ") ---------");
            System.out.println(vehiculos.get(i).getId());
            System.out.println(vehiculos.get(i).getMarca());
            System.out.println(vehiculos.get(i).getModelo());
            System.out.println(vehiculos.get(i).getAnioFabricacion());
            System.out.println(vehiculos.get(i).getKilometraje());
            System.out.println(vehiculos.get(i).getTipoVehiculo());
            System.out.println(vehiculos.get(i).getAtributo1());
            System.out.println(vehiculos.get(i).getAtributo2());
            System.out.println("-------------------------------");

            System.out.println("---------( Vehiculo " + (i + 2) + ") ---------");
            System.out.println(vehiculos.get(i + 1).getId());
            System.out.println(vehiculos.get(i + 1).getMarca());
            System.out.println(vehiculos.get(i + 1).getModelo());
            System.out.println(vehiculos.get(i + 1).getAnioFabricacion());
            System.out.println(vehiculos.get(i + 1).getKilometraje());
            System.out.println(vehiculos.get(i + 1).getTipoVehiculo());
            System.out.println(vehiculos.get(i + 1).getAtributo1());
            System.out.println(vehiculos.get(i + 1).getAtributo2());
            System.out.println("--------------------------------");

            System.out.println("---------( Vehiculo " + (i + 3) + ") ----------");
            System.out.println(vehiculos.get(i + 2).getId());
            System.out.println(vehiculos.get(i + 2).getMarca());
            System.out.println(vehiculos.get(i + 2).getModelo());
            System.out.println(vehiculos.get(i + 2).getAnioFabricacion());
            System.out.println(vehiculos.get(i + 2).getKilometraje());
            System.out.println(vehiculos.get(i + 2).getTipoVehiculo());
            System.out.println(vehiculos.get(i + 2).getAtributo1());
            System.out.println(vehiculos.get(i + 2).getAtributo2());
            System.out.println("---------------------------------");

            System.out.println("----------( Vehiculo " + (i + 4) + ") ----------");
            System.out.println(vehiculos.get(i + 3).getId());
            System.out.println(vehiculos.get(i + 3).getMarca());
            System.out.println(vehiculos.get(i + 3).getModelo());
            System.out.println(vehiculos.get(i + 3).getAnioFabricacion());
            System.out.println(vehiculos.get(i + 3).getKilometraje());
            System.out.println(vehiculos.get(i + 3).getTipoVehiculo());
            System.out.println(vehiculos.get(i + 3).getAtributo1());
            System.out.println(vehiculos.get(i + 3).getAtributo2());
            System.out.println("----------------------------------");
            System.out.println("Pagina " + (pagina));
        }
        System.out.println("No hay vehiculo.");
        System.out.println("-----------------------------------");

        // Subopciones de ver si quiere ir a la siguiente pagina, a la anterior pagina o salir de la opccion

        System.out.println("1.- Siguiente pagina.");
        System.out.println("2.- Pagina anterior.");
        System.out.println("3.- Salir.");
        System.out.println("Elija una opcion: ");

        // Se activa la opcion para que pueda elegir la persona

        String pregunta5 = opcion.nextLine();

        //Se inicia el ciclo para que empiece a seguir el programa con la opcion que se eligio

        while (true){

            // Se ponen las condiciones para ver si a elegido cada una de las opciones que hay

            if (pregunta5.equals("1")) {

                // Se aumenta en 4 en 4 el indice "i" para que siga avanzando

                i = i + 4;

                // Se aumenta en 1 en 1 la pagina
                pagina = pagina + 1;

                // Las 2 verificaciones que tiene, para ver si esta dentro de las lista en las 4 partes aumentadas
                if (i >= 0) {
                    if (i < vehiculos.size()) {
                        System.out.println("------- ( Vehiculo " + (i + 1) + ") -------");
                        System.out.println(vehiculos.get(i).getId());
                        System.out.println(vehiculos.get(i).getMarca());
                        System.out.println(vehiculos.get(i).getModelo());
                        System.out.println(vehiculos.get(i).getAnioFabricacion());
                        System.out.println(vehiculos.get(i).getKilometraje());
                        System.out.println(vehiculos.get(i).getTipoVehiculo());
                        System.out.println(vehiculos.get(i).getAtributo1());
                        System.out.println(vehiculos.get(i).getAtributo2());
                        System.out.println("----------------------------------");
                    } else {
                        System.out.println("No hay vehiculo.");
                        System.out.println("----------------------------------");
                    }
                    if (i < vehiculos.size()){
                        if (i + 1 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 2) + ") -------");
                            System.out.println(vehiculos.get(i + 1).getId());
                            System.out.println(vehiculos.get(i + 1).getMarca());
                            System.out.println(vehiculos.get(i + 1).getModelo());
                            System.out.println(vehiculos.get(i + 1).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 1).getKilometraje());
                            System.out.println(vehiculos.get(i + 1).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 1).getAtributo1());
                            System.out.println(vehiculos.get(i + 1).getAtributo2());
                            System.out.println("-----------------------------------");
                        }
                        else{
                            System.out.println("No hay vehiculo.");
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("No hay vehiculo.");
                        System.out.println("------------------------------------");
                    }
                    if (i < (vehiculos.size())) {
                        if(i + 2 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 3) + ") -------");
                            System.out.println(vehiculos.get(i + 2).getId());
                            System.out.println(vehiculos.get(i + 2).getMarca());
                            System.out.println(vehiculos.get(i + 2).getModelo());
                            System.out.println(vehiculos.get(i + 2).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 2).getKilometraje());
                            System.out.println(vehiculos.get(i + 2).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 2).getAtributo1());
                            System.out.println(vehiculos.get(i + 2).getAtributo2());
                            System.out.println("-------------------------------------");
                        }
                        else{
                            System.out.println("No hay vehiculo.");
                            System.out.println("-------------------------------------");
                        }

                    }
                    else {
                        System.out.println("No hay vehiculo.");
                        System.out.println("-------------------------------------");
                    }

                    if (i < (vehiculos.size())) {
                        if (i + 3 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 4) + ") -------");
                            System.out.println(vehiculos.get(i + 3).getId());
                            System.out.println(vehiculos.get(i + 3).getMarca());
                            System.out.println(vehiculos.get(i + 3).getModelo());
                            System.out.println(vehiculos.get(i + 3).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 3).getKilometraje());
                            System.out.println(vehiculos.get(i + 3).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 3).getAtributo1());
                            System.out.println(vehiculos.get(i + 3).getAtributo2());
                            System.out.println("---------------------------------------");
                        }
                        else {
                            System.out.println("No hay vehiculo.");
                            System.out.println("---------------------------------------");
                        }

                    } else {
                        System.out.println("No hay vehiculo.");
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Pagina " + (pagina));
                } else {
                    System.out.println("Disculpe, no hay vehiculos");
                }
            }

            else if(pregunta5.equals("2")) {

                // Se baja en 4 en 4 para que pueda seguir con la pagina

                i = i - 4;

                // Se baja la pagina en 1 en 1 para que pueda bajar la pagina

                pagina = pagina - 1;

                // Las 2 verificaciones para ver si esta dentro de la lista aunque se ponga o se quite un vehiculo

                if (i >= 0) {
                    if (i < vehiculos.size()){
                        System.out.println("------- ( Vehiculo " + (i + 1) + ") -------");
                        System.out.println(vehiculos.get(i).getId());
                        System.out.println(vehiculos.get(i).getMarca());
                        System.out.println(vehiculos.get(i).getModelo());
                        System.out.println(vehiculos.get(i).getAnioFabricacion());
                        System.out.println(vehiculos.get(i).getKilometraje());
                        System.out.println(vehiculos.get(i).getTipoVehiculo());
                        System.out.println(vehiculos.get(i).getAtributo1());
                        System.out.println(vehiculos.get(i).getAtributo2());
                        System.out.println("---------------------------------");
                    }
                    else{
                        System.out.println("No hay vehiculo.");
                        System.out.println("---------------------------------");
                    }
                    if(i < vehiculos.size()) {
                        if(i + 1 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 2) + ") -------");
                            System.out.println(vehiculos.get(i + 1).getId());
                            System.out.println(vehiculos.get(i + 1).getMarca());
                            System.out.println(vehiculos.get(i + 1).getModelo());
                            System.out.println(vehiculos.get(i + 1).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 1).getKilometraje());
                            System.out.println(vehiculos.get(i + 1).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 1).getAtributo1());
                            System.out.println(vehiculos.get(i + 1).getAtributo2());
                            System.out.println("----------------------------------");
                        }
                        else{
                            System.out.println("No hay vehiculo.");
                            System.out.println("----------------------------------");
                        }

                    }
                    else{
                        System.out.println("No hay vehiculo.");
                        System.out.println("----------------------------------");
                    }
                    if (i < vehiculos.size()) {
                        if (i + 2 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 3) + ") -------");
                            System.out.println(vehiculos.get(i + 2).getId());
                            System.out.println(vehiculos.get(i + 2).getMarca());
                            System.out.println(vehiculos.get(i + 2).getModelo());
                            System.out.println(vehiculos.get(i + 2).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 2).getKilometraje());
                            System.out.println(vehiculos.get(i + 2).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 2).getAtributo1());
                            System.out.println(vehiculos.get(i + 2).getAtributo2());
                            System.out.println("------------------------------------");
                        }
                        else{
                            System.out.println("No hay vehiculo.");
                            System.out.println("------------------------------------");
                        }

                    }
                    else{
                        System.out.println("No hay vehiculo.");
                        System.out.println("------------------------------------");
                    }
                    if (i < vehiculos.size()) {
                        if(i + 3 < vehiculos.size()){
                            System.out.println("------- ( Vehiculo " + (i + 4) + ") -------");
                            System.out.println(vehiculos.get(i + 3).getId());
                            System.out.println(vehiculos.get(i + 3).getMarca());
                            System.out.println(vehiculos.get(i + 3).getModelo());
                            System.out.println(vehiculos.get(i + 3).getAnioFabricacion());
                            System.out.println(vehiculos.get(i + 3).getKilometraje());
                            System.out.println(vehiculos.get(i + 3).getTipoVehiculo());
                            System.out.println(vehiculos.get(i + 3).getAtributo1());
                            System.out.println(vehiculos.get(i + 3).getAtributo2());
                            System.out.println("--------------------------------------");
                        }
                        else{
                            System.out.println("No hay vehiculo.");
                            System.out.println("--------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay vehiculo.");
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Pagina " + (pagina));
                } else {
                    System.out.println("Disculpe no se puede seguir");
                }
            }
            if(pregunta5.equals("3")){
                System.out.println("Saliendo...");
                break;
            }
            System.out.println("1.- Siguiente pagina.");
            System.out.println("2.- Pagina anterior.");
            System.out.println("3.- Salir.");
            System.out.println("Elija una opcion: ");
            pregunta5 = opcion.nextLine();
        }
    }
    @Override
    public void buscarPorTipo() {

        // Se crear 3 cosas para poder hacer la opcion 2 (ver vehiculo por tipo), dentro del submenu (ver vehiculo) los cuales son:
        // "pagina" que es la pagina del vehiculo que se busco, donde empieza en 1, "i" que es el primer indice para las lista vehiculos, donde empieza en 0,
        // y "i2" para el numero del vehiculo que hay, donde empieza en 0

        int pagina = 1;
        int i = 0;
        int i2 = 1;

        // Se hace la pregunta de cual es el tipo del vehiculo que se quiere buscar

        System.out.println("¿Cual es el tipo del vehiculo?");

        //Se activa la opcion para que pueda escribir el tipo del vehiculo

        String tipo = opcion.nextLine();

        // Se hace la condicion para cada vehiculo que hay en el programa

        if(tipo.equalsIgnoreCase("Automóvil")){

            pagina = 1;
            i = 0;
            i2 = 1;
            // Se inicia un ciclo para poder elergir cuales de las subopciones quiere la persona

            while(true){

                // Se activan las opciones para ver cual quiere la persona elegir

                System.out.println("1.- Siguiente Pagina.");
                System.out.println("2.- Pagina anterior.");
                System.out.println("3.- Salir.");

                // Se activa la pregunta para que la persona pueda elegir cual opcion quiere la persona.

                String pregunta6 = opcion.nextLine();

                // Se activa las 3 condiciones que son lo que pasara si elija las opciones 1,2 y 3;

                if (pregunta6.equals("1")){

                    // Se aumenta cada uno de las cosas

                    i = i + 1;
                    pagina = pagina + 1;
                    i2 = i2 + 1;

                    // Se activan las condiciones para que se pueda ver que esta dentro de la lista el indice "i"

                    if(i >= 0){
                        if(i < vehiculos.size()){
                            for(i = i; i < vehiculos.size(); i++){
                                if(vehiculos.get(i).getTipoVehiculo().equalsIgnoreCase("Automóvil")){;
                                    System.out.println("-------( Automovil " + i2 + " )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getModelo());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("----------------------------------------------");
                                    System.out.println("Pagina " + pagina);
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("No hay automovil.");
                            System.out.println("----------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay automovil.");
                        System.out.println("------------------------------------------");
                    }
                }
                if(pregunta6.equals("2")){
                    i = i - 1;
                    pagina = pagina - 1;
                    i2 = i2 - 1;
                   if(i >= 0){
                       if(i < vehiculos.size()){
                           for (i = i; i >= 0; i--){
                               if(vehiculos.get(i).getTipoVehiculo().equalsIgnoreCase("Automóvil")) {
                                   System.out.println("-------( Automovil " + i2 + " )-------");
                                   System.out.println(vehiculos.get(i).getId());
                                   System.out.println(vehiculos.get(i).getMarca());
                                   System.out.println(vehiculos.get(i).getModelo());
                                   System.out.println(vehiculos.get(i).getAnioFabricacion());
                                   System.out.println(vehiculos.get(i).getKilometraje());
                                   System.out.println(vehiculos.get(i).getAtributo1());
                                   System.out.println(vehiculos.get(i).getAtributo2());
                                   System.out.println("----------------------------------------");
                                   System.out.println("Pagina " + pagina);
                                   break;
                               }
                           }
                       }
                       else{
                           System.out.println("No hay automovil.");
                           System.out.println("----------------------------------------");
                       }
                   }
                   else{
                       System.out.println("No hay Automovil.");
                       System.out.println("-------------------------------------------");
                   }
                }
                if (pregunta6.equals("3")){
                    System.out.println("Saliendo...");
                    break;
                }
                else{
                    System.out.println("Porfavo, elija una de las opciones que hay");
                }
            }
        }
        if (tipo.equals("Camión")){

            pagina = 1;
            i = 0;
            i2 = 1;
            while(true){

                System.out.println("1.- Siguiente pagina.");
                System.out.println("2.- Anterior pagina.");
                System.out.println("3.- Salir.");

                String pregunta6 = opcion.nextLine();

                if (pregunta6.equals("1")){
                    i = i + 1;
                    i2 = i2 + 1;
                    pagina = pagina + 1;
                    if (i >= 0){
                        if(i < vehiculos.size()){
                            for (i = i; i < vehiculos.size(); i++){
                                if (vehiculos.get(i).getTipoVehiculo().equals("Camión")){
                                    System.out.println("-------( Camión "+ i2 +" )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getModelo());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("----------------------------------");
                                    System.out.println("Pagina " + pagina);
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("No hay Camión.");
                            System.out.println("-----------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay Camión.");
                        System.out.println("---------------------------------");
                    }
                }
                if (pregunta6.equals("2")) {

                    // Se bajan las cosa para que puedair a la anterior pagina y vehiculo

                   i = i - 1;
                   i2 = i2 - 1;
                   pagina = pagina - 1;

                   // Se activan las condiciones para que se pueda ver si esta dentro de la lista el indice "i"

                   if (i > 0){
                       if(i < vehiculos.size()){
                           for (i = i; i >= 0; i--){
                               if (vehiculos.get(i).getTipoVehiculo().equals("Camión")){
                                   System.out.println("-------( Camión " + i2 +" )-------");
                                   System.out.println(vehiculos.get(i).getId());
                                   System.out.println(vehiculos.get(i).getMarca());
                                   System.out.println(vehiculos.get(i).getModelo());
                                   System.out.println(vehiculos.get(i).getAnioFabricacion());
                                   System.out.println(vehiculos.get(i).getKilometraje());
                                   System.out.println(vehiculos.get(i).getAtributo1());
                                   System.out.println(vehiculos.get(i).getAtributo2());
                                   System.out.println("-----------------------------------");
                                   System.out.println("Pagina "+ pagina);
                                   break;
                               }
                           }
                       }
                       else{
                           System.out.println("No hay Camión.");
                           System.out.println("----------------------------------");
                       }
                   }
                   else{
                       System.out.println("No hay Camión.");
                       System.out.println("-----------------------------------");
                   }

                }
                if (pregunta6.equals("3")){
                    System.out.println("Saliendo...");
                    break;
                }
            }
        }
        if(tipo.equals("Autobús")){

            pagina = 1;
            i2 = 1;
            i = 0;

            while(true){

                System.out.println("1.- Siguiente pagina.");
                System.out.println("2.- Anterior pagina.");
                System.out.println("3.- Salir.");

                String pregunta6 = opcion.nextLine();

                if(pregunta6.equals("1")){
                    i = i + 1;
                    i2 = i2 + 1;
                    pagina = pagina + 1;

                    if(i >= 0){
                        if (i < vehiculos.size()){
                            for (i = i; i < vehiculos.size(); i++){
                                if (vehiculos.get(i).getTipoVehiculo().equals("Autobús")){
                                    System.out.println("-------( Autobus " + i2 + " )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("-------------------------------------");
                                    System.out.println("Pagina " + pagina);
                                }
                            }
                        }
                        else{
                            System.out.println("No hay autobus.");
                            System.out.println("-----------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay Autobus.");
                        System.out.println("---------------------------------------");
                    }
                }
                if(pregunta6.equals("2")){

                    pagina = pagina - 1;
                    i2 = i2 - 1;
                    i = i - 1;

                    if (i >= 0){
                        if(i < vehiculos.size()){
                            for(i = i; i >= 0 ; i--){
                                if(vehiculos.get(i).getTipoVehiculo().equals("Autobús")){
                                    System.out.println("-------( Autobus " + i2 +" )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getModelo());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("------------------------------------");
                                    System.out.println("Pagina " + pagina);
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("No hay Autobus");
                            System.out.println("---------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay Autobus.");
                        System.out.println("---------------------------------------");
                    }
                }
                if(pregunta6.equals("3")){
                    System.out.println("Saliendo...");
                    break;
                }
            }
        }
        if(tipo.equals("Motocicleta")){
            i = 0;
            i2 = 1;
            pagina = 1;

            while (true){

                System.out.println("1.- Siguiente pagina.");
                System.out.println("2.- Anterior pagina");
                System.out.println("3.- Salir.");

                String pregunta6 = opcion.nextLine();

                if (pregunta6.equals("1")) {

                    pagina = pagina + 1;
                    i2 = i2 + 1;
                    i = i + 1;

                    if (i >= 0){
                        if(i < vehiculos.size()){
                            for(i = i; i < vehiculos.size(); i ++){
                                if( vehiculos.get(i).getTipoVehiculo().equals("Motocicleta")){
                                    System.out.println("-------( Motocicleta " + i2 + " )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getModelo());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("-----------------------------------------");
                                    System.out.println("Pagina " + pagina);
                                }
                            }
                        }
                        else{
                            System.out.println("No hay motocicketa.");
                            System.out.println("-------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay motocicleta.");
                        System.out.println("------------------------------------");
                    }
                }
                if (pregunta6.equals("2")) {
                    i = i - 1;
                    i2 = i2 - 1;
                    pagina = pagina - 1;
                    if(i >= 0){
                        if( i < vehiculos.size()){
                            for (i = i; i >= 0; i-- ){
                                if (vehiculos.get(i).getTipoVehiculo().equals("Motocicleta")){
                                    System.out.println("-------( Motocicleta " + i2 + " )-------");
                                    System.out.println(vehiculos.get(i).getId());
                                    System.out.println(vehiculos.get(i).getMarca());
                                    System.out.println(vehiculos.get(i).getModelo());
                                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                                    System.out.println(vehiculos.get(i).getKilometraje());
                                    System.out.println(vehiculos.get(i).getAtributo1());
                                    System.out.println(vehiculos.get(i).getAtributo2());
                                    System.out.println("----------------------------------------");
                                    System.out.println("Pagina " + pagina);
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("No hay motocicleta");
                            System.out.println("--------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay motocicleta");
                        System.out.println("-------------------------------------");
                    }
                }
                if (pregunta6.equals("3")) {
                    System.out.println("Saliendo...");
                    break;

                }
            }
        }
    }
    @Override
    public void buscarPorId() {

        // Se crean 1 cosa para poder saber si se cumplio la busqueda del vehiculo por su id, la cual es "verificador" que empieza en 0

        int verificador = 0;

        System.out.println("¿Cual es el ID del vehiculo?");

        // Se inicia la pregunta para que la persona pueda elegir el id que quiera poner

        int pregunta7 = opcion.nextInt();

        // Se inicia el ciclo for para que pueda buscar el id que se escribio en la consola

        for (int i = 0;i < vehiculos.size(); i++){

            // La condicion que es para ver si se llego a buscar el id del vehiculo dentro del archivo

            if(pregunta7 == vehiculos.get(i).getId()){
                verificador = verificador + 1;
                System.out.println(vehiculos.get(i).getMarca());
                System.out.println(vehiculos.get(i).getModelo());
                System.out.println(vehiculos.get(i).getAnioFabricacion());
                System.out.println(vehiculos.get(i).getKilometraje());
                System.out.println(vehiculos.get(i).getTipoVehiculo());
                System.out.println(vehiculos.get(i).getAtributo1());
                System.out.println(vehiculos.get(i).getAtributo2());
            }
        }

        // La condicion que ve si se llego a cambiar el verificador

        if (verificador == 0){
            System.out.println("No se encontro el vehiculo");
        }

    }

    @Override
    public void mostrarHistorialVehiculo() {

        // Se crea 1 cosa para que pueda verificar si se pudo buscar los mantenimiento del vehiculo

        int verificador2 = 0;
        System.out.println("¿Cual es el ID del vehiculo?");

        // Se inicia la pregunta para que la persona pueda escribir el id para buscar los mantenimientos que se hicieron con ese id de vehiculo

        int pregunta8 = opcion.nextInt();

        // Se inicio el ciclo for para que pueda buscar el id del vehiculo

        for (int i = 0; i < mantenimientos.size(); i++){

            // La condicion que deja ver si se pudo encontrar el id del vehiculo

            if(mantenimientos.get(i).getId() == pregunta8){
                verificador2 = verificador2 + 1;
                System.out.println("Historial ");
                System.out.println(mantenimientos.get(i).getFecha());
                System.out.println(mantenimientos.get(i).getTipoMantenimiento());
                System.out.println(mantenimientos.get(i).getDescripcion());
                System.out.println("---------------------------------------");
            }
        }

        // La condicion que deja ver si se cambio el "verificador2"
        if (verificador2 == 0){
            System.out.println("No se encontro los mantenimientos de ese vehiculo");
        }
    }

    @Override
    public void agregarVehiculo() {

        // Se hace las preguntas con su condiciones si hacen bien las respuesta que se escribieron

        System.out.println("¿De que marca es el automovil?");
        String marca = opcion.nextLine();
        if(!marca.equals("")){
            System.out.println("¿De que modelo es?");
            String modelo = opcion.nextLine();
            if(!modelo.equals("")){
                System.out.println("¿Cuando se fabrico?");
                int anios = opcion.nextInt();
                if(anios >= 1950 && anios <= 2024){
                    System.out.println("¿Cuanto kilometraje trae?");
                    int kilometraje = opcion.nextInt();
                    if(kilometraje > 1000){
                        System.out.println("¿Que tipo de vehiculo es?");
                        String tipo = opcion.nextLine();
                        tipo = opcion.nextLine();
                        if(tipo.equals("Automóvil") || tipo.equals("Camión") || tipo.equals("Autobús") || tipo.equals("Motocicleta")){
                            System.out.println("¿Cual es su primer atributo?");
                            String atributo1 = opcion.nextLine();
                            if (!atributo1.equals("")){
                                System.out.println("¿Cual es su segundo atributo?");
                                String atributo2 = opcion.nextLine();
                                if(!atributo2.equals("")){
                                    int id = vehiculos.size() + 1;

                                    // Instanceo del vehiculo para que se pueda agregar el vehiculo a la lista de vehiculos

                                    Vehiculo vehiculo2 = new Vehiculo(id,marca,modelo,anios,kilometraje,tipo,atributo1,atributo2);
                                    vehiculos.add(vehiculo2);
                                    System.out.println("Se agrego el vehiculo al sistema");
                                }
                                else{
                                    System.out.println("Porfavor, rellene el atributo 2.");
                                }
                            }
                            else{
                                System.out.println("Porfavor, rellene el atributo 1.");
                            }
                        }
                        else{
                            System.out.println("Porfavor elija uno de los tipos de vehiculos que hay.");
                        }
                    }
                    else{
                        System.out.println("Porfavor, elija un kilometraje que se mayor a 1000.");
                    }
                }
                else{
                    System.out.println("Porfavor, elija una fecha de fabricacion mayor al año 1950.");
                }
            }
            else{
                System.out.println("Porfavor, elija un modelo.");
            }
        }
        else{
            System.out.println("Porfavor rellene la marca.");
        }

    }
    @Override
    public void agregarMantenimineto() {

        // Se inician las preguntas con sus condiciones para ver si se escribio bien las preguntas para poder agregar el mantenimiento a la lista de mantenimientos

        int idMan = mantenimientos.size() + 1;
        System.out.println("¿Cual es el Id del vehiculo que se quiere hacer el mantenimiento?");
        int idVehiculo = opcion.nextInt();
        if (idVehiculo >= 1 && idVehiculo <= vehiculos.size()){
            System.out.println("¿Cual es la fecha del mantenimiento?");
            String fecha = opcion.nextLine();
            fecha = opcion.nextLine();
            if(fecha.length() == 10){
                System.out.println("¿Que tipo de mantenimiento se hizo?");
                String mantenimiento = opcion.nextLine();
                if(!mantenimiento.equals("")){
                    System.out.println("¿Cual es la descripcion del vehiculo?(realizado correctamente, sin problemas, requiere seguimiento, reemplazo exitoso).");
                    String descripcion = opcion.nextLine();
                    if(descripcion.equals("realizado correctamente") || descripcion.equals("sin problemas") || descripcion.equals("requiere seguimiento") || descripcion.equals("reemplazo exitoso")){

                        // Se instacia la clase Mantenimiento y se agrega a la lista de mantenimientos (con su mensaje)

                        Mantenimiento mantenimiento1 = new Mantenimiento (idMan,idVehiculo,fecha,mantenimiento,descripcion);
                        mantenimientos.add(mantenimiento1);
                        System.out.println("Se agrego el mantenimiento al sistema");
                    }
                    else{
                        System.out.println("Porfavor, elija una de las descripciones que hay");
                    }
                }
                else{
                    System.out.println("Porfavor, elija un mantenimiento para el vehiculo");
                }
            }
            else{
                System.out.println("Porfavor elija una fecha para ponerla dentro de la pagina");
            }
        }
        else{
            System.out.println("Disculpe no se encontro el vehiculo");
        }
    }

    @Override
    public void generarBoleta() {

        // Se crean 1 cosa para que se pueda instanciar por completo la clase Boleta y se agregue a la lista boletas la cual es: "id" que es el id de la bolata que se creara.

        int id = 1;
        id = id + boletas.size();

        // Se activan las preguntas y los mensajes para que la persona pueda crear la boleta.

        System.out.println("¿Cual es el id del vehiculo que quiere generar su boleta");
        int i = opcion.nextInt();
        if(i >= 0 && i <= vehiculos.size()){
            int posicion = vehiculos.indexOf(vehiculos.get(i - 1));
            Vehiculo vehiculo = vehiculos.get(posicion);

            System.out.println("¿Cual es el id del mantenimiento que quiere agregar a la boleta (que sea igual al del vehiculo)");
            int idMantenimiento = opcion.nextInt();

            if (idMantenimiento >= 0 && idMantenimiento <= mantenimientos.size()){
                if(mantenimientos.get(idMantenimiento - 1).getId() == i) {

                    int posicion2 = mantenimientos.indexOf(mantenimientos.get(idMantenimiento - 1));
                    Mantenimiento mantenimiento = mantenimientos.get(posicion2);

                    Date fecha = new Date();

                    Date fechaActual = fecha;

                    System.out.println("¿Cual es el precio total?");
                    double total = opcion.nextDouble();

                    if (total > 0) {

                        // Se instancia la clase Boleta y se agrega a la lista de boletas
                        Boleta boleta = new Boleta(id,vehiculo,mantenimiento,fechaActual,total);
                        boletas.add(boleta);
                        System.out.println("Se creo la boleta.");
                        System.out.println("------------------------------------");

                        vehiculos.remove(vehiculos.get(i - 1));
                        for (int in = 0; in < mantenimientos.size(); in++) {
                            if (mantenimientos.get(in).getId() == i) {
                                mantenimientos.remove(mantenimientos.get(in));
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.println("No se encontro el vehiculo.");
        }
    }

    @Override
    public void verBoletas() {

        // Se cran 2 cosas para que pueda funcionar la opcion las cuales son: "i" que es el indice de la lista boleta y "pagina" que es la pagina que estara las 4 vehiculos
        int i = 0;
        int pagina = 1;

        // Se empieza a mostrar las boletas con sus atributos y su numero de pagina
        if (boletas.size() == 1) {
            System.out.println("-------( Boleta " + (i + 1) + " )-------");
            System.out.println(boletas.get(i).getId());
            System.out.println(boletas.get(i).getVehiculo());
            System.out.println(boletas.get(i).getMantenimiento());
            System.out.println(boletas.get(i).getFechaEmision());
            System.out.println(boletas.get(i).getPagaTotal());
            System.out.println("----------------------------------------");
        }
        else{
            System.out.println("No hay boleta");
            System.out.println("----------------------------------------");
        }
        if (boletas.size() == 2) {

            System.out.println("-------( Boleta " + (i + 2) + " )-------");
            System.out.println(boletas.get(i + 1).getId());
            System.out.println(boletas.get(i + 1).getVehiculo());
            System.out.println(boletas.get(i + 1).getMantenimiento());
            System.out.println(boletas.get(i + 1).getFechaEmision());
            System.out.println(boletas.get(i + 1).getPagaTotal());
            System.out.println("----------------------------------------");
        }
        else {
            System.out.println("No hay boleta");
            System.out.println("----------------------------------------");
        }
        if(boletas.size() == 3) {
            System.out.println("-------( Boleta " + (i + 3) + " )-------");
            System.out.println(boletas.get(i + 2).getId());
            System.out.println(boletas.get(i + 2).getVehiculo());
            System.out.println(boletas.get(i + 2).getMantenimiento());
            System.out.println(boletas.get(i + 2).getFechaEmision());
            System.out.println(boletas.get(i + 2).getPagaTotal());
            System.out.println("----------------------------------------");
        }
        else {
            System.out.println("No hay boleta");
            System.out.println("----------------------------------------");
        }
        if( boletas.size() == 4){

            System.out.println("-------( Boleta " + (i + 4) + " )-------");
            System.out.println(boletas.get(i + 3).getId());
            System.out.println(boletas.get(i + 3).getVehiculo());
            System.out.println(boletas.get(i + 3).getMantenimiento());
            System.out.println(boletas.get(i + 3).getFechaEmision());
            System.out.println(boletas.get(i + 3).getPagaTotal());
            System.out.println("-----------------------------------------");
        }
        else{
            System.out.println("No hay boleta");
            System.out.println("-----------------------------------------");
        }
        System.out.println("Pagina " + pagina);

        System.out.println("1.- Siguiente pagina.");
        System.out.println("2.- Anterior pagina.");
        System.out.println("3.- Salir.");
        System.out.println("Elija una opcion: ");
        String pregunta9 = opcion.nextLine();

        while(true){
            if (pregunta9.equals("1")){

                i = i + 4;
                pagina = pagina + 1;

                if(i >= 0){
                    if(i < boletas.size()) {
                        System.out.println("-------( Boleta " + (i + 1) + " )-------");
                        System.out.println(boletas.get(i).getId());
                        System.out.println(boletas.get(i).getVehiculo());
                        System.out.println(boletas.get(i).getMantenimiento());
                        System.out.println(boletas.get(i).getFechaEmision());
                        System.out.println(boletas.get(i).getPagaTotal());
                        System.out.println("----------------------------------");
                    }
                    else{
                        System.out.println("No hay boleta.");
                        System.out.println("----------------------------------");
                    }
                    if(i < boletas.size()) {
                        if(i + 1 < boletas.size()) {
                            System.out.println("-------( Boleta " + (i + 2) + " )-------");
                            System.out.println(boletas.get(i + 1).getId());
                            System.out.println(boletas.get(i + 1).getVehiculo());
                            System.out.println(boletas.get(i + 1).getMantenimiento());
                            System.out.println(boletas.get(i + 1).getFechaEmision());
                            System.out.println(boletas.get(i + 1).getPagaTotal());
                            System.out.println("-----------------------------------");
                        }
                        else{
                            System.out.println("NO hay boleta.");
                            System.out.println("-----------------------------------");
                        }
                    }
                    else {
                        System.out.println("No hay boleta.");
                        System.out.println("-------------------------------------");
                    }
                    if( i < boletas.size()) {
                        if(i + 2 < boletas.size()) {
                            System.out.println("-------( Boleta " + (i + 3) + " )-------");
                            System.out.println(boletas.get(i + 2).getId());
                            System.out.println(boletas.get(i + 2).getVehiculo());
                            System.out.println(boletas.get(i + 2).getMantenimiento());
                            System.out.println(boletas.get(i + 2).getFechaEmision());
                            System.out.println(boletas.get(i + 2).getPagaTotal());
                            System.out.println("------------------------------------");
                        }
                        else{
                            System.out.println("No hay boleta. ");
                            System.out.println("------------------------------------");
                        }
                    }
                    else {
                        System.out.println("No hay boleta.");
                        System.out.println("--------------------------------------");
                    }
                    if(i < boletas.size()){
                        if(i + 3 < boletas.size()) {
                            System.out.println("-------( Boleta " + (i + 4) + " )-------");
                            System.out.println(boletas.get(i + 3).getId());
                            System.out.println(boletas.get(i + 3).getVehiculo());
                            System.out.println(boletas.get(i + 3).getMantenimiento());
                            System.out.println(boletas.get(i + 3).getFechaEmision());
                            System.out.println(boletas.get(i + 3).getPagaTotal());
                            System.out.println("-------------------------------------");
                        }
                        else{
                            System.out.println("No hay boleta.");
                            System.out.println("-------------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay boleta.");
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Pagina " + pagina);
                }
                else{
                    System.out.println("No hay boleta.");
                    System.out.println("------------------------------------");
                }

            }
            if (pregunta9.equals("2")){

                i = i - 4;
                pagina = pagina - 1;

                if (i >= 0){
                    if (i < boletas.size()){
                        System.out.println("-------( Boleta " + (i + 1) + " )-------");
                        System.out.println(boletas.get(i).getId());
                        System.out.println(boletas.get(i).getVehiculo());
                        System.out.println(boletas.get(i).getMantenimiento());
                        System.out.println(boletas.get(i).getFechaEmision());
                        System.out.println(boletas.get(i).getPagaTotal());
                    }
                    else{
                        System.out.println("No hay boleta.");
                        System.out.println("------------------------------------");
                    }
                    if(i < boletas.size()){
                        if(i + 1 < boletas.size()){
                            System.out.println("-------( Boleta " + (i + 2) + " )-------");
                            System.out.println(boletas.get(i + 1).getId());
                            System.out.println(boletas.get(i + 1).getVehiculo());
                            System.out.println(boletas.get(i + 1).getMantenimiento());
                            System.out.println(boletas.get(i + 1).getFechaEmision());
                            System.out.println(boletas.get(i + 1).getPagaTotal());
                        }
                        else{
                            System.out.println("No hay boleta.");
                            System.out.println("---------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay boleta.");
                        System.out.println("-------------------------------------");
                    }
                    if ( i < boletas.size()){
                        if(i + 2 < boletas.size()){
                            System.out.println("------( Boleta "+ (i + 3) +" )-------");
                            System.out.println(boletas.get(i + 2).getId());
                            System.out.println(boletas.get(i + 2).getVehiculo());
                            System.out.println(boletas.get(i + 2).getMantenimiento());
                            System.out.println(boletas.get(i + 2).getFechaEmision());
                            System.out.println(boletas.get(i + 2).getPagaTotal());
                        }
                        else{
                            System.out.println("No hay boleta.");
                            System.out.println("---------------------------------");
                        }
                    }
                    else{
                        System.out.println("No hay boletas.");
                        System.out.println("---------------------------------------");
                    }
                    if (i < boletas.size()){
                        if(i + 3 < boletas.size()){
                            System.out.println("-------( Boleta " + (i + 4) + " )-------");
                            System.out.println(boletas.get(i + 3).getId());
                            System.out.println(boletas.get(i + 3).getVehiculo());
                            System.out.println(boletas.get(i + 3).getMantenimiento());
                            System.out.println(boletas.get(i + 3).getFechaEmision());
                            System.out.println(boletas.get(i + 3).getPagaTotal());
                            System.out.println("----------------------------------------");
                        }
                        else{
                            System.out.println("No hay boleta.");
                            System.out.println("-------------------------------------------");
                        }

                    }
                    else {
                        System.out.println("No hay boleta.");
                        System.out.println("------------------------------------------");
                    }

                    System.out.println("Pagina " + pagina);
                }
                else{
                    System.out.println("No hay boleta");
                    System.out.println("-----------------------------------");
                }


            }
            if (pregunta9.equals("3")){
                System.out.println("Saliendo...");
                break;
            }

            System.out.println("1.- Siguiente pagina.");
            System.out.println("2.- Anterior pagina.");
            System.out.println("3.- Salir.");
            System.out.println("Elija una opcion: ");
            pregunta9 = opcion.nextLine();

        }

    }


    @Override
    public void salir() {

        // Se inicia la sobreescritura de los archivos.csv y se guardan los cambios que se hicieron dentro del programa

        // Para el archivo vehiculos.csv
        Out out = new Out("vehiculos.csv");

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);

            String vehiculoEnEscrito = vehiculos.get(i).getId() + "," + vehiculos.get(i).getMarca()+ "," + vehiculos.get(i).getModelo()+ "," + vehiculos.get(i).getAnioFabricacion()+ "," + vehiculos.get(i).getKilometraje()+ "," + vehiculos.get(i).getTipoVehiculo()+ "," + vehiculos.get(i).getAtributo1() + "," + vehiculos.get(i).getAtributo2() ;

            out.println(vehiculoEnEscrito);


        }

        // Para el archivo mantenimientos.csv

        Out out1 = new Out("mantenimientos.csv");
        for (int j = 0; j< mantenimientos.size() ;j++){

            Mantenimiento mantenimiento = mantenimientos.get(j);

            String mantenimientoEnEscrito = mantenimientos.get(j).getIdMantenimiento() +"," + mantenimientos.get(j).getId() + "," + mantenimientos.get(j).getFecha() +"," + mantenimientos.get(j).getTipoMantenimiento() + "," + mantenimientos.get(j).getDescripcion();

            out1.println(mantenimientoEnEscrito);
        }

        // Para el archivo boletas.csv
        Out out2 = new Out("boletas.csv");
        for (int j = 0; j< boletas.size() ;j++){


            Boleta boleta = boletas.get(j);

            String boletaEnEscrito = boletas.get(j).getId() + "," +boletas.get(j).getVehiculo() + "," + boletas.get(j).getMantenimiento() + "," + boletas.get(j).getFechaEmision() + "," + boletas.get(j).getPagaTotal()  ;

            out2.println(boletaEnEscrito);



        }






    }
}
