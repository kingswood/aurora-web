package com.training.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class BaseEntity {
	private static final long serialVersionUID = 1L;
		
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
