package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Libro libro;
    Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
        libro = new Libro("1984", "Orwell", 1969);
    }

    @Test
    void agregarLibro() {
        assertTrue(biblioteca.agregarLibro(libro));
        assertTrue(biblioteca.getLibros().contains(libro));
    }

    @Test
    void eliminarLibro() {
        biblioteca.agregarLibro(libro);
        assertTrue(biblioteca.eliminarLibro(libro));
        assertFalse(biblioteca.getLibros().contains(libro));
    }

    @Test
    void encuentraLibroPorTitulo() {
        biblioteca.agregarLibro(libro);
        biblioteca.encuentraLibroPorTitulo("1984");
        assertEquals(biblioteca.getLibros().contains(libro.getTitulo()), biblioteca.encuentraLibroPorTitulo("1984"));
        assertNotEquals(biblioteca.getLibros().contains(libro.getTitulo()), biblioteca.encuentraLibroPorTitulo("Harry Potter"));

    }

    @Test
    void encuentraLibrosPorAutor() {
        biblioteca.agregarLibro(libro);
        biblioteca.encuentraLibrosPorAutor("Orwell");
        assertEquals(biblioteca.getLibros().contains(libro.getAutor()), biblioteca.encuentraLibrosPorAutor("Orwell"));
        assertNotEquals(biblioteca.getLibros().contains(libro.getAutor()), biblioteca.encuentraLibrosPorAutor("Foster Wallace"));


        //NO ME DA TIEMPO A PONERLOS BIEN PERO POR AQUI VAN LOS TIROS
    }
}