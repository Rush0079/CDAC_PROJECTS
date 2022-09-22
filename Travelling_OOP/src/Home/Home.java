package Home;
import java.util.*;
import HotelDet.*;

public class Home{
	public static void main(String[] args){
//		int n;  
		String enteredCity="";
		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter Number Of Cities you want to store"); 
//		n=sc.nextInt();   
//		String[] City_arr = new String[10];  
//		System.out.println("Enter cities ");  
//		for(int i=0; i<n; i++)  
//		{    
//			City_arr[i]=sc.next();  
//		}  
//		System.out.println();
//		System.out.println("Entered Cities : ");
//		System.out.println();
//		for (int i=0; i<n; i++)   
//		{  
//			System.out.println(City_arr[i]);  
//		} 
//		String []def_arr = {"Delhi","Mumbai","Pune","Chennai","Bangalore"};
		boolean flag = false;
		String Username="";
		String Password ="";
		do {
			System.out.println("Enter Username");
		 	 Username =sc.next().trim();
		 	System.out.println("Enter  Password");
		 	 Password =sc.next().trim();
		 	boolean UsernameLetters = Username.chars().allMatch(Character::isLetter);
		 	if(!UsernameLetters)
		 	{
		 		flag = true;
		 		System.out.println( "Please Enter only Characters in Username");
		 	}
		 	else if(! (Username.equals("Rushi") )|| !(Password.equals("Rupesh")))
		 	{
		 		flag = true;
		 		System.out.println("Please Enter Valid Username and Password");
		 	}else
		 	flag=false;
		 	System.out.println("");
		}while(flag);
	 	if((Username.equals("Rushi") )|| (Password.equals("Rupesh"))){
	 		
	 		System.out.println("Enter city u want to visit : ");
	 		String []def_arr = {"Delhi","Mumbai","Pune","Chennai","Bangalore"};
	 		for (int i=0; i<def_arr.length; i++)   
				{  
					System.out.println(def_arr[i]);  
				} 
	 		System.out.println("");
	 		System.out.println("");
	 	 	enteredCity=sc.next();  
	 	 	
	 		System.out.println("Entered city is : "+enteredCity);
	 		System.out.println();
//	 		while(i!=3)
//	 		{
//	 		switch(enteredCity)
//	 		{
//	 			default :
//	 			{
	 				int i = 0;
	 				System.out.println("Welcome to:"+enteredCity);
	 				String Service[] = {"City_Information","Available_Hotels","Shopping_Places","exit"};
	 				int ServiceID ;
	 				boolean temp = false;
	 				do {
	 				System.out.println();
	 				System.out.println("Choose Service");
	 				
	 				for ( i=0; i<Service.length; i++)   
	 				{  
	 					System.out.println(i+" "+Service[i]);  
	 				} 
	 				 ServiceID = sc.nextInt(); 
	 				CityInformation ci = new CityInformation();
	 				//System.out.println("ServiceID"+ServiceID);
	 				
	 				switch(ServiceID)
	 				{
	 				
	 				case 0 :
	 				{
	 					//System.out.println("City_Information");
	 					temp = true;
	 					System.out.println(enteredCity);
	 					String Information = ci.GetCityInformation(enteredCity);
	 					System.out.println(Information);
	 					break;
	 				}
	 				case 1 :
	 				{
     					
//	 					System.out.println();
	 					//temp = true;
	 					String[] AvailableHotels = ci.GetAvailableHotels(enteredCity);
//	 					for ( i=0; i<AvailableHotels.length; i++)   
//	 					{  
//	 						System.out.println(AvailableHotels[i]);  
//	 					} 
//	 					System.out.println("Choose Hotel");
	 					
	 					for ( i=1; i<AvailableHotels.length; i++)   
	 					{  
	 						System.out.println(i+" "+AvailableHotels[i]);  
	 					}
	 					System.out.println("Please Choose Hotel");
	 					int hotelListID = sc.nextInt();
//	 					String cityName = sc.next();
	 					Details hi = new Details();
//	 					String hotelInfo = hi.getHotelInfo(hotelName);
//	 					hi.getContactDetail(cityName);
//	 					hi.getHotelMenuList();
//	 					hi.getVacantRoomAvail();
//	 					
//	 					System.out.println("hotelListID"+hotelListID);
//	 				
//	 					String Info = hi.getHotelInfo(hotelListID,enteredCity);
//	 					System.out.println(Info);
////	 					========================================================
//	 					System.out.println("MenuList of ERos");
//	 					int hotelListId = sc.nextInt();
//	 					
//	 					String Menu = hi.getHotelMenuList(hi.hotelMenuList,enteredCity);
//	 					System.out.println(Menu);
	 					 //ServiceID = sc.nextInt(); 
	 					 //System.out.println("ServiceID "+ServiceID);
	 					
	 					
	 					
	 					 //Add method like GetHotelInformation,GetHotelMenuList,GetNumberOfVaccentRoomAvailable,GetHotelContactDetails,
	 					break;
	 				}
	 				case 2 : {
	 					temp = true;
	 					String[] ShoppingPlaces = ci.GetShoppingPlaces(enteredCity);
	 					for( i=1; i<ShoppingPlaces.length; i++) {
	 						System.out.println(i+" "+ShoppingPlaces[i]);
	 					}
	 					break;
	 				}
	 				case 3 :{
	 					temp = true;
	 					//flag=false;
	 					System.exit(0);
	 					System.out.println("Exit");
	 				}
	 				default:
	 					System.out.println("Service not available");
	 				}
	 				}while(temp);
	 				//System.out.println("ServiceID"+ServiceID);
	 			}
	 	}
	 		

		
	//}
//}
		//System.out.println("");
	//}
}
