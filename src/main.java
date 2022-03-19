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

        Ingredientes tortilla= new Ingredientes("tortillas",false,300);
        Ingredientes sal = new Ingredientes("sal",true,400);
        Ingredientes pollo =new Ingredientes("pollo",true,90);
        Ingredientes queso =new Ingredientes("queso",true,15);
        Ingredientes crema =new Ingredientes("crema",false ,330);


        ArrayList<Ingredientes> ingredientesDisponibles= new ArrayList<>();
        ingredientesDisponibles.add(tortilla);
        ingredientesDisponibles.add(queso);
        ingredientesDisponibles.add(sal);
        ingredientesDisponibles.add(pollo);
        ingredientesDisponibles.add(crema);

        Receta flan=new Receta(
                "Tacos dorados",
                40,
                new ArrayList<>(Arrays.asList(tortilla,sal,pollo,queso,crema)),
                new ArrayList<>(Arrays.asList("Preparar los ingrrdientes",
                        "Pon a cpcer el pollo con sal y cilantro",
                        "Una vez cpcido, procede a desebrarlo",
                        "Calienta las tortilas que sean necesarias",
                        "Coloca el pollo en la orilla de una tortilla y enrollalo",
                        "pon los tacos en una sarten con aceite breviamente calentado",
                        "Espera a que la tortilla se dore por completo",
                        "Pon los tacos a escurris de preferencia en un papel absorbente",
                        "Prepara los tacos con un poc ode crema y queso y salsa de tu preferencia ")));

        //crerar un recetario
        Recetario miRecetario =new Recetario(
                "DavidH",
                "Recetas Caseras",
                new ArrayList<>(Arrays.asList(flan)));

        System.out.println("Bienvenido, elige una opcion: ");
        System.out.println("1º Agregar un ingrediente nuevo");
        System.out.println("2º Agregar una receta nueva");
        System.out.println("3º Ver mi recetario");
        System.out.println("4° Eliminar ingrediente");
        System.out.println("5° Eliminar receta");
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

