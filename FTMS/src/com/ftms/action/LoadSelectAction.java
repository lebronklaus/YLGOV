package com.ftms.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.entity.Address;
import com.ftms.entity.User;
import com.ftms.service.LocationService;
import com.ftms.service.ProfService;
import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoadSelectAction extends ActionSupport {
private LocationService locationService;
private ProfService profService;
private JSONArray loadJosn;
private JSONArray provinceJSON;
private JSONArray cityJSON;
private JSONArray countyJSON;
private JSONArray townJSON;
private JSONArray prof1JSON;
private JSONArray prof2JSON;
private int prof1id;
private int provinceid;
private long cityid;
private long countyid;
private long townid;
private String province;
private String city;
private String county;
private User user;
private Address address;
private String addr;
private String username;
private UserService userService;

public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public long getTownid() {
	return townid;
}
public void setTownid(long townid) {
	this.townid = townid;
}
public String getCounty() {
	return county;
}
public void setCounty(String county) {
	this.county = county;
}
public JSONArray getProvinceJSON() {
	return provinceJSON;
}
public void setProvinceJSON(JSONArray provinceJSON) {
	this.provinceJSON = provinceJSON;
}
public JSONArray getCityJSON() {
	return cityJSON;
}
public void setCityJSON(JSONArray cityJSON) {
	this.cityJSON = cityJSON;
}
public JSONArray getCountyJSON() {
	return countyJSON;
}
public void setCountyJSON(JSONArray countyJSON) {
	this.countyJSON = countyJSON;
}
public JSONArray getTownJSON() {
	return townJSON;
}
public void setTownJSON(JSONArray townJSON) {
	this.townJSON = townJSON;
}
public JSONArray getProf1JSON() {
	return prof1JSON;
}
public void setProf1JSON(JSONArray prof1json) {
	prof1JSON = prof1json;
}
public JSONArray getProf2JSON() {
	return prof2JSON;
}
public void setProf2JSON(JSONArray prof2json) {
	prof2JSON = prof2json;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public UserService getUserService() {
	return userService;
}
public void setUserService(UserService userService) {
	this.userService = userService;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public LocationService getLocationService() {
	return locationService;
}
public void setLocationService(LocationService locationService) {
	this.locationService = locationService;
}
public JSONArray getLoadJosn() {
	return loadJosn;
}
public void setLoadJosn(JSONArray loadJosn) {
	this.loadJosn = loadJosn;
}
public ProfService getProfService() {
	return profService;
}
public void setProfService(ProfService profService) {
	this.profService = profService;
}
public int getProf1id() {
	return prof1id;
}
public void setProf1id(int prof1id) {
	this.prof1id = prof1id;
}
public int getProvinceid() {
	return provinceid;
}
public void setProvinceid(int provinceid) {
	this.provinceid = provinceid;
}

public long getCityid() {
	return cityid;
}
public void setCityid(long cityid) {
	this.cityid = cityid;
}
public long getCountyid() {
	return countyid;
}
public void setCountyid(long countyid) {
	this.countyid = countyid;
}

public String provincesearch(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getProvince();
	return "search";
}
public String citysearch(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getCity(provinceid);
	return "search";
}
public String countysearch(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getCounty(cityid);
	return "search";
}
public String townsearch(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.gettown(countyid);
	return "search";
}
public String prof1search(){
	this.loadJosn=new JSONArray();
	this.loadJosn=profService.getProf1();
	return "search";
}
public String prof2search(){
	this.loadJosn=new JSONArray();
	this.loadJosn=profService.getProf2(prof1id);
	return "search";
}
//qgsj province
public String provincesjsearch(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getProvince();
	JSONObject json=new JSONObject();
	json.put("value", "不限");
	json.put("text", "不限");
	json.put("selected",true);
	loadJosn.add(json);
	return "sjsearch";
}
//sfsj province
public String provinceshow(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getProvince();
	for(int i=0;i<loadJosn.size();i++){
		if(province.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "show";
}
//sfsj city
public String citysjsearch(){
	this.loadJosn=new JSONArray();
	if(provinceid!=0){
		this.loadJosn=locationService.getCity(provinceid);
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		json.put("selected",true);
		loadJosn.add(json);
	}
	else{
		loadJosn= new JSONArray();
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		json.put("selected",true);
		loadJosn.add(json);
	}
	return "sjsearch";
}
//cssj city
public String cityshow(){
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.getCity(610);
	return "show";
}
public String countysjsearch(){
	this.loadJosn=new JSONArray();
	if(cityid!=0){
		this.loadJosn=locationService.getCounty(cityid);
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		loadJosn.add(json);
	}
	else{
		loadJosn= new JSONArray();
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		loadJosn.add(json);
	}
	return "sjsearch";
}
// xjsj
public String countyshow(){
	long ss=610403000000l;
	this.loadJosn=new JSONArray();
	this.loadJosn=locationService.gettown(ss);
	return "show";
}
public String townsjsearch(){
	this.loadJosn=new JSONArray();
	if(countyid!=0){
		this.loadJosn=locationService.gettown(countyid);
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		loadJosn.add(json);
	}
	else{
		loadJosn= new JSONArray();
		JSONObject json=new JSONObject();
		json.put("value", "不限");
		json.put("text", "不限");
		loadJosn.add(json);
	}
	return "sjsearch";
}
//xxwh 显示位置和专业
public String userprovince(){
	this.provinceJSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userpro=user.getJPositionProvice().getProviceName();
	this.provinceJSON=locationService.getProvince();
	for(int i=0;i<provinceJSON.size();i++){
		if(userpro.equals(provinceJSON.getJSONObject(i).getString("text"))){
			provinceJSON.getJSONObject(i).put("selected",true);
		}
	}
	return "userprovince";
}
public String usercity(){
	this.cityJSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	provinceid=user.getJPositionProvice().getProviceId();
	String usercity=user.getJPositionCity().getCityName();
	this.cityJSON=locationService.getCity(provinceid);
	for(int i=0;i<cityJSON.size();i++){
		if(usercity.equals(cityJSON.getJSONObject(i).getString("text"))){
			cityJSON.getJSONObject(i).put("selected",true);
		}
	}
	return "usercity";
}
public String usercounty(){
	this.countyJSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	String usercounty=user.getJPositionCounty().getCountyName();
	cityid=user.getJPositionCity().getCityId();
	this.countyJSON=locationService.getCounty(cityid);
	for(int i=0;i<countyJSON.size();i++){
		if(usercounty.equals(countyJSON.getJSONObject(i).getString("text"))){
			countyJSON.getJSONObject(i).put("selected",true);
		}
	}
	return "usercounty";
}
public String usertown(){
	this.townJSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	String usertown=user.getJPositionTown().getTownName();
	countyid=user.getJPositionCounty().getCountyId();
	this.townJSON=locationService.gettown(countyid);
	for(int i=0;i<townJSON.size();i++){
		if(usertown.equals(townJSON.getJSONObject(i).getString("text"))){
			townJSON.getJSONObject(i).put("selected",true);
		}
	}
	return "usertown";
}
public String userprof1(){
	this.prof1JSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userprof=user.getProf2().getProf1().getName();
	this.prof1JSON=profService.getProf1();
	for(int i=0;i<prof1JSON.size();i++){
		if(userprof.equals(prof1JSON.getJSONObject(i).getString("text"))){
			prof1JSON.getJSONObject(i).put("selected",true);
		}
	}
	return "userprof1";
}
public String userprof2(){
	this.prof2JSON=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userprof=user.getProf2().getName();
	prof1id=user.getProf2().getProf1().getId();
	this.prof2JSON=profService.getProf2(prof1id);
	for(int i=0;i<prof2JSON.size();i++){
		if(userprof.equals(prof2JSON.getJSONObject(i).getString("text"))){
			prof2JSON.getJSONObject(i).put("selected",true);
		}
	}
	return "userprof2";
}

public String xxwhprovince(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userpro=user.getJPositionProvice().getProviceName();
	this.loadJosn=locationService.getProvince();
	for(int i=0;i<loadJosn.size();i++){
		if(userpro.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String xxwhcity(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String usercity=user.getJPositionCity().getCityName();
	this.loadJosn=locationService.getCity(provinceid);
	for(int i=0;i<loadJosn.size();i++){
		if(usercity.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String xxwhcounty(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String usercounty=user.getJPositionCounty().getCountyName();
	this.loadJosn=locationService.getCounty(cityid);
	for(int i=0;i<loadJosn.size();i++){
		if(usercounty.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String xxwhtown(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String usertown=user.getJPositionTown().getTownName();
	this.loadJosn=locationService.gettown(countyid);
	for(int i=0;i<loadJosn.size();i++){
		if(usertown.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String xxwhprof1(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userprof=user.getProf2().getProf1().getName();
	this.loadJosn=profService.getProf1();
	for(int i=0;i<loadJosn.size();i++){
		if(userprof.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String xxwhprof2(){
	this.loadJosn=new JSONArray();
	this.user=userService.getUserInfo(username);
	String userprof=user.getProf2().getName();
	this.loadJosn=profService.getProf2(prof1id);
	for(int i=0;i<loadJosn.size();i++){
		if(userprof.equals(loadJosn.getJSONObject(i).getString("text"))){
			loadJosn.getJSONObject(i).put("selected",true);
		}
	}
	return "userLocation";
}
public String addressload(){
	address=locationService.getUserAddress(username);
	return "addressload";
}
public String uploadAddress(){
	locationService.setUserAddress(username, addr);
	return "uploadAddress";
}
public String useraddressload(){
	this.loadJosn=new JSONArray();
	address=locationService.getUserAddress(username);
	this.loadJosn.add(address.getAddress());
	return "useraddressload";
}
}
