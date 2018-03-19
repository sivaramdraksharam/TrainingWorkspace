
package com.vjay.customerorder.order;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderLine"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lineId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="prdId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="unitSaleprice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderLine", propOrder = {
    "lineId",
    "prdId",
    "quantity",
    "unitSaleprice"
})
public class OrderLine {

    protected int lineId;
    @XmlElement(required = true)
    protected String prdId;
    @XmlElement(name = "Quantity")
    protected int quantity;
    @XmlElement(required = true)
    protected BigDecimal unitSaleprice;

    /**
     * Gets the value of the lineId property.
     * 
     */
    public int getLineId() {
        return lineId;
    }

    /**
     * Sets the value of the lineId property.
     * 
     */
    public void setLineId(int value) {
        this.lineId = value;
    }

    /**
     * Gets the value of the prdId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * Sets the value of the prdId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrdId(String value) {
        this.prdId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitSaleprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitSaleprice() {
        return unitSaleprice;
    }

    /**
     * Sets the value of the unitSaleprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitSaleprice(BigDecimal value) {
        this.unitSaleprice = value;
    }

}
