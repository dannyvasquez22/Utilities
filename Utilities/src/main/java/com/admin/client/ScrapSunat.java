package com.admin.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.client.response.ExchangeRate;
import com.admin.client.response.UserJne;
import com.admin.client.response.UserReniec;
import com.admin.client.response.UserSunat;
import com.admin.util.Constantes;
import com.admin.util.PropertiesConfig;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class ScrapSunat {
	
	@Autowired
	private PropertiesConfig properties;

	public List<ExchangeRate> getExchangeRate(int monthNumber, int year) {
		List<ExchangeRate> listER = new ArrayList<>();
		try {
        	Document doc = Jsoup.connect(properties.EXCHANGERATE_URL.replace(Constantes.S_MONTH_EXCHANGE_RATE, String.valueOf(monthNumber))
        			.replace(Constantes.S_YEAR_EXCHANGE_RATE, String.valueOf(year))).get();
//        	"http://www.sunat.gob.pe/cl-at-ittipcam/tcS01Alias?mes=2&anho=2019"
//            Document doc = Jsoup.connect("http://www.sunat.gob.pe/cl-at-ittipcam/tcS01Alias").get();
//        	String url_sunat = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias?accion=consPorRuc&razSoc=&nroRuc=" + ruc + "&nrodoc=&contexto=ti-it&tQuery=on&search1=" + ruc + "&codigo=" + result.trim().toUpperCase() + "&tipdoc=1&search2=&coddpto=&codprov=&coddist=&search3=";
        	//http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/frameCriterioBusqueda.jsp
        	//http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS03Alias
        	//http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias


            System.out.println(doc.select("body center h3").first().text() == null ? Month.of(monthNumber).name() + " " + year : doc.select("body center h3").first().text());
            
            for (Element el : doc.select("body div table[class=class=\"form-table\"] tr").next()) {
            	int columna = 0;
				String tc_fecha = "";
		        Double tc_compra = 0.0;
		        Double tc_venta = 0.0;
		        
				for (Element element : el.select("td")) {
					ExchangeRate er = new ExchangeRate();
					columna++;
					
					if (columna > 3) columna = 1;
					
					String val = element.select("strong").text() == null ||  element.select("strong").text().length() <= 0 ? element.text() : element.select("strong").text();
					
					if (columna == 1) tc_fecha = (val.length() == 2 ? val : "0" + val) + "/" + monthNumber + "/" + year;  
					if (columna == 2) tc_compra = Double.parseDouble(val);
					if (columna == 3) {
						tc_venta = Double.parseDouble(val);
						System.out.println(tc_fecha + " - " + tc_compra + " - " + tc_venta);
						er.setTc_fecha(tc_fecha);
						er.setTc_compra(tc_compra);
						er.setTc_venta(tc_venta);
						listER.add(er);
					}
				}
            }
            
            return listER;
            
//            doc.select("body div table[class=class=\"form-table\"] tr").next()
//            	.forEach(el -> {
//            				int columna = 0;
//            				String tc_fecha = "";
//					        Double tc_compra = 0.0;
//					        Double tc_venta = 0.0;
//            				for (Element element : el.select("td")) {
//            					columna++;
//            					
//            					if (columna > 3) columna = 1;
//            					
//            					String val = element.select("strong").text() == null ||  element.select("strong").text().length() <= 0 ? element.text() : element.select("strong").text();
//            					
//            					if (columna == 1) tc_fecha = (val.length() == 2 ? val : "0" + val) + "/" + monthNumber + "/" + year;  
//        						if (columna == 2) tc_compra = Double.parseDouble(val);
//    							if (columna == 3) {
//    								tc_venta = Double.parseDouble(val);
//    								System.out.println(tc_fecha + " - " + tc_compra + " - " + tc_venta);
//    							}
//            				}
//            			});
            
//            List<ExchangeRate> op = doc.select("body div table[class=class=\"form-table\"] tr").next()
//        	.map(el -> {
//        				int columna = 0;
//        				String tc_fecha = "";
//				        Double tc_compra = 0.0;
//				        Double tc_venta = 0.0;
//				        List<ExchangeRate> listER = new ArrayList<>();
//        				for (Element element : el.select("td")) {
//        					ExchangeRate er = new ExchangeRate();
//        					columna++;
//        					
//        					if (columna > 3) columna = 1;
//        					
//        					String val = element.select("strong").text() == null ||  element.select("strong").text().length() <= 0 ? element.text() : element.select("strong").text();
//        					
//        					if (columna == 1) tc_fecha = (val.length() == 2 ? val : "0" + val) + "/" + monthNumber + "/" + year;  
//    						if (columna == 2) tc_compra = Double.parseDouble(val);
//							if (columna == 3) {
//								tc_venta = Double.parseDouble(val);
//								System.out.println(tc_fecha + " - " + tc_compra + " - " + tc_venta);
//								er.setTcFecha(tc_fecha);
//								er.setTcCompra(tc_compra);
//								er.setTcVenta(tc_venta);
//								listER.add(er);
//							}
//        				}
//        				
//        				return listER;
//        			}).collect(Collectors.toList());
        } catch (IOException e) {
        }
		
		return null;
	} 
	
	public String getCatpcha() {
		
		//String imageURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";   &nmagic=1
        String url_antigua = properties.CAPTCHA_URL;
        String result = "";
        URL url;

        ITesseract instance = new Tesseract();

        try {
            url = new URL(url_antigua);
            BufferedImage img = ImageIO.read(url);
            result = instance.doOCR(img);
            System.out.println(result);
            
            return result;
        } catch (TesseractException | IOException e) {
            System.err.println(e.getMessage());
        }
        
        return null;
	}
	
	public UserJne getUserJne(String numero_documento) {
		UserJne user = new UserJne();
		
		try {
        	String url_reniec = properties.JNE_URL.replace(Constantes.S_NUMBER_DOCUMENT, numero_documento);
        	System.out.println(url_reniec);
        	Document doc = Jsoup.connect(url_reniec).get();
        	
        	doc.select("body").forEach(System.out::println);
        	
        	user.setNombres(doc.select("body").text());
        	
        	return user;
        } catch (IOException e) {
        }
		
		return null;
	}
	
	public UserReniec getUserReniec(String numero_documento) {
		UserReniec user = new UserReniec();
		
		try {
        	String url_reniec = properties.RENIEC_URL.replace(Constantes.S_NUMBER_DOCUMENT, numero_documento);
//        	System.out.println(url_reniec);
        	Document doc = Jsoup.connect(url_reniec).get();
        	
//        	doc.select("body table tr.txtCuerpo").next().next().forEach(System.out::println);
        	
        	Element trPrincipal = doc.select("body table tr.txtCuerpo").next().next().first();
        	Element tab = trPrincipal.select("table").first();

        	int i = 0;
        	for (Element el : tab.select("tr")) {
        		i++;
        		if (i == 1) user.setNombres(el.child(1).text());
        		if (i == 2) user.setNumero_documento(el.child(1).text());
        		if (i == 3) user.setGrupo_votacion(el.child(1).text());
        		if (i == 4) user.setDistrito(el.child(1).text());
        		if (i == 5) user.setProvincia(el.child(1).text());
        		if (i == 6) user.setDepartamento(el.child(1).text());
        	}
        	return user;
//        	tab.select("tr").forEach(trd -> {
//        		System.out.println(trd.child(0).text() + " - " + trd.child(1).text());
//        	});
        } catch (IOException e) {
        }
		
		return null;
	}
	
	public UserSunat getUserSunat(String numero_documento) {
		UserSunat user = new UserSunat();
		try {
			String[] arr = consultaRUC(numero_documento);

			user.setNumero_documento(arr[0]);
			user.setNombres(arr[1]);
			user.setTipo_contribuyente(arr[2]);
			user.setTipo_documento(arr[3]);
			user.setNombre_comercial(arr[4]);
			user.setFecha_inscripcion(arr[5]);
			user.setFecha_ini_actividades(arr[6]);
			user.setEstado_contribuyente(arr[7]);
			user.setCondicion_contribuyente(arr[8]);
			user.setProfesion(arr[9]);
			
			return user;
		} catch (Exception e) {
		}
		return null;
	}
	
	public String[] consultaRUC(String ruc) throws Exception {
		String[] datos = new String[10];

		String captcha = "";

		Connection.Response res = Jsoup.connect(properties.SUNATCAPTCHA_URL)
				.data("accion", "random").method(Method.GET).execute();

		Map<String, String> cookie = res.cookies();

		captcha = res.parse().select("body").text();

		Document dRuc = Jsoup.connect(properties.SUNAT_URL)
				.data(Constantes.S_SUNAT_PARAM1, Constantes.S_SUNAT_VALUE1)
				.data(Constantes.S_SUNAT_PARAM2, ruc)
				.data(Constantes.S_SUNAT_PARAM3, Constantes.S_UNO)
				.data(Constantes.S_SUNAT_PARAM4, captcha)
				.cookies(cookie).get();

		Element table = dRuc.select("TABLE[class = form-table]").first();
		Elements rows = table.select("tr");
		int i = 0;

		datos[0] = /*rows.first().child(0).text() == null || rows.first().child(0).text().length() <= 0 ? "" : rows.first().child(0).text() + " " +*/ ruc;
		for (Element e : rows) {
//			System.out.println(e);
			if (e.children().size() > 1) {

//				Element tdc = e.child(0);
				Element td = e.child(1);
				
				if (i == 0) datos[1] = /*"NOMBRES: " +*/ td.text().substring(14, td.text().length());
				
				if (i == 1) datos[2] = /*tdc.text() + " " +*/ td.text();
				
				if (i == 2) datos[3] = /*tdc.text() + " " +*/ td.text().split("-")[0];
				
				if (i == 3) datos[4] = /*tdc.text() + " " +*/ td.text();
				
				if (i == 4) {
					datos[5] = /*tdc.text() + " " +*/ td.text();
					datos[6] = /*e.child(2).text() + " " +*/ e.child(3).text();
				}
				
				if (i == 5) datos[7] = /*tdc.text() + " " +*/ td.text();
				
				if (i == 6) {
					datos[8] = /*tdc.text() + " " +*/ td.text();
					datos[9] = /*e.child(2).text() + " " +*/ e.child(3).text();
				}
			}
			i += 1;
		}
		return datos;
	}

}
