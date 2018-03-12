//Author Jacob Carter



import java.io.*;
public class Test {
	public static void main(String[] args) throws IOException{
		String line;
		String document = null;
		
		//When testing you will have to change the quoted part to where you have the file located
		try{
		BufferedReader contactReader = new BufferedReader(new FileReader("C:\\Users\\Jacob\\Documents\\Mike.txt"));
		
		//We need an additional string to to check if the next line is null or not
		line = contactReader.readLine();
		while(line != null){
			//If the line string is not null it will be added to the document string
			//we will be adding a comma to the end of each line to keep track of the number of lines
			document += line + ",";
			line = contactReader.readLine();
			
		}
		//We will use the parser to get the name, number and email from the file
		Parser parser = new Parser();
		
		//Here we make a contact object so that we can use the methods in the contact class
		Contact contact = new Contact(parser.getContactInfo(document));
		
		System.out.println(contact.getName());
		System.out.println(contact.getPhoneNumber());
		System.out.println(contact.getEmailAddress());
		contactReader.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
}
