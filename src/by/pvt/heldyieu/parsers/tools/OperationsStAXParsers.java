package by.pvt.heldyieu.parsers.tools;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.enums.TariffsEnum;
import by.pvt.heldyieu.parsers.enums.XMLTagsEnum;

public class OperationsStAXParsers implements Constants {

	private static final Logger logger = Logger.getLogger(OperationsStAXParsers.class.getName());
	private static List<Tariff> listOfTariff = null;   
	private Tariff tariff = null;
	private Parameters parameter = null;
	private List<CallPrices> callsPrice = null;
	private CallPrices tempCallPrice = null;
	private TariffForInternet currentTariffForInternet = null;
	private TariffForCalls currentTariffForCalls = null;
	private CallPricesTypes callPricesType = null;
	private XMLTagsEnum currentXMLTag = null;
	private TariffsEnum currentXMLTagsWithSimpleValuesEnum = null;
	
	/**
	 * @return the currentTariffForInternet
	 */
	public TariffForInternet getCurrentTariffForInternet() {
		return currentTariffForInternet;
	}

	/**
	 * @return the currentTariffForCalls
	 */
	public TariffForCalls getCurrentTariffForCalls() {
		return currentTariffForCalls;
	}

	public void buildTariffsParser(InputStream input) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			process(reader);
		} catch (XMLStreamException e) {
			System.err.println("XML stream error");
			logger.error("XML stream error", e);
		}

	}	
	
	public void process(XMLStreamReader reader) throws XMLStreamException{
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
			name = reader.getLocalName();
			currentXMLTag = XMLTagsEnum.valueOf(name.toUpperCase().replace('-', '_'));
			
	switch (currentXMLTag) {
				case MOBILEPROVIDER:
					break;
				case TARIFFS:
					break;
				case TARIFFFORINTERNET:
					currentTariffForInternet = TariffForInternet.getInstance();
					listOfTariff = new ArrayList<Tariff>();
					break;
				case TARIFFFORCALLS:
					currentTariffForCalls = TariffForCalls.getInstance();
					listOfTariff = new ArrayList<Tariff>();
					break;
				case TARIFF:
					tariff = new Tariff();
					break;
				case CALL_PRICES:
					callPricesType = new CallPricesTypes();
					callsPrice = new ArrayList<CallPrices>();
					break;
				case PRICES:
					tempCallPrice = new CallPrices();
					if (reader.getAttributeLocalName(0).equals("id")) {
						tempCallPrice.setId(Byte.parseByte(reader
								.getAttributeValue(0)));
					} else if (reader.getAttributeLocalName(1).equals("id")) {
						tempCallPrice.setId(Byte.parseByte(reader
								.getAttributeValue(1)));
					} else if (reader.getAttributeLocalName(2).equals("id")) {
						tempCallPrice.setId(Byte.parseByte(reader
								.getAttributeValue(2)));
					}
					if (reader.getAttributeLocalName(0).equals("name")) {
						tempCallPrice.setName(reader.getAttributeValue(0));
					} else if (reader.getAttributeLocalName(1).equals("name")) {
						tempCallPrice.setName(reader.getAttributeValue(1));
					} else if (reader.getAttributeLocalName(2).equals("name")) {
						tempCallPrice.setName(reader.getAttributeValue(2));
					}
					if (reader.getAttributeLocalName(0).equals("cost")) {
						tempCallPrice.setCost(Double.parseDouble(reader
								.getAttributeValue(0)));
					} else if (reader.getAttributeLocalName(1).equals("cost")) {
						tempCallPrice.setCost(Double.parseDouble(reader
								.getAttributeValue(1)));
					} else if (reader.getAttributeLocalName(2).equals("cost")) {
						tempCallPrice.setCost(Double.parseDouble(reader
								.getAttributeValue(2)));
					}
					break;
				case PARAMETERS:
					parameter = new Parameters();
					break;

				default:
					currentXMLTagsWithSimpleValuesEnum = TariffsEnum
							.valueOf(name.toUpperCase().replace('-', '_'));
					break;
				}
				break;
		

			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				switch (XMLTagsEnum.valueOf(name.toUpperCase()
						.replace('-', '_'))) {

				case TARIFFFORINTERNET:
					currentTariffForInternet.setListOfTariff(listOfTariff);
					break;
				case TARIFFFORCALLS:
					currentTariffForCalls.setListOfTariff(listOfTariff);
					break;
				case TARIFF:
					listOfTariff.add(tariff);
					break;
				case CALL_PRICES:
					callPricesType.setPrices(callsPrice);
					tariff.setCallPrices(callPricesType);
					break;
				case PRICES:
					callsPrice.add(tempCallPrice);
					tariff.setCallPrices(callPricesType);
					break;
				case PARAMETERS:
					tariff.setParameters(parameter);
					break;
				default:
					break;
				}
				currentXMLTagsWithSimpleValuesEnum = null;
				break;
							
		 case XMLStreamConstants.CHARACTERS:
				if (currentXMLTagsWithSimpleValuesEnum == null) {
			break;
				}
	     switch (currentXMLTagsWithSimpleValuesEnum) {
		 case NAME:
				tariff.setName(reader.getText());
			break;
		 case OPERATOR_NAME:
				 tariff.setOperatorName(reader.getText());	 
			break; 
		 case PAYROLL:
		    	 tariff.setPayroll(Double.parseDouble(reader.getText()));	
		    break;
		  case SMS_PRICE:
		    	 tariff.setSmsPrice(Double.parseDouble(reader.getText()));	
		 	break;
		 case FREE_GYGABYTES:
				 tariff.setFreeGygabytes(Double.parseDouble(reader.getText()));	
			break;
	      case FREE_MINUTES:
				tariff.setFreeMinutes(Integer.parseInt(reader.getText()));	
			break;
		   case FAVOURITE_NUMBER:
				parameter.setFavouriteNumber(Double.parseDouble(reader.getText()));
				break;
		   case TARIFFICATION:
				parameter.setTariffication(reader.getText());
				break;
			case SUBSCRIBE_COST:
				parameter.setSubscribeCost(Double.parseDouble(reader.getText()));
				break;			
			default:
				break;	
						}
			}
		}
	}
}
