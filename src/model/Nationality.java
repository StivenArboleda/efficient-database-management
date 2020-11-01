package model;

public enum Nationality {
	USA("United States"),
	BR("Brazil"),
	MX("Mexico"),
	COL("Colombia"),
	ARG("Argentina"),
	CAN("Canada"),
	PER("Peru"),
	CHL("Chile"),
	VEN("Venezuela"),
	ECU("Ecuador"),
	BOL("Bolivia"),
	HAI("Haiti"),
	CUB("Cuba"),
	DRP("Dominican Republic"),
	HON("Honduras"),
	PNG("Papua New Guinea"),
	PAR("Paraguay"),
	NIC("Nicaragua"),
	SAL("El Salvador"),
	CRC("Costa Rica"),
	PAN("Panama"),
	URU("Uruguay"),
	JAM("Jamaica"),
	PRC("Puerto Rico"),
	TAT("Trinidad and Tobago"),
	GUY("Guyana"),
	SUR("Suriname"),
	GUA("Guadeloupe"),
	BEL("Belize"),
	BAH("Bahamas"),
	MAR("Martinique"),
	BAR("Barbados"),
	SLC("Saint Lucia"),
	GUM("Guam"),
	CUR("Curaçao"),
	GRE("Grenada"),
	VIN("St. Vincent & Grenadines"),
	UVI("U.S. Virgin Islands"),
	ANB("Antigua and Barbuda"),
	DOM("Dominica"),
	CAY("Cayman Islands"),
	BER("Bermuda"),
	NOR("Northern Mariana Islands"),
	GRL("Greenland"),
	SAM("American Samoa"),
	CAI("Turks and Caicos"),
	SMR("Saint MArtin"),
	BVI("British Virgin Islands"),
	CNE("Caribbean Netherlands"),
	ANG("Anguilla"),
	MON("Monserrat")
	;
	
	private final String country;

	Nationality(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
}
