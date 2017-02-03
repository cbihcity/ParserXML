//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 03:06:42 PM MSK 
//


package by.pvt.heldyieu.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.pvt.heldyieu.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MobileProvider_QNAME = new QName("", "mobileProvider");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.pvt.heldyieu.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MobileProviderType }
     * 
     */
    public MobileProviderType createMobileProviderType() {
        return new MobileProviderType();
    }

    /**
     * Create an instance of {@link TariffForInternetType }
     * 
     */
    public TariffForInternetType createTariffForInternetType() {
        return new TariffForInternetType();
    }

    /**
     * Create an instance of {@link PricesType }
     * 
     */
    public PricesType createPricesType() {
        return new PricesType();
    }

    /**
     * Create an instance of {@link TariffType }
     * 
     */
    public TariffType createTariffType() {
        return new TariffType();
    }

    /**
     * Create an instance of {@link CallPricesType }
     * 
     */
    public CallPricesType createCallPricesType() {
        return new CallPricesType();
    }

    /**
     * Create an instance of {@link TariffForCallsType }
     * 
     */
    public TariffForCallsType createTariffForCallsType() {
        return new TariffForCallsType();
    }

    /**
     * Create an instance of {@link TariffsType }
     * 
     */
    public TariffsType createTariffsType() {
        return new TariffsType();
    }

    /**
     * Create an instance of {@link ParametersType }
     * 
     */
    public ParametersType createParametersType() {
        return new ParametersType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MobileProviderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mobileProvider")
    public JAXBElement<MobileProviderType> createMobileProvider(MobileProviderType value) {
        return new JAXBElement<MobileProviderType>(_MobileProvider_QNAME, MobileProviderType.class, null, value);
    }

}
