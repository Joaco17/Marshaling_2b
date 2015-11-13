package marshaller_libro;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
private String titulo;
private ArrayList<String> autor;
private int año;
private String editorial;
private int numero_paginas;

public Libro(String t,String nombre, String apellido, int añ, String e, int num){
	this.autor= new ArrayList<String>();
	this.titulo=t;
	this.año=añ;
	this.editorial=e;
	this.numero_paginas=num;
	this.autor.add(nombre);
	this.autor.add(apellido);
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public ArrayList<String> getAutor() {
	return autor;
}

public void setAutor(ArrayList<String> autor) {
	this.autor = autor;
}

public int getAño() {
	return año;
}

public void setAño(int año) {
	this.año = año;
}

public String getEditorial() {
	return editorial;
}

public void setEditorial(String editorial) {
	this.editorial = editorial;
}

public int getNumero_paginas() {
	return numero_paginas;
}

public void setNumero_paginas(int numero_paginas) {
	this.numero_paginas = numero_paginas;
}

}
