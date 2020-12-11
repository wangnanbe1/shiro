package com.exception.test.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-12-11 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="groovy" )
public class Groovy  implements Serializable {

	private static final long serialVersionUID =  2762290180127710132L;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "username" )
	private String username;

}
