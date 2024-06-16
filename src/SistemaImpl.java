
// Las importaciones de las librerias para poder hacer el codigo, por ejemplo edu.pricenton.cs.stdlib.In es para leer los archivos de vehiculos.csv y mantenimientos.csv,
// despues el java.util.ArrayList es para crear las listas de las clases vehiculo y mantenimiento llamadas "vehicul0s" y "mantenimiento" despues el java.util.Scanner es para
// crear el Scanner llamado opcion donde los usuarios pueden esccribir las opciones
import edu.princeton.cs.stdlib.In;
import java.util.ArrayList;
import java.util.Scanner;

// clase del sistema llamado "SistemaImpl" donde se usaron las implementaciones de la interface llamada "Sistema"
public class SistemaImpl implements Sistema {

    // Los atributos privados de la clase SistemaImpl, los cuales son 2 listas de las clases "Vehiculo" y "Mantenimiento"
    private ArrayList<Vehiculo> vehiculos;

    private ArrayList<Mantenimiento> mantenimientos;

    // El constructor de la clase SistemaImpl, donde crea las ArrayList de las listas vehiculos y mantenimientos.
    public SistemaImpl() {
        this.vehiculos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
    }

    // La creacion del Scanner llamado "opcion"
    Scanner opcion = new Scanner(System.in);

