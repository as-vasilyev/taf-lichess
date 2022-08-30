package by.itacademy.alexey_vasilyev.lichess.ui.steps;

import by.itacademy.alexey_vasilyev.lichess.ui.page.IndexPage;

public class IndexPageSteps {
    public static void navigateToLoginForm(){
        IndexPage indexPage = new IndexPage();
        indexPage.buttonLoginClick();
    }
}
