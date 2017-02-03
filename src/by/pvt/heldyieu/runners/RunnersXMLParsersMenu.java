package by.pvt.heldyieu.runners;

import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.management.tools.ManagementOperations;
import by.pvt.heldyieu.xml.validatorSAX.ValidatorSAX;

public class RunnersXMLParsersMenu implements Constants {
	public static void main(String[] args) {
			while (true) {
				System.out.println("Выберите действие:\n"
						+ "1. Проверить валидность xml-файла на основе его xsd схемы\n"
						+ "2. Распарсить xml-файл с помощью DOMParser\n"
						+ "3. Распарсить xml-файл с помощью SAXParser\n"
						+ "4. Распарсить xml-файл с помощью StAXParser\n"
						+ "5. Преобразовать xml-файл в формат НTML, и отсортировать тарифы по абонентской плате\n"
						+ "0. Выход из программы\n"
						+ DELIMITER+"\n");
				switch (ManagementOperations.inputNumber()) {
				case 1:
					ValidatorSAX.validateXMLFile();
					break;
					
				case 2:
					ManagementOperations.parseWithDOMParser();
					break;
						
				case 3:
					ManagementOperations.parseWithSAXParser();
					break;
					
				case 4:
					ManagementOperations.parseWithStAXParser();
					break;
					
				case 5:
					break;
					
				case 0:
					System.out.println("Работа завершена.\n"+DELIMITER);
					System.exit(0);;

				default:
					System.out.println(INCORRECT_INPUT_VALUE_FOR_SCANNER);
				}
			}
	}
}
