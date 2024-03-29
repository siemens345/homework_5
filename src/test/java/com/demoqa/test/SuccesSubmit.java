package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pageobject.Pageobject;
import com.demoqa.pageobject.components.ResultModal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.pageobject.testData.Data.*;


public class SuccesSubmit {
    public Pageobject pageobject = new Pageobject();
    public ResultModal resultModal = new ResultModal();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillForm() {
        pageobject.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender()
                .setUserNumber(number)
                .setBirthDate(month, year)
                .setSubject(subject)
                .setHobbies()
                .uploadPicture()
                .setCurrentAddress(address)
                .setStateCity(state, city);
        resultModal.checkTitle()
                .checkResult(fullName)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(number)
                .checkResult(birthDate)
                .checkResult(subject)
                .checkResult(hobbies)
                .checkResult(picture)
                .checkResult(address)
                .checkResult(stateCity);

    }


}

