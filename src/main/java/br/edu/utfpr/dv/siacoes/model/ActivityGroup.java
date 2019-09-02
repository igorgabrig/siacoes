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
public class ActivityGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idActivityGroup;
	private String description;
	private int sequence;
	private int minimumScore;
	private int maximumScore;
	
	public String toString(){
		return this.getDescription();
	}
	
	@Override
    public int hashCode() {
        return this.getIdActivityGroup();
    }
	
	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof ActivityGroup)) {
            return false;
        }else if(this.getIdActivityGroup() == ((ActivityGroup)object).getIdActivityGroup()){
        	return true;
        }else{
        	return false;
        }
    }
}
