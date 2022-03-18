import java.util.ArrayList;
public class Recetario {
    private String autor;
    private String titulo;
    private ArrayList<Receta> recetas;

    public Recetario( String autor, String titulo, ArrayList<Receta> recetas) {

        this.autor = autor;
        this.titulo = titulo;
        this.recetas = recetas;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }

    public void mostrarRecetario(){
        System.out.println(titulo);
        System.out.println(autor);
        for (Receta receta:recetas
        ) {
            receta.mostrarReceta();

        }
    }

}
