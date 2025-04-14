//package com.cvs.csa.javamapping.si001;
package com.cvs.pos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.AbstractTransformation;
import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mapping.api.TransformationInput;
import com.sap.aii.mapping.api.TransformationOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException; //import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import org.xml.sax.SAXException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//RT10
//..RT11
//....RT28
//....RT6220
//....RT62091
//....RT62092
//....RT62093
//
//..RT6201
//..RT62121
//..RT62122
//..RT12

public class SplitDelimitedInputRecords extends AbstractTransformation {

	private  XmlUtil xUtil;
	private  Document docOutput = null;

	private  Element rt10 = null;
	private  Element rt11 = null;
	private  Element rt28 = null;
	private  Element rt6220 = null;
	private  Element rt6220A = null;
	private  Element rt62091 = null;
	private  Element rt62092 = null;
	private  Element rt62093 = null;
	private  Element rt62121 = null;
	private  Element rt62122 = null;
	private  Element rt6201 = null;
	private  Element rt12 = null;
	public boolean traceon = false; // For testing adhoc
	public  AbstractTrace trace;

	@Override
	public void transform(TransformationInput arg0, TransformationOutput arg1)
			throws StreamTransformationException {
		trace = (AbstractTrace) getTrace();
		try {
			this.execute((InputStream) arg0.getInputPayload().getInputStream(),
					(OutputStream) arg1.getOutputPayload().getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute(InputStream in, OutputStream out)
			throws StreamTransformationException, IOException {
		/**
		 * Step 0: Initialization of variables
		 */
		xUtil = new XmlUtil();
		String recType = null;
		String subType = null;
		String miniType = null;
		List<Integer> rt10List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 5, 10, 4,
				4, 10, 2, 11);
		String[] rt10Tags = { "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah",
				"ai", "aj", "ak", "al", "am", "an" };

		String[] rt11Tags = { "ba", "bb", "bc", "bd", "be", "bf", "bg", "bh",
				"bi", "bj", "bk", "bl", "bm", "bn", "bo", "bp", "bq" };
		List<Integer> rt11List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 12, 12,
				1, 16, 4, 4, 7, 16, 2, 11);

		String[] rt28Tags = { "da", "db", "dc", "dd", "de", "df", "dg", "dh",
				"di", "dj", "dk" };
		List<Integer> rt28List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 6, 7, 7,
				2);

		String[] rt6220Tags = { "ha", "hb", "hc", "hd", "he", "hf", "hg", "ho",
				"hh", "hi", "hj", "hk", "hl", "hm", "hn", "ht", "hp", "hq", "hr", "hs" };
		List<Integer> rt6220List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 17,
				9, 1, 1, 1, 5, 8, 1, 5, 8, 8, 8);
		
