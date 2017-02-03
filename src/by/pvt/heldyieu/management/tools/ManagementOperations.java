package by.pvt.heldyieu.management.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.builders.AbstractTariffsBuilder;
import by.pvt.heldyieu.parsers.factory.TariffsParserBuilderFactory;

public class ManagementOperations implements Constants{

	private static final Logger logger = Logger.getLogger(ManagementOperations.class.getName());
	private static TariffForCalls tariffForCalls = null;
	private static TariffForInternet tariffForInternet = null;
	private static AbstractTariffsBuilder tariffBuilder = null;
	private static TariffsParserBuilderFactory builderFactory = new TariffsParserBuilderFactory();
	private static Scanner input = new Scanner(System.in, "utf-8");
	
	public static void ReportTariffsCompareByPayroll(
		TariffForCalls tariffForCalls, TariffForInternet tariffForInternet) {
		System.out.println(MESSAGE_SORT_LIST.toUpperCase());
		List<Tariff> tempTariffs = new ArrayList<Tariff>();
		tempTariffs.addAll(tariffForCalls.getListOfTariff());
		tempTariffs.addAll(tariffForInternet.getListOfTariff());
		Collections.sort(tempTariffs, new Tariff());
		tempTariffs.forEach(item->System.out.println(item));
	}

	public static int inputNumber() {
		int choice = -1;
		while (true) {
			try {
				input = new Scanner(System.in, "utf-8");
				choice = input.nextInt();
				if (choice >= 0) {
					break;
				} else {
					System.out.println(INCORRECT_INPUT_VALUE_FOR_SCANNER);
				}
			} catch (InputMismatchException e) {
				System.out.println(MYSMATCH_TYPE_INPUT_VALUE_FOR_SCANNER);
				logger.info(e.getMessage());
			}
		}
		return choice;
	}

	public static void parseWithDOMParser() {
		
			try {
				logger.info("Try to make TariffsDOMBuilder");
				tariffBuilder = builderFactory.createTariffsBuilder(TYPE_DOM_PARSER);
				System.out.println(START_PARSE_DOMBUILDER);
				logger.info("Parsing xml with TariffsDOMBuilder");
				tariffBuilder.buildTariffs(XML_FILENAME);
				logger.info("get TariffForCalls instance after parsing"); 
				tariffForCalls = tariffBuilder.getTariffForCalls();
				System.out.println(tariffForCalls.toString());
				logger.info("print list tariffs of TariffsForCalls"); 
				tariffForCalls.getListOfTariff().forEach(item -> System.out.println(item));
				logger.info("get TariffForInternet instance after parsing"); 
				tariffForInternet = tariffBuilder.getTariffForInternet();
				System.out.println(tariffForInternet.toString());
				logger.info("print list tariffs of TariffForInternet"); 
				tariffForInternet.getListOfTariff().forEach(item -> System.out.println(item));
				System.out.println(END_DOM_PARSER);
			} catch (InvalidValueException e) {
				logger.info(e.getMessage());
			}
	}

	public static void parseWithSAXParser() {
		
			try {
				logger.info("Try to make TariffsSAXBuilder");
				tariffBuilder = builderFactory.createTariffsBuilder(TYPE_SAX_PARSER);
				System.out.println(START_PARSE_SAXBUILDER);
				logger.info("Parsing xml with TariffsSAXBuilder");
				tariffBuilder.buildTariffs(XML_FILENAME);
				logger.info("get TariffForCalls instance after parsing"); 
				tariffForCalls = tariffBuilder.getTariffForCalls();
				System.out.println(tariffForCalls.toString());
				logger.info("print list tariffs of TariffsForCalls"); 
				tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
				logger.info("get TariffForInternet instance after parsing"); 
				tariffForInternet = tariffBuilder.getTariffForInternet();
				System.out.println(tariffForInternet.toString());
				logger.info("print list tariffs of TariffForInternet"); 
				tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
				System.out.println(END_SAX_PARSER);
			} catch (InvalidValueException e) {
				logger.info(e.getMessage());
			}
	}
}
