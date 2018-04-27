package controller;

import java.util.List;

import model.Medication;

public interface Report {
		void generate(List<Medication> a);
	}
