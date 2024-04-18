package zoo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FoodComing {
    Food arrFood[] = new Food[10];
    
    Species Felino = Species.Felino;
    Species Mamifero = Species.Mamifero;
    
    String List = "";
    
    public void PrecargarComida() {
        arrFood[0] = new Food("001", Felino, "7am - 12pm - 5pm", 10, "15 Kg en la tarde para Leo");
        arrFood[1] = new Food("002", Mamifero, "8am - 1pm - 5pm", 5, "Si el animal pesa menos de 100 Kg, dar 3 Kg");
    }
    
    public void MenuFood() {
        if (arrFood[0] == null) {
            PrecargarComida();
        }
        
        boolean continuar = true;
        while (continuar) {
            List = "";
            
            for (int i = 0; i < arrFood.length; i++) {
                if (arrFood[i] != null){
                    List = List + "Codigo: " + arrFood[i].getCodHorario() + ", Especie: " + arrFood[i].getSpecie()+ ", Horario: " + arrFood[i].getHorario()+ ", Cantidad: " + arrFood[i].getCantidad()+ ", Notas: " + arrFood[i].getNotas()+"\n";
                }
            }
            
            List = List + "\n";
            String[] opcionComida = {"Añadir horario de alimento", "Remover horario de alimento", "Modificar horario de alimento", "Buscar horario de alimento", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n\n"+List, "------Registro de animales------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionComida, opcionComida[0]);

            switch (opcion) {
                case 0 -> FoodComing.this.Add();
                case 1 -> FoodComing.this.Remove();
                case 2 -> FoodComing.this.Modify();
                case 3 -> FoodComing.this.Search();
                case 4 -> continuar = false;
            }
        }
    }
        
    public void Add() {
        Species species = null; //Instancia la clase Species
        
        String codHorario = JOptionPane.showInputDialog("Digite el codigo del horario que desea añadir");
        for (int i = 0; i < arrFood.length; i++) {
            if (arrFood[i]!=null) {
                int result = arrFood[i].getCodHorario().compareTo(codHorario);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "El codigo ya existe");
                    return;
                }
            }
        }
        
        String[] opciones = {"Felino", "Ave", "Reptil", "Pez", "Primate", "Mamífero"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        int opcion = JOptionPane.showOptionDialog(null, comboBox, "Seleccione la especie del horario que desea añadir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        //Asigna el valor de Species necesario según la elección del usuario
        if (opcion != JOptionPane.CLOSED_OPTION) {
            String selectedOption = (String) comboBox.getSelectedItem(); 
            switch (selectedOption) {
                case "Felino" ->
                    species = Species.Felino;
                case "Ave" ->
                    species = Species.Ave;
                case "Reptil" ->
                    species = Species.Reptil;
                case "Pez" ->
                    species = Species.Pez;
                case "Primate" ->
                    species = Species.Primate;
                case "Mamífero" ->
                    species = Species.Mamifero;
            }
        }

        // Si la opción no es válida, se mostrará un mensaje y no se procederá con la adición del animal.
        if (species == null) {
            return;
        }
        
        int data = Integer.parseInt(JOptionPane.showInputDialog("Digite cuantas veces al dia va a comer la espcie"));
        String[] horas = new String[data];
        String horario = "";
        
        for (int x = 0; x < data; x++) {
            String data2 = JOptionPane.showInputDialog("Digite la hora de comida "+(x+1)+" (Ejemplo: 7am)");
            horario = horario + data2 + " - ";
        }
        
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de alimento del horario que desea añadir"));
        String notas = JOptionPane.showInputDialog("Digite cualquier nota del horario que desea añadir");

        for (int x = 0; x < arrFood.length; x++) {
            if (arrFood[x] == null) { //Verifica si el objeto es nulo para no sobrescribir
                arrFood[x] = new Food(codHorario, species, horario, cantidad, notas); //Si es nulo añade el valor ahi
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "El horario fue añadido correctamente");
    }
    
    public void Remove() {
        String codHorario = JOptionPane.showInputDialog("Digite el codiogo del horario que desea remover");
        int result = 9;
        
        for (int x = 0; x < arrFood.length; x++) {
            if (arrFood[x] != null) { //Verifica si el objeto no es nulo
                result = codHorario.compareTo(arrFood[x].getCodHorario());
                if (result == 0) {
                    arrFood[x] = null;
                    JOptionPane.showMessageDialog(null, "El horario fue removido correctamente");
                    break;
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El horario no fue encontrado");
        }
    }
    
    public void Modify() {
        String codigo = JOptionPane.showInputDialog("Digite el codigo del horario que desea modificar");
        Species species = null;
        int result = 9;

        for (int x = 0; x < arrFood.length; x++) {
            if (arrFood[x] != null) {
                result = codigo.compareTo(arrFood[x].getCodHorario());
                if (result == 0) {
                    String codHorario = JOptionPane.showInputDialog("Digite el codigo nuevo (Codigo viejo: " + arrFood[x].getCodHorario()+ ")");
                    String[] opciones = {"Felino", "Ave", "Reptil", "Pez", "Primate", "Mamífero"};
                    JComboBox<String> comboBox = new JComboBox<>(opciones);
                    int opcion = JOptionPane.showOptionDialog(null, comboBox, "Digite la especie nueva (Especie vieja: " + arrFood[x].getSpecie()+ ")", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    //Asigna el valor de Species necesario según la elección del usuario
                    if (opcion != JOptionPane.CLOSED_OPTION) {
                        String selectedOption = (String) comboBox.getSelectedItem(); 
                        switch (selectedOption) {
                            case "Felino" ->
                                species = Species.Felino;
                            case "Ave" ->
                                species = Species.Ave;
                            case "Reptil" ->
                                species = Species.Reptil;
                            case "Pez" ->
                                species = Species.Pez;
                            case "Primate" ->
                                species = Species.Primate;
                            case "Mamífero" ->
                                species = Species.Mamifero;
                        }
                    }

                    int data = Integer.parseInt(JOptionPane.showInputDialog("Digite cuantas veces al dia va a comer la espcie"));
                    String[] horas = new String[data];
                    String horario = "";

                    for (int i = 0; i < data; i++) {
                        String data2 = JOptionPane.showInputDialog("Digite la hora de comida "+(i+1)+" (Ejemplo: 7am)");
                        horario = horario + data2 + " - ";
                    }
                    
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de alimento nueva (Cantidad vieja: " + arrFood[x].getCantidad()+ ")"));
                    String notas = JOptionPane.showInputDialog("Ingrese las notas nuevas (Notas viejas: " + arrFood[x].getNotas()+ ")");
                    
                    arrFood[x] = new Food(codigo, species, horario, cantidad, notas);
                    JOptionPane.showMessageDialog(null, "El horario fue modificado correctamente");
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El horario no fue encontrado");
        }
    }
    
    public void Search() {
        String data = JOptionPane.showInputDialog("Digite el codigo del horario que desea buscar");
        int flag = 0;

        //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
        for (int x = 0; x < arrFood.length; x++) {
            if (arrFood[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrFood[x].getCodHorario());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Codigo: " + arrFood[x].getCodHorario() + "\nEspecie: " + arrFood[x].getSpecie()+ "\nHorario: " + arrFood[x].getHorario()+ "\nCantidad: " + arrFood[x].getCantidad()+ "\nNotas: " + arrFood[x].getNotas());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break; //Rompe el ciclo si se encuentra una coincidencia
                }
            }
        }

        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "El horario no fue encontrado");
        }
    }
}
