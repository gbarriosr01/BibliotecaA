package Entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author manuo
 */
public class Utilidades {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final Socio SOCIOS[] = {
        new Socio(1, "Juan", "12345678R", "722232220", "Avenida Bermudez"),
        new Socio(2, "Paco", "12345679K", "987654321", "Calle Francisco"),
        new Socio(3, "Pepe", "65498732E", "369852147", "Calle Croqueta")
    };
    public static final int numSocios = SOCIOS.length;

    public static final Prestamo PRESTAMOS[] = {
        new Prestamo(1, Date.valueOf(LocalDate.parse("01/10/2021", dateFormatter)), Date.valueOf(LocalDate.parse("01/11/2021", dateFormatter))),
        new Prestamo(2, Date.valueOf(LocalDate.parse("01/09/2021", dateFormatter)), Date.valueOf(LocalDate.parse("01/12/2021", dateFormatter))),
        new Prestamo(3, Date.valueOf(LocalDate.parse("01/07/2021", dateFormatter)), Date.valueOf(LocalDate.parse("01/01/2022", dateFormatter)))
    };
    public static final int numprestamos = PRESTAMOS.length;

    public static final Estado ESTADOS[] = {
        new Estado(1, "Pendiente"),
        new Estado(2, "Parcial"),
        new Estado(3, "Completo")
    };
    public static final int numEstados = ESTADOS.length;

    public static final Penalizacion PENALIZACIONES[] = {
        new Penalizacion(1, "No entregó a tiempo", Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Penalizacion(2, "No entregó a tiempo", Date.valueOf(LocalDate.parse("12/01/2021", dateFormatter))),
        new Penalizacion(3, "Entregó en mal estado", Date.valueOf(LocalDate.parse("13/01/2021", dateFormatter)))
    };
    public static final int numPenalizaciones = PENALIZACIONES.length;
    
    public static final Proveedor PROVEEDORES[] = {
        new Proveedor(1, "Juan", "942111111"),
        new Proveedor(2, "Luis", "676222222"),
        new Proveedor(3, "Teresa", "721333333")
    };
    public static final int numProveedores = PROVEEDORES.length;
    
    public static final Genero GENEROS[] = {
        new Genero(1, "Aventuras"),
        new Genero(2, "Novela negra"),
        new Genero(3, "Educativos"),
        new Genero(4, "Misterio"),
        new Genero(5, "Fantasia"),
        new Genero(6, "Ciencia ficción"),
        new Genero(7, "Terror"),
        new Genero(8, "Autoayuda")
    };
    public static final int numGeneros = GENEROS.length;

    public static final Lote LOTES[] = {
        new Lote(Date.valueOf(LocalDate.parse("12/10/2021", dateFormatter)), 1),
        new Lote(Date.valueOf(LocalDate.parse("12/10/2020", dateFormatter)), 2),
        new Lote(Date.valueOf(LocalDate.parse("12/10/2020", dateFormatter)), 3)
    };
    public static final int numLotes = LOTES.length;

    public static final Elemento ELEMENTOS[] = {
        new Elemento(1, GENEROS[0] ),
        new Elemento(2, GENEROS[0] ),
        new Elemento(3, GENEROS[0] )
    };
    public static final int numElementos = ELEMENTOS.length;

    public static final Estanteria ESTANTERIAS[] = {
        new Estanteria(1, 'A', "fondo derecha", false),
        new Estanteria(2, 'B', "fondo izquierda", false),
        new Estanteria(3, 'C', "centro", false)
    };
    public static final int numEstanterias = ESTANTERIAS.length;

    public static final DVD DVDS[] = {
        new DVD("Tyler Rake"),
        new DVD("A ciegas"),
        new DVD("Spenser: Confidencial")
    };
    public static final int numDVDs = DVDS.length;

    public static final Libro LIBROS[] = {
        new Libro("Cien años de soledad", "Ediciones del norte", "Gabriel Garcia Marquez", 230),
        new Libro("El ingenioso hidalgo Don Quijote de la Mancha", "Nadir ediciones", "Miguel de Cervantes", 400),
        new Libro("El principito", "Editorial universidad de cantabria", "Antoine De Saint Exupéry", 300)
    };
    public static final int numLibros = LIBROS.length;
    
    public static final Evento EVENTOS[] = {
        new Evento(1, "Lucha de Sables", Date.valueOf(LocalDate.parse("01/01/2021", dateFormatter)), 1),
        new Evento(2, "Firma de libros", Date.valueOf(LocalDate.parse("02/02/2021", dateFormatter)), 2),
        new Evento(3, "Nuevos autores", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter)), 3)
    };
    public static final int Evento = EVENTOS.length;

    public static final Concurso CONCURSOS[] = {
        new Concurso("Informatica", "Raton Logitech"),
        new Concurso("Origami", "100€"),
        new Concurso("Matematicas", "100€")
    };
    public static final int Concurso = CONCURSOS.length;

    public static final Curso CURSOS[] = {
        new Curso("50 minutos", "Aula 1"),
        new Curso("30 minutos", "Aula 2"),
        new Curso("40 minutos", "Aula 3")
    };
    public static final int Curso = CURSOS.length;

    public static final Lectura LECTURAS[] = {
        new Lectura(false, "Cien años de soledad"),
        new Lectura(false, "El ingenioso hidalgo Don Quijote de la Mancha"),
        new Lectura(false, "El principito")
    };
    public static final int Lectura = LECTURAS.length;

    public static final Visionado VISIONADOS[] = {
        new Visionado("Aula 1"),
        new Visionado("Aula 2"),
        new Visionado("Aula 3")
    };
    public static final int Visionado = VISIONADOS.length;
}
