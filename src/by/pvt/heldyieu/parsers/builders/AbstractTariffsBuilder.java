package by.pvt.heldyieu.parsers.builders;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.ParserConfigurationException;

import by.pvt.heldyieu.generated.TariffForCallsType;
import by.pvt.heldyieu.generated.TariffForInternetType;

public abstract class AbstractTariffsBuilder {
	
	    protected TariffForInternetType tariffForInternet;
	    protected TariffForCallsType tariffForCalls;
	
	public AbstractTariffsBuilder(){
		tariffForInternet = new TariffForInternetType();
	}
	
	/**
	 * @param humanEatings
	 */
//	public AbstractTariffsBuilder(List<HumanEatings> humanEatings) {
//		super();
//		this.humanEatings = humanEatings;
//	}
//
//	public List<HumanEatings> getHumanEatings(){
//		return humanEatings;
//		
//	}
//	
//	abstract public List<HumanEatings> buildListHumanEatings(String fileName) throws ParserConfigurationException;
}