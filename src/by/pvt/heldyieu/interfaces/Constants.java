package by.pvt.heldyieu.interfaces;

public interface Constants {
	int CHOICE_1 = 1;
	int CHOICE_2 = 2;
	int CHOICE_3 = 3;
	int CHOICE_4 = 4;
	int CHOICE_5 = 5;
	int CHOICE_0 = 0;
	String TARIFF_FOR_CALLS_CHOICE = "tariffForCalls";
	String TARIFF_FOR_INERNET_CHOICE = "tariffForInternet";
	String DELIMITER = "====================";
	String TARIFF_FOR_INTERNET = "tariffForInternet";
	String TARIFF_FOR_CALLS = "tariffForCalls";
	String XML_FILENAME = "src\\by\\pvt\\heldyieu\\xml\\tariffs.xml";
	String XSD_FILNAME = "src\\by\\pvt\\heldyieu\\xml\\tariffs.xsd";
	String XSL_FILNAME = "src\\by\\pvt\\heldyieu\\xml\\tariffs.xsl";
	String HTML_FILNAME = "src\\by\\pvt\\heldyieu\\xml\\tariffs.html";
	String LOG_FILENAME = "src\\by\\pvt\\heldyieu\\log\\log.txt";
	String TYPE_SAX_PARSER = "SAX";
	String TYPE_DOM_PARSER = "DOM";
	String TYPE_STAX_PARSER = "STAX";
	String START_PARSE_DOMBUILDER = "Starting to parse xml with DOMParser....";
	String START_PARSE_SAXBUILDER = "Starting to parse xml with SAXParser....";
	String SAX_ERROR = "Проблема при парсере документа ";
	String IO_ERROR = "Проблема с доступом к ресурсу ";
	String CONFIGURATION_ERROR = "Ошибка конфигурации парсера :";
	String MESSAGE_SORT_LIST = "Отсортированный список тарифов по абонентской плате :";
	String END_DOM_PARSER = "PARSING XML WITH DOMPARSER IS FINISHED\n" + DELIMITER;
	String END_SAX_PARSER = "PARSING XML WITH SAXPARSER IS FINISHED\n"	+ DELIMITER;
	String END_StAX_PARSER = "PARSING XML WITH StAXPARSER IS FINISHED\n" + DELIMITER;
	String INCORRECT_INPUT_VALUE_FOR_SCANNER = "Неправильно введен номер пункта меню. Повторите ввод";
	String MYSMATCH_TYPE_INPUT_VALUE_FOR_SCANNER = "Неверный тип ввходных данных. Повторите ввод";
	String ERROR_CLOSING_SCANNER = "Произошла ошибка при попытке закрыть поток. ";
	String INVALID_PARSER_PARAMETER = "Неверно задан параметр для создания Парсера ";
	String WORK_IS_DONE = "Работа завершена.\n" + DELIMITER;
	String XML_CONVERT_SUCCESS = "Xml-файл успешно преобразован в html-файл. " + HTML_FILNAME;
	String XML_CONVERT_ERROR = "Ошибка при преобразовании xml-файла";
	String CALLS_TYPES_TOSTRING = "разновидность стоимости звонков :\n";
	String TARIFF_FOR_CALLS_TOSTRING = "\nТарифы для звонков";
	String TARIFF_FOR_INTERNET_TOSTRING = "\nТарифы для интернета";
	String MENU = "Выберите действие:\n"
			+ "1. Проверить валидность xml-файла на основе его xsd схемы\n"
			+ "2. Распарсить xml-файл с помощью DOMParser\n"
			+ "3. Распарсить xml-файл с помощью SAXParser\n"
			+ "4. Распарсить xml-файл с помощью StAXParser\n"
			+ "5. Преобразовать xml-файл в формат НTML, и отсортировать тарифы по абонентской плате\n"
			+ "0. Выход из программы\n"
			+ DELIMITER + "\n";
	
}
