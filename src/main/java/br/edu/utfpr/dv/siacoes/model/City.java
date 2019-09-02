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
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCity;
	private State state;
	private String name;

	public String toString(){
		if((this.getState() == null) || (this.getState().getInitials().isEmpty())){
			return this.getName();	
		}else{
			return this.getName() + " / " + this.getState().getInitials();
		}
	}
}
