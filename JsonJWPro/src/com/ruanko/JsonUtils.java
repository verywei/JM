package com.ruanko;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

	public JsonUtils() {
		
		// TODO Auto-generated constructor stub
	}
	public static List <Person>newPersonList(){
		List<Person>list=new ArrayList<Person>();
		for(int i=0;i<10;i++) {
			Person p = new Person(i,"张三"+i,20+i);
			list.add(p);
		}
		return list;
	}
	
	//生成json字符串
	public static String makeJson(List<Person>list){		
		JSONArray arr=new JSONArray();
		for(Person p:list) {
			//创建JSONObject
			JSONObject obj = new JSONObject();
			//将person对象中的值设置给JSONObject
						
			try {
				obj.put("id",p.getId());				
				obj.put("name", p.getName());
				obj.put("age", p.getAge());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			//将JSONObject添加进JSONArray中
			arr.put(obj);
		}
		//生成字符串
		return arr.toString();		
	}
	
	//解析json字符串
	public static List<Person>parse(String json)throws JSONException{
		//把字符串转换成JSONArray
		List<Person> list= new ArrayList<Person>();
		try {
			JSONArray array = new JSONArray(json);
			int length = array.length();
			for(int i=0;i<length;i++) {//遍历JSONArray				
				JSONObject object=array.getJSONObject(i);//得到JSONObject
				
				//从JSONObject中获取数据，封装成person
				Person p = new Person();
				p.setId(object.getInt("id"));
				p.setAge(object.getInt("age"));
				p.setName(object.getString("name"));				
				list.add(p);//添加到list集合
			}
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public static void main(String[]args){
		//测试生成JSON字符串
		List<Person>list=newPersonList();
		String result="";
		result=makeJson(list);
		
		System.out.println(result);
		
		List<Person>list1=null;
		try {
			list1=parse(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Person person:list1) {
			System.out.println(person.toString());
		}
		
	}
	


}
