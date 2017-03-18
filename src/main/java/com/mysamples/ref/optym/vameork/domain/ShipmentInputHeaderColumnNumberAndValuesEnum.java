package com.mysamples.ref.optym.vameork.domain;

public enum ShipmentInputHeaderColumnNumberAndValuesEnum {

	ORIGIN("Shipment Origin"), DESTINATION("Shipment Destination"), 
	PICKUP_DATE("Pickup Date"), WEIGHT("Weight"),
    CUBE("Cube"), SERVICE_TYPE("Service Type");
	private String columnName;
	
    ShipmentInputHeaderColumnNumberAndValuesEnum(String colName){
		columnName = colName;
	}
    public String getColumnName(){
    	return columnName;
    }
    
    public static String[] names() {
    	ShipmentInputHeaderColumnNumberAndValuesEnum[] states = values();
        String[] names = new String[states.length];

        for (int i = 0; i < states.length; i++) {
            names[i] = states[i].getColumnName();
        }
        return names;
    }
}
