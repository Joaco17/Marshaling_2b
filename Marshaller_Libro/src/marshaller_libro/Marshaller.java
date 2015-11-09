package marshaller_libro;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {
	
	private Document dom = null;
	private ArrayList<Libro> libros = null;

	public Marshaller(ArrayList<Libro> l) {
		libros = l;
	}
	
	public void crearDocumento() {
			// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// creamos una instancia de DOM 
			dom = db.newDocument();		
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}

	}
	
	public void crearArbolDOM() {

		// creamos el elemento raíz "Biblioteca"
		Element docEle = dom.createElement("Biblioteca");
		dom.appendChild(docEle);

		// recorremos con iterator
		
			Iterator it = libros.iterator();
			while (it.hasNext()) {
			Libro l = (Libro) it.next();
		
		// para cada objeto libro creamos el elemento <libro> y lo añadimos a la raíz
			Element libroEle = setLibro(l);
			docEle.appendChild(libroEle);
		}

	}
	
	private Element setLibro(Libro l) {

		// creamos el elemento libro
		Element LibroEle = dom.createElement("libro");

		// creamos el elemento titulo y el nodo de texto y lo añadimos al elemento libro
		Element tituloEle = dom.createElement("titulo");		
		Text tituloTexto = dom.createTextNode(l.getTitulo());
		tituloEle.appendChild(tituloTexto);
		LibroEle.appendChild(tituloEle);
		
		// creamos el elemento autor y el nodo de texto y lo añadimos al elemento libro
		Element autorEle = dom.createElement("autor");		
		Text autorTexto = dom.createTextNode(l.getAutor());
		autorEle.appendChild(autorTexto);
		LibroEle.appendChild(autorEle);
				
		// creamos el elemento año y el nodo de texto y lo añadimos al elemento libro
		Element añoEle = dom.createElement("año");		
		Text añoTexto = dom.createTextNode(Integer.toString(l.getAño()));
		añoEle.appendChild(añoTexto);
		LibroEle.appendChild(añoEle);
				
		// creamos el elemento editorial y el nodo de texto y lo añadimos al elemento libro
		Element editorialEle = dom.createElement("editorial");		
		Text editorialTexto = dom.createTextNode(l.getEditorial());
		editorialEle.appendChild(editorialTexto);
		LibroEle.appendChild(editorialEle);

		// creamos el elemento num_paginas y el nodo de valor entero y lo añadimos al elemento libro
		Element num_paginasEle = dom.createElement("num_paginas");
		Text num_paginasTexto = dom.createTextNode(Integer.toString(l.getNumero_paginas()));
		num_paginasEle.appendChild(num_paginasTexto);
		LibroEle.appendChild(num_paginasEle);
		
		return LibroEle;
	}
	
	public void escribirDocumentAXml(File file) throws TransformerException {

		// creamos una instacia para escribir el resultado
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		// especificamos dónde escribimos y la fuente de datos
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);

	}

}