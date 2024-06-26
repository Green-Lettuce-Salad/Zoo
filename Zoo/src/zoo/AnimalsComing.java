package zoo;

import javax.swing.*;

public class AnimalsComing { //Antes de usar la clase animales, se debe usar la clase Habitats para que queden habitats registrados
    Animals arrAnimals[] = new Animals[5];
    HabitatsComing habitatcoming = new HabitatsComing();

    Species Felino = Species.Felino;
    Species Mamifero = Species.Mamifero;
    Environment Calido = Environment.Calido;
    
    String List = "";

    public void PrecargarAnimales() { //Precarga dos objetos en el array
        arrAnimals[0] = new Animals("Leo", Felino, 10, "C1");
        arrAnimals[1] = new Animals("Rafa", Mamifero, 30, "A1");
    }

    public void MenuAnimals() {
        if (arrAnimals[0] == null) { //Verifica que no existan datos en el array para hacer el precargado
            PrecargarAnimales();
            if (habitatcoming.arrHabitats[0] == null) {
                habitatcoming.PrecargarHabitats();
            }
        }

        boolean continuar = true;
        while (continuar) { //Menu de opciones
            List = "";
            
            for (int i = 0; i < arrAnimals.length; i++) {
                if (arrAnimals[i] != null){
                    List = List + "Nombre: " + arrAnimals[i].getNombre() + ", Especie: " + arrAnimals[i].getEspecie() + ", Edad: " + arrAnimals[i].getEdad() + ", Habitat: " + arrAnimals[i].getHabitat()+"\n";
                }
            }
            
            List = List + "\n";
            
            String[] opcionAnimales = {"Añadir animal", "Remover animal", "Modificar animal", "Buscar animal", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n\n" + List, "------Registro de animales------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionAnimales, opcionAnimales[0]);

            switch (opcion) {
                case 0 ->
                    AnimalsComing.this.Add();
                case 1 ->
                    AnimalsComing.this.Remove();
                case 2 ->
                    AnimalsComing.this.Modify();
                case 3 ->
                    AnimalsComing.this.Search();
                case 4 ->
                    continuar = false;
            }
        }
    }

    public void Add() {
        Species species = null; //Instancia la clase Species
        
        JOptionPane.showMessageDialog(null, habitatcoming.arrHabitats[3].getNombre());
        
        String nombre = JOptionPane.showInputDialog("Digite el nombre del animal que desea añadir");
        for (int i = 0; i < arrAnimals.length; i++) {
            if (arrAnimals[i]!=null) {
                int result = arrAnimals[i].getNombre().compareTo(nombre);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "El animal ya existe");
                    return;
                }
            }
        }

        String[] opciones = {"Felino", "Ave", "Reptil", "Pez", "Primate", "Mamífero"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        int opcion = JOptionPane.showOptionDialog(null, comboBox, "Seleccione la especie del animal que desea añadir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

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
        
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del animal que desea añadir"));
        
        
        String habitat = "";

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] == null) { //Verifica si el objeto es nulo para no sobreescribir
                arrAnimals[x] = new Animals(nombre, species, edad, habitat); //Si es nulo añade el valor ahi
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "El animal fue añadido correctamente");
    }

    public void Remove() {
        String data = JOptionPane.showInputDialog("Digite el nombre del animal que desea remover");
        int result = 9;

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) { //Verifica si el objeto no es nulo
                result = data.compareTo(arrAnimals[x].getNombre());
                if (result == 0) { //Verifica coincidencia entre el nombre indicado con la base de datos
                    arrAnimals[x] = null;
                    JOptionPane.showMessageDialog(null, "El animal fue removido correctamente");
                    break;
                }
            }
        }
        
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El animal no fue encontrado");
        }
    }

    public void Modify() {
        String nombreAnimal = JOptionPane.showInputDialog("Digite el nombre del animal que desea modificar");
        Species species = null;
        Environment environment = null;
        int result = 9;

        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) {
                result = nombreAnimal.compareTo(arrAnimals[x].getNombre());
                if (result == 0) {
                    String nombre = JOptionPane.showInputDialog("Digite el nombre nuevo (Nombre viejo: " + arrAnimals[x].getNombre() + ")");
                    String[] opciones = {"Felino", "Ave", "Reptil", "Pez", "Primate", "Mamífero"};                    JComboBox<String> comboBox = new JComboBox<>(opciones);
                    int opcion = JOptionPane.showOptionDialog(null, comboBox, "Digite la especie nueva (Especie vieja: " + arrAnimals[x].getEspecie() + ")", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

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
                    
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad nueva (Edad vieja: " + arrAnimals[x].getEdad() + ")"));
                    
                    //habitat
                    String habitat = "";

                    arrAnimals[x] = new Animals(nombre, species, edad, habitat);
                    JOptionPane.showMessageDialog(null, "El animal fue modificado correctamente");
                }
            }
        }
        if (result != 0) {
            JOptionPane.showMessageDialog(null, "El animal no fue encontrado");
        }
    }

    public void Search() {
        String data = JOptionPane.showInputDialog("Digite el nombre del animal que desea buscar");
        int flag = 0;

        //Toma el nombre solicitado y lo compara con los valores llenos del arreglo
        for (int x = 0; x < arrAnimals.length; x++) {
            if (arrAnimals[x] != null) { //Verifica si el objeto no es nulo
                int result = data.compareTo(arrAnimals[x].getNombre());
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "Nombre: " + arrAnimals[x].getNombre() + "\nEspecie: " + arrAnimals[x].getEspecie() + "\nEdad: " + arrAnimals[x].getEdad() + "\nHabitat: " + arrAnimals[x].getHabitat());
                    flag = 1; //Marca la variable flag como 1 si encuentra una coincidencia
                    break; //Rompe el ciclo si se encuentra una coincidencia
                }
            }
        }

        if (flag == 0) { //Si no se encontraron coincidencias el valor es 0 y se muestra el mensaje
            JOptionPane.showMessageDialog(null, "El animal no fue encontrado");
        }
    }
}
