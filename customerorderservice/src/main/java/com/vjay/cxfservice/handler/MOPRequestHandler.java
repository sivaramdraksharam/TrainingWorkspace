package com.vjay.cxfservice.handler;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.vjay.cxfservice.exception.BusinessException;
import com.vjay.cxfservice.util.ParseSoapBody;


public class MOPRequestHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean result = false;
		boolean isResponse = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (!isResponse) {
			System.out.println("Logging Input Request :");
			SOAPMessage message = null;
			try {
				message = context.getMessage();
				result = validateSecurehash(message);
				if(!result)
					throw new BusinessException("Securehash mismatch");
				
			} catch (BusinessException e) {
				SOAPFault soapFault = null;
				try {
					soapFault = message.getSOAPBody().addFault();
					soapFault.setFaultString(e.getMessage());
					throw new SOAPFaultException(soapFault);
				} catch (SOAPException e1) {
					e1.printStackTrace();
				}
				System.out.println("Runtime Excpetion:" + e.getMessage());
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	private boolean validateSecurehash(SOAPMessage message) throws SOAPException, BusinessException {
		boolean result = false;
		SOAPBody body = message.getSOAPBody();
		String generatedHashcode = ParseSoapBody.generateHashcode4Request(body);
		SOAPHeader soapHeader = message.getSOAPHeader();
		Iterator<Node> childElements = soapHeader.getChildElements(); 
		boolean found = false;
		while (childElements.hasNext()) {
			
			Node node = childElements.next();
			if ("securehash".equals(node.getLocalName())) {
				found = true;
				String securehash = node.getValue();
				result = securehash.equals(generatedHashcode);
			}
		}
		if (!found)
			throw new BusinessException("Securehash not found");
		return result;
	}
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
