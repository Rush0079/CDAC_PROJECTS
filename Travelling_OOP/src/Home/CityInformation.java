package Home;

interface City {
	public String GetCityInformation(String CityName);
	public String[] GetAvailableHotels(String CityName);
	public String[] GetShoppingPlaces(String CityName);

}
public class CityInformation implements City{
	@Override
	public String GetCityInformation(String CityName) {
		String info="";
		if(CityName.equals("Delhi"))
		{
			System.out.println("==========================================================================================");
			info="New Delhi is the capital of India and a part of the National Capital Territory of Delhi.\nNew Delhi is the seat of all three branches of the government of India, \nhosting the Rashtrapati Bhavan, Parliament House, and the Supreme Court of India";
			return info;
		}else if(CityName.equals("Mumbai"))
		{
			System.out.println("=====================================================================");
			info="Mumbai City District is a district of Maharashtra in Konkan Division. \nAs a city district, it has no headquarters or subdivisions. \nIt, along with the Mumbai Suburban District, makes up the metropolis of Mumbai. \nThe city area is called the \"island city\" or South Mumbai or Old Mumbai.";
			return info;
		}
		else if(CityName.equals("Pune"))
		{
			System.out.println("===================================================================================");
			info="Pune, also called Poona, city, west-central Maharashtra state, western India, \nat the junction of the Mula and Mutha rivers. Called “Queen of the Deccan,” \nPune is the cultural capital of the Maratha peoples. The city first gained \nimportance as the capital of the Bhonsle Marathas in the 17th century.";
			return info;
		}
		else if(CityName.equals("Chennai"))
		{
			System.out.println("===================================================================================");
			info="The state's largest city in area and population as well, Chennai is located on the \nCoromandel Coast of the Bay of Bengal, and is the most prominent cultural, \neconomic and educational centre of South India.";
			return info;
		}
		else if(CityName.equals("Bengalore"))
		{
			System.out.println("========================================================================================");
			info="Located in southern India on the Deccan Plateau, at a height of over 900 m (3,000 ft) \nabove sea level, Bangalore is known for its pleasant climate throughout the year. \nIts elevation is the highest among the major cities of India.";
			return info;
		}
		return "Information Not Available";
	}
	public String[] availableHotel ;
	@Override
	public String[] GetAvailableHotels(String CityName) {
		// TODO Auto-generated method stub
		//String []availableHotel=  new String[5];
		
		if(CityName.equals("Delhi"))
		{
			System.out.println("Delhi hotels are : ");
			System.out.println();
			availableHotel =new String []{"EROS hotel","Hotel Novotel New Delhi Aerocity","The Claridges New Delhi","Radisson Blu Hotel New Delhi(Paschim Vihar)","Pullman New Delhi Aerocity Hotel"};
			return availableHotel;
		}else if(CityName.equals("Mumbai"))
		{
			System.out.println("Mumbai hotels are : ");
			System.out.println();
			availableHotel = new String []{"Grand Hyatt Mumbai Hotel","Four Seasons Hotel","The Oberoi Hotel","TAJ","Sofitel Mumbai BKC"};
			return availableHotel;
		}
		else if(CityName.equals("Pune"))
		{
			System.out.println("Pune hotels are : ");
			System.out.println();
			availableHotel = new String []{"The Ritz-Carlton Pune","JW Marriot,Pune","Conrad,Pune","Hyatt,Pune","JAGDAMBA"};
			return availableHotel;
		}
		else if(CityName.equals("Chennai"))
		{
			System.out.println("Chennai hotels are : ");
			System.out.println();
			availableHotel = new String []{"The Leela Palace,Chennai","Trident Hotel,Chennai","Hablis","The Accord Metropolitan","ITC Grand chola"};
			return availableHotel;
		}
		else if(CityName.equals("Bengalore"))
		{
			System.out.println("Bengalore hotels are : ");
			System.out.println();
			availableHotel = new String []{"The Ritz-Carlton,Bangalore","ITC Windsor","The Leela Palace,Bangalore","The Oberoi,Bangalore","Grand Mercure"};
			return availableHotel;
		}
		
		return new String[0] ;
	}
	@Override
	public String[] GetShoppingPlaces(String CityName) {
		String[] availableShoppingPlaces;
		if(CityName.equals("Delhi")) {
			System.out.println("Delhi shopping places are : ");
			System.out.println();
			availableShoppingPlaces = new String[] {"CITYWALK","DLF Emporio","Pacific Mall","Greater Kailash Market","Janpath Market"};
			return availableShoppingPlaces;
		}
		if(CityName.equals("Mumbai")) {
			System.out.println("Mumbai Shopping places are : ");
			System.out.println();
			availableShoppingPlaces = new String[] {"Oberoi Mall","Pheonix Paradium","Infiniti Mall","R City Mall","CR2"};
			return availableShoppingPlaces;
		}
		if(CityName.equals("Pune")) {
			System.out.println("Pune shopping places are : ");
			System.out.println();
			availableShoppingPlaces = new String[] {"Lifestyles Store","Amanora Mall","The Pavillion","Seasons Mall","S G S Mall"};
			return availableShoppingPlaces;
		}
		if(CityName.equals("Chennai")) {
			System.out.println("Chennai shopping places are : ");
			System.out.println();
			availableShoppingPlaces = new String[] {"Express Avenue","Forum Vijaya Mall","Pheonix Market_city","junk jewellery"};
			return availableShoppingPlaces;
		}
		if(CityName.equals("Bengalore")) {
			System.out.println("Bengalore shopping places are : ");
			System.out.println();
			availableShoppingPlaces = new String[] {"Brigade Road","Dubai Plaza","National Market","Malleswaram"};
			return availableShoppingPlaces;
		}
		return new String[0];
	}
	
}
