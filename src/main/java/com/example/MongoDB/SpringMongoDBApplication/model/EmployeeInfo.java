package com.example.MongoDB.SpringMongoDBApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Employeeinfo")
public class EmployeeInfo {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
		private int eid;
		private int eins;
		private int sal;


		
		public int getEid() {
			return eid;
		}
		
		public void setEid(int eid) {
			this.eid = eid;
		}
		
		public int getEins() {
			return eins;
		}
		
		public void setEins(int eins) {
			this.eins = eins;
		}
		
		public int getSal() {
			return sal;
		}
		
		public void setSal(int sal) {
			this.sal = sal;
		}

		public EmployeeInfo(int eid, int eins, int sal) {
			
			this.eid = eid;
			this.eins = eins;
			this.sal = sal;
		}
		
		
		public EmployeeInfo() {
			super();
			
		}

		@Override
	public String toString() {
		return "EmployeeInfo [eid=" + eid + ", eins=" + eins + ", sal=" + sal + "]";
	}
		
		 
}
