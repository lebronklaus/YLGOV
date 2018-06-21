package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import com.lee.mode.KuaiXun;
import com.lee.mode.Message;
import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;

public class SearchAllDao {
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public List<Message> SearchAll(String name) throws Exception{
		List<Message> list = new ArrayList<Message>();
		KuaiXunDAO1 kxd = new KuaiXunDAO1();
		PeiXunDAO1 pxd = new PeiXunDAO1();
		TnewsDAO1 tdd = new TnewsDAO1();
		ZhengCeDAO1 zcd = new ZhengCeDAO1();
		
		List<KuaiXun> list1 = kxd.Search(name);
		for(KuaiXun kx :list1){
			list.add(new Message(kx.getKxid(),kx.getTitle(),1,kx.getDate()));
		}
		list1.clear();
		list1=null;
		List<PeiXun> list2 = pxd.Search(name);
		for(PeiXun px :list2){
			list.add(new Message(px.getDtid(),px.getTitle(),2,px.getDate()));
		}
		list2.clear();
		list2=null;
		
		List<ZhengCe> list3 = zcd.Search(name);
		for(ZhengCe zc:list3){
			list.add(new Message(zc.getZcid(), zc.getTitle(), 3,zc.getDate()));
		}
		list3.clear();
		list3= null;
		
		List<Tnews> list4 = tdd.Search(name);
		for(Tnews tn :list4){
			list.add(new Message(tn.getId(),tn.getTitle(),4,tn.getDate()));
		}
		list4.clear();
		list4 = null;

		return list;
	}
	
	
	public List<Message> findByPage(int pageSize, int pageNow,String name) throws Exception {
		List<Message> page = new ArrayList();
		List<Message> list = this.SearchAll(name);
		int len = list.size();
		if(len !=0){
			int size = len;
			int first = (pageSize * (pageNow - 1))>size?size:(pageSize*(pageNow-1));
			int end = (first+pageSize)>size?size:(first+pageSize);
			page = list.subList(first, end);
		}else if(len==0){
			page = list;
		}
		return page;
	}

	public int getRows(int pageSize,String name) throws Exception {
 		int dataCount = 0;
		int pageCount;
		dataCount = SearchAll(name).size();
		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		return pageCount;
	}

}
