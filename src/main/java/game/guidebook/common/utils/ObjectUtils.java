package game.guidebook.common.utils;

import game.guidebook.domain.enumerate.*;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象操作工具类, 继承org.apache.commons.lang3.ObjectUtils类
 * @author zhaojt
 * @version 2014-6-29
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {

	/**
	 * 注解到对象复制，只复制能匹配上的方法。
	 * @param annotation
	 * @param object
	 */
	public static void annotationToObject(Object annotation, Object object){
		if (annotation != null){
			Class<?> annotationClass = annotation.getClass();
			Class<?> objectClass = object.getClass();
			for (Method m : objectClass.getMethods()){
				if (StringUtils.startsWith(m.getName(), "set")){
					try {
						String s = StringUtils.uncapitalize(StringUtils.substring(m.getName(), 3));
						Object obj = annotationClass.getMethod(s).invoke(annotation);
						if (obj != null && !"".equals(obj.toString())){
							if (object == null){
								object = objectClass.newInstance();
							}
							m.invoke(object, obj);
						}
					} catch (Exception e) {
						// 忽略所有设置失败方法
					}
				}
			}
		}
	}
	
	/**
	 * 序列化对象
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			if (object != null){
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(object);
				return baos.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			if (bytes != null && bytes.length > 0){
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				return ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static  EmployeeState getEmployeeState (String text){
		for(EmployeeState o:EmployeeState.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}
	public static  SexType getSexType (String text){
		for(SexType o:SexType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static CurrencyType getCurrencyType(String text)
	{
		for(CurrencyType o:CurrencyType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static BoolValue getBoolValue(String text)
	{
		for(BoolValue o:BoolValue.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static SupplierType getSupplierType(String text)
	{
		for(SupplierType o:SupplierType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static ProcedureType getProcedureType(String text)
	{
		for(ProcedureType o:ProcedureType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static ProduceType getProduceType(String text)
	{
		for(ProduceType o:ProduceType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static YieldReportingType getYieldReportingType(String text)
	{
		for(YieldReportingType o:YieldReportingType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static ScheduleDataSource getScheduleDataSource(String text)
	{
		for(ScheduleDataSource o:ScheduleDataSource.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}

	public static MaterialType getMaterialType(String text)
	{
		for(MaterialType o:MaterialType.values()){
			if(o.getText().equals(text)){
				return o;
			}
		}
		return  null;
	}
	
	public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null)  
            return null;      
  
        Map<String, Object> map = new HashMap<String, Object>();   
  
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
        for (PropertyDescriptor property : propertyDescriptors) {    
            String key = property.getName();    
            if (key.compareToIgnoreCase("class") == 0) {   
                continue;  
            }  
            Method getter = property.getReadMethod();  
            Object value = getter!=null ? getter.invoke(obj) : null;  
            map.put(key, value);  
        }    
  
        return map;  
    }    
}
