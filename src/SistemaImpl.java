import edu.princeton.cs.stdlib.In;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaImpl implements Sistema {

    private ArrayList<Vehiculo> vehiculos;

    private ArrayList<Mantenimiento> mantenimientos;

    public SistemaImpl() {
        this.vehiculos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
    }
    Scanner opcion = new Scanner(System.in);

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

                    break;

                case "4" :

                    break;

                case "5" :

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

                    break;
                case "3" :

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
        }

    }

    @Override
    public void menu3() {
        System.out.println("-------( Ver historial de mantenimiento )-------");
        System.out.println("1.-  Mostrar historial por vehiculo.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");
        String pregunta3 = opcion.nextLine();
        while (true){
            switch (pregunta3){

                case "1" :

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

        System.out.println("-------( Ver boletas )-------");
        System.out.println("1.- Listado de todas las boletas.");
        System.out.println("2.- Volver al menu principal.");
        System.out.println("Elija una opcion: ");
        String pregunta4 = opcion.nextLine();
        while (true){
            switch (pregunta4){

                case "1" :

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
            Mantenimiento mantenimiento = new Mantenimiento(idMantenimiento,idVehiculo,fecha,tipoMantenimiento,descripcion);
            mantenimientos.add(mantenimiento);

            linea = in2.readLine();
        }

    }

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
                    } else {
                        System.out.println("No hay vehiculo.");
                        System.out.println("------------------------------------");
                    }
                    if (i < (vehiculos.size())) {
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
                    else {
                        System.out.println("No hay vehiculo");
                        System.out.println("-------------------------------------");
                    }

                    if (i < (vehiculos.size())) {
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
                    } else {
                        System.out.println("No hay vehiculo");
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
                    System.out.println("------- ( Vehiculo " + (i - 1) + ") -------");
                    System.out.println(vehiculos.get(i).getId());
                    System.out.println(vehiculos.get(i).getMarca());
                    System.out.println(vehiculos.get(i).getModelo());
                    System.out.println(vehiculos.get(i).getAnioFabricacion());
                    System.out.println(vehiculos.get(i).getKilometraje());
                    System.out.println(vehiculos.get(i).getTipoVehiculo());
                    System.out.println(vehiculos.get(i).getAtributo1());
                    System.out.println(vehiculos.get(i).getAtributo2());
                    System.out.println("---------------------------------");

                    System.out.println("------- ( Vehiculo " + (i - 2) + ") -------");
                    System.out.println(vehiculos.get(i - 1).getId());
                    System.out.println(vehiculos.get(i - 1).getMarca());
                    System.out.println(vehiculos.get(i - 1).getModelo());
                    System.out.println(vehiculos.get(i - 1).getAnioFabricacion());
                    System.out.println(vehiculos.get(i - 1).getKilometraje());
                    System.out.println(vehiculos.get(i - 1).getTipoVehiculo());
                    System.out.println(vehiculos.get(i - 1).getAtributo1());
                    System.out.println(vehiculos.get(i - 1).getAtributo2());
                    System.out.println("----------------------------------");

                    System.out.println("------- ( Vehiculo " + (i - 3) + ") -------");
                    System.out.println(vehiculos.get(i - 2).getId());
                    System.out.println(vehiculos.get(i - 2).getMarca());
                    System.out.println(vehiculos.get(i - 2).getModelo());
                    System.out.println(vehiculos.get(i - 2).getAnioFabricacion());
                    System.out.println(vehiculos.get(i - 2).getKilometraje());
                    System.out.println(vehiculos.get(i - 2).getTipoVehiculo());
                    System.out.println(vehiculos.get(i - 2).getAtributo1());
                    System.out.println(vehiculos.get(i - 2).getAtributo2());
                    System.out.println("------------------------------------");

                    System.out.println("------- ( Vehiculo " + (i - 3) + ") -------");
                    System.out.println(vehiculos.get(i - 3).getId());
                    System.out.println(vehiculos.get(i - 3).getMarca());
                    System.out.println(vehiculos.get(i - 3).getModelo());
                    System.out.println(vehiculos.get(i - 3).getAnioFabricacion());
                    System.out.println(vehiculos.get(i - 3).getKilometraje());
                    System.out.println(vehiculos.get(i - 3).getTipoVehiculo());
                    System.out.println(vehiculos.get(i - 3).getAtributo1());
                    System.out.println(vehiculos.get(i - 3).getAtributo2());
                    System.out.println("--------------------------------------");
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

    @Override
    public void buscarPorTipo(String tipo) {

    }

    @Override
    public void buscarPorId(int id) {

    }

    @Override
    public void mostrarHistorialVehiculo(int id) {

    }

    @Override
    public void agregarVehiculo() {

    }

    @Override
    public void agregarMantenimineto() {

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
