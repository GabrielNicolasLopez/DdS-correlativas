package domain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.List;

public class testInscripcion {
    private static Materia algoritmos;
    private static Materia pdep;
    private static Materia dds;
    private static Alumno alumnoSinMaterias;
    private static Alumno alumnoConUnaMateria;
    private static Alumno alumnoConDosMaterias;

    private static Inscripcion inscripcionAPdep;
    private static Inscripcion inscripcionADds;
    private static Inscripcion inscripcionAAlgoritmos;


    @BeforeClass
    public static void setUp() {
        //Creo las materias
        algoritmos = new Materia();
        pdep = new Materia();
        dds = new Materia();

        //Creo alumnos
        alumnoSinMaterias = new Alumno();
        alumnoConUnaMateria = new Alumno();
        alumnoConDosMaterias = new Alumno();

        //Creo una inscripcion
        inscripcionAPdep = new Inscripcion();
        inscripcionADds = new Inscripcion();
        inscripcionAAlgoritmos = new Inscripcion();

        //CORRELATIVAS
        //Agrego las correlativas a algoritmos
        List<Materia> correlativasAlgoritmos = new ArrayList<>();
        algoritmos.setCorrelativas(correlativasAlgoritmos);

        //Agrego las correlativas a pdep
        List<Materia> correlativasPdep = new ArrayList<>();
        correlativasPdep.add(algoritmos);
        pdep.setCorrelativas(correlativasPdep);

        //Agrego las correlativas a dds
        List<Materia> correlativasDDS = new ArrayList<>();
        correlativasDDS.add(algoritmos);
        correlativasDDS.add(pdep);
        dds.setCorrelativas(correlativasDDS);

        //ALUMNOS
        //Agrego las materias aprobadas de alumnoSinMaterias
        List<Materia> materiasDelAlumnoSinMaterias = new ArrayList<>();
        alumnoSinMaterias.setMateriasAprobadas(materiasDelAlumnoSinMaterias);

        //Agrego las materias aprobadas de alumnoConAUnaMateria
        List<Materia> materiasDelAlumnoConAUnaMateria = new ArrayList<>();
        materiasDelAlumnoConAUnaMateria.add(algoritmos);
        alumnoConUnaMateria.setMateriasAprobadas(materiasDelAlumnoConAUnaMateria);

        //Agrego las materias aprobadas de alumnoConADosMaterias
        List<Materia> materiasDelAlumnoConADosMaterias = new ArrayList<>();
        materiasDelAlumnoConADosMaterias.add(algoritmos);
        materiasDelAlumnoConADosMaterias.add(pdep);
        alumnoConDosMaterias.setMateriasAprobadas(materiasDelAlumnoConADosMaterias);

        //INSCRIPCIONES
        //Inscripcion a Algoritmos
        List<Materia> inscribirseAAlgoritmos = new ArrayList<>();
        inscribirseAAlgoritmos.add(algoritmos);
        inscripcionAAlgoritmos.setMateriasAInscribir(inscribirseAAlgoritmos);

        //Inscripcion a PdeP
        List<Materia> inscribirseAPdep = new ArrayList<>();
        inscribirseAPdep.add(pdep);
        inscripcionAPdep.setMateriasAInscribir(inscribirseAPdep);

        //Inscripcion a DDS
        List<Materia> inscribirseADds = new ArrayList<>();
        inscribirseADds.add(dds);
        inscripcionADds.setMateriasAInscribir(inscribirseADds);
    }

    @Test
    public void inscripcionExitosaAUnaMateriaSinCorrelativas() {
        inscripcionAAlgoritmos.setAlumno(alumnoSinMaterias);
        Assert.assertTrue(inscripcionAAlgoritmos.aprobada());
    }

    @Test
    public void inscripcionExitosaAUnaMateriaConCorrelativas() {
        inscripcionAPdep.setAlumno(alumnoConUnaMateria);
        Assert.assertTrue(inscripcionAPdep.aprobada());
    }

    @Test
    public void inscripcionFallidaAUnaMateriaConCorrelativas() {
        inscripcionAPdep.setAlumno(alumnoSinMaterias);
        Assert.assertFalse(inscripcionAPdep.aprobada());
    }

    @Test
    public void inscripcionFallidaAUnaMateriaYaAprobada() {
        inscripcionAAlgoritmos.setAlumno(alumnoConUnaMateria);
        Assert.assertFalse(inscripcionAAlgoritmos.aprobada());
    }
}