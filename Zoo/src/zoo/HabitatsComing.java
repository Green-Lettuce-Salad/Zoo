package zoo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static zoo.Environment.Acuatico;
import static zoo.Environment.Calido;
import static zoo.Environment.Pantanoso;
import static zoo.Environment.Selvatico;

public class HabitatsComing {

    Habitats arrHabitats[] = new Habitats[16];
    Environment Calido = Environment.Calido;
    Environment Frio = Environment.Frio;
    Environment Selvatico = Environment.Selvatico;
    Environment Acuatico = Environment.Acuatico;
    Environment Pantanoso = Environment.Pantanoso;
    String List = "";

    public void PrecargarHabitats() { //Precarga objetos
        arrHabitats[0] = new Habitats("C1", 8, Calido);
        arrHabitats[1] = new Habitats("A1", 4, Acuatico);
        arrHabitats[2] = new Habitats("A2", 4, Acuatico);
    }

    public void MenuHabitats() {
        if (arrHabitats[0] == null) {
            PrecargarHabitats();
        }

        boolean continuar = true;
        while (continuar) {

            List = "";
            for (int i = 0; i < arrHabitats.length; i++) { //Muestra lista de habitats en pantalla
                if (arrHabitats[i] != null) {
                    List = List + "Nombre: " + arrHabitats[i].getNombre() + ", Capacidad: " + arrHabitats[i].getCapacidad() + ", Ambiente: " + arrHabitats[i].getEnvironment() + "\n";
                }
            }
            List = List + "\n";

            String[] opcionHabitats = {"Añadir habitat", "Remover habitat", "Modificar habitat", "Buscar habitat", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n\n" + List, "Registro de Habitats", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionHabitats, opcionHabitats[0]);

            switch (opcion) { //Dirige que metodo usar segun la opcion elegida
                case 0 ->
                    HabitatsComing.this.Add();
                case 1 ->
                    HabitatsComing.this.Remove();
                case 2 ->
                    HabitatsComing.this.Modify();
                case 3 ->
                    HabitatsComing.this.Search();
                case 4 ->
                    continuar = false;
            }
        }
    }

    public void Add() {
        Environment environment = null; //Instancia el enum Environment
        
        String nombre = JOptionPane.showInputDialog("Digite el nombre del habitat que desea añadir");
        for (int i = 0; i < arrHabitats.length; i++) {
            if (arrHabitats[i] != null) {
                int result = arrHabitats[i].getNombre().compareTo(nombre);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "El habitat ya existe");
                    return;
                }
            }
        }

        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la capacidad del habitat que desea añadir"));
        String[] opciones2 = {"Calido", "Frio", "Selvatico", "Acuatico", "Pantanoso"};
        JComboBox<String> comboBox2 = new JComboBox<>(opciones2);
        int opcion2 = JOptionPane.showOptionDialog(null, comboBox2, "Digite el ambiente del habitat que desea añadir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        //Asigna el valor de Species necesario según la elección del usuario
        if (opcion2 != JOptionPane.CLOSED_OPTION) {
            String selectedOption = (String) comboBox2.getSelectedItem(); 
            switch (selectedOption) {
                case "Calido" ->
                    environment = Environment.Calido;
                case "Frio" ->
                    environment = Environment.Frio;
                case "Selvatico" ->
                    environment = Environment.Selvatico;
                case "Acuatico" ->
                    environment = Environment.Acuatico;
                case "Pantanoso" ->
                    environment = Environment.Pantanoso;
            }
        }
        
        if (Confirm(environment) == true) {
            JOptionPane.showMessageDialog(null, "Todos los espacios están llenos para este ambiente");
            return;
        }

        for (int x = 0; x < arrHabitats.length; x++) {
            if (arrHabitats[x] == null) { //Verifica si el objeto es nulo para no sobrescribir
                arrHabitats[x] = new Habitats(nombre, capacidad, environment); //Si es nulo añade el valor ahi
                JOptionPane.showMessageDialog(null, "El habitat fue añadido correctamente");
                break;
            }
        }
    }

