
package com.vjay.customerorder.order;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderLineInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderLineInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="prdId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="unitSalePrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderLineInfo", propOrder = {
    "prdId",
    "quantity",
    "unitSalePrice"
})
public class OrderLineInfo {

    @XmlElement(required = true)
    protected String prdId;
    protected int quantity;
    @XmlElement(required = true)
    protected BigDecimal unitSalePrice;

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
     * Gets the value of the unitSalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitSalePrice() {
        return unitSalePrice;
    }

    /**
     * Sets the value of the unitSalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitSalePrice(BigDecimal value) {
        this.unitSalePrice = value;
    }

}