		String[] rt6220ATags = { "ma", "mb", "mc", "md", "me", "mf", "mg", "mh",
				"mi", "mj" };
		List<Integer> rt6220AList = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 25,
				40);

		String[] rt62091Tags = { "ia", "ib", "ic", "id", "ie", "if", "ig",
				"ih", "iq", "ii", "ij", "ik", "il", "im", "in", "io", "ip" };
		List<Integer> rt62091List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 1,
				1, 7, 8, 20, 3, 1, 1, 3);

		String[] rt62092Tags = { "ja", "jb", "jc", "jd", "je", "jf", "jg",
				"jh", "jl", "ji", "jj", "jk" };
		List<Integer> rt62092List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 1,
				8, 18, 3);

		String[] rt62093Tags = { "ka", "kb", "kc", "kd", "ke", "kf", "kg",
				"kh", "kp", "ki", "kj", "kk", "kl", "km", "kn", "ko" };
		List<Integer> rt62093List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 1,
				1, 8, 18, 7, 7, 1, 3);

		String[] rt62121Tags = { "fa", "fb", "fc", "fd", "fe", "ff", "fg",
				"fh", "fu", "fi", "fj", "fk", "fl", "fm", "fn", "fo", "fp",
				"fq", "fr", "fs", "ft" };
		List<Integer> rt62121List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 1,
				5, 10, 4, 2, 6, 4, 6, 1, 1, 1, 4, 1);

		String[] rt62122Tags = { "ga", "gb", "gc", "gd", "ge", "gf", "gg",
				"gh", "gk", "gi", "gj" };
		List<Integer> rt62122List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 1,
				16, 17);

		String[] rt6201Tags = { "ea", "eb", "ec", "ed", "ee", "ef", "eg", "eh",
				"ei", "ej", "ek", "el" };
		List<Integer> rt6201List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 2, 5,
				4, 3, 6);

		String[] rt12Tags = { "ca", "cb", "cc", "cd", "ce", "cf", "cg", "ch",
				"ci", "cj", "ck", "cl" };
		List<Integer> rt12List = Arrays.asList(5, 10, 4, 4, 10, 4, 2, 8, 5, 9,
				9, 12);

		/**
		 * 4: Create an instance of NEW document output using DOM factory
		 * methods
		 */
		
		
		
		try {
			docOutput = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		//// same code can written as below
		//// Create a DocumentBuilder
        // DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder builder = factory.newDocumentBuilder();
        // Create a new Document
        //Document document = builder.newDocument();

		
		
		if (traceon) {
			trace.addInfo("06 of 14-Created new instance of Output document");
		}
		/**
		 * 5: Create root element with Namespace
		 */
		Element rootElement = docOutput.createElementNS(
				"urn:CVSHealth.com:SI001:MFS:weCareTargetTlog",
				"ns:weCareTargetTlogMfs");
		docOutput.appendChild(rootElement);
		if (traceon) {
			trace.addInfo("07 of 14-Appended root node with Namespace...");
		}
		/**
		 * 6: For every row, check the Node Type and create respective structure
		 */
		if (traceon) {
			trace.addInfo("08 of 14-for every row... ");
		}
		String rowContent = null;
		BufferedReader bfR = new BufferedReader(new InputStreamReader(in));

		while ((rowContent = bfR.readLine()) != null) {

			/**
			 * 9: Get the record Types for weCare Target with 2 characters, 4
			 * characters and 5 characters
			 */
			String[] rowVals = rowContent.split("\\|");

			recType = rowVals[6];
			subType = rowVals[7];
			miniType = rowVals[8];
			/**
			 * 10: Check for each record Type. Create record type node. Also
			 * create all elements for the record
			 */
			if (recType.equals("10")) {
				rt10 = xUtil.createNode(docOutput, "RT10");
				rootElement.appendChild(rt10);

				generateXML(docOutput, rt10, "RT10", rt10List, rt10Tags,
						rowVals);
				if (traceon) {
					trace.addInfo("RT10 is complete");
				}
			} else if (recType.equals("11")) {
				rt11 = xUtil.createNode(docOutput, "RT11");
				rt10.appendChild(rt11);

				generateXML(docOutput, rt11, "RT11", rt11List, rt11Tags,
						rowVals);
			} else if (recType.equals("28")) {
				rt28 = xUtil.createNode(docOutput, "RT28");
				rt11.appendChild(rt28);

				generateXML(docOutput, rt28, "RT28", rt28List, rt28Tags,
						rowVals);
			} else if (recType.equals("62") && subType.equals("20")) {
				rt6220 = xUtil.createNode(docOutput, "RT6220");
				rt11.appendChild(rt6220);

				generateXML(docOutput, rt6220, "RT6220", rt6220List,
						rt6220Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("20A")) {
				rt6220A = xUtil.createNode(docOutput, "RT6220A");
				rt11.appendChild(rt6220A);

				generateXML(docOutput, rt6220A, "RT6220A", rt6220AList,
						rt6220ATags, rowVals);
			} else if (recType.equals("62") && subType.equals("09")
					&& miniType.equals("1")) {
				rt62091 = xUtil.createNode(docOutput, "RT62091");
				rt11.appendChild(rt62091);

				generateXML(docOutput, rt62091, "RT62091", rt62091List,
						rt62091Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("09")
					&& miniType.equals("2")) {
				rt62092 = xUtil.createNode(docOutput, "RT62092");
				rt11.appendChild(rt62092);

				generateXML(docOutput, rt62092, "RT62092", rt62092List,
						rt62092Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("09")
					&& miniType.equals("3")) {
				rt62093 = xUtil.createNode(docOutput, "RT62093");
				rt11.appendChild(rt62093);

				generateXML(docOutput, rt62093, "RT62093", rt62093List,
						rt62093Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("12")
					&& miniType.equals("1")) {
				rt62121 = xUtil.createNode(docOutput, "RT62121");
				rt10.appendChild(rt62121);

				generateXML(docOutput, rt62121, "RT62121", rt62121List,
						rt62121Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("12")
					&& miniType.equals("2")) {
				rt62122 = xUtil.createNode(docOutput, "RT62122");
				rt10.appendChild(rt62122);

				generateXML(docOutput, rt62122, "RT62122", rt62122List,
						rt62122Tags, rowVals);
			} else if (recType.equals("62") && subType.equals("01")) {
				rt6201 = xUtil.createNode(docOutput, "RT6201");
				rt10.appendChild(rt6201);

				generateXML(docOutput, rt6201, "RT6201", rt6201List,
						rt6201Tags, rowVals);
			} else if (recType.equals("12")) {
				rt12 = xUtil.createNode(docOutput, "RT12");
				rt10.appendChild(rt12);

				generateXML(docOutput, rt12, "RT12", rt12List, rt12Tags,
						rowVals);
			}
		}
		bfR.close();

		/**
		 * 10: write the converted xml to output payload
		 */
		if (traceon) {
			trace.addInfo("09 of 14-Using Transformer Class...");
		}
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e2) {
			e2.printStackTrace();
		}
		if (traceon) {
			trace.addInfo("10 of 14- Create..StreamResult");
		}
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(docOutput);
		if (traceon) {
			trace.addInfo("11 of 14-Created DOM Source.....");
		}
		try {
			transformer.transform(source, result);
			if (traceon) {
				trace.addInfo("12 of 14-Transform: Source - Result");
			}
		} catch (TransformerException e1) {
			e1.printStackTrace();
		}

		try {
			if (traceon) {
				trace
						.addInfo("13 of 14-Before Wirting to output Payload with format UTF-8");
			}
			out.write(new String(result.getWriter().toString())
					.getBytes("UTF-8"));
			if (traceon) {
				trace
						.addInfo("14 of 14-Written to Output Payload with format UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 12: Method to Split rowContent into row elements and append to the parent
	 * node
	 * 
	 * @param docOutput
	 * @param child
	 *            - Node
	 * @param childName
	 *            - Node Name
	 * @param sizeList
	 *            - Sizes of fields in record - Array List
	 * @param tagNames
	 *            - Names of elements - Array of string
	 * @param rowVals
	 */
	private  void generateXML(Document docOutput, Element child,
			String childName, List<Integer> sizeList, String[] tagNames,
			String[] rowVals) {

		Element childData = null;

		int index = 0;

		index = 0;

		for (String tagName : tagNames) {
			childData = xUtil.createNode(docOutput, tagName, rowVals[index]);
			child.appendChild(childData);

			index += 1;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// This method is executed only on the local running and no effect
		// running from PI mapping program
		try {
			FileInputStream fin = new FileInputStream(
					"C:/Java/Data/wecare_trn.txt" );
			        
			FileOutputStream fout = new FileOutputStream(
					"C:/Java/Data/wecare_trn_out.xml");

			SplitDelimitedInputRecords instance = new SplitDelimitedInputRecords();
			// instance.traceon = false; //This will help to print the output
			// instead of trace.
			instance.execute(fin, fout);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (StreamTransformationException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
