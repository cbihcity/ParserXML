package by.pvt.heldyieu.parsers.tools;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.interfaces.Constants;

public class OperationsDOMParsers implements Constants {
	public static ArrayList<Tariff> buildTariffsParser(NodeList internetList, String choice) {
		ArrayList<Tariff> tempTariffs = null;
		Element internet = (Element) internetList.item(0);
		NodeList tariffs = internet.getElementsByTagName("tariff");
		tempTariffs = new ArrayList<Tariff>();
		for (int i = 0; i < tariffs.getLength(); i++) {
			Tariff tariff = new Tariff();
			Element tariffElement = (Element) tariffs.item(i);
			tariff.setName(getElementTextContent(tariffElement, "name"));
			tariff.setOperatorName(getElementTextContent(tariffElement, "operator-name"));
			tariff.setPayroll(Double.parseDouble((getElementTextContent(tariffElement, "payroll"))));
			tariff.setSmsPrice(Double.parseDouble((getElementTextContent(tariffElement, "sms-price"))));
			switch (choice) {
			case TARIFF_FOR_INTERNET:
				tariff.setFreeGygabytes(Double.parseDouble((getElementTextContent(tariffElement, "free-gygabytes"))));
				break;

			case TARIFF_FOR_CALLS:
				tariff.setFreeMinutes(Integer.parseInt((getElementTextContent(tariffElement, "free-minutes"))));
				break;
				
			default:
				break;
			}
			List<CallPrices> callsPrice = new ArrayList<CallPrices>();
			NodeList callsPricesList = tariffElement.getElementsByTagName("call-prices");
			Element callsPricesListItem = (Element) callsPricesList.item(0);
			NodeList callsPriceitems = callsPricesListItem.getElementsByTagName("prices");
			for (int j = 0; j < callsPriceitems.getLength(); j++) {
				CallPrices call = new CallPrices();
				Element callElement = (Element) callsPriceitems.item(j);
				call.setId(Byte.parseByte(callElement.getAttribute("id")));
				call.setName(callElement.getAttribute("name"));
				call.setCost(Double.parseDouble(callElement.getAttribute("cost")));
				callsPrice.add(call);
			}
			tariff.setCallPrices(new CallPricesTypes(callsPrice));
			NodeList parametersList = tariffElement.getElementsByTagName("parameters");
			Element parametersItem = (Element) parametersList.item(0);
			Parameters parameter = new Parameters();
			parameter.setFavouriteNumber(Double.parseDouble(getElementTextContent(parametersItem, "favourite-number")));
			parameter.setSubscribeCost(Double.parseDouble(getElementTextContent(parametersItem, "subscribe-cost")));
			parameter.setTariffication(getElementTextContent(parametersItem, "tariffication"));
			tariff.setParameters(parameter);
			tempTariffs.add(tariff);
		}
		return tempTariffs;
	}
	
	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
		}
}
