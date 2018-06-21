package com.nwsuaf.mob.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

import com.ftms.entity.Tiku;
import com.ftms.service.ZuJuanService;
import com.nwsuaf.mob.domain.QuesCountScore;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ģ�⿼��
 */
public class MobZuJuanAction extends ActionSupport{
	//ֱ������web�汾��Service��ȡ�Ծ�
	private ZuJuanService zujuanService;
	
	private String profession;
	private String difficulty;
	
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public void setZujuanService(ZuJuanService zujuanService) {
		this.zujuanService = zujuanService;
	}
	/*
	 * �Ծ���Ŀ�����������Լ�ʱ��
	 */
	private QuesCountScore qcs = new QuesCountScore();
	
	public QuesCountScore getQcs() {
		return qcs;
	}

	public void setQcs(QuesCountScore qcs) {
		this.qcs = qcs;
	}
	/*
	 * �Ծ���Ŀ�����շ���json�ַ�
	 */
	private List<Tiku> list;
	
	public List<Tiku> getList() {
		return list;
	}

	public void setList(List<Tiku> list) {
		this.list = list;
	}
	/*
	 * ��ȡ�Ծ�
	 */
	public String getPaper() throws Exception{
		String[] professionarray = {
				"果树嫁接技术","苹果栽培管理技术","猕猴桃栽培管理技术","枣栽培管理技术（冬枣）","核桃栽培管理技术","杂果栽培管理技术（桃、杏、樱桃）",
				"设施蔬菜栽培管理技术",
				"生猪饲养管理技术","奶山羊饲养管理技术","鸡饲养管理技术（肉鸡、蛋鸡）","兔饲养管理技术","牛饲养管理技术（肉牛、奶牛）","动物疫病防治员","动物繁殖员",
				"蔬菜植物保护工","农作物植物保护工","果树植物保护工",
				"农作物种子繁殖员","花卉园艺","绿化种苗工","食用菌培养技术","农村经纪人"
			};
		InputStream in = new FileInputStream( (URLDecoder.decode(this.getClass().getResource("/").getPath(), "UTF-8")+"config.properties"));
		Properties pt=new Properties();
		pt.load(in);
		String mylevel = "初级";
		getCountAndScore();
//		if(new String(difficulty.getBytes("iso8859-1"),"utf-8").equals("农技员")) mylevel="初级";
//		else if(new String(difficulty.getBytes("iso8859-1"),"utf-8").equals("农技师")) mylevel="中级";
//		else if(new String(difficulty.getBytes("iso8859-1"),"utf-8").equals("高级农技师")) mylevel="高级";
		profession = professionarray[Integer.parseInt(profession)];
		if(difficulty.equals("1")) mylevel="初级";
		else if(difficulty.equals("2")) mylevel="中级";
		else if((difficulty.equals("3"))) mylevel="高级";
		else mylevel="初级";
		list = zujuanService.getXuanze(profession,mylevel , Integer.parseInt(qcs.getXuanzecount()));
		list.addAll(zujuanService.getPanduan(profession,mylevel,Integer.parseInt(qcs.getPanduancount())));
		if(list.size()==0){
			list = zujuanService.getXuanze("花卉园艺",mylevel , Integer.parseInt(qcs.getXuanzecount()));
			list.addAll(zujuanService.getPanduan("花卉园艺",mylevel,Integer.parseInt(qcs.getPanduancount())));
		}
		System.out.println(list);
		return SUCCESS;
	}
	/*
	 * ��ȡ�Ծ���Ŀ�����������Լ�ʱ��
	 */
	public String getCountAndScore() throws IOException{
		InputStream in = new FileInputStream( (URLDecoder.decode(this.getClass().getResource("/").getPath(), "UTF-8")+"config.properties"));
		Properties pt=new Properties();
		pt.load(in);
		qcs.setXuanzecount(pt.getProperty("xuanzecount"));
		qcs.setScore_xuanze(pt.getProperty("score_xuanze"));
		qcs.setPanduancount(pt.getProperty("panduancount"));
		qcs.setScore_panduan(pt.getProperty("score_panduan"));
		qcs.setTime(pt.getProperty("time"));
		return SUCCESS;
	}
}
