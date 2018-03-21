package com.vjay.cxfservice.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.soap.SOAPBody;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseSoapBody {

	public static final String SECRET_KEY = "Fr!d@y";	
	
	
	public static void printSoapBody(SOAPBody body) {
		NodeList nodeList = body.getChildNodes();
		Node firstElement = getFirstElement(nodeList);
		recursiveParseNode(firstElement); 
	}
	
	public static void recursiveParseNode(Node node) {
		StringBuilder builder = new StringBuilder("");
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (item.getLocalName() != null) {
				if (item.getChildNodes().getLength() == 1) {
					builder.append(item.getTextContent());
				} else {
					builder.append(getInputs(item));
				}
			}
		}
		
	}
	
	public static String generateHashcode4Request(SOAPBody body) {
		NodeList nodeList = body.getChildNodes();
		Node firstElement = getFirstElement(nodeList);
		String inputString = getInputs(firstElement);
		System.out.println("Final string:" + inputString);
		String hashcode = generateHashcode4String(inputString+SECRET_KEY);
		System.out.println("Hashccode : " + hashcode); 
		return hashcode;
	}
	
	public static String getInputs(Node node) {
		StringBuilder builder = new StringBuilder("");
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (item.getLocalName() != null) {
				System.out.println("<"+item.getLocalName()+">");	
				if (item.getChildNodes().getLength() == 1) {
					builder.append(item.getTextContent());
					System.out.println(item.getTextContent()); 
				} else {
					builder.append(getInputs(item));
				}
				System.out.println("</"+item.getLocalName()+">");
			}
		}
		return builder.toString();
	}

	/*
	 * public static Object recursiveParseNode(Node node) { NodeList nodeList =
	 * node.getChildNodes(); List<Object> newList = null; Map<String, Object> map =
	 * new LinkedHashMap<>(); for (int i = 0; i < nodeList.getLength(); i++) { Node
	 * item = nodeList.item(i); String nodeName = item.getLocalName();
	 * 
	 * if (item.getLocalName() != null) { Object prvnode = map.get(nodeName);
	 * if(null==prvnode) { System.out.println("parsed node:" + item.getLocalName());
	 * System.out.println("parsed node child len:" +
	 * item.getChildNodes().getLength()); if (item.getChildNodes().getLength() == 1)
	 * { System.out.println("parsed value:" + item.getTextContent());
	 * map.put(item.getLocalName(), item.getTextContent()); } else {
	 * map.put(nodeName, recursiveParseNode(item)); } }else if(prvnode instanceof
	 * List<?>) { System.out.println("Got instance of list"+((List)prvnode));
	 * //((List)prvnode).add(recursiveParseNode(item)); newList = new ArrayList();
	 * newList.addAll(((List)prvnode)); newList.add(recursiveParseNode(item)); }else
	 * if (prvnode instanceof Map<?, ?>) {
	 * System.out.println("Got instance of map"); newList = new ArrayList();
	 * newList.add(prvnode); newList.add(recursiveParseNode(item)); } } }
	 * //System.out.println("Returning "+map+" or "+newList);
	 * 
	 * if(newList!=null) return newList; else return map;
	 * 
	 * }
	 */
	public static Node getFirstElement(NodeList nodeList) {
		Node firstElement = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (item.getLocalName() != null) {
				System.out.println("First node:" + item.getLocalName());
				firstElement = item;
				System.out.println("First node child len:" + item.getChildNodes().getLength());
				break;
			}

		}
		return firstElement;
	}

	public static String generateHashcode4String(String input) {
		String hexStr = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.reset();
			byte[] buffer = input.getBytes("UTF-8");
			md.update(buffer);
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; i++) {
				hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}
		return hexStr;

	}

}
