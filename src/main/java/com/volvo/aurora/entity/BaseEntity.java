package com.volvo.aurora.entity;
//import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID")
		private Integer id;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
}
