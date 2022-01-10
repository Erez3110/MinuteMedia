package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class webFlows extends commonOps
{
    @Step("Fill a Form")
    public static void fillForm(String name,
                                String company,
                                String email,
                                String phone,
                                String inquiry,
                                String heard,
                                String message)
    {
        uiActions.scrollIntoView(contactUs_minuteMedia.fullName_txt);
        uiActions.updateText(contactUs_minuteMedia.fullName_txt, name);

        uiActions.updateText(contactUs_minuteMedia.companyName_txt, company);

        uiActions.updateText(contactUs_minuteMedia.email_txt, email);

        uiActions.scrollIntoView(contactUs_minuteMedia.phoneNum_txt);
        uiActions.updateText(contactUs_minuteMedia.phoneNum_txt, phone);

        uiActions.updateDropDown(contactUs_minuteMedia.Inquiries_dropdown, inquiry);

        uiActions.scrollIntoView(contactUs_minuteMedia.heardFrom_txt);
        uiActions.updateText(contactUs_minuteMedia.heardFrom_txt, heard);

        uiActions.scrollIntoView(contactUs_minuteMedia.message_txt);
        uiActions.updateText(contactUs_minuteMedia.message_txt, message);
    }
}
