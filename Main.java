import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Persona {
    private int id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private String dpi;
    private int edad;
    private String ciudad;

    // Constructor
    public Persona(int id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String genero, String dpi, int edad, String ciudad) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.genero = genero;
        this.dpi = dpi;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters
    public int getId() { return id; }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getPrimerApellido() { return primerApellido; }
    public String getSegundoApellido() { return segundoApellido; }
    public String getGenero() { return genero; }
    public String getDpi() { return dpi; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }

    // Método para obtener el nombre completo
    public String getNombreCompleto() {
        return primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido;
    }
}

public class Main {
    private List<Persona> listaPersonas;

    // Constructor
    public Main() {
        listaPersonas = new ArrayList<>();
    }

    // Método para agregar una persona a la lista
    public void agregarPersona(Persona persona) {
        listaPersonas.add(persona);
    }

    // Método para retornar la lista de personas
    public List<Persona> obtenerListaPersonas() {
        return listaPersonas;
    }

    // Método para imprimir los nombres completos usando Streams
    public void imprimirNombresCompletos() {
        listaPersonas.stream()
            .map(Persona::getNombreCompleto)
            .forEach(System.out::println);
    }

    // Método para buscar personas mayores de edad usando Streams y predicados
    public List<Persona> buscarMayoresDeEdad() {
        return listaPersonas.stream()
            .filter(persona -> persona.getEdad() >= 18)
            .collect(Collectors.toList());
    }

    // Método para encontrar la primera persona que cumpla con las condiciones usando Optional
    public Optional<Persona> encontrarPrimeraPersona() {
        return listaPersonas.stream()
            .filter(persona -> persona.getEdad() >= 18)
            .filter(persona -> "Guatemala".equals(persona.getCiudad()))
            .filter(persona -> persona.getPrimerNombre().contains("Lu"))
            .findFirst();
    }

    public static void main(String[] args) {
        Main main = new Main();

        // Agregar personas a la lista
        main.agregarPersona(new Persona(1, "Luis", "Alberto", "Gomez", "Perez", "M", "123456789", 25, "Guatemala"));
        main.agregarPersona(new Persona(2, "Lucia", "Maria", "Lopez", "Martinez", "F", "987654321", 30, "Guatemala"));
        main.agregarPersona(new Persona(3, "Carlos", "Eduardo", "Ramirez", "Sanchez", "M", "456789123", 17, "Guatemala"));

        // Imprimir nombres completos
        main.imprimirNombresCompletos();

        // Buscar personas mayores de edad
        List<Persona> mayoresDeEdad = main.buscarMayoresDeEdad();
        mayoresDeEdad.forEach(persona -> System.out.println(persona.getNombreCompleto()));

        // Encontrar la primera persona que cumpla con las condiciones
        Optional<Persona> personaOpt = main.encontrarPrimeraPersona();
        personaOpt.ifPresent(persona -> System.out.println("Primera persona encontrada: " + persona.getNombreCompleto()));
    }
}
