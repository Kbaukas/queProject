Task
Screens with serial numbers can be seen in customer service departments (bank, outpatient
clinic, post office, etc.). The incoming customer prints out the number and the display shows the
waiting line and the customers place in it. To avoid serial numbers printed on paper, a system is
needed that could allow the customer to book a visit time using a website. After booking the
time of the visit, the customer could see the waiting line and their respected place in it. The
queue is displayed on the service department screens. The customer can see how much time
he has left before the meeting according to the reservation code.

Users
● Customer - a user whose purpose is to visit a specialist.
● A specialist - a user whose purpose is to serve a customer.
Requirements
Display board requirements
● The service department screen should show current visits and five upcoming visits.
● The service department screen information must be updated every five seconds.
● The service department screen must not be publicly accessible.

Visit reservation requirements
● The customer must be able to book an appointment with a specialist (the customer does
not need to register in the account system). After a successful reservation, the system
must generate a reservation code and provide it to the customer.
● The customer must see how much time is left before the visit (separate page, not the
service department screen).
● The customer must be able to cancel the visit.

Customer visit management requirements
● The specialist must have an account (can be created through a database, no
administrations are required for accounts) with which to log in to visit management.
● The specialist should only see patients who have registered with him.
● The specialist must be able to mark that the visit has begun. There can only be one
active visit at a time.
● The specialist must be able to mark the end of the visit.
● The specialist must be able to cancel the visit.
