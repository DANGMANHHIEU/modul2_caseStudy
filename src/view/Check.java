package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {


        private static final String email="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        private static final String phone="^\\(\\+84\\)-\\(\\d{9}\\)$";
        private static final String id="^SV\\d{6}$";
        private static final String name="^[a-zA-Z\\p{L}' ]{2,}(\\s[a-zA-Z\\p{L}' ]{2,})+$";
        private static final String password="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        public Check(){
        }

        public boolean checkPassword(String regex){
            Pattern pattern=Pattern.compile(password);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }

        public boolean checkName(String regex){
            Pattern pattern=Pattern.compile(name);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }
        public boolean checkId(String regex){
            Pattern pattern= Pattern.compile(id);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }

        public boolean checkEmail(String regex){
            Pattern pattern = Pattern.compile(email);
         Matcher matcher= pattern.matcher(regex);
            return matcher.matches();
        }

        public boolean checkPhone(String regex){
            Pattern pattern =Pattern.compile(phone);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }

    }

