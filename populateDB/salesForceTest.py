import pytz
import datetime
from simple_salesforce import Salesforce




SECURITY_TOKEN = "Y35ffR4oThGaDIt53s5vFuE8U"
sf = Salesforce(username="alanjponte@gmail.com", password="R@gnaros89",
					security_token = "qYuwbpV4gWx9T2rCw0Y8302MV")


if __name__ == "__main__":
	#end = datetime.datetime.now(pytz.UTC)
	#sf.Contact.updated(end - datetime.timedelta(days=1), end)

	jon = sf.Contact.create({'LastName': 'Moon', 'FirstName': 'Jon', 'Email': 'jazzystazzy@gmail.com'})
	#print jon
	newMerchandise = sf.Merchandise__c.create({"name":"some name"})
	#tablet = sf.Merchandise.create({"name": "some new merch"})
	#jon_object = sf.Contact.get('003o000000AqICuAAN')

	#print sf.Merchandise__c
	#sf.Merchandise__c.update('a03i0000006Mbe0',{'Name': 'Python Example'})