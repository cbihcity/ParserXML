package by.pvt.heldyieu.parsers.tools;

//import java.util.ArrayList;
//import java.util.EnumSet;
//import java.util.List;
//
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//
//import by.pvt.heldyieu.beans.callprices.CallPrices;
//import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.interfaces.Constants;
//import by.pvt.heldyieu.parsers.enums.TariffsEnum;

public class TariffSAXHandler extends DefaultHandler implements Constants {

//	private List<Tariff> tempCallsTariffs = null;
//	private List<Tariff> tempInternetTariffs = null;
//	private List<CallPrices> callsPrice = null;
//	private TariffsEnum tempEnum = null;
//	
//	
//	public TariffSAXHandler() {
//		tempCallsTariffs = new ArrayList<Tariff>();
//		tempInternetTariffs = new ArrayList<Tariff>();
//		callsPrice = new ArrayList<CallPrices>();	
//		
//	}
//	
//	@Override
//	public void startDocument() throws SAXException {
//		System.out.println("Start SAX Parsing");
//	}
//
//	@Override
//	public void endDocument() throws SAXException {
//		System.out.println("\nFinished SAX Parsing");
//	}
//
//	@Override
//	public void startElement(String uri, String localName, String qName,
//			Attributes attributes) throws SAXException {
//		String s = localName;
//		//получение вывода информации об атрибутах элемента
//		for (int i = 0; i < attributes.getLength(); i++) {
//			s += " " + attributes.getLocalName(i) + "=" + attributes.getValue(i);
//		}
//		System.out.println(s.trim());
//	}
//
//	@Override
//	public void endElement(String uri, String localName, String qName)
//			throws SAXException {
//		System.out.println(localName);
//	}
//
//	@Override
//	public void characters(char[] ch, int start, int length)
//			throws SAXException {
//		System.out.println(new String(ch, start, length));
//	}
	
}
