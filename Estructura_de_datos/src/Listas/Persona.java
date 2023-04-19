package Listas;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Persona {
    private String CI, Nombre, Primer_Apellido;
    private int Edad;

    public Persona(String CI, String Nombre, String Primer_Apellido, int Edad) {
        this.CI = CI;
        this.Nombre = Nombre;
        this.Primer_Apellido = Primer_Apellido;
        this.Edad = Edad;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String Primer_Apellido) {
        this.Primer_Apellido = Primer_Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
