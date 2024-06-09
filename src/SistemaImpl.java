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

    }

    @Override
    public void cargarMantenimientos() {

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
