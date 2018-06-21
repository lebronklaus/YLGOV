package com.ftms.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ftms.service.DataAnalysisService;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataAnalysisService service = (DataAnalysisService)ctx.getBean("DataAnalysisService");
//		Certificate c = new Certificate();
//		c.setId(1);
//		c.setMajor("ha2dha");
//		c.setCertificatename("h2idhei");
		System.out.println(service.provinceLegendByCity("北京市"));
//		System.out.println(service.countByProvince());
//		
//		CertificateDAO dao =(CertificateDAO)ctx.getBean("CertificateDAO");
//		System.out.println();
//		
//		Iterator iter = dao.provinceCountByAge("������").iterator();       
//		while (iter.hasNext()) { 
//			System.out.println(iter.next());
//		   Object[] data = (Object[]) iter.next();       
//		   System.out.println(data[0]);      
//		}     
	}
	
}
