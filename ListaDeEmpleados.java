import java.io.Serializable;

/**
 *Clase ListaDeEmpleados 
 *@author Alan Kevin Cano Tenorio y Malinalli Escobedo Irineo
 *@version 1.0
 */
public class ListaDeEmpleados implements Serializable{

        /* El nodo inical */
        private Nodo cabeza;

    

         /**Metodo que agrega un solo empleado nuevo si no existe en el catalogo                                
         * @param rolAnimador el rol del empleado                                                              
         * @param sueldo el sueldo del empleado                                                                
         *                                                                                                     
         */
        public void agregarEmpleadoNuevo(String rolAnimador, double sueldo){
             Nodo nuevo = new Nodo();
                    nuevo.setSiguiente(cabeza);
                    cabeza=nuevo;
                    nuevo.setCantidadEmpleado(1);
                    nuevo.setTipo_empleado(rolAnimador);
                    nuevo.setSueldo(sueldo);
        }


        /**Metodo que agrega un solo empleado si ya existe en el catalogo                                      
         * @param rolAnimador el rol del empleado                                                              
         * @param sueldo el sueldo del empleado                                                                
         *                                                                                                     
         */
        public boolean agregarEmpleado (String rolAnimador){
            boolean bandera=true;
            Nodo aux=cabeza;
                while (aux !=null) {
                if(aux.getTipo_empleado().equals(rolAnimador)){
                        aux.setCantidadEmpleado(aux.getCantidadEmpleado()+1);
                        bandera=false;
                    }
                    aux=aux.getSiguiente();
                }
            return bandera;
        }


     
        /**Metodo que elimina un solo empleado si ya existe en el catalogo, en caso que llegue a 0, lo quita completamente del catalogo                                                                                      
         * @param rolAnimador el rol del empleado                                                              
         *                                                                                                     
         */
        public void eliminarEmpleado (String tipoEmpleado){
            Nodo anterior = cabeza;
            Nodo actual = cabeza.getSiguiente();
            if(tipoEmpleado.equals(cabeza.getTipo_empleado())){
                 if(cabeza.getCantidadEmpleado()==1){
                        cabeza = cabeza.getSiguiente();
                    }else{
                    cabeza.setCantidadEmpleado(cabeza.getCantidadEmpleado()-1);
                    }
            }
            while(actual != null){
                 if(tipoEmpleado.equals(actual.getTipo_empleado())){
                    if(actual.getCantidadEmpleado()==1){
                        anterior.setSiguiente(actual.getSiguiente());
                    }else{
                    actual.setCantidadEmpleado(actual.getCantidadEmpleado()-1);
                    }
                 }
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }


        /**Metodo que modifica el rol de un empleado                                                          
         * @param rolAnimador el rol del empleado                                                              
         * @param nuevoRol el nuevo rol del empleado                                                           
         *                                                                                                     
         */
        public void mRol(String rolAnimador, String nuevoRol){
            Nodo aux=cabeza;
            while(aux!=null){
                if(rolAnimador.equals(aux.getTipo_empleado())){
                    aux.setTipo_empleado(nuevoRol);
                }
                 aux = aux.getSiguiente(); 
            }
        }

        /**Metodo que modifica el sueldo de un empleado                                                       
         * @param rolAnimador el rol del empleado                                                              
         * @param sueldo el nuevo sueldo del empleado                                                          
         *                                                                                                     
         */        
        public void mSueldo(String rolAnimador, double nuevoSueldo){
            Nodo aux=cabeza;
            while(aux!=null){
                if(rolAnimador.equals(aux.getTipo_empleado())){
                    aux.setSueldo(nuevoSueldo);
                }
                aux = aux.getSiguiente(); 
            }
        }

      

        /**Metodo que crea una cotizacion                                                                    
         * @param tipoEmpleado el rol del empleado contratado                                                  
         * @param cantidadEmpleados la cantidad de empleados a contratar                                       
         * @param horasEvento las horas que durara el evento                                                   
         * @param comision la comision a agregar                                                               
         * @cotizacion la cotizacion a mostrar                                                                 
         * @return la cotizacion final                                                                         
         */
        public double cotizacion(String tipoEmpleado, int cantidadEmpleados, int horasEvento, double comision, ListaDeEmpleados cotizacion) {
        Nodo aux = cabeza;
        double totalPago = 0;
    
        while (aux != null) {
            if (tipoEmpleado.equals(aux.getTipo_empleado())) {
                if (cantidadEmpleados <= aux.getCantidadEmpleado()) {
                    totalPago += aux.getSueldo() * cantidadEmpleados * horasEvento;
                    

                } else {
                    System.out.println("No hay suficientes " + tipoEmpleado + " en el catálogo.");
                }
            }
            aux = aux.getSiguiente();
        }
    
        return totalPago + (totalPago * comision / 100);
    }

    /**Metodo  que muestra el catalogo y la cotizacion
     * 
     */
    public void muestra() {
        if(esVacia())
        System.out.println("No tienes trabajadores contratados");
        else {
            Nodo aux = cabeza;
            while (aux != null) {
                System.out.println("Tipo de empleado: "+aux.getTipo_empleado() + " Cantidad: " + aux.getCantidadEmpleado() + " Sueldo por hora: $" + aux.getSueldo() + "\n");
                aux = aux.getSiguiente(); 
            }
        }
    }

    public String muestra2() {
        String muestra="";
        if(esVacia())
            return "No tienes trabajadores contratados";
        else {
            Nodo aux = cabeza;
            while (aux != null) {
                muestra +="Tipo de empleado: "+aux.getTipo_empleado() + " Cantidad: " + aux.getCantidadEmpleado() + " Sueldo por hora: $" + aux.getSueldo() + "\n";
                aux = aux.getSiguiente(); 
            }
        }
        return "TU CATALOGO ES EL SIGUIENTE\n"+muestra;
    }

        //Metodos auxiliares

        /**
         * Metodo que busca si un empleado esta en el catalogo
         * @param elemento el empleado que se buscara
         * @return true en caso que si, false en caso que no
         */
        public boolean contiene(String elemento){
            Nodo aux = cabeza;
            while(aux != null){
                if(aux.getTipo_empleado().equals(elemento)){
            return true;
                }
                 aux=aux.getSiguiente();
            }
            return false;
        }
    



        //OBTIENE EL SUELDO POR HORA
        public double sueldoPorHora (String rolAnimador){
            Nodo aux=cabeza;
            double sueldo=0;
            while(aux!=null){
                if(rolAnimador.equals(aux.getTipo_empleado())){
                    sueldo = aux.getSueldo();
                }
                 aux = aux.getSiguiente(); 
            }
            return sueldo;
        }

        //obtiene la cantidad de empleados de un solo tipo
         public int Cantidad(String rolAnimador){
            Nodo aux=cabeza;
            int cantidadPrincipal=0;
            while(aux!=null){
                if(rolAnimador.equals(aux.getTipo_empleado())){
                    cantidadPrincipal = aux.getCantidadEmpleado();
                }
                 aux = aux.getSiguiente(); 
            }
            return cantidadPrincipal;
        }

        //MODIFICA LOS VALORES DEL EMPLEADO
        public boolean modificar(String rolAnimador, int cantidad, double sueldoPorHora, int horas, ListaDeEmpleados cotizacion, int cantidadPrincipal){
            if(!cotizacion.contiene(rolAnimador)){
                    cotizacion.agregarEmpleadoNuevo(rolAnimador, sueldoPorHora);
                    Nodo aux=cabeza;
                    while(aux!=null){
                        if(rolAnimador.equals(aux.getTipo_empleado())){
                            aux.setCantidadEmpleado(cantidad);
                            if(aux.getCantidadEmpleado()> cantidadPrincipal){
                            return false;
                        }
                        }

                        aux = aux.getSiguiente(); 
                        
                    }
            }else{  
                 Nodo auxi=cabeza;
                while(auxi!=null){
                    if(rolAnimador.equals(auxi.getTipo_empleado())){
                        auxi.setCantidadEmpleado(auxi.getCantidadEmpleado()+cantidad);
                        if(auxi.getCantidadEmpleado()> cantidadPrincipal){
                            return false;
                        }
                    }
                    auxi = auxi.getSiguiente(); 
                }
                
            }
            return true;
            
        }


    /**
    * Indica si la lista es vacia
    * @return true si la lista es vacia, false en otro caso
    */
    public boolean esVacia(){
    //Aqui va tu codigo
    return cabeza == null;
    }
    
 
    //LIMPIA LAS LISTAS
    public void limpia(){        
        cabeza = null;
        }
        
    

}
