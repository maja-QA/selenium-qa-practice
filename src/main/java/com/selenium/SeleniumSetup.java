package com.selenium;

public class SeleniumSetup extends SeleniumInteractions {

    public static String logMeIn() {
        clickOn("//*[@id=\"mat-input-0\"]");
        typeIn("//*[@id=\"mat-input-0\"]", "workshop.admin");
        typeIn("//*[@id=\"mat-input-1\"]", "Test123#");
        clickOn("/html/body/app-root/div/main/app-login-page/section/div/div[3]/form/mat-card/mat-card-actions/button");
        waitFor(3);
        clickOn("/html/body/app-root/div/main/app-core-page/mat-drawer-container/mat-drawer-content/header/div/button");
        waitFor(2);
        return getText("/html/body/app-root/div/main/app-core-page/mat-drawer-container/mat-drawer/div/div[2]/span[1]");
    }

    public static String customerIntakeFormIsOpened() {
        clickOn("/html/body/app-root/div/main/app-core-page/mat-drawer-container/mat-drawer-content/div/app-organization-home-page/section[2]/article[1]/a");
        return getText("//*[@id=\"cdk-stepper-0-content-0\"]/div/div/div/p[2]");
    }

    public static void customerIntakeAcceptsAllValidInput(
            String fullName,
            String phoneNumber,
            String email,
            String address
    ) {
        typeIn("//*[@id=\"mat-input-2\"]", fullName);
        typeIn("//*[@id=\"mat-input-3\"]", phoneNumber);
        typeIn("//*[@id=\"mat-input-4\"]", email);
        typeIn("//*[@id=\"mat-input-5\"]", address);
        waitFor(3);
        scrollToElement("//*[@id=\"cdk-stepper-0-content-0\"]/div/form/div/button");
        clickOn("//*[@id=\"cdk-stepper-0-content-0\"]/div/form/div/button");
        waitFor(3);
        clickOn("//*[@id=\"cdk-stepper-0-label-1\"]");
        waitFor(2);
    }


    public static boolean userIsNavigatedOnTheCarFormPage() {
        return isDisplayed("//*[@id=\"cdk-stepper-0-content-1\"]/div/div/span/mat-icon");
    }

    public static String carFormAcceptsValidInput(
            String make,
            String model,
            String year,
            String plate,
            String vin,
            String mileage) {


        typeIn("//*[@id=\"mat-input-7\"]", make);
        typeIn("//*[@id=\"mat-input-8\"]", model);
        clear("//*[@id=\"mat-input-9\"]");
        typeIn("//*[@id=\"mat-input-9\"]", year);
        typeIn("//*[@id=\"mat-input-10\"]", plate);
        typeIn("//*[@id=\"mat-input-11\"]", vin);
        clickOn("//*[@id=\"mat-select-value-0\"]/span");
        clickOn("//*[@id=\"mat-select-0\"]");
        clickOn("//*[@id=\"mat-option-3\"]");
        clear("//*[@id=\"mat-input-12\"]");
        typeIn("//*[@id=\"mat-input-12\"]", mileage);
        scrollToElement("//*[@id=\"cdk-stepper-0-content-1\"]/div/form/div[3]/button[2]");
        clickOn("//*[@id=\"cdk-stepper-0-content-1\"]/div/form/div[3]/button[2]");
        waitFor(2);
        clickOn("//*[@id=\"cdk-stepper-0-label-2\"]");
        clickOn("//*[@id=\"cdk-stepper-0-content-2\"]/div/div[3]/button[3]");
        waitFor(3);
        return getText("//*[@id=\"cdk-stepper-0-content-0\"]/div/div/div/p[2]");
    }

}
