//package com.cvs.csa.javamapping.si001;
package com.cvs.pos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Vector;
import org.w3c.dom.*;

public class XmlUtil {

	public static final int iALIGN_LEFT = 0;
	public static final int iALIGN_RIGHT = 1;
/**
 * 
 */
	public XmlUtil() {
	}
/**
 * 
 * @param field
 * @param length
 * @param align
 * @param padding
 * @return
 */
	public String formatField(String field, int length, int align, char padding) {
		String sResult = "";
		if (field == null) {
			for (int i = 0; i < length; i++) {
				sResult = (new StringBuilder(String.valueOf(sResult))).append(padding).toString();
			}

		} else if (field.length() >= length) {
			sResult = getLeft(field, length);
		} else {
			int iPadPosition = length - field.length();
			if (align == 1) {
				sResult = field;
				for (int i = 0; i < iPadPosition; i++) {
					sResult = (new StringBuilder(String.valueOf(padding))).append(sResult).toString();
				}

			} else {
				sResult = field;
				for (int i = 0; i < iPadPosition; i++) {
					sResult = (new StringBuilder(String.valueOf(sResult))).append(padding).toString();
				}

			}
		}
		return sResult;
	}
	
/**
 * 
 * @param field
 * @param length
 * @return
 */
	public String getLeft(String field, int length) {
		String sResult = "";
		if (field != null) {
			if (field.length() > length) {
				sResult = field.substring(0, length);
			} else {
				sResult = field;
			}
		}
		return sResult;
	}

	/**
	 * 
	 * @param field
	 * @param length
	 * @return
	 */
	public String getRight(String field, int length) {
		String sResult = "";
		if (field != null) {
			if (field.length() > length) {
				sResult = field.substring(field.length() - length, field.length());
			} else {
				sResult = field;
			}
		}
		return sResult;
	}
/**
 * 
 * @param parent
 * @param name
 * @return
 */
	public Element createNode(Document parent, String name) {
		return createNode(parent, name, null, null, null);
	}
/**
 * 
 * @param parent
 * @param name
 * @param text
 * @return
 */
	public Element createNode(Document parent, String name, String text) {
		return createNode(parent, name, null, null, text);
	}
/**
 * 
 * @param parent
 * @param name
 * @param attname
 * @param attvalue
 * @return
 */
	public Element createNode(Document parent, String name, String attname, String attvalue) {
		return createNode(parent, name, attname, attvalue, null);
	}
/**
 * 
 * @param parent
 * @param name
 * @param attname
 * @param attvalue
 * @param text
 * @return
 */
	public Element createNode(Document parent, String name, String attname, String attvalue, String text) {
		Element eResult = null;
		if (name == null) {
			return eResult;
		}
		eResult = parent.createElement(name);
		if (text != null) {
			eResult.appendChild(parent.createTextNode(text));
		}
		if (attname != null && attvalue != null) {
			eResult.setAttribute(attname, attvalue);
		}
		return eResult;
	}
/**
 * 
 * @param node
 * @param child
 * @return
 */
	public String getChildNodeText(Node node, String child) {
		String sResult = "";
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node tmp = node.getChildNodes().item(i);
			if (tmp.getNodeType() != 1 || !tmp.getNodeName().equals(child)) {
				continue;
			}
			for (int j = 0; j < tmp.getChildNodes().getLength(); j++) {
				Node tmp2 = tmp.getChildNodes().item(j);
				if (tmp2.getNodeType() != 3) {
					continue;
				}
				sResult = tmp2.getNodeValue();
				break;
			}

			break;
		}

		return sResult;
	}
/**
 * 
 * @param node
 * @param child
 * @return
 */
	public Node getFirstChildNode(Node node, String child) {
		Node nResult = null;
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node tmp = node.getChildNodes().item(i);
			if (tmp.getNodeType() != 1 || !tmp.getNodeName().equals(child)) {
				continue;
			}
			nResult = tmp;
			break;
		}

		return nResult;
	}
/**
 * 
 * @param node
 * @param child
 * @return
 */
	public Node[] getChildNodes(Node node, String child) {
		Vector vTmp = new Vector();
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node tmp = node.getChildNodes().item(i);
			if (tmp.getNodeType() == 1 && tmp.getNodeName().equals(child)) {
				vTmp.add(tmp);
			}
		}

		Node nResult[] = new Node[vTmp.size()];
		for (int i = 0; i < vTmp.size(); i++) {
			nResult[i] = (Node) vTmp.get(i);
		}

		vTmp = null;
		return nResult;
	}
