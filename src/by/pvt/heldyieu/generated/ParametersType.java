//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 01:24:28 AM MSK 
//


package by.pvt.heldyieu.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="favourite-number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tariffication">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="12sec"/>
 *               &lt;enumeration value="60sec"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="subscribe-cost" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametersType", propOrder = {
    "favouriteNumber",
    "tariffication",
    "subscribeCost"
})
public class ParametersType {

    @XmlElement(name = "favourite-number")
    protected int favouriteNumber;
    @XmlElement(required = true)
    protected String tariffication;
    @XmlElement(name = "subscribe-cost")
    protected double subscribeCost;

    /**
     * Gets the value of the favouriteNumber property.
     * 
     */
    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    /**
     * Sets the value of the favouriteNumber property.
     * 
     */
    public void setFavouriteNumber(int value) {
        this.favouriteNumber = value;
    }

    /**
     * Gets the value of the tariffication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffication() {
        return tariffication;
    }

    /**
     * Sets the value of the tariffication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffication(String value) {
        this.tariffication = value;
    }

    /**
     * Gets the value of the subscribeCost property.
     * 
     */
    public double getSubscribeCost() {
        return subscribeCost;
    }

    /**
     * Sets the value of the subscribeCost property.
     * 
     */
    public void setSubscribeCost(double value) {
        this.subscribeCost = value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParametersType [favouriteNumber=" + favouriteNumber
				+ ", tariffication=" + tariffication + ", subscribeCost="
				+ subscribeCost + "]";
	}
    
}
