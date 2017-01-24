package by.pvt.heldyieu.xml.unmarshaller;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import by.pvt.heldyieu.generated.MobileProviderType;
import by.pvt.heldyieu.generated.ObjectFactory;
import by.pvt.heldyieu.generated.TariffForCallsType;
import by.pvt.heldyieu.generated.TariffForInternetType;
import by.pvt.heldyieu.generated.TariffType;
import by.pvt.heldyieu.generated.TariffsType;

public class UnMarshallWithXml {
	public static void main(String[] args) throws JAXBException {
	    //1. We need to create JAXContext instance
	    JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

	    //2. Use JAXBContext instance to create the Unmarshaller.
	    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

	    //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
		@SuppressWarnings("unchecked")
		JAXBElement<MobileProviderType> unmarshalledObject = (JAXBElement<MobileProviderType>) 
				unmarshaller.unmarshal(new File("src\\by\\pvt\\heldyieu\\xml\\tariffs.xml"));

	    //4. Get the instance of the required JAXB Root Class from the JAXBElement.
	    MobileProviderType mobileObj = unmarshalledObject.getValue();
	    TariffsType list = mobileObj.getTariffs();
	    TariffForInternetType internet = list.getTariffForInternet();
	    TariffForCallsType calls = list.getTariffForCalls();
	    
	    //Obtaining all the required data from the JAXB Root class instance.
	    for ( TariffType tariff  : internet.getTariff()){
	    	System.out.println("name: "+tariff.getName());
	    	System.out.println("operatorName: "+tariff.getOperatorName());
	    	System.out.println("payroll: "+tariff.getPayroll());
	    	System.out.println("smsPrice: "+tariff.getSmsPrice());
	    	System.out.println("FreeGygabytes: "+tariff.getFreeGygabytes());
	    	tariff.getCallPrices().getPrices().forEach(item->System.out.println(item.getName() + " "+ item.getCost()));
	    	System.out.println("Favourite numbers: "+tariff.getParameters().getFavouriteNumber());
	    	System.out.println("SubscribeCost: "+tariff.getParameters().getSubscribeCost());
	    	System.out.println("Tariffication: "+tariff.getParameters().getTariffication());
	    	System.out.println("=============================");
	    }   
	    for ( TariffType tariff  : calls.getTariff()){
	    	System.out.println("name: "+tariff.getName());
	    	System.out.println("operatorName: "+tariff.getOperatorName());
	    	System.out.println("payroll: "+tariff.getPayroll());
	    	System.out.println("smsPrice: "+tariff.getSmsPrice());
	    	System.out.println("FreeMinutes: "+tariff.getFreeMinutes());
	    	tariff.getCallPrices().getPrices().forEach(item->System.out.println(item.getName() + " "+ item.getCost()));
	    	System.out.println("Favourite numbers: "+tariff.getParameters().getFavouriteNumber());
	    	System.out.println("SubscribeCost: "+tariff.getParameters().getSubscribeCost());
	    	System.out.println("Tariffication: "+tariff.getParameters().getTariffication());
	    	System.out.println("=============================");
	    }   
	  }
}