/**
 * 
 * @param nodes
 * @param qualfkey
 * @param qualfvalue
 * @param field
 * @return
 */
	public String lookUp(Node nodes[], String qualfkey, String qualfvalue, String field) {
		String sResult = "";
		for (int i = 0; i < nodes.length; i++) {
			if (!getChildNodeText(nodes[i], qualfkey).trim().equals(qualfvalue.trim())) {
				continue;
			}
			sResult = getChildNodeText(nodes[i], field);
			break;
		}

		return sResult;
	}
/**
 * 
 * @param nodes
 * @param qualfkey
 * @param qualfvalue
 * @param field
 * @return
 */
	public String lookUpAndTrim(Node nodes[], String qualfkey, String qualfvalue, String field) {
		String sResult = null;
		for (int i = 0; i < nodes.length; i++) {
			if (!getChildNodeText(nodes[i], qualfkey).trim().equals(qualfvalue.trim())) {
				continue;
			}
			sResult = getChildNodeText(nodes[i], field);
			break;
		}

		return sResult == null ? "" : sResult.trim();
	}
/**
 * 
 * @param nodes
 * @param qualfkeys
 * @param qualfvalues
 * @param field
 * @return
 */
	public String lookUp(Node nodes[], String qualfkeys[], String qualfvalues[], String field) {
		String sResult = "";
		boolean bFound = true;
		if (qualfkeys.length == qualfvalues.length) {
			for (int i = 0; i < nodes.length; i++) {
				for (int j = 0; j < qualfkeys.length; j++) {
					if (!getChildNodeText(nodes[i], qualfkeys[j]).trim().equals(qualfvalues[j].trim())) {
						bFound = false;
						break;
					}
					bFound = true;
				}

				if (!bFound) {
					continue;
				}
				sResult = getChildNodeText(nodes[i], field);
				break;
			}

		}
		return sResult;
	}
/**
 * 
 * @param value
 * @param decimal
 * @return
 */
	public String roundNumber(double value, int decimal) {
		BigDecimal bdDecimal = new BigDecimal(value);
		bdDecimal.setScale(decimal, 6);
		return bdDecimal.toString();
	}
/**
 * 
 * @param value
 * @param integer
 * @param decimal
 * @return
 */
	public String roundNumber(String value, int integer, int decimal) {
		return roundNumber((new Double(value)).doubleValue(), integer, decimal);
	}
/**
 * 
 * @param value
 * @param integer
 * @param decimal
 * @return
 */
	public String roundNumber(double value, int integer, int decimal) {
		String sInteger = "";
		String sDecimal = "";
		BigDecimal bdDecimal = new BigDecimal(value);
		bdDecimal.setScale(2, 6);
		for (int i = 0; i < integer; i++) {
			sInteger = (new StringBuilder(String.valueOf(sInteger))).append("0").toString();
		}

		for (int i = 0; i < decimal; i++) {
			sDecimal = (new StringBuilder(String.valueOf(sDecimal))).append("0").toString();
		}

		DecimalFormatSymbols dfsSymbol = new DecimalFormatSymbols();
		dfsSymbol.setDecimalSeparator('.');
		DecimalFormat dfNumber = new DecimalFormat(
				(new StringBuilder(String.valueOf(sInteger))).append(".").append(sDecimal).toString());
		dfNumber.setDecimalFormatSymbols(dfsSymbol);
		return dfNumber.format(value);
	}
/**
 * 
 * @param yyyymmdd
 * @return
 */
	public String convertDateDDMMYYYY_(String yyyymmdd) {
		return (new StringBuilder(String.valueOf(yyyymmdd.substring(6, 8)))).append(yyyymmdd.substring(4, 6))
				.append(yyyymmdd.substring(0, 4)).toString();
	}
/**
 * 
 * @param ddmmyyyy
 * @return
 */
	public String convertDateYYYYMMDD_(String ddmmyyyy) {
		return (new StringBuilder(String.valueOf(ddmmyyyy.substring(4, 8)))).append(ddmmyyyy.substring(2, 4))
				.append(ddmmyyyy.substring(0, 2)).toString();
	}
}
