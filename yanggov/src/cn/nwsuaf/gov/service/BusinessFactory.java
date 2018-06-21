package cn.nwsuaf.gov.service;

public class BusinessFactory {
	private static TrainTeachersBusiness trainTeacherbusi = null;

	public static TrainTeachersBusiness createTrainTeacherBussiness() {
		if (trainTeacherbusi == null) {
			trainTeacherbusi = new TrainTeachersBusinessWithHibernate();
		}
		return trainTeacherbusi;
	}

	private static TrainBaseBusiness trainBasebusi = null;

	public static TrainBaseBusiness createTrainBaseBussiness() {
		if (trainBasebusi == null) {
			trainBasebusi = new TrainBaseBusinessWithHibernate();
		}
		return trainBasebusi;
	}

	private static TrainResourceBusiness trainResourcbusi = null;

	public static TrainResourceBusiness createTrainResourceBussiness() {
		if (trainResourcbusi == null) {
			trainResourcbusi = new TraintrainResourceBusinessWithHibernate();
		}
		return trainResourcbusi;
	}

}
