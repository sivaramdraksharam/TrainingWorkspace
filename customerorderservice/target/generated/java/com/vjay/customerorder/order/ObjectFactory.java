
package com.vjay.customerorder.order;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vjay.customerorder.order package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vjay.customerorder.order
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteOrderRequest }
     * 
     */
    public DeleteOrderRequest createDeleteOrderRequest() {
        return new DeleteOrderRequest();
    }

    /**
     * Create an instance of {@link DeleteOrderResponse }
     * 
     */
    public DeleteOrderResponse createDeleteOrderResponse() {
        return new DeleteOrderResponse();
    }

    /**
     * Create an instance of {@link DeleteOrderLineRequest }
     * 
     */
    public DeleteOrderLineRequest createDeleteOrderLineRequest() {
        return new DeleteOrderLineRequest();
    }

    /**
     * Create an instance of {@link DeleteOrderLineResponse }
     * 
     */
    public DeleteOrderLineResponse createDeleteOrderLineResponse() {
        return new DeleteOrderLineResponse();
    }

    /**
     * Create an instance of {@link GetCustomerOrderRequest }
     * 
     */
    public GetCustomerOrderRequest createGetCustomerOrderRequest() {
        return new GetCustomerOrderRequest();
    }

    /**
     * Create an instance of {@link GetCustomerOrderResponse }
     * 
     */
    public GetCustomerOrderResponse createGetCustomerOrderResponse() {
        return new GetCustomerOrderResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link GetOrderRequest }
     * 
     */
    public GetOrderRequest createGetOrderRequest() {
        return new GetOrderRequest();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link AddOrderRequest }
     * 
     */
    public AddOrderRequest createAddOrderRequest() {
        return new AddOrderRequest();
    }

    /**
     * Create an instance of {@link OrderDetails }
     * 
     */
    public OrderDetails createOrderDetails() {
        return new OrderDetails();
    }

    /**
     * Create an instance of {@link AddOrderResponse }
     * 
     */
    public AddOrderResponse createAddOrderResponse() {
        return new AddOrderResponse();
    }

    /**
     * Create an instance of {@link OrderLineInfo }
     * 
     */
    public OrderLineInfo createOrderLineInfo() {
        return new OrderLineInfo();
    }

    /**
     * Create an instance of {@link OrderLine }
     * 
     */
    public OrderLine createOrderLine() {
        return new OrderLine();
    }

}
