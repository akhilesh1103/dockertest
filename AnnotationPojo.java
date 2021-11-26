package aki.test.annotation;

@ClassLevelCheck
public class AnnotationPojo {

	@FieldLevelCheck
	public String name;
	@FieldLevelCheck
	public String address;
	public String lname;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	

	
	@MethodLevelCheck
	public void modifyAddress() {
		
		this.setAddress(this.getAddress()+" New Delhi");
	}
	
	
}
