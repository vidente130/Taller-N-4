/**
 * Es el main principal del programa y tambien parte del camino para llegar al menu
 */
public class Main {
    public static void main(String[] args) {

        // Instanceo de la clase SistemaImpl

        SistemaImpl sistema = new SistemaImpl();

        //Activacion del menu principal

        sistema.menu();
    }
}