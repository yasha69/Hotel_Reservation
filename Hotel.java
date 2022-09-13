package HotelReservation;

    public class Hotel {

        private String hotelName;
        private int rating;
        private double weekDayRate;
        private double weekendRate;
        private double weekdayRewardCustomerRate;
        private double weekendRewardCustomerRate;
        public Hotel() {
        }

        public Hotel(String hotelName, int rating, double weekDayRate, double weekendRate,double weekdayRewardCustomerRate,double weekendRewardCustomerRate) {
            this.hotelName = hotelName;
            this.rating = rating;
            this.weekDayRate = weekDayRate;
            this.weekendRate=weekendRate;
            this.weekdayRewardCustomerRate=weekdayRewardCustomerRate;
            this.weekendRewardCustomerRate=weekendRewardCustomerRate;
        }
        
}
