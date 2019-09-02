package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int idActivity;
	private ActivityGroup group;
	private ActivityUnit unit;
	private Department department;
	private String description;
	private double score;
	private double maximumInSemester;
	private boolean active;
	private int sequence;
	

	public boolean isActive() {
		return active;
	}

	public String toString(){
		return this.getDescription();
	}
	
	@Override
    public int hashCode() {
        return this.getIdActivity();
    }
	
	@Override
    public boolean equals(final Object object) {
        if (!(object instanceof Activity)) {
            return false;
        }else if(this.getIdActivity() == ((Activity)object).getIdActivity()){
        	return true;
        }else{
        	return false;
        }
    }
	
}
