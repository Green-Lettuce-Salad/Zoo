package zoo;

import javax.swing.JOptionPane;

public class VisitorsComing {

    //Arreglos y variables
    Visitors arrVisitors[] = new Visitors[5];
    VisitorsTemp arrVisitorsTemp[] = new VisitorsTemp[5];
    String List = "";

    public void PrecargarVisitantes() { //Precarga data al ingresar a la clase
        arrVisitors[0] = new Visitors("1", 119160633, 15, "2024-06-04");
        arrVisitors[1] = new Visitors("2", 401680172, 30, "2024-06-05");
    }

    public void MenuVisitors() {
        if (arrVisitors[0] == null) {
            PrecargarVisitantes();
        }

        boolean continuar = true;
        while (continuar) {
            List = "";

            for (int i = 0; i < arrVisitors.length; i++) { //Muestra lista de visitantes en pantalla
                if (arrVisitors[i] != null) {
                    List = List + "Nombre: " + arrVisitors[i].getNombre() + ", Cedula: " + arrVisitors[i].getCedula() + ", Edad: " + arrVisitors[i].getEdad() + ", Fecha: " + arrVisitors[i].getFecha() + "\n";
                }
            }

            List = List + "\n";

            String[] opcionVisitantes = {"Añadir visitante", "Remover visitante", "Modificar visitante", "Buscar visitante", "Consultar visitas", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n\n" + List, "------Registro de visitantes------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionVisitantes, opcionVisitantes[0]);

            switch (opcion) { //Dirige a los metodos de la clase segun la eleccion
                case 0 ->
                    VisitorsComing.this.Add();
                case 1 ->
                    VisitorsComing.this.Remove();
                case 2 ->
                    VisitorsComing.this.Modify();
                case 3 ->
                    VisitorsComing.this.Search();
                case 4 ->
                    VisitorsComing.this.Query();
                case 5 ->
                    continuar = false;
            }
        }
    }

