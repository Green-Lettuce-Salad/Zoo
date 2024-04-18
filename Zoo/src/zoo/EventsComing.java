package zoo;

import javax.swing.JOptionPane;

public class EventsComing {
    Events arrEvents[] = new Events[5];
    String List = "";

    public void PrecargarEventos() {
        arrEvents[0] = new Events("Evento 1", "2024-04-05", "Descripcion del evento 1", "001");
        arrEvents[1] = new Events("Evento 2", "2024-04-06", "Descripcion del evento 2", "002");
    }

    public void MenuEvents() {
        if (arrEvents[0] == null) {
            PrecargarEventos();
        }
                    
        boolean continuar = true;
        while (continuar) {
            List = "";
            
            for (int i = 0; i < arrEvents.length; i++) {
                if (arrEvents[i] != null){
                    List = List + "Nombre: " + arrEvents[i].getNombre() + ", Fecha: " + arrEvents[i].getFecha()+ ", Descripcion: " + arrEvents[i].getDescripcion()+ ", Codigo: " + arrEvents[i].getCodigo()+"\n";
                }
            }
            
            List = List + "\n";
            String[] opcionEventos = {"Añadir evento", "Buscar evento", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n\n" + List, "Registro de eventos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionEventos, opcionEventos[0]);

            switch (opcion) {
                case 0 -> EventsComing.this.Add();
                case 1 -> EventsComing.this.Search();
                case 2 -> continuar = false;
            }
        }
    }
    
    public void Add() {
        String nombreEvento = JOptionPane.showInputDialog("Digite el nombre del evento que desea añadir");
        
        for (int i = 0; i < arrEvents.length; i++) {
            if (arrEvents[i]!=null) {
                int result = arrEvents[i].getNombre().compareTo(nombreEvento);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "El evento ya existe");
                    return;
                }
            }
        }
        
        String fechaEvento = JOptionPane.showInputDialog("Digite la fecha del evento que desea añadir");
        String descripcionEvento = JOptionPane.showInputDialog("Digite la descipcion del evento que desea añadir");
        String codigoEvento = JOptionPane.showInputDialog("Digite el codigo del evento que desea añadir");

        for (int x = 0; x < arrEvents.length; x++) {
            if (arrEvents[x] == null) { //Verifica si el objeto es nulo para no sobrescribir
                arrEvents[x] = new Events(nombreEvento, fechaEvento, descripcionEvento, codigoEvento); //Si es nulo añade el valor ahi
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "El evento fue añadido correctamente");
    }
    
    public void Search() {
        String data = JOptionPane.showInputDialog("Digite el codigo del evento que desea buscar");
        int flag = 0;

        //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
        for (int x = 0; x < arrEvents.length; x++) {
            if (arrEvents[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrEvents[x].getCodigo());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Nombre: " + arrEvents[x].getNombre() + "\nFecha: " + arrEvents[x].getFecha()+ "\nDescripcion: " + arrEvents[x].getDescripcion()+ "\nCodigo: " + arrEvents[x].getCodigo());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break; //Rompe el ciclo si se encuentra una coincidencia
                }
            }
        }

        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "El evento no fue encontrado");
        }
    }
}