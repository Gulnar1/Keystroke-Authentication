# Keystroke-Authentication
Authentication through Keystroke biometrics
Authentication mechanism provides the basis for access control in order to ensure the information security.
Relying on the traditional text based password method to authenticate users is not effective anymore due to its vulnerabilities. 
Many alternative solutions such as the use of multi level authentication, graphical password or biometric password have been suggested in the last few decades. 
Keystroke dynamics is a low cost biometric solution as it does not require any special hardware. 
The assumption behind keystroke dynamics is that typing rhythm is unique for any individual. 
In this project, a simple and secure authentication scheme has been produced by adding this biometric feature with the existing ID/password method.
The main aim is to authenticate users based on the combination of habitual patterns of their typing rhythm and the text password. 
I have applied statistical approach for this purpose. There are mainly two phases in the policy that a user has to go through to be authenticated which are the registration
phase and log-in phase. 
In registration phase, the major functions are data capture, feature extraction and the learning step. Keystroke dynamics features are extracted by analyzing
the timing information of the key down/hold/up events.System will store the keystroke times in correspondence to the user’s other credential details
like username, password in a database.
Login phase takes place whenever a user needs to access the system.The login phase realizes the identification, data capture and feature extraction for comparison purpose.
Correct username and password does not ensure authentication of a user because an illegitimate user having the knowledge of a correct username and password combination may access the account as
well. So the parallel typing verification is the main concern of our project.
I have used java for coding since it contains in-built functions for reading keyboard events.
The method is quite simple since it is based on statistical approach and provides interesting results with more than 93% accuracy.
