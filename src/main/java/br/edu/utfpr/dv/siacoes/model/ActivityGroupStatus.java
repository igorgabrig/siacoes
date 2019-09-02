package br.edu.utfpr.dv.siacoes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
public class ActivityGroupStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ActivityGroup group;
	private double averageScore;
	
	public ActivityGroupStatus() {
		this.setGroup(new ActivityGroup());
		this.setAverageScore(0);
	}
}
