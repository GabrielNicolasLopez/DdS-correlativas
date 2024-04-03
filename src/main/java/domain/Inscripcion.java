package domain;

import java.util.List;

public class Inscripcion {
    public Alumno alumno;
    private List<Materia> materiasAInscribir;

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateriasAInscribir(List<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }

    public boolean aprobada(){
        return (materiasAInscribir.stream().allMatch(materia -> materia.correlativasAprobadas(alumno))) &&
                (materiasAInscribir.stream().allMatch(materia -> materia.materiaNoAprobada(alumno)));
    }
}