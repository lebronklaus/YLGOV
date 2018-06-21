package cn.nwsuaf.gov.test;

import org.hibernate.HibernateException;
import org.junit.Test;

import cn.nwsuaf.gov.service.TraintrainResourceBusinessWithHibernate;

public class TestACrub {
	@Test
	public void dele() throws HibernateException, Exception {
		TraintrainResourceBusinessWithHibernate trb = new TraintrainResourceBusinessWithHibernate();
		System.out.println(trb.getTime());
	}
}