    // menu(): Esto hace que se pueda mostrar el menu principal del programa, con sus opciones, con la carga de archivos de los archivos
    // "vehiculos.csv"y "mantenimientos.csv", tambien que se activa la funcion "mensajeMenu1()", donde se usa el Scanner "opcion" y con la salida del programa.
    // que guarda los nuevos cambios de los archivos y se termina
    public void menu() {
        cargarVehiculos();
        cargarMantenimientos();
        mensajeMenu1();
        String pregunta = opcion.nextLine();
        while (true){
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

    // Se usa mensajeMenu1() en la parte de menu() para mostrar las opciones que dentro del menu principal
    @Override
    public void mensajeMenu1() {
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

    // Se usa dentro del switch (en el "case 1"), donde muestra las opciones del submenu, dejando al usuario elegir cada una de las opciones
    // que hay dentro del programa y las opcines son 4, ahi la ultima opcion es volver al menu principal
    @Override
    public void menu2() {
        System.out.println("-------( Ver vehiculos )-------");
        System.out.println("1.- Listar todos los vehiculos.");
        System.out.println("2.- Buscar vehiculo por tipo.");
        System.out.println("3.- Buscar vehiculo por ID.");
        System.out.println("4.- Volver al menu pricipal.");
        System.out.println("Elija una opcion: ");
        String pregunta2 = opcion.nextLine();
        while (true){
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

    // Se usa dentro del switch(en el "case 2"), donde muestra las opciones, dejando al usuario elegir la opcion que quiera
    // , donde hay 2 opciones, ahi a ultima es volver al menu principal
    @Override
    public void menu3() {
        System.out.println("-------( Ver historial de mantenimiento )-------");
        System.out.println("1.- Mostrar historial por vehiculo.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");
        String pregunta3 = opcion.nextLine();
        while (true){
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

    // Se usa dentro del switch(en el "case 6"), donde muestra las opciones que hay, dejando al usuario que pueda elegir esas opciones
    // tambien hay 2 opciones, ahi en la ultima opcion es volver al menu principal
    @Override
    public void menu4() {

        System.out.println("-------( Ver boletas )-------");
        System.out.println("1.- Listado de todas las boletas.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");
        String pregunta4 = opcion.nextLine();
        while (true){
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
            System.out.println("2.- Volver al menu principal.0");
            System.out.println("Elija una opcion: ");
            pregunta4 = opcion.nextLine();
        }

    }

    //Se usa en el menu principal en el momento que se inicia el programa, ahi se usa la funcion cargarVehiculos para cargar el archivo vehiculos.csv
    @Override
    public void cargarVehiculos() {
        In in = new In ("vehiculos.csv");
        String linea = in.readLine();

        while(linea != null) {

            String[] campos = linea.split(",");
            int id = Integer.parseInt(campos[0]);
            String marca = campos[1];
            String modelo = campos[2];
            int anioFabricacion = Integer.parseInt(campos[3]);
            int kilometraje = Integer.parseInt(campos[4]);
            String tipo = campos[5];
            String atributo1 = campos[6];
            String atributo2 = campos[7];
            Vehiculo vehiculo1 = new Vehiculo(id,marca,modelo,anioFabricacion,kilometraje,tipo,atributo1,atributo2);
            vehiculos.add(vehiculo1);

            linea = in.readLine();
        }

    }

    // Se usa en el menu pricipal en el momento que se inicia el programa, donde se carga el archivo de mantenimientos.csv.

    @Override
    public void cargarMantenimientos() {
        In in2 = new In ("mantenimientos.csv");

        String linea = in2.readLine();
        while (linea != null){
            String[] campos = linea.split(",");
            int idMantenimiento = Integer.parseInt(campos[0]);
            int idVehiculo = Integer.parseInt(campos[1]);
            String fecha = campos[2];
            String tipoMantenimiento = campos[3];
            String descripcion = campos[4];
            Mantenimiento mantenimiento = new Mantenimiento(idMantenimiento,idVehiculo  ,fecha,tipoMantenimiento,descripcion);
            mantenimientos.add(mantenimiento);

            linea = in2.readLine();
        }

    }

    // Se usa dentro del submenu "menu2()" (en la opcion 1), donde se usa las 2 variables la primera es "i" donde es el indice de las listas y es igual a 0 desde el principio de la funcion
    // y la otra veriable llamado "pagina", que empieza en 1, donde es la pagina que se mostrara dentro de las listas de los vehiculos.
    @Override
    public void verVehiculos() {
        int i = 0;
        int pagina = 1;
        System.out.println("--------- Vehiculo " + (i + 1) + ") ---------");
        System.out.println(vehiculos.get(i).getId());
        System.out.println(vehiculos.get(i).getMarca());
        System.out.println(vehiculos.get(i).getModelo());
        System.out.println(vehiculos.get(i).getAnioFabricacion());
        System.out.println(vehiculos.get(i).getKilometraje());
        System.out.println(vehiculos.get(i).getTipoVehiculo());
        System.out.println(vehiculos.get(i).getAtributo1());
        System.out.println(vehiculos.get(i).getAtributo2());
        System.out.println("-------------------------------");

        System.out.println("--------- Vehiculo " + (i + 2) + ") ---------");
        System.out.println(vehiculos.get(i + 1).getId());
        System.out.println(vehiculos.get(i + 1).getMarca());
        System.out.println(vehiculos.get(i + 1).getModelo());
        System.out.println(vehiculos.get(i + 1).getAnioFabricacion());
        System.out.println(vehiculos.get(i + 1).getKilometraje());
        System.out.println(vehiculos.get(i + 1).getTipoVehiculo());
        System.out.println(vehiculos.get(i + 1).getAtributo1());
        System.out.println(vehiculos.get(i + 1).getAtributo2());
        System.out.println("--------------------------------");

        System.out.println("--------- Vehiculo " + (i + 3) + ") ----------");
        System.out.println(vehiculos.get(i + 2).getId());
        System.out.println(vehiculos.get(i + 2).getMarca());
        System.out.println(vehiculos.get(i + 2).getModelo());
        System.out.println(vehiculos.get(i + 2).getAnioFabricacion());
        System.out.println(vehiculos.get(i + 2).getKilometraje());
        System.out.println(vehiculos.get(i + 2).getTipoVehiculo());
        System.out.println(vehiculos.get(i + 2).getAtributo1());
        System.out.println(vehiculos.get(i + 2).getAtributo2());
        System.out.println("---------------------------------");

        System.out.println("--------- Vehiculo " + (i + 4) + ") ----------");
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

        System.out.println("1.- Siguiente pagina.");
        System.out.println("2.- Pagina anterior.");
        System.out.println("3.- Salir.");
        System.out.println("Elija una opcion: ");
        String pregunta5 = opcion.nextLine();
        while (true){

            if (pregunta5.equals("1")) {
                i = i + 4;
                pagina = pagina + 1;
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
                i = i - 4;
                pagina = pagina - 1;
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
            System.out.println("Elija una opcio: ");
            pregunta5 = opcion.nextLine();
        }
    }

    // Se usa dentro del submenu del menu2() (En la opcion 2), donde hay 3 variables las cuales son esta: "i" es el indice de la lista "vehiculos"
    // , despues el segundo es "pagina" donde es la pagina que se hara cada 1 vehiculo que se busque y el tercero es "i2" donde es el indice para mostrar
    // el numero del vehiculo que se muestra dentro de la opcion
    @Override
    public void buscarPorTipo() {
        int pagina = 1;
        int i = 0;
        int i2 = 1;
        System.out.println("¿Cual es el tipo del vehiculo?");
        String tipo = opcion.nextLine();
        if(tipo.equalsIgnoreCase("Automóvil")){
            while(true){
                System.out.println("1.- Siguiente Pagina.");
                System.out.println("2.- Pagina anterior.");
                System.out.println("3.- Salir.");
                String pregunta6 = opcion.nextLine();

                if (pregunta6.equals("1")){
                    i = i + 1;
                    pagina = pagina + 1;
                    i2 = i2 + 1;
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
            }
        }
    }
    // Se usa dentro del submenu de menu2() (en la opcion 3), donde hay  1 variable que es el verificador que empiza en 0, este verificador
    // se usa para ver si llego a la parte que se busco el vehiculo por su ID, sino se mostrara el mensaje que no se encontro el vehiculo.
    @Override
    public void buscarPorId() {
        int verificador = 0;
        System.out.println("¿Cual es el ID del vehiculo?");
        int pregunta7 = opcion.nextInt();
        for (int i = 0;i < vehiculos.size(); i++){
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
        if (verificador == 0){
            System.out.println("No se encontro el vehiculo");
        }

    }

    // Se usa en el submenu "menu3()" (en la opcion 1), ahi se pregunta por la id del vehiculo y se busca esa id en los mantenimientos que se hizo en ese vehiculo
    // mostrando las fehcas, tipo de mantenimiento y descripcion.
    @Override
    public void mostrarHistorialVehiculo() {
        System.out.println("¿Cual es el ID del vehiculo?");
        int pregunta8 = opcion.nextInt();
        for (int i = 0; i < mantenimientos.size(); i++){
            if(mantenimientos.get(i).getId() == pregunta8){
                System.out.println("Historial ");
                System.out.println(mantenimientos.get(i).getFecha());
                System.out.println(mantenimientos.get(i).getTipoMantenimiento());
                System.out.println(mantenimientos.get(i).getDescripcion());
                System.out.println("---------------------------------------");
            }
        }
    }

    // Se usa en la opcion 3 del menu principal y se agrega un vehiculo nuevo en la lista de vehiculos, donde tambien se agrega al
    // archivo "vehiculos.csv" cuando se salio del programa en la opcion salir
    @Override
    public void agregarVehiculo() {
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

    // Se usa en la opcion 4 del menu principal, donde se agrega en la lista "mantenimientos" y se agregar al archivo
    // de "mantenimiento.csv" cuando se use la opcion salir.
    @Override
    public void agregarMantenimineto() {
        int idMan = mantenimientos.size() + 1;
        System.out.println(idMan);
        System.out.println("¿Cual es el Id del vehiculo que se quiere hacer el mantenimiento?");
        int idVehiculo = opcion.nextInt();
        if (idVehiculo >= 1 && idVehiculo <= vehiculos.size()){
            System.out.println("¿Cual es la fecha del mantenimiento?");
            String fecha = opcion.nextLine();
            if(fecha.contains("aaaa-mm-dd")){
                System.out.println("¿Que tipo de mantenimiento se hizo?");
                String mantenimiento = opcion.nextLine();
                if(!mantenimiento.equals("")){
                    System.out.println("¿Cual es la descripcion del vehiculo?(realizado correctamente, sin problemas, requiere seguimiento, reemplazo exitoso).");
                    String descripcion = opcion.nextLine();
                    if(descripcion.equals("realizado correctamente") || descripcion.equals("sin problemas") || descripcion.equals("requiere seguimiento") || descripcion.equals("reemplazo exitoso")){
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

    }

    @Override
    public void verBoletas() {

    }


    @Override
    public void salir() {


    }
}
