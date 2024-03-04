package org.example;

public class Park {

    private String designation;

    public Park(String designation) {

        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public class Attractions {
        public String name;
        public String timetable;
        public double price;

        public Attractions(String name, String timetable, double price) {
            this.name = name;
            this.timetable = timetable;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTimetable() {
            return timetable;
        }

        public void setTimetable(String timetable) {
            this.timetable = timetable;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
