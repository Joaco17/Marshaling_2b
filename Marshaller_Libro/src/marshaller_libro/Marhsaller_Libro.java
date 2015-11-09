package marshaller_libro;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class Marhsaller_Libro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Libro> libros;
		
		libros = new ArrayList<Libro>();
		libros.add(new Libro("Bellezas de Europa","Atlas",1994,"SM",254));
		libros.add(new Libro("Dragon Ball","Akira Toriyama",1989,"Toei",255));
		
		Marshaller marsh = new Marshaller(libros);
		
		marsh.crearDocumento();
		marsh.crearArbolDOM();
		
		File file = new File("Biblioteca.xml");
		
		try {
			marsh.escribirDocumentAXml(file);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
