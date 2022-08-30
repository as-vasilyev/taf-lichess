package by.itacademy.alexey_vasilyev.lichess.ui.steps;

import by.itacademy.alexey_vasilyev.lichess.ui.page.AuthenticationPage;

public class AuthenticationPageSteps {
    public static void Authorize(AuthenticationPage authenticationPage,String username, String password){
        authenticationPage.typeUsername(username)
                .typePassword(password)
                .buttonSubmitClick();
    }
}
