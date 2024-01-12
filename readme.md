Proyecto 4 - Animadores Para Eventos - Extension
Profesor:
Pedro Ulises Cervantes González confundeme@ciencias.unam.mx
Ayudantes:
Julio Vázquez Alvarez julio.vazquez@ciencias.unam.mx
Ian Israel García Vázquez iangarcia@ciencias.unam.mx
Erick Bernal Márquez erick07@ciencias.unam.mx
Yessica Janeth Pablo Martínez yessica_j_ pablo@ciencias.unam.mx

Equipo:
-Cano Tenorio Alan Kevin(321259967)
-Escobedo Irineo Malinalli (424121101)


Sobre el proyecto:
Es una extensión del proyecto anterior, en el cual, se hizo un programa que permite modificar un catalogo de empleados y crear una cotizacion para eventos.
Las funciones que realiza dicho programa son las siguientes:
•Agregar un empleado.
•Despedir un empleado.
•Modificar el rol de un empleado.
•Modificar el sueldo de un empleado
•Crear una cotización.
A diferencia del proyecto anterior, este proyecto incluye interfaz grafica y archivos, esto para facilitar la vision y el uso del programa al usuario.

Estructura:
El proyecto esta dividido en tres archivos de la extension .java y dos carpetas. A continuacion, se dara una breve descripcion de cada uno.

-ListaDeEmpleados.java : Este archivo contiene varios metodos principales y algunos auxiliares que se desarrollaron para poder cumplir con las funciones anteriormente descritas, se opto por colocar los metodos en el
orden que aparecen en el menú para mejor intuición al momento de leer el código, y los metodos auxiliares se colocaron hasta el final de la clase. Cada método tiene una breve descripción sobre lo que hace.
-Nodo.java : Este archivo tiene los atributos que se requeria que los empleados tuvieran para el proyecto:
•Sueldo por hora 
•Nombre del tipo de empleado 
•Cantidad de empleados.

ademas de otro atributo de tipo Nodo llamado siguiente, el cual sirve para apuntar la siguiente empleado de la lista. Por otra parte, la clase contiene setters y getters para poder modificar los atributos y obtenerlos

-Main.java: Este archivo es la clase principal del programa.Esta conformado por dos grandes apartados:
El primero es un public static void main(String[] args), osea, el metodo principal, en el cual se crea un objeto de tipo ListaDeEmpleados llamado listaprincipal, la cuál es el catálogo, otro objeto del mismo tipo llamado 
listacotizacion el cual es la cotización, dos String que se agregan a la listaprincipal  cerca del inicio de la clase para no tener un catálogo inicial vacio, y otros dos de tipo Scanner, esto con la finalidad de usar 
con eficacia el menu, estos dos ultimos estan alojados en esta parte y dentro de un do-while para que se ejecute hasta que el usuario desee. Este menu es de gran utilidad porque ayuda al usuario a ejecutar el programa 
de la forma que el guste.
El segundo es la clase Main, en la cual, se incluyen todos los atributos, bibliotecas y metodos para que, a la hora de ejecucion el programa no se muestre en la terminal y se muestre en un panel.

-Carpeta Catalogo: en esta carpeta, se guardan dos archivos, en los cuales, se incluye el catalogo, el cual, se ira modificando dependiendo el usuario, uno de estos es de usl exclusivo para la maquina y el otro puede ser visible para el ojo humano.

-Carpeta cotizaciones: en esta carpeta, se guardan todas las cotizaciones.

Inconvenientes que se presentaron:
El primer inconveniente que se presento fue el como hacer el proyecto, pues teniamos muchas ideas pero ninguna concreta, optamos por usar SWING y desarrollar nuestras ideas conforme la practica.
El segundo inconveniente fue realizar correctamente la opcion de "Agregar empleado" porque no agregaba los empleados de forma correcta, sin embargo, despues de un largo y duro trabajo, se pudo solucionar.
El tercer inconveniente fue hacer que el boton de "Contratar nas" funcionara debido a que ni siquiera mostraba nada, pero vimos que era porque no estaba bien implementado.
El cuarto y ultimo inconveniente fue hacer que el catalogo se mantuviera con los cambios realizados  tras cada ejecucion porque siempre se sobreescribia el archivo.

Ejecucion:
Primero se descarga el archivo. Zip que se subio al classroom y guardalo en la carpeta que desees
Posteriormente se descomprime el .zip (solo tienes que  dar doble clic sobre el archivo)
Abre la terminal y metete a la carpeta en la cual guardaste el archivo, para hacer esto escribe:

computadora:~$ cd + “nombre de la carpeta que descargaste”

Posteriormente escribe el comando ls
Si te aparecen los archivos ListaDeEmpleados.java, Main.java y Nodo.java, y la carpeta archivos, estas en la carpeta correcta

En la terminal escribe javac *.java
Esto compila todos los archivos que tengas en esa carpeta
Finalmente escribe java Main y en en la terminal se mostrara un menu que indica los metodos disponibles

En ese menu presionas cualquiera de las opciones que arroja el programa y sigues las instrucciones que te arrojan.
Pd: Si en algun caso, no se llega a ver bien el panel, solo reajusta un poquito la pantalla y listo.
