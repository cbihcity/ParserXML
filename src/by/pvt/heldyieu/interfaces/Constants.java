package by.pvt.heldyieu.interfaces;


public interface Constants {
	String DELIMITER= "====================";
	String TARIFF_FOR_INTERNET= "tariffForInternet";
	String TARIFF_FOR_CALLS= "tariffForCalls";
	String XML_FILENAME= "src\\by\\pvt\\heldyieu\\xml\\tariffs.xml";
	String XSD_FILNAME= "src\\by\\pvt\\heldyieu\\xml\\tariffs.xsd";
	String LOG_FILENAME= "src\\by\\pvt\\heldyieu\\log\\log.txt";
	String TYPE_SAX_PARSER= "SAX";
	String TYPE_DOM_PARSER= "DOM";
	String TYPE_STAX_PARSER= "STAX";
	String START_PARSE_DOMBUILDER= "Starting to parse xml with DOMParser....";
	String START_PARSE_SAXBUILDER= "Starting to parse xml with SAXParser....";
	String SAX_ERROR= "Проблема при парсере документа ";
	String IO_ERROR= "Проблема с доступом к ресурсу ";
	String CONFIGURATION_ERROR= "Ошибка конфигурации парсера :";
	String MESSAGE_SORT_LIST= "Отсортированный список тарифов по абонентской плате :";
	String END_DOM_PARSER= "PARSING XML WITH DOMPARSER IS FINISHED\n"+DELIMITER;
	String END_SAX_PARSER= "PARSING XML WITH SAXPARSER IS FINISHED\n"+DELIMITER;

}
