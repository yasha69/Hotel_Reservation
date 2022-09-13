package HotelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservationSystem {
    List<Hotel> hotelReservation = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public void addHotel() {
        Hotel hotel1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel hotel2 = new Hotel("Bridgewood", 4, 160, 60, 110, 50);
        Hotel hotel3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        hotelReservation.add(hotel1);
        hotelReservation.add(hotel2);
        hotelReservation.add(hotel3);
    }
    public void findCheapestHotelForWeekDay() {
        System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth()+1;
        List<Hotel> cheapestHotel = hotelReservation.stream().sorted(Comparator.comparing(Hotel::getWeekDayRate)).collect(Collectors.toList());
        System.out.println(" The cheapest hotel is " + cheapestHotel.get(0).getHotelName() + ", Rating : " + cheapestHotel.get(0).getRating() + ", Total Rates = $" + cheapestHotel.get(0).getWeekDayRate() * totalDays);
    }
    public void findCheapestHotelForWeekend() {
        System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth()+1;
        List<Hotel> cheapestHotel = hotelReservation.stream().sorted(Comparator.comparing(Hotel::getWeekendRate)).collect(Collectors.toList());
        System.out.println(" The cheapest hotel for weekend is " + cheapestHotel.get(0).getHotelName() + ", Rating : " + cheapestHotel.get(0).getRating() + ", Total Rates = $" + cheapestHotel.get(0).getWeekendRate() * totalDays);
    }
    public void findBestRatedHotel() {
        System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
        List<Hotel> cheapestHotel = hotelReservation.stream().sorted(Comparator.comparing(Hotel::getRating).reversed()).collect(Collectors.toList());
        System.out.println(" The cheapest Best rated hotel is " + cheapestHotel.get(0).getHotelName() + ", Rating : " + cheapestHotel.get(0).getRating() + ", Total Rates = $" + cheapestHotel.get(0).getWeekDayRate() * totalDays);
    }
    public void findHotelBestRatingForReward() {
        System.out.println("Enter 1 for regular customer and 2 for Reward customer");
        int num = sc.nextInt();
        System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        if (num == 1) {
            LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
            List<Hotel> cheapestHotel = hotelReservation.stream().sorted(Comparator.comparing(Hotel::getRating).reversed()).collect(Collectors.toList());
            System.out.println(" The cheapest Best rated hotel is " + cheapestHotel.get(0).getHotelName() + ", Rating : " + cheapestHotel.get(0).getRating() + ", Total Rates = $" + cheapestHotel.get(0).getWeekDayRate() * totalDays);
        } else if(num==2) {
            LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
            List<Hotel> cheapestHotel = hotelReservation.stream().sorted(Comparator.comparing(Hotel::getRating).reversed().thenComparing(Hotel::getWeekDayRewardRate)).collect(Collectors.toList());
            System.out.println(" The cheapest Best rated hotel is " + cheapestHotel.get(0).getHotelName() + ", Rating : " + cheapestHotel.get(0).getRating() + ", Total Rates = $" + cheapestHotel.get(0).getWeekDayRewardRate() * totalDays);
        }else{
            System.out.println("please enter given number");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservationSystem hotel = new HotelReservationSystem();
        hotel.addHotel();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Cheapest hotel for Weekday.\n2.Cheapest hotel for weekend.\n3.Best rated hotel.\n4.Best rated and reward.\n5.Exit");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    hotel.findCheapestHotelForWeekDay();
                    break;
                case 2:
                    hotel.findCheapestHotelForWeekend();
                    break;
                case 3:
                    hotel.findBestRatedHotel();
                    break;
                case 4:
                    hotel.findHotelBestRatingForReward();
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("You Entered Incorrect Choice....!");
                    break;
            }
        }
    }
}
