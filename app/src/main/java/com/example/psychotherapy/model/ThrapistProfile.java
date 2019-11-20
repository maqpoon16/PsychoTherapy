package com.example.psychotherapy.model;

public class ThrapistProfile {

    public String Age;
    public String Experience;
    public String Location;
    public String Name;
    public String Qualification;
    public String Status;

        public ThrapistProfile() {
        }

        public ThrapistProfile(String age, String experience, String location, String name, String qualification, String status) {
            this.Age = age;
            this.Experience = experience;
            this.Location = location;
            this.Name = name;
            this.Qualification = qualification;
            this.Status = status;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String age) {
            this.Age = age;
        }

        public String getExperience() {
            return Experience;
        }

        public void setExperience(String experience) {
            this.Experience = experience;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String location) {
            this.Location = location;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getQualification() {
            return Qualification;
        }

        public void setQualification(String qualification) {
            this.Qualification = qualification;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            this.Status = status;
        }
}
