package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	
	private ArrayList<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<Estudiante>();
    }

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public Estudiante buscarEstudiantePorCedula(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equals(estudiante.getCedula())) {
                return e; 
            }
        }
        return null; 
    }

    public void matricularEstudiantes(Estudiante estudiante) {
        
        Estudiante estudianteExistente = buscarEstudiantePorCedula(estudiante);
        
        if (estudianteExistente == null) {
            estudiantes.add(estudiante); 
            System.out.println("Estudiante matriculado exitosamente.");
        } else {
            System.out.println("El estudiante ya está matriculado en el curso.");
        }
    }

    public double calcularPromedioCurso() {
        double sumatoriaPromedios = 0.0;

        for (Estudiante estudiante : estudiantes) {
            sumatoriaPromedios += estudiante.calcularPromedioNotasEstudiante();
        }

        return sumatoriaPromedios / estudiantes.size();
    }

    public void mostrar() {
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrar();
        }
        System.out.println("Promedio del curso: " + calcularPromedioCurso());
    }
}