    public void Remove() {
        String data = JOptionPane.showInputDialog("Digite el nombre del habitat que desea remover");
        int result = 9;

        for (int x = 0; x < arrHabitats.length; x++) {
            if (arrHabitats[x] != null) { //Verifica si el objeto no es nulo
                result = data.compareTo(arrHabitats[x].getNombre());
                if (result == 0) {
                    arrHabitats[x] = null;
                    JOptionPane.showMessageDialog(null, "El habitat fue removido correctamente");
                    break;
                }
            }
        }

        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El habitat no fue encontrado");
        }
    }

    public void Modify() {
        String nombreHabitat = JOptionPane.showInputDialog("Digite el nombre del habitat que desea modificar");
        Environment environment = null;
        int result = 9;

        for (int x = 0; x < arrHabitats.length; x++) {
            if (arrHabitats[x] != null) {
                result = nombreHabitat.compareTo(arrHabitats[x].getNombre());
                if (result == 0) {
                    String nombre = JOptionPane.showInputDialog("Digite el nombre nuevo (Nombre viejo: " + arrHabitats[x].getNombre() + ")");
                    int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la capacidad nueva (Capacidad vieja: " + arrHabitats[x].getCapacidad() + ")"));

                    String[] opciones2 = {"Calido", "Frio", "Selvatico", "Acuatico", "Pantanoso"};
                    JComboBox<String> comboBox2 = new JComboBox<>(opciones2);
                    int opcion2 = JOptionPane.showOptionDialog(null, comboBox2, "Digite el ambiente nuevo (Ambiente viejo: " + arrHabitats[x].getEnvironment()+ ")", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    //Asigna el valor de Species necesario según la elección del usuario
                    if (opcion2 != JOptionPane.CLOSED_OPTION) {
                        String selectedOption = (String) comboBox2.getSelectedItem(); 
                        switch (selectedOption) {
                            case "Calido" ->
                                environment = Environment.Calido;
                            case "Frio" ->
                                environment = Environment.Frio;
                            case "Selvatico" ->
                                environment = Environment.Selvatico;
                            case "Acuatico" ->
                                environment = Environment.Acuatico;
                            case "Pantanoso" ->
                                environment = Environment.Pantanoso;
                        }
                    }

                    arrHabitats[x] = new Habitats(nombre, capacidad, environment);
                    JOptionPane.showMessageDialog(null, "El habitat fue modificado correctamente");
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El habitat no fue encontrado");
        }
    }

    public void Search() {
        String data = JOptionPane.showInputDialog("Digite el nombre del habitat que desea buscar");
        int flag = 0;

        //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
        for (int x = 0; x < arrHabitats.length; x++) {
            if (arrHabitats[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrHabitats[x].getNombre());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Nombre: " + arrHabitats[x].getNombre() + "\nCapacidad: " + arrHabitats[x].getCapacidad() + "\nAmbiente: " + arrHabitats[x].getEnvironment());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break; //Rompe el ciclo si se encuentra una coincidencia
                }
            }
        }

        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "El habitat no fue encontrado");
        }
    }
    
    public boolean Confirm(Environment environment){
        int cal = 0;
        int fri = 0;
        int sel = 0;
        int acu = 0;
        int pan = 0;
        
        for (int i = 0; i < arrHabitats.length; i++) {
            if (arrHabitats[i] != null) {
                switch (environment) {
                    case Calido -> {
                        if (arrHabitats[i].getEnvironment() == Calido) {
                            cal++;
                        }
                    }
                    case Frio -> {
                        if (arrHabitats[i].getEnvironment() == Frio) {
                            fri++;
                        }
                    }
                    case Selvatico -> {
                        if (arrHabitats[i].getEnvironment() == Selvatico) {
                            sel++;
                        }
                    }
                    case Acuatico -> {
                        if (arrHabitats[i].getEnvironment() == Acuatico) {
                            acu++;
                        }
                    }
                    case Pantanoso -> {
                        if (arrHabitats[i].getEnvironment() == Pantanoso) {
                            pan++;
                        }
                    }
                }
            }
        }
        
        if (cal == 4 || fri == 4 || sel == 4 || acu == 2 || pan == 2) {
            return true;
        } else {
            return false;
        }
    }
}
