package zoo;

import javax.swing.JOptionPane;

public class Zoo {

    public static void main(String[] args) {
        //Se instancian las clases necesarias
        AnimalsComing animalsComing = new AnimalsComing();
        EventsComing eventsComing = new EventsComing();
        HabitatsComing habitatsComing = new HabitatsComing();
        VisitorsComing visitorsComing = new VisitorsComing();
        FoodComing foodComing = new FoodComing();
        Cont cont = new Cont();

        boolean continuar = true; //Flag para seguir dentro del menu
        while (continuar) {
            String[] opciones = {"Registro de Animales", "Registro de Eventos", "Registro de Hábitats", "Registro de Visitantes", "Gestión de Alimentación", "Mapa de Animales", "Salir"};// 
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 :
                    animalsComing.MenuAnimals();
                    break;
                case 1 :
                    eventsComing.MenuEvents();
                    break;
                case 2 :
                    habitatsComing.MenuHabitats();
                    break;
                case 3 :
                    visitorsComing.MenuVisitors();
                    break;
                case 4 :
                    foodComing.MenuFood();
                    break;
                case 5 :
                    cont.eje();
                    break;
                case 6 :
                    continuar = false;
                    break;
            }
        }
    }
}
