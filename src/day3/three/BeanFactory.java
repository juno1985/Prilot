package day3.three;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;	

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	// 用于保存创建的对象的Map，key是配置文件中的id值，value是对象
	private Map<String, Object> beans = new HashMap<String, Object>();

	/**
	 * BeanFactory的构造方法，解析XML文档，装配对象
	 */
	public BeanFactory(String fileName){
		// dom4j的SAX解析器对象
		SAXReader saxReader = new SAXReader();
		// 得到类加载器
		ClassLoader clsLoader = this.getClass().getClassLoader();
		// 得到用于读取配置文件的输入流，配置文件根据类路径来查找
		InputStream is = clsLoader.getResourceAsStream(fileName);
		try {
			// 构建dom4j树
			Document doc = saxReader.read(is);
			// 得到XML文档的根元素
			Element root = doc.getRootElement();
			// 得到的所有的<bean>元素
			List<Element> beanList = root.elements("bean");
			// 循环解析<bean>元素
			for(Element beanElt : beanList)	{
				// 得到<bean>元素id属性的值
				String id = beanElt.attributeValue("id");
				// 得到<bean>元素class属性的值
				String className = beanElt.attributeValue("class");
				Class<?> cls = Class.forName(className);
				// 得到<bean>元素所有<constructor>子元素
				List<Element> consList = beanElt.elements("constructor");
				// 如果不存在<constructor>子元素，则调用默认构造方法创建对象
				if(consList.isEmpty()){
					Object obj = cls.getConstructor().newInstance();
					// 以<bean>元素id属性的值为key，对象为value，保存到Map中
					beans.put(id, obj);
				}
				// 如果<bean>元素下存在<constructor>子元素，
				// 则找到匹配的构造方法，实例化对象，并传入参数值，
				// 为了简单起见，构造方法的参数类型都暂定为String类型，
				// 创建对象，保存到Map中
				else{
					int i = 0;
					Class[] argsCls = new Class[consList.size()];
					Object[] args = new Object[consList.size()];
					for(Iterator it = consList.iterator(); it.hasNext(); i++){
						Element consElt = (Element)it.next();
						argsCls[i] = String.class;
						args[i] = consElt.element("value").getText();
					}
					Constructor cons = cls.getConstructor(argsCls);
					Object obj = cons.newInstance(args);
					beans.put(id, obj);
				}
				// 查看<bean>元素下是否有<property>子元素
				List<Element> propList = beanElt.elements("property");
				// 如果有，则准备调用对象的setXxx方法，传入依赖的对象
				for(Element propElt : propList){
					String name = propElt.attributeValue("name");
					StringBuffer sb = new StringBuffer();
					// 拼接方法名，格式为：set + name属性值首字母大写 + name属性值剩余字母
					sb.append("set")
							.append(name.substring(0, 1).toUpperCase())
							.append((name.substring(1)));

					// 得到依赖的对象的id值
					String objName = propElt.element("ref").attributeValue("bean");
					// 从Map中取出对象
					Object obj2 = beans.get(objName);
					// 得到setXxx方法对应的Method对象
					Method mth = cls.getMethod(
							sb.toString(), obj2.getClass().getInterfaces()[0]);
					// 调用setXxx方法方法，传入依赖的对象
					mth.invoke(beans.get(id), obj2);
				}
			}

		} catch (DocumentException
				| ClassNotFoundException
				| NoSuchMethodException
				| InstantiationException
				| IllegalAccessException
				| InvocationTargetException e){
			e.printStackTrace();
		}
	}
	/**
	 * 根据配置文件中<bean>元素id属性的值，从Map中得到对象
	 */
	public Object getBean(String name){
		return beans.get(name);
	}

}
