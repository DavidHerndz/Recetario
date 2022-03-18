import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//crear algunos ingredientes
//guardar esos ingredientes en un ArrayList
// crear algunas recetas
//crear un recetario
//y guardar las recetas en el recetario
//los traigo con un get
//indice (-1)
//uso un do while con una bandera que es 0
//mostrar las opciones que el usuario tiene

public class main {

    public static void main(String[] args) {

        Ingredientes lechera= new Ingredientes("lechera",false,300);
        Ingredientes quesoCrema = new Ingredientes("queso crema",false,400);
        Ingredientes huevo =new Ingredientes("huevo",true,90);
        Ingredientes vainilla =new Ingredientes("vainilla",false,15);


        ArrayList<Ingredientes> ingredientesDisponibles= new ArrayList<>();
        ingredientesDisponibles.add(lechera);
        ingredientesDisponibles.add(quesoCrema);
        ingredientesDisponibles.add(huevo);
        ingredientesDisponibles.add(vainilla);

        Receta flan=new Receta(
                "Flan",
                20,
                new ArrayList<>(Arrays.asList(lechera,huevo,quesoCrema,vainilla)),
                new ArrayList<>(Arrays.asList("Preparar los ingrrdientes",
                        "Mezcla la lechera con los huevos",
                        "Mezcla lo anterior con el queso crema",
                        "En una licuadora mezcla todo con la vainilla",
                        "En un recipiente, coloca la mezcla",
                        "En una olla coloca agua simple a un nivel dos dedos mas abajo del recipiente",
                        "Prende la estufa, coloca la olla y encima el recipiente",
                        "Espera 30 min a que la mezcla ya este lista",
                        "Disfruta :)")));

        //crerar un recetario
        Recetario miRecetario =new Recetario(
                "DavidH",
                "Recetas Caseras",
                new ArrayList<>(Arrays.asList(flan)));

        System.out.println("Bienvenido, elige una opcion: ");
        System.out.println("1º Agregar un ingrediente nuevo");
        System.out.println("2º Agregar una receta nueva");
        System.out.println("3º Ver mi recetario");
        System.out.println();
        System.out.println("4º Salir");
        //pendiente opcion para salir

        int respuesta;
        do {
            Scanner scanner = new Scanner(System.in);
            ;


            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    Ingredientes nuevo = new Ingredientes();
                    System.out.println("ingrese el nombre del ingrediente");
                    nuevo.setNombre(scanner.next());
                    System.out.println("Ingrese la cantidad");
                    nuevo.setPeso(scanner.nextDouble());
                    System.out.println("¿Tu ingrediente es salado?1. Si \t2. No");
                    if (scanner.nextInt() == 1) {
                        nuevo.setEsSalado(true);
                    } else {
                        nuevo.setEsSalado(false);
                    }
                    System.out.println("Ingrediente creado");
                    ingredientesDisponibles.add(nuevo);
                    break;
                case 2:
                    Receta nueva = new Receta();
                    System.out.println("Ingrese el nombre de la receta");
                    nueva.setNombre(scanner.next());
                    System.out.println("Ingrese el tiempo de preparacion");
                    nueva.setTiempoPreparacion(scanner.nextDouble());
                    System.out.println("Los ingredientes disponibles son: ");
                    for (int i = 0; i < ingredientesDisponibles.size(); i++) {
                        System.out.println(i + 1 + ". " + ingredientesDisponibles.get(i).getNombre());

                    }
                    ArrayList<Ingredientes> ingredientesReceta = new ArrayList<>();
                    System.out.println("Ingrese el numero del ingrediente correspondiente y de enter," +
                            "si ya no quiere agregar mas escriba 0");
                    do {
                        respuesta = scanner.nextInt();
                        if (respuesta != 0) {
                            ingredientesReceta.add(ingredientesDisponibles.get(respuesta - 1));
                        }
                    } while (respuesta != 0);
                    respuesta = 9;
                    nueva.setIngredientes(ingredientesReceta);
                    ArrayList<String> pasosReceta = new ArrayList<>();
                    System.out.println("ingrede los pasos de uno en uno y de enter" +
                            "Si ya no quiere agregar mas ingrese 0");
                    String res = "";
                    do {
                        res = scanner.next();
                        if (!res.equals("0")) {
                            pasosReceta.add(res);
                        }
                    } while (!res.equals("0"));

                    nueva.setPasos(pasosReceta);
                    miRecetario.getRecetas().add(nueva);

                    break;

                case 3:
                    miRecetario.mostrarRecetario();

                    break;

            }

        }while (respuesta !=0);

    }


    }

