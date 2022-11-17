# Methods
My fourth Java assignment for Programming 1 (COMP 1501) involving methods.

## Problem Scenario:  Electricity Billing

The City of Utopia provides electricity to its residents and businesses.  At the end of the month, they produce a utility bill to the different customers.  This bill is calculated using the amount of usage and the type of customer.

The following are the details of the calculation of the bill for each customer:

* A client is identified by a 7 digit code.  Any code that is not 7 digits is not a valid code and no processing should be done for that customer.
* There are three types of customers – residential, multiple housing (condos), commercial.  The client will be identified by a 7 digit client code and a character client type. (‘R’, ‘M’, or ‘C’)
* Charges are based on kilowatt-hour (kwh) used. The usage is determined by reading the electric meter at each customer location every month.  For this part, assume that the beginning and ending meter reading is inputted via the terminal.  All meters have a maximum of 99999 at which time they revert back to 00000.  Calculation of kWh used must take this into account.  The values read are assumed to be integers.
* Price per kWh is 6 cents for residential, 5 cents for multiple housing, 4 cents for commercial.
* In order to encourage environmental awareness, the city provides 10 percent discount on the above charges whenever the customer has a reading less than a certain value.  The value is: for residential, 400 kWh, for multiple housing, 8000 kWh, and for commercial, 2000 kWh.
* There is a $15 fixed transmission and distribution charge regardless of customer (This is not included in the calculation of the discount).
* All charges are subject to GST
* Print a “bill” for the customer that gives the client code, client type, kWh, and total cost.  This bill should look like:
	
> Customer Electric Bill

> Customer Number:	1234567  
> Customer Type:	Residential  
> Electric Usage:	1000   kWh  
> Total Bill:		$ 78.75
