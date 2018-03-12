public class Parser implements BusinessCardParser {

public ContactInfo getContactInfo(String document) {
	
	char[] documentArr = document.toCharArray();
	String name = "Name: ";
	String number = "Phone: ";
	String email = "Email: ";
	int count = 0;
	int i;
	
	//This section will count the number of commas in the code so it will know what
	//Kind of business card it is
	for(i = 0; i < documentArr.length-1; i++){
		if(documentArr[i] == ','){
			count++;
		}
	}
	//If there are 4 commas then that means that the name is on the second line
	if(count == 4){
		count = 0;
		for(i = 0; i < documentArr.length-1; i++){
			if(documentArr[i] == ','){
				count++;
			}
			if(count == 1){
				while(documentArr[i+1] != ','){
					name += documentArr[i+1];
					i++;
				}
				break;
			}
		}
	//If there are 8 commas then that means that the name is on the third line
	} else if (count == 8){
		count = 0;
		for(i = 0; i < documentArr.length-1; i++){
			if(documentArr[i] == ','){
				count++;
			}
			if(count == 2){
				while(documentArr[i+1] != ',' ){
					name += documentArr[i+1];
					i++;
				}
				break;
			}
		}	
	//IF there are 10 commas then the name is on the first line
	} else if (count == 10){
		//I set i = 3 here because the beginning of the string starts with null
		i=3;
			while(documentArr[i+1] != ','){
				name += documentArr[i+1];
				i++;
			}	
	}
	
	//This section of code will get the phone number but not the fax number from the string
	for(i = 0; i < documentArr.length; i++){		
		if((documentArr[i] == ':' || documentArr[i] == '(') && number.length() <= 17 ){
			while(documentArr[i+1] != ','){				
				if (documentArr[i] != '(' && documentArr[i] != ')' && documentArr[i] != 
						'-' && documentArr[i] != '+' && documentArr[i] != ' ' && documentArr[i] != ':' ){					
						
					number += documentArr[i];						
				}		
				i++;	
			}
			number += documentArr[i];
			count = i;
			break;
		}
	}
	
	//This section of code will take the get the email address from the string 
	for(i = count; i < documentArr.length-1; i++){
		if(documentArr[i+1] == 'F' && documentArr[i+5] == '+'){
			i += 22;
		} else if(documentArr[i+1] == 'F'){
			i += 17;
		}
		if(documentArr[i-1] == ',' && (documentArr[i-2] 
				>= '0' && (documentArr[i-2] <= '9' ))){
				
			while(documentArr[i+1] != ','){
				email += documentArr[i];

				i++;
			}
				
			email += documentArr[i];
				
		}
		
	}
	//Now we will return a contact	
	Contact contact = new Contact(name, number, email);
	
	return contact;
	
	}

}
