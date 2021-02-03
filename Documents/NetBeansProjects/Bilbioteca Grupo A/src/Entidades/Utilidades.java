package Entidades;

import java.sql.Date;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
    public static final int numPrestamos = PRESTAMOS.length;

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
        new Elemento(1, GENEROS[1]),
        new Elemento(2, GENEROS[2]),
        new Elemento(3, GENEROS[3])
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
        new Evento(1, "Prueba informatica", Date.valueOf(LocalDate.parse("01/01/2021", dateFormatter))),
        new Evento(2, "Firma de libros", Date.valueOf(LocalDate.parse("02/02/2021", dateFormatter))),
        new Evento(3, "Nuevos autores", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(4, "asfasg", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(5, "bdsds", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(6, "Nuevos", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(7, "Nuevos autos", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(8, "Nadda", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(9, "addah autores", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(10, "Nuevosadsdfasbhds", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(11, "Nuevosaddautores", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter))),
        new Evento(12, "Nuevostores", Date.valueOf(LocalDate.parse("03/03/2021", dateFormatter)))
    };
    public static final int numEventos = EVENTOS.length;

    public static final Concurso CONCURSOS[] = {
        new Concurso(EVENTOS[0], "Informatica", "Raton Logitech"),
        new Concurso(EVENTOS[1], "Origami", "100€"),
        new Concurso(EVENTOS[2], "Matematicas", "100€")
    };
    public static final int numConcursos = CONCURSOS.length;

    public static final Curso CURSOS[] = {
        new Curso(EVENTOS[3], "50 minutos", "Aula 1"),
        new Curso(EVENTOS[4], "30 minutos", "Aula 2"),
        new Curso(EVENTOS[5], "40 minutos", "Aula 3")
    };
    public static final int numCursos = CURSOS.length;

    public static final Lectura LECTURAS[] = {
        new Lectura(EVENTOS[6], false, "Cien años de soledad"),
        new Lectura(EVENTOS[7], false, "El ingenioso hidalgo Don Quijote de la Mancha"),
        new Lectura(EVENTOS[8], false, "El principito"),};
    public static final int numLecturas = LECTURAS.length;

    public static final Visionado VISIONADOS[] = {
        new Visionado(EVENTOS[9], "Aula 1"),
        new Visionado(EVENTOS[10], "Aula 2"),
        new Visionado(EVENTOS[11], "Aula 3")
    };
    public static final int numVisionados = VISIONADOS.length;

    public static class Fecha {

        private int anio;
        private int mes;
        private int dia;

        public Fecha() {
            Date hoy = Date.valueOf(LocalDate.now());
        }

        public Fecha(int y, int m, int d) {
            this.anio = y;
            this.mes = m;
            this.dia = d;
        }

        public Date conversorFecha() {
            java.sql.Date ret = new Date(this.anio, this.mes, this.dia);
            return ret;
        }

        public static Fecha nuevaFecha() {
            Fecha ret = new Fecha();
            Scanner in = new Scanner(System.in);
            int d = 0;
            do {
                System.out.println("Dame el dia del mes");
                d = in.nextInt();
                if (d <= 0 || d > 31) {
                    System.out.println("valor incorrecto");
                }
            } while (d <= 0 || d > 31);
            int m = 0;
            do {
                System.out.println("Dame el mes del año");
                m = in.nextInt();
                if (m <= 0 || m > 12) {
                    System.out.println("Valor incorrecto");
                }
            } while (m <= 0 || m > 12);
            int y = 0;
            do {
                System.out.println("Dame el año");
                y = in.nextInt();
                if (y <= 0) {
                    System.out.println("Valor incorrecto");
                }
            } while (y <= 0);

            ret = new Fecha(y, m, d);
            return ret;

        }

    }

    public static String removeDiacriticalMarks(String string) {
        //Form.NFC acepta ñ y distingue las tildes en español
        return Normalizer.normalize(string, Normalizer.Form.NFC)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

//      Primer intento Registro   
//      public Socio RegistrarSocio(){
//        
//        Socio s1 = new Socio();
//        Scanner in = new Scanner(System.in);
//        do{        
//        System.out.println("Inserte su nombre");
//        String nombre = in.nextLine();
//        if(nombre.length()>20){
//            System.out.println("te has pasao pa");
//            continue;
//        }
//        else
//            break;
//        } while (nombre.length()>20);
//        return s1;
//    }
}
