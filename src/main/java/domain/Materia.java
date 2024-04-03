package domain;

import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean correlativasAprobadas(Alumno alumno) {
        return alumno.getMateriasAprobadas().containsAll(this.correlativas);
    }

    public boolean materiaNoAprobada(Alumno alumno) {
        return !alumno.getMateriasAprobadas().contains(this);
    }
}