package com.cvs.arrangment;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrangmentOrder {

	public void getArrangments(Arrangments arrangments) {
		List<ArrangementList> sortOrder = arrangments.getList();
		Collections.sort(sortOrder,  new Comparator<ArrangementList>() {

			@Override
			public int compare(ArrangementList o1, ArrangementList o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
			});

		List<ArrangementList> fillingSortOrder = arrangments.getFillingList();
		Collections.sort(fillingSortOrder , new Comparator<ArrangementList>() {

			@Override
			public int compare(ArrangementList o1, ArrangementList o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});

		for (ArrangementList arrange : sortOrder) {
			for (ArrangementList filling : fillingSortOrder) {
				if (arrange.getKey() == filling.getKey())// 1:A
					if (arrange.getValue() != null) {
						arrange.setKey(filling.getKey());
					} else {
						List<ArrangementList> arrangementList2 = new ArrayList<ArrangementList>();
						ArrangementList arrangement2 = new ArrangementList();
						arrangement2.setKey(filling.getKey());
						arrangement2.setValue(filling.getValue());
						arrangementList2.add(arrangement2);
					}
			}
		}
	}
}
