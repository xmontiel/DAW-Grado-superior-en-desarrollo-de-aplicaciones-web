/**
 * Clase Biblioteca.
 * @author Juan Montiel
 * @version 2.0
 * @see Libro
 */

package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    /**
     * Lista de libros
     */
    private final List<Libro> libros;

    /**
     * Constructor vacio de Biblioteca
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Constructor con libros de Biblioteca
     * @param libros
     */
    //  Test: NO HAY QUE TESTEAR ESTE METODO
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Agrega un libro a la biblioteca
     * @param libro
     */
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    /**
     * Elimina un libro de la biblioteca
     * @param libro
     */
    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    /**
     * Lista de libros de la biblioteca
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Busca un libro por su titulo
     * @param titulo
     */
    //  Test 01: buscar libro existente y comprobar que lo localiza.
    //  Test 02: buscar libro NO existente y comprobar que no lo localiza.
    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca libros segun su autor
     * Metodo obsoleto:
     * @deprecated {@link #encuentraLibrosPorAutor(String)}
     * @param autor
     */
    //  No testearlo
    //  En esta ocasión, NO TESTEAREMOS este metodo
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca libros segun su autor
     * Metodo que sustituye:
     * @deprecated {@link #encuentaLibroPorAutor(String)}
     * @since v2.0
     * @param autor
     */

    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}
