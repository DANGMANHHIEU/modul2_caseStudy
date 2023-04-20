package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {


        private static final String email="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        private static final String phone="^\\(\\+84\\)-\\(\\d{9}\\)$";
        private static final String id="^SV\\d{6}$";
        public Check(){
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

