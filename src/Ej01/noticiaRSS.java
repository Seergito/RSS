package Ej01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class noticiaRSS {

	private String titulo;
	private String descripcion;
	private String enlace;
	private String strFechapub;


	// Formateadores para fechas declarados como static para ahorrar memoria
	public static SimpleDateFormat formateador1AFecha = new	SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
	public static SimpleDateFormat formateador2AFecha = new	SimpleDateFormat("EEE, dd MMM yyyy HH:mm zzz", Locale.US);
	public static SimpleDateFormat formateadorAString = new	SimpleDateFormat("EEEE, dd 'de' MMMM 'del' yyyy, HH:mm",Locale.getDefault());



	public noticiaRSS(Element item) {
		Element etitle=(Element) item.getElementsByTagName("title").item(0);
		if(etitle!=null) this.titulo=etitle.getFirstChild().getNodeValue();
		this.enlace=item.getElementsByTagName("link").item(0).getFirstChild().getNodeValue();
		if (item.getElementsByTagName("description").item(0)==null) this.descripcion=""; 
		else {
			if (item.getElementsByTagName("description").item(0).getFirstChild()==null) this.descripcion=""; 
			else this.descripcion=item.getElementsByTagName("description").item(0).getFirstChild().getNodeValue();
		}
		this.strFechapub=item.getElementsByTagName("pubDate").item(0).getFirstChild().getNodeValue();
	}	

	public String noticiaRSSHTML() {
		return "<tr><td>"+this.titulo+"</td><td><a href='"+enlace+"'>"+enlace+"</a></td><td>"+this.strFechapub+"</td><td>"+this.descripcion+"</td></tr>\n";
	}

	public void anñadeArbolXMLRSS(Document arbolXMLRSS) {
		Element channel=(Element) arbolXMLRSS.getElementsByTagName("channel").item(0);
		Element item=arbolXMLRSS.createElement("item");

		Element title=arbolXMLRSS.createElement("title");
		Element link=arbolXMLRSS.createElement("link");
		Element fecha=arbolXMLRSS.createElement("pubDate");
		Element descripcion=arbolXMLRSS.createElement("description");


		title.setTextContent(titulo);
		link.setTextContent(enlace);
		descripcion.setTextContent(this.descripcion);
		fecha.setTextContent(strFechapub);

		item.appendChild(title);
		item.appendChild(link);
		item.appendChild(descripcion);
		item.appendChild(fecha);

		channel.appendChild(item);

	}

	// Convierte el String strFechaPub a Calendar
	public Calendar getFechaPubComoCalendar() throws ParseException{
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formateador1AFecha.parse(getStrFechapub()));
		}
		catch (Exception e){
			c.setTime(formateador2AFecha.parse(getStrFechapub()));
		}
		return c;
	}
	// Devuelve strFechaPub en formato: miércoles, 10 de febrero del 2013, 21:16
	public String getFechaPubComoStringFormateado(){
		try {
			return formateadorAString.format(getFechaPubComoCalendar().getTime());
		} catch (Exception e) {
			return "";
		}
	}

	public String getFechaString() {
		try {
			return formateadorAString.format(getFechaPubComoCalendar().getTime());
		}catch(Exception e) {
			return "";
		}
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getStrFechapub() {
		return strFechapub;
	}
	public void setStrFechapub(String strFechapub) {
		this.strFechapub = strFechapub;
	}



}
