public class Main {
    public static void main(String[] args) {

        //String login = "!01234567899876543210";
        String login = "1_234_56_aA";
        String password = "0123_7";
        String confirmPassword = "0123_7";

        try {
            checkUp(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e){
            e.printStackTrace();
        }



    }
    //массив разрешенных символов
    public  static char[] createArray(){
        char[] arraySymbolsForCheck = new char[123];
        for( int i = 0; i < arraySymbolsForCheck.length; i++){
            if(i < 48) {
                arraySymbolsForCheck[i] = '_';
            } else if (i >57 && i < 65) {
                arraySymbolsForCheck[i] = '_';
            } else if (i > 90 && i <95) {
                arraySymbolsForCheck[i] = '_';
            } else if (i == 96) {
                arraySymbolsForCheck[i] = '_';
            } else arraySymbolsForCheck[i] = (char)(i);
        }
        //System.out.println(arraySymbolsForCheck);
        return arraySymbolsForCheck;
    }

    public static void checkUp(String login, String password, String confirmPassword){
        boolean isCorrectLogin = false;
        boolean isCorrectPassword = false;
        char[] arrCharForCheck = createArray();

        if(login.length() < 20) {
            char[] arrCharLogin = login.toCharArray();
            for (int i = 0; i < arrCharLogin.length; i++) {
                for (int j = 0; j < arrCharForCheck.length; j++) {
                    if (arrCharLogin[i] == arrCharForCheck[j]) {
                        isCorrectLogin = true;
                        break;
                    }
                    isCorrectLogin = false;
                }
                if(!isCorrectLogin) {
                    throw new WrongLoginException("Ошибка. Некорректный символ для Login");
                }
            }
        } else {
            throw new WrongLoginException("Ошибка. Более 20 символов для Login");
        }

        if(password.length() < 20) {
            char[] arrCharPassword = password.toCharArray();
            for (int i = 0; i < arrCharPassword.length; i++) {
                for (int j = 0; j < arrCharForCheck.length; j++) {
                    if (arrCharPassword[i] == arrCharForCheck[j]) {
                        isCorrectPassword = true;
                        break;
                    }
                    isCorrectPassword = false;
                }
                if(!isCorrectPassword) {
                    throw new WrongPasswordException("Ошибка. Некорректный символ для Password");
                }
            }
        } else {
            throw new WrongPasswordException("Ошибка. Более 20 символов для Password");
        }

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Ошибка. Пароль не совпадает");
        }
    }

}