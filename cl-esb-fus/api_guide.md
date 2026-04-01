# OPTA Comml Peril Score (OSS) Rest Api

* Endpoint: https://server:port/cxf/cl/api/oss
* Resource: fus

**Sample code (request)**
```var unirest = require("unirest");
var req = unirest("GET", "http://localhost:8181/cxf/cl/api/oss/fus");

req.query({
  "streetAddress": "3202 Tania Cres",
  "postalCode": "L7M3M7",
  "municipality": "Burlington",
  "province": "ON"
});

req.headers({
  "accept": "application/json",
  "authorization": "Basic ASJFDEGG264DG4IDF6I6W74GF6WFI76GE="
});


req.end(function (res) {
  if (res.error) throw new Error(res.error);

  console.log(res.body);
});```

**Sample Response**
```
{
	"Result": [{
		"ActivityID": null,
		"Address": {
			"AddressID": "1",
			"OptaAddressKey": "00A-00A-00P",
			"StreetNumber": "3202",
			"StreetName": "Tania",
			"StreetType": "Crescent",
			"StreetDirection": null,
			"UnitNumber": null,
			"Municipality": "Burlington",
			"Province": "ON",
			"PostalCode": "L7M3M7"
		},
		"ProductResults": {
			"iClarifyResidentialProductOrCommercialPerilScoreProductOrIClarifyCommercialOccupancyProduct": [{
				"FUSProduct": {
					"Dwelling": {
						"RespondingFirehall": {
							"RoadDistanceKilometres": 2.1,
							"GoverningAgency": "CITY OF BURLINGTON",
							"ProtectionGradeTerritories": {
								"Commercial": "91",
								"Dwelling": "76"
							},
							"FirefightersPerFireStation": {
								"FullTime": 6,
								"Volunteer": 0
							},
							"TankerCapacityImperialGallons": 500,
							"PumperFlowImperialGallonsPerMinute": "ImperialGallonsPerMinute",
							"SuperiorTankerServiceAccreditationDate": null,
							"GradingDate": 1416286800000
						},
						"DwellingGrades": {
							"HydrantProtectedGrade": [{
								"Grade": "1",
								"WaterSystem": "Burlington - W.S."
							}],
							"FirehallProtectedGrade": null,
							"AllOtherAreasGrade": null
						}
					},
					"Commercial": {
						"RespondingFirehall": {
							"RoadDistanceKilometres": 2.1,
							"GoverningAgency": "CITY OF BURLINGTON",
							"ProtectionGradeTerritories": {
								"Commercial": "91",
								"Dwelling": "76"
							},
							"FirefightersPerFireStation": {
								"FullTime": 6,
								"Volunteer": 0
							},
							"TankerCapacityImperialGallons": 500,
							"PumperFlowImperialGallonsPerMinute": "1100",
							"SuperiorTankerServiceAccreditationDate": null,
							"GradingDate": 1416286800000
						},
						"CommercialGrade": [{
							"PublicFireProtectionClassification": 3,
							"RiskSCORDetail": [{
								"RiskSCOR": 3,
								"Type": "Unconditional",
								"Adjustment": [{
									"AdjustmentType": "Firehall",
									"Adjustment": "0"
								},
								{
									"AdjustmentType": "Hydrant",
									"Adjustment": "0"
								}]
							}],
							"WaterSystem": null
						}]
					},
					"EarthquakeCodes": {
						"EarthquakeCode": [{
							"Zone": "15",
							"Description": "Ontario very low",
							"SystemName": "CRESTA Accumulation Zone"
						},
						{
							"Zone": "East 6",
							"Description": "Very Low",
							"SystemName": "ICLR Earthquake Hazard Zone"
						}]
					},
					"HydrantCounts": {
						"HydrantCount": [{
							"RadiusMetres": 150,
							"NumberOfHydrants": 6,
							"Ownership": "Public"
						},
						{
							"RadiusMetres": 150,
							"NumberOfHydrants": 0,
							"Ownership": "Private"
						},
						{
							"RadiusMetres": 300,
							"NumberOfHydrants": 25,
							"Ownership": "Public"
						},
						{
							"RadiusMetres": 300,
							"NumberOfHydrants": 0,
							"Ownership": "Private"
						}]
					},
					"StatusCode": "Success",
					"ServiceMode": null,
					"Message": null
				}
			}]
		},
		"Message": null
	}]
}
```
