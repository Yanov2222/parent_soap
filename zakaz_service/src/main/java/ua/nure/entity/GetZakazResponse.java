//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.16 at 01:00:20 AM EET 
//


package ua.nure.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="zakaz" type="{http://spring.io/guides/gs-producing-web-service}zakaz"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zakaz"
})
@XmlRootElement(name = "getZakazResponse")
public class GetZakazResponse {

    @XmlElementWrapper
    @XmlElement(required = true)
    protected List<Zakaz> zakaz;

    /**
     * Gets the value of the zakaz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zakaz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZakaz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zakaz }
     * 
     * 
     */
    public List<Zakaz> getZakaz() {
        if (zakaz == null) {
            zakaz = new ArrayList<Zakaz>();
        }
        return this.zakaz;
    }

    public void setZakaz(List<Zakaz> list){
        this.zakaz = list;
    }
}
