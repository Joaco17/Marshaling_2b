package marshaller_libro;

import java.io.Serializable;

public class Libro implements Serializable {
private String titulo;
private String autor;
private int año;
private String editorial;
private int numero_paginas;

public Libro(String t, String a, int añ, String e, int num){
	this.titulo=t;
	this.autor= a;
	this.año=añ;
	this.editorial=e;
	this.numero_paginas=num;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
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
