package by.pvt.heldyieu.parsers.tools;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.enums.TariffsEnum;

public class TariffSAXHandler extends DefaultHandler implements Constants{
	static Logger logger = Logger.getLogger(TariffSAXHandler.class.getName());
	
	private TariffForCalls tempCallsTariffs;
	private TariffForInternet tempInternetTariffs;
	private List<Tariff> listOftempTariff = null;
	private List<CallPrices> callsPrice = null;
	CallPricesTypes callPricesType;
	Tariff tempTariff;
	Parameters parameter;
	CallPrices tempCallPrice;
	private TariffsEnum tempEnum = null;

	public List<Tariff> getTempCallsTariffs() {
		return tempCallsTariffs.getListOfTariff();
	}

	public List<Tariff> getTempInternetTariffs() {
		return tempInternetTariffs.getListOfTariff();
	}
	
	@Override
	public void startElement(String uri, String localName,
            String qName, Attributes atts) throws SAXException {
		if (qName.equals("mobileProvider")) {
		} else if (qName.equals("tariffs")) {
		} else if (qName.equals("tariffForInternet")) {
			tempInternetTariffs = TariffForInternet.getInstance();
			listOftempTariff = new ArrayList<Tariff>();
		} else if (qName.equals("tariffForCalls")) {
			tempCallsTariffs = TariffForCalls.getInstance();
			listOftempTariff = new ArrayList<Tariff>();
		} 
		else if (qName.equals("tariff")) {
			tempTariff = new Tariff();
		} else if (qName.equals("call-prices")) {
			callPricesType = new CallPricesTypes();
			callsPrice = new ArrayList<CallPrices>();
		} else if (qName.equals("prices")) {
			tempCallPrice = new CallPrices();
			
			if (atts.getLocalName(0).equals("id")) {
				tempCallPrice.setId(Byte.parseByte(atts.getValue(0)));
			} else if (atts.getLocalName(1).equals("id")) {
				tempCallPrice.setId(Byte.parseByte(atts.getValue(1)));
			} else if (atts.getLocalName(2).equals("id")) {
				tempCallPrice.setId(Byte.parseByte(atts.getValue(2)));
			}
			if (atts.getLocalName(0).equals("name")) {
				tempCallPrice.setName(atts.getValue(0));
			} else if (atts.getLocalName(1).equals("name")) {
				tempCallPrice.setName(atts.getValue(1));
			} else if (atts.getLocalName(2).equals("name")) {
				tempCallPrice.setName(atts.getValue(2));
			}
			if (atts.getLocalName(0).equals("cost")) {
				tempCallPrice.setCost(Double.parseDouble(atts.getValue(0)));
			} else if (atts.getLocalName(1).equals("cost")) {
				tempCallPrice.setCost(Double.parseDouble(atts.getValue(1)));
			} else if (atts.getLocalName(2).equals("cost")) {
				tempCallPrice.setCost(Double.parseDouble(atts.getValue(2)));
			}
		} else if (qName.equals("parameters")) {
			parameter = new Parameters();
		} else {
			tempEnum = TariffsEnum.valueOf(qName.replace('-', '_').toUpperCase());
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("tariffForInternet")) {
			tempInternetTariffs.setListOfTariff(listOftempTariff);
		} else if (qName.equals("tariffForCalls")) {
			tempCallsTariffs.setListOfTariff(listOftempTariff);
		}
		else if (qName.equals("tariff")) {
			listOftempTariff.add(tempTariff);
		} else if (qName.equals("call-prices")) {
			callPricesType.setPrices(callsPrice);
			tempTariff.setCallPrices(callPricesType);
		} else if (qName.equals("prices")) {
			callsPrice.add(tempCallPrice);
		} else if (qName.equals("parameters")) {
			tempTariff.setParameters(parameter);
		} 
		tempEnum = null;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String s = new String(ch, start, length).trim();
		if (tempEnum == null)
			return;
		switch (tempEnum) {
		case NAME:
			tempTariff.setName(s);
			break;
			
		case OPERATOR_NAME:
			tempTariff.setOperatorName(s);
			break;
			
		case PAYROLL:
			tempTariff.setPayroll(Double.parseDouble(s));
			break;
		case SMS_PRICE:
			tempTariff.setSmsPrice(Double.parseDouble(s));
			break;
			
		case FREE_GYGABYTES:
			tempTariff.setFreeGygabytes(Double.parseDouble(s));
			break;
			
		case FREE_MINUTES:
			tempTariff.setFreeMinutes(Integer.parseInt(s));
			break;
			
		case FAVOURITE_NUMBER:
			parameter.setFavouriteNumber(Double.parseDouble(s));
			break;
			
		case SUBSCRIBE_COST:
			parameter.setSubscribeCost(Double.parseDouble(s));
			break;
			
		case TARIFFICATION:
			parameter.setTariffication(s);
			break;
			
		default:
			break;
		}
	}
	
	public void warning(SAXParseException ex) {
		System.err.println("Warning: " + ex);
		System.err.println("line = " + ex.getLineNumber() + "  col = "
				+ ex.getColumnNumber());
	}

	// Method for the messages about parsing errors
	public void error(SAXParseException ex) {
		System.err.println("Error: " + ex);
		System.err.println("line = " + ex.getLineNumber() + "  col = "
				+ ex.getColumnNumber());
	}

	// Method for the messages about parsing fatalErrors
	public void fatalError(SAXParseException ex) {
		System.err.println("Fatal error: " + ex);
		System.err.println("line = " + ex.getLineNumber() + "  col = "
				+ ex.getColumnNumber());
	}
}
