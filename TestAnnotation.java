package aki.test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotation {

	public boolean checkClassMethodAnnotaion(AnnotationPojo annotationPojo) {

		Class<? extends AnnotationPojo> class1 = annotationPojo.getClass();

		if (class1.isAnnotationPresent(ClassLevelCheck.class)) {

			for (Method method : class1.getDeclaredMethods()) {
				method.setAccessible(true);
				if (method.isAnnotationPresent(MethodLevelCheck.class)) {
					annotationPojo.modifyAddress();
				}
			}
			return true;
		}
		return false;
	}

	public String checkFieldAnnotation(AnnotationPojo annotationPojo) throws IllegalArgumentException, IllegalAccessException {

		Class<? extends AnnotationPojo> class1 = annotationPojo.getClass();

		String plainString = "";

		for (Field field : class1.getFields()) {

			if (field.isAnnotationPresent(FieldLevelCheck.class)) {

				
				try {
					plainString = plainString + field.getName() + "  value " 
					+ field.get(annotationPojo)+"\n";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return plainString;
	}
public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		AnnotationPojo annotationPojo=new AnnotationPojo();
		annotationPojo.setAddress("rv");
		annotationPojo.setLname("kumar");
		annotationPojo.setName("akhiles");
		TestAnnotation testAnnotation=new TestAnnotation();
		if(testAnnotation.checkClassMethodAnnotaion(annotationPojo)) {
			System.out.println(testAnnotation.checkFieldAnnotation(annotationPojo));
		}
	}
}