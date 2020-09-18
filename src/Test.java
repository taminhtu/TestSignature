import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.CertificateInfo;
import com.itextpdf.text.pdf.security.PdfPKCS7;

public class Test {
	public static void main(String[] args) {
		try {
		String filePath = "/Users/tutm/Work/2020/TCB/Omni_Channel/Study/Spring_Microservices/TestSignature/blank_signed.pdf";
		File file = new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		PdfReader reader = new PdfReader(fis);
//		AcroFields af = reader.getAcroFields();
//		ArrayList<String> names = af.getSignatureNames();
		
		java.lang.reflect.Field algorithmNamesField = com.itextpdf.text.pdf.security.EncryptionAlgorithms.class.getDeclaredField("algorithmNames");
		algorithmNamesField.setAccessible(true);
		@SuppressWarnings("unchecked")
		HashMap<String, String> algorithmNames = (HashMap<String, String>) algorithmNamesField.get(null);
		algorithmNames.put("1.2.840.10045.4.3.2", "ECDSA");
		
//		PdfReader reader = new PdfReader(resource);
		AcroFields acroFields = reader.getAcroFields();

		List<String> names = acroFields.getSignatureNames();
		for (String name : names) {
		   System.out.println("Signature name: " + name);
		   System.out.println("Signature covers whole document: " + acroFields.signatureCoversWholeDocument(name));
		   System.out.println("Document revision: " + acroFields.getRevision(name) + " of " + acroFields.getTotalRevisions());
//		   PdfPKCS7 pk = acroFields.verifySignature(name);
//		   System.out.println("Subject: " + CertificateInfo.getSubjectFields(pk.getSigningCertificate()));
//		   System.out.println("Document verifies: " + pk.verify());
		}
		
//		acroFields.get
		
//		acroFields.get
		
//		KeyStore kall = PdfPKCS7.loadCacertsKeyStore();
//		PdfReader reader = new PdfReader("my_signed_doc.pdf");
//		AcroFields af = reader.getAcroFields();
//		ArrayList names = af.getSignatureNames();
//		for (int k = 0; k < names.size(); ++k) {
//		    String name = (String)names.get(k);
//		    System.out.println("Signature name: " + name);
//		    System.out.println("Signature covers whole document: " + af.signatureCoversWholeDocument(name));
//		    PdfPKCS7 pk = af.verifySignature(name);
//		    Calendar cal = pk.getSignDate();
//		    Certificate pkc[] = pk.getCertificates();
////		    System.out.println("Subject: " + PdfPKCS7.getSubjectFields(pk.getSigningCertificate()));
//		    System.out.println("Document modified: " + !pk.verify());
////		    Object fails[] = PdfPKCS7.verifyCertificates(pkc, kall, null, cal);
////		    if (fails == null)
////		        System.out.println("Certificates verified against the KeyStore");
////		    else
////		        System.out.println("Certificate failed: " + fails[1]);
//		}
		
		
//		KeyStore kall = KCS7.loadloadCacertsKeyStore();
//		PdfReader reader = new PdfReader("my_signed_doc.pdf");
//		AcroFields af = reader.getAcroFields();
//		ArrayList names = af.getSignatureNames();
		
//		AcroFields acroFields = reader.getAcroFields();
//	    List<String> names = acroFields.getSignatureNames();
//
//	    for (String name: names)
//	    {
//	        PdfPKCS7 pdfPkcs7 = acroFields.verifySignature(name);
//	        pdfPkcs7.verify();
//
//	        Field digestAttrField = PdfPKCS7.class.getDeclaredField("digestAttr");
//	        digestAttrField.setAccessible(true);
//	        byte[] digestAttr = (byte[]) digestAttrField.get(pdfPkcs7);
//
//	        // process the digest value in digestAttr 
//	    }
		
//		for (int k = 0; k < names.size(); ++k) {
//		  String name = (String)names.get(k);
//		  System.out.println("Signature name: " + name);
//		  System.out.println("Signature covers whole document: " + af.signatureCoversWholeDocument(name));
//		  PdfPKCS7 pk = af.verifySignature(name);
//		  Calendar cal = pk.getSignDate();
//		  Certificate pkc[] = pk.getCertificates();
//		  System.out.println("Subject: " + PdfPKCS7.class .getSubjectFields(pk.getSigningCertificate()));
//		  System.out.println("Document modified: " + !pk.verify());
//		  Object fails[] = PdfPKCS7.verifyCertificates(pkc, kall, null, cal);
//		  if (fails == null)
//		    System.out.println("Certificates verified against the KeyStore");
//		  else
//		    System.out.println("Certificate failed: " + fails[1]);
//		}
		
//		PdfPKCS7 pdfPkcs7 = af.verifySignature(name);
//		pdfPkcs7.verify();
//
//		Field digestField = PdfPKCS7.class.getDeclaredField("digest");
//		digestField.setAccessible(true);
//		byte[] digest = (byte[]) digestField.get(pdfPkcs7);
//		
//
//		SimpleDateFormat sdf = new SimpleDateFormat(
//		                    "dd/MM/yyyy 'a las' HH:mm:ss");
//
//		for (int i = 0; i < names.size(); ++i) {
//
//		    StringBuilder sb = new StringBuilder();
//		    String name = names.get(i);
//		    PdfPKCS7 pk = af.verifySignature(name);
//
//		    String firmante = CertificateInfo.getSubjectFields(
//		            pk.getSigningCertificate()).getField("CN");
//		    sb.append("Nombre del firmante: " + firmante + "\n");
//
//		    Date signDate = pk.getSignDate().getTime();
//		    String sdate = sdf.format(signDate);
//		    sb.append("Fecha y hora de la firma: " + sdate + "\n");
//
//
//		    String razon = pk.getReason();
//		    sb.append("proposito: " + razon + "\n");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}