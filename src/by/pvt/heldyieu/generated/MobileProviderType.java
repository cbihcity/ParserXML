//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 03:06:42 PM MSK 
//


package by.pvt.heldyieu.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mobileProviderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mobileProviderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tariffs" type="{}tariffsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mobileProviderType", propOrder = {
    "tariffs"
})
public class MobileProviderType {

    @XmlElement(required = true)
    protected TariffsType tariffs;

    /**
     * Gets the value of the tariffs property.
     * 
     * @return
     *     possible object is
     *     {@link TariffsType }
     *     
     */
    public TariffsType getTariffs() {
        return tariffs;
    }

    /**
     * Sets the value of the tariffs property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffsType }
     *     
     */
    public void setTariffs(TariffsType value) {
        this.tariffs = value;
    }

}
