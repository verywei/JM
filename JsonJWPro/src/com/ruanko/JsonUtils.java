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
			Person p = new Person(i,"����"+i,20+i);
			list.add(p);
		}
		return list;
	}
	
	//����json�ַ���
	public static String makeJson(List<Person>list){		
		JSONArray arr=new JSONArray();
		for(Person p:list) {
			//����JSONObject
			JSONObject obj = new JSONObject();
			//��person�����е�ֵ���ø�JSONObject
						
			try {
				obj.put("id",p.getId());				
				obj.put("name", p.getName());
				obj.put("age", p.getAge());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			//��JSONObject��ӽ�JSONArray��
			arr.put(obj);
		}
		//�����ַ���
		return arr.toString();		
	}
	
	//����json�ַ���
	public static List<Person>parse(String json)throws JSONException{
		//���ַ���ת����JSONArray
		List<Person> list= new ArrayList<Person>();
		try {
			JSONArray array = new JSONArray(json);
			int length = array.length();
			for(int i=0;i<length;i++) {//����JSONArray				
				JSONObject object=array.getJSONObject(i);//�õ�JSONObject
				
				//��JSONObject�л�ȡ���ݣ���װ��person
				Person p = new Person();
				p.setId(object.getInt("id"));
				p.setAge(object.getInt("age"));
				p.setName(object.getString("name"));				
				list.add(p);//��ӵ�list����
			}
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public static void main(String[]args){
		//��������JSON�ַ���
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
