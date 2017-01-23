package by.pvt.heldyieu.beans.unmarshaller;

import java.io.File;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import by.pvt.heldyieu.beans.generated.MobileProviderType;
import by.pvt.heldyieu.beans.generated.ObjectFactory;
import by.pvt.heldyieu.beans.generated.TariffType;
import by.pvt.heldyieu.beans.generated.TariffsType;

public class UnMarshall {
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
	    
	    //Obtaining all the required data from the JAXB Root class instance.
	    for ( TariffType tariff  : list.tariff){
	    	System.out.println("name: "+tariff.getName());
	    	System.out.println("operatorName: "+tariff.getOperatorName());
	    	System.out.println("payroll: "+tariff.getPayroll());
	    	System.out.println("smsPrice: "+tariff.getSmsPrice());
	    	tariff.getCallPrices().getPrices().forEach(item->System.out.println(item.getName() + " "+ item.getCost()));
	    	System.out.println("Favourite numbers: "+tariff.getParameters().getFavouriteNumber());
	    	System.out.println("SubscribeCost: "+tariff.getParameters().getSubscribeCost());
	    	System.out.println("Tariffication: "+tariff.getParameters().getTariffication());
	    	System.out.println("=============================");
	    }   
	  }
}
