#02/06/2021
#Jhonatan Medina Blanco
@Regretion
Feature: search destion and select flight to travel
Scenario Outline: search flight 
	Given open browser page Avianca 
	And search Flight from <outPutP> and destination <destinationP>
	And select date start month <initMothP> start day <initDayP> by the end of the month <endMothP> by the end of the day <endDayP> 
	When select second flight 
	Then show the flight information 
	Examples: 
		|outPutP	 |destinationP |initMothP|initDayP|endMothP|endDayP|
		|Medellin	 |Cali		   |6		   |9	    |6		 |14     |
		|Bogota	 	 |Cali		   |7		   |15	    |7		 |26     |
		