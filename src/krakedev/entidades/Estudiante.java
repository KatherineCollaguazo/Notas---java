package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Nota> notas;

	public Estudiante(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota nuevaNota) {
		if (!existeCodigoMateria(nuevaNota.getMateria().getCodigo()) && esNotaValida(nuevaNota.getCalificacion())) {
			notas.add(nuevaNota);
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		for (Nota nota : notas) {
			if (nota.getMateria().getCodigo().equals(codigo) && esNotaValida(nuevaNota)) {
				nota.setCalificacion(nuevaNota);
				return;
			}
		}
		System.out.println("No se encontró una nota con el código especificado.");
	}

	public double calcularPromedioNotasEstudiante() {
		if (notas.isEmpty()) {
			return 0.0;
		}

		double sumaNotas = 0.0;
		for (Nota nota : notas) {
			sumaNotas += nota.getCalificacion();
		}

		return sumaNotas / notas.size();
	}

	public void mostrar() {
		System.out.println("Estudiante: nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula);
		for (Nota nota : notas) {
			nota.mostrar();
		}
		System.out.println("Promedio: " + calcularPromedioNotasEstudiante());
	}

	private boolean existeCodigoMateria(String codigo) {
		for (Nota nota : notas) {
			if (nota.getMateria().getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}

	private boolean esNotaValida(double nota) {
		return nota >= 0 && nota <= 10;
	}

}
