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

    public void menu(){
        mensajeMenu1();
        String pregunta = opcion.nextLine();
        while (true){
            switch(pregunta){
                case "1" :

                    break;
                case "2" :

                    break;
                case "3" :

                    break;
                case "4" :

                    break;
                case "5" :

                    break;
                case "6" :

                    break;
                case "7" :

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
        System.out.println("5.- Generar boleta de mantenimiento");
        System.out.println("6.- Ver boletas.");
        System.out.println("7.- Salir.");
        System.out.println("Elija una opcion: ");
    }

    @Override
    public void mensajeMenu2() {

    }

    @Override
    public void mensajeMenu3() {

    }

    @Override
    public void mensajeMenu4() {

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
            Vehiculo vehiculo = new Vehiculo(id,marca,modelo,anioFabricacion,kilometraje,tipo,atributo1,atributo2);
            vehiculos.add(vehiculo);
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
