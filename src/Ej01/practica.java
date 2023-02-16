package Ej01;

import java.io.BufferedWriter;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class practica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="https://e00-elmundo.uecdn.es/elmundo/rss/portada.xml";
		
		try {
			Document DOM=UtilidadesDOM.gernerararbolDOMURL(url);
			ArrayList<noticiaRSS> lista=new ArrayList<noticiaRSS>();
			Element raiz=DOM.getDocumentElement();
			NodeList listaitems=raiz.getElementsByTagName("item");
			
			
			for (int i = 0; i < listaitems.getLength(); i++) {
				Element item=(Element) listaitems.item(i);
				noticiaRSS noticia=new noticiaRSS(item);
				lista.add(noticia);
			}
			
			String html="<!DOCTYPE HTML>\r\n"
			+"<html lang=\"es\">\r\n"
			+"<head>\r\n"
			+"<meta charset=\"utf-8\">\r\n"
			+"<title>Mis noticias MUNDO</title>\r\n"
			+"</head>\r\n"
			+"<body>\r\n"
			+"<table>";
			
			Document arbolXML=UtilidadesDOM.generararbolDOMvacio();
			Element rss=arbolXML.createElement("rss");
			Element channel=arbolXML.createElement("channel");
			arbolXML.appendChild(rss);
			rss.appendChild(channel);
			
			for (noticiaRSS noticiaRSS : lista) {
				html=html+noticiaRSS.noticiaRSSHTML();
				noticiaRSS.anñadeArbolXMLRSS(arbolXML);
			}
			
			html=html+"</table><body/>\r\n</html>";
			System.out.println(html);
			
			Path rutasalida=Paths.get("mundo.html");
			Charset cs=Charset.forName("utf-8");
			BufferedWriter salida=Files.newBufferedWriter(rutasalida , cs);
			salida.write(html);
			salida.close();
			UtilidadesDOM.crearficheroxml(arbolXML, "mundo.xml");
			
			
			Comparador c=new Comparador();
			Collections.sort(lista,c);
			
			arbolXML=UtilidadesDOM.generararbolDOMvacio();
			rss=arbolXML.createElement("rss");
			channel=arbolXML.createElement("channel");
			arbolXML.appendChild(rss);
			rss.appendChild(channel);
			
			html="<!DOCTYPE HTML>\r\n"
					+"<html lang=\"es\">\r\n"
					+"<head>\r\n"
					+"<meta charset=\"utf-8\">\r\n"
					+"<title>Mis noticias</title>\r\n"
					+"</head>\r\n"
					+"<body>\r\n"
					+"<table>";
			
			//ORDENADO
			System.out.println();
			System.out.println("-------------ORDENADO:-----------");
			System.out.println();
			
		
			
			for (noticiaRSS noticiaRSS : lista) {
				html=html+noticiaRSS.noticiaRSSHTML();
				noticiaRSS.anñadeArbolXMLRSS(arbolXML);
			}
			html=html+"</table><body/>\r\n</html>";
			System.out.println(html);
			
			
			
			Path rutasalida2=Paths.get("mundo2.html");
			Charset cs2=Charset.forName("utf-8");
			BufferedWriter salida_ordenada=Files.newBufferedWriter(rutasalida2 , cs2);
			salida_ordenada.write(html);
			salida_ordenada.close();
			UtilidadesDOM.crearficheroxml(arbolXML, "mundo2.xml");
			
			
			
			//PROCESO PAIS
				
			url="http://ep00.epimg.net/rss/elpais/portada.xml";
			
					html="<!DOCTYPE HTML>\r\n"
					+"<html lang=\"es\">\r\n"
					+"<head>\r\n"
					+"<meta charset=\"utf-8\">\r\n"
					+"<title>Mis noticias PAIS</title>\r\n"
					+"</head>\r\n"
					+"<body>\r\n"
					+"<table>";
			
			 
			 DOM =UtilidadesDOM.gernerararbolDOMURL(url);
			 ArrayList<noticiaRSS> lista2=new ArrayList<noticiaRSS>();
			 Element raiz2=DOM.getDocumentElement();
			 NodeList listaitem2=raiz2.getElementsByTagName("item");
			 
			 for (int i = 0; i < listaitem2.getLength(); i++) {
				Element item=(Element) listaitem2.item(i);
				noticiaRSS noticia=new noticiaRSS(item);
				lista2.add(noticia);
			}
			 
			 
			 Document arbolXML2=UtilidadesDOM.generararbolDOMvacio();
				Element rss2=arbolXML2.createElement("rss");
				Element channel2=arbolXML2.createElement("channel");
				arbolXML2.appendChild(rss2);
				rss2.appendChild(channel2);
				
				for (noticiaRSS noticiaRSS : lista2) {
					html=html+noticiaRSS.noticiaRSSHTML();
					noticiaRSS.anñadeArbolXMLRSS(arbolXML2);
				}
				
				html=html+"</table><body/>\r\n</html>";
				System.out.println(html);
				
				Path rutasalida3=Paths.get("pais.html");
				Charset cs3=Charset.forName("utf-8");
				BufferedWriter salida3=Files.newBufferedWriter(rutasalida3 , cs3);
				salida3.write(html);
				salida3.close();
				UtilidadesDOM.crearficheroxml(arbolXML2, "pais.xml");
				
				Collections.sort(lista2,c);
				
				
				System.out.println();
				System.out.println("-------------ORDENADO:-----------");
				System.out.println();
				
				
				arbolXML2=UtilidadesDOM.generararbolDOMvacio();
				rss=arbolXML2.createElement("rss");
				channel=arbolXML2.createElement("channel");
				arbolXML2.appendChild(rss);
				rss.appendChild(channel);
				
				for (noticiaRSS noticiaRSS : lista2) {
					html=html+noticiaRSS.noticiaRSSHTML();
					noticiaRSS.anñadeArbolXMLRSS(arbolXML2);
				}
				
				html=html+"</table><body/>\r\n</html>";
				System.out.println(html);
				
				Path rutasalida4=Paths.get("pais2.html");
				Charset cs4=Charset.forName("utf-8");
				BufferedWriter salida_ordenada2=Files.newBufferedWriter(rutasalida4 , cs4);
				salida_ordenada2.write(html);
				salida_ordenada2.close();
				UtilidadesDOM.crearficheroxml(arbolXML2, "pais2.xml");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
