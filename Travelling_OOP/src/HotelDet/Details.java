package HotelDet;
import java.util.*;
import Home.*;
abstract class Hotels {
	public int  HotelListId;
	public String getHotelInfo(int HotelListID,String enteredCity) {
	System.out.println(enteredCity);
switch(enteredCity) {
case "Delhi" : {
	switch (HotelListID) {
case 1: {
	
	System.out.println("Eros Hotel New Delhi Nehru Place is known for consistently delivering the finest Indian Hospitality experience over last 25 years. It offers contemporary design and comfort paired with Old World hospitality charm. ");
	break;
}
default:
	System.out.println("Information not found");
	break;
}
break;
}
case "Mumbai" : {switch (HotelListID) {
case 1: {
	
	System.out.println("Located 20 minutes away from Grand Hyatt Mumbai, Bandra is a prominent entertainment and culture hub in Mumbai. Termed as the ‘Queen of Suburbs’, Bandra is a melting pot of activity and culture.");
	break;
}
default:
	System.out.println("Information not found");
	break;
}}
	}
return "";
		
	
}
	
	public String getContactDetail(String CityName) {
		String contactDetails = null;
		return contactDetails;
	}
	abstract String getHotelMenuList();
	abstract String getVacantRoomAvail();
}
public class Details extends Hotels{
	public int hotelMenuList;
		public String  getHotelMenuList(int hotelMenuList,String enteredcity) {
			System.out.println(enteredcity);
			switch(enteredcity) {
			case "Delhi" :
				System.out.println(HotelListId);
				switch(HotelListId) {
				case 1:{
				System.out.println(hotelMenuList);
				switch(hotelMenuList) {
				case 1 : {
					System.out.println("1. Tea Lounge\n 2. Sweet N crusty\n 3. Blooms\n 4. Singh Sahib\n 5. Express China\n");break;
				}
				default : {
					System.out.println("Iformation not found");
					break;
				}
				}
				}
				}
			}
			
			return "Hello34243234234";
		}
		public String getVacantRoomAvail(){
			return "No Vaccant rooms are available";
		}
}

