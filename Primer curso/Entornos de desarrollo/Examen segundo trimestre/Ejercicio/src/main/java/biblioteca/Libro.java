/**
 * Clase Libro.
 * @author Juan Montiel
 * @version 1.0
 * @see Biblioteca
 */

package biblioteca;

public class Libro {

    /**
     * Estas varibles contienen el titulo, autor y anio de publicacion
     * @param titulo
     * @param autor
     * @param anioPublicacion
     */
    private String titulo;
    private String autor;
    private int anioPublicacion;

    /**
     *  Constructor con titulo, autor y anio de publicacion de Libro
     * @param titulo
     * @param autor
     * @param anioPublicacion
     */
    // TODO: Testear este método
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *  Busca el autor de un libro
     */
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *  Busca anio de publicacion de un libro
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
}
