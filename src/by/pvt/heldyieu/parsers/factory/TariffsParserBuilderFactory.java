package by.pvt.heldyieu.parsers.factory;

import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.builders.AbstractTariffsBuilder;
import by.pvt.heldyieu.parsers.builders.TariffsDOMBuilder;
import by.pvt.heldyieu.parsers.builders.TariffsSAXBuilder;
import by.pvt.heldyieu.parsers.builders.TariffsStAXBuilder;

public class TariffsParserBuilderFactory implements Constants{
	
	public AbstractTariffsBuilder createTariffsBuilder(String typeParser) throws InvalidValueException{
		switch (typeParser){
		case TYPE_SAX_PARSER:
			return new TariffsSAXBuilder();
		case TYPE_DOM_PARSER:
			return new TariffsDOMBuilder();
		case TYPE_STAX_PARSER:
			return new TariffsStAXBuilder();
		default :
			throw new InvalidValueException("Неверно задан параметр для создания Парсера ", typeParser); 
		}
	}
}
