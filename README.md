AccountNo;  // Auto generates everytime when new request is sent.
cardNumber;
cardHolderFirstName;
cardHolderLastName;
cardLimit;

//VALID CREDIT CARD NO - AS PER LUHN'S ALGORITHM
{
"cardNumber" : "1358954993914435",
"cardHolderFirstName" : "ANKITA",
"cardHolderLastName" : "NALAWADE",
"cardLimit" : "1000"
}

//INVALID CARD NO - NOT AS PER LUHN'S ALGORITHM
{
"cardNumber" : "1358954993914410",
"cardHolderFirstName" : "MILIND",
"cardHolderLastName" : "BHANDARI",
"cardLimit" : "1000"
}

==========================
TECHNOLOGIES USED :-
=======================

JAVA 14
H2-In memory database
springboot 2.4.5
maven
junit 5 (jupiter)
Mockito
InteliJ IDE
postman for testing 
Spring JPA
Spring Initializer (start.spring.io)
==========================

STEPS :-
==========================

1. Download the code and import in IDE (use intelliJ / Eclipse)
2. Run Maven install
3. Once the maven build is successful, run the java class (SpringBootCreditCardProcessing.java) -> Right click, run as java application.
This is the main class of the project.
4. Attached one file named(StepsWithScreenshots.xl), refer the same and follow instructions as per the screenshots, and run the code. 


