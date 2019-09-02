package br.edu.utfpr.dv.siacoes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCountry;
	private String name;

	
	public String toString(){
		return this.getName();
	}
}
