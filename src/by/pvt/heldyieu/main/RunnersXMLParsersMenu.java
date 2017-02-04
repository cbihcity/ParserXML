package by.pvt.heldyieu.main;

import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.management.tools.ManagementOperations;
import by.pvt.heldyieu.xml.validatorSAX.ValidatorSAX;

public class RunnersXMLParsersMenu implements Constants {
	public static void main(String[] args) {
			while (true) {
				System.out.println(MENU);
				switch (ManagementOperations.inputNumber()) {
				case CHOICE_1:
					ValidatorSAX.validateXMLFile();
					break;
					
				case CHOICE_2:
					ManagementOperations.parseWithDOMParser();
					break;
						
				case CHOICE_3:
					ManagementOperations.parseWithSAXParser();
					break;
					
				case CHOICE_4:
					ManagementOperations.parseWithStAXParser();
					break;
					
				case CHOICE_5:
					ManagementOperations.convertXMLtoHTML();
					break;
					
				case CHOICE_0:
					System.out.println(WORK_IS_DONE);
					System.exit(0);;

				default:
					System.out.println(INCORRECT_INPUT_VALUE_FOR_SCANNER);
				}
			}
	}
}
