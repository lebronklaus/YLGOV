package com.ftms.service;

import java.util.List;
import com.ftms.entity.Tiku;

public interface ZuJuanService {
	List<Tiku> getXuanze(String profession,String difficulty,int count);
	List<Tiku> getPanduan(String profession,String difficulty,int count);
}