    public void Add() { //Ingresa un visitante
        String nombre = JOptionPane.showInputDialog("Digite el nombre del visitante que desea añadir");

        for (int i = 0; i < arrVisitors.length; i++) { //Identifica si el visitante ya existe
            if (arrVisitors[i] != null) { //Verifica si el objeto no es nulo para que no genere error
                int result = arrVisitors[i].getNombre().compareTo(nombre); //Compara el visitante ingresado con los visitantes almacenados
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "El visitante ya existe");
                    return;
                }
            }
        }
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la cedula del visitante que desea añadir"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del visitante que desea añadir"));
        String fecha = JOptionPane.showInputDialog("Digite la fecha de visita que desea añadir (YYYY-MM-DD)");

        for (int x = 0; x < arrVisitors.length; x++) {
            if (arrVisitors[x] == null) { //Verifica si el objeto es nulo para no sobrescribir
                arrVisitors[x] = new Visitors(nombre, cedula, edad, fecha); //Si es nulo añade el valor ahi
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "El visitante fue añadido correctamente");
    }

    public void Remove() { //Remueve un visitante
        String data = JOptionPane.showInputDialog("Digite el nombre del visitante que desea remover");
        int result = 9;

        for (int x = 0; x < arrVisitors.length; x++) {
            if (arrVisitors[x] != null) { //Verifica si el objeto no es nulo para que no genere error
                result = data.compareTo(arrVisitors[x].getNombre()); //Compara el visitante ingresado con los visitantes almacenados
                if (result == 0) {
                    arrVisitors[x] = null;
                    JOptionPane.showMessageDialog(null, "El visitante fue removido correctamente");
                    break;
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El visitante no fue encontrado");
        }
    }

    public void Modify() { //Modifica un visitante
        String nombreVisita = JOptionPane.showInputDialog("Digite el nombre del visitante que desea modificar");
        int result = 9;

        for (int x = 0; x < arrVisitors.length; x++) {
            if (arrVisitors[x] != null) { //Verifica si el objeto no es nulo para que no genere error
                result = nombreVisita.compareTo(arrVisitors[x].getNombre()); //Compara el visitante ingresado con los visitantes almacenados
                if (result == 0) {
                    String nombre = JOptionPane.showInputDialog("Digite el nombre nuevo (Nombre viejo: " + arrVisitors[x].getNombre() + ")");
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la cedula nueva (Cedula vieja: " + arrVisitors[x].getCedula() + ")"));
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad nueva (Edad vieja: " + arrVisitors[x].getEdad() + ")"));
                    String fecha = JOptionPane.showInputDialog("Digite la fecha nueva (YYYY-MM-DD) (Fecha vieja: " + arrVisitors[x].getFecha() + ")");

                    arrVisitors[x] = new Visitors(nombre, cedula, edad, fecha);
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El visitante no fue encontrado");
        }
    }

    public void Search() { //Busca un visitante
        String data = JOptionPane.showInputDialog("Digite el nombre del animal que desea buscar");
        int flag = 0;

        for (int x = 0; x < arrVisitors.length; x++) { //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
            if (arrVisitors[x] != null) { //Verifica si el objeto no es nulo para que no genere error
                int result = data.compareTo(arrVisitors[x].getNombre());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Nombre: " + arrVisitors[x].getNombre() + "\nCedula: " + arrVisitors[x].getCedula() + "\nEdad: " + arrVisitors[x].getEdad() + "\nFecha: " + arrVisitors[x].getFecha());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break;
                }
            }
        }
        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "El visitante no fue encontrado");
        }
    }

    public void Query() { //Consulta visitas
        int contador = 0;

        String[] resultado = new String[arrVisitors.length]; //Crea una lista temporal

        for (int i = 0; i < arrVisitors.length; i++) {
            if (arrVisitors[i] != null) {
                boolean repetida = false; //Crea variable para encontrar coincidencias en las fechas
                for (int j = 0; j < i; j++) {
                    if (arrVisitors[i].getFecha().equals(arrVisitors[j].getFecha())) {
                        repetida = true; //Si encuentra coincidencias cambia la variable a real
                        break;
                    }
                }

                if (!repetida) { //Si el contrario de la variable el verdad se ingresa el valor de esa fecha a una lista temporal
                    resultado[contador++] = arrVisitors[i].getFecha();
                }
            }
        }

        for (int i = 0; i < resultado.length; i++) { //Calcula edades en el arreglo temporal
            if (resultado[i] != null) {
                int cantidad = 0; //Crea contadores para edades mayores, menores y cantidad de personas
                int cantMayores = 0;
                int cantMenores = 0;

                for (int j = 0; j < arrVisitors.length; j++) {
                    if (arrVisitors[j] != null) {
                        int result = resultado[i].compareTo(arrVisitors[j].getFecha());
                        if (result == 0) {
                            cantidad++;
                            if (arrVisitors[j].getEdad() > 18) {
                                cantMayores++;
                            } else {
                                cantMenores++;
                            }
                        }
                    }
                    arrVisitorsTemp[i] = new VisitorsTemp(arrVisitors[i].getFecha(), cantidad, cantMayores, cantMenores); //Ingresa valores a arreglo temporal
                }
            }
        }

        for (int i = 0; i < arrVisitorsTemp.length; i++) { //Muestra resultados en pantalla
            if (arrVisitorsTemp[i] != null) {
                JOptionPane.showMessageDialog(null, "Dia: " + resultado[i] + "\n"
                        + "Cantidad de personas que asistieron: " + arrVisitorsTemp[i].getCantidad() + "\n"
                        + "Cantidad de personas mayores que asistieron: " + arrVisitorsTemp[i].getCantMayores() + "\n"
                        + "Cantidad de personas menores que asistieron: " + arrVisitorsTemp[i].getCantMenores() + "\n");
            }
        }
    }
}
