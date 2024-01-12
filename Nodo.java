import java.io.Serializable;
/**
 *Clase Nodo, el cual, es el empleado 
 *@author Alan Kevin Cano Tenorio y Malinalli Escobedo Irineo
 *@version 1.0
 */

public class Nodo implements Serializable {
    
    private Nodo siguiente;

    private String tipo_empleado;

    private double sueldo=0;

    private int cantidadEmpleado=0;

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

     public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setCantidadEmpleado(int cantidadEmpleado) {
        this.cantidadEmpleado = cantidadEmpleado;
    }

    public int getCantidadEmpleado() {
        return cantidadEmpleado;
    }
}
