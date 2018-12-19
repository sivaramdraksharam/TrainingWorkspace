package librarypackage;

public class Student implements User{

	
	
		private String name; 
		private int phone;
		  
		public String getName() {  
		    return name;  
		}  
		  
		public void setName(String name) {  
		    this.name = name;  
		}  
		  
		public void displayInfo(){  
		    System.out.println("Hello: "+name+" your phone is:"+getPhone());  
		}  
		public boolean register() {
			// TODO Auto-generated method stub
			return false;
		}

		public int getPhone() {
			return phone;
		}

		public void setPhone(int phone) {
			this.phone = phone;
		}
		
		}


