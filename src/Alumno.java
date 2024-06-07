import java.util.Objects;

public class Alumno extends Object{
    private int ID;
    private String fullName;
    private String email;

    public Alumno(int ID, String fullName, String email) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;//Si el objeto actual es igual al objeto q pasamos por parámetro, entonces son iguales
        if(o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return ID == alumno.ID &&
                Objects.equals(fullName, alumno.fullName) &&
                Objects.equals(email, alumno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID,fullName, email);
    }

    /*
        Características que deben tener las implementaciónes de los métodos solicitados para mantener el contrato general para el método
        HashCode:

        Simétrica:
        Si un objeto x es igual a un objeto y, entonces y tambien debe ser igual a x

        Reflexiva:
        El objeto debe ser igual a si mismo

        Transitiva:
        Si un objeto x es igual a un objeto y, además ese objeto y es igual a otro objeto z, x debe de ser igual a z

        No Nulo:
        Los objetos no deben ser nulos, por consiguiente al compararlos, el resultado de esa operación tampoco puede ser nulo.

     */
}
