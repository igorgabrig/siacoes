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
public class ActivityScore implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idActivity;
	private String activity;
	private double score;
}
