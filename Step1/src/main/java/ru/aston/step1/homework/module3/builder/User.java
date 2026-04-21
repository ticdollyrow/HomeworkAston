package ru.aston.step1.homework.module3.builder;


public class User {
    private String name;
    private String password;
    private String phone;
    private String email;

    private User(UserBuilder builder){
        this.name = builder.name;
        this.password = builder.password;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class UserBuilder{
        private String name;
        private String password;
        private String phone;
        private String email;

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
