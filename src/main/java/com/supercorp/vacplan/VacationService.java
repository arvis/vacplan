package com.supercorp.vacplan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VacationService {

    private List<Vacation> vacationList;

    VacationService() {
        vacationList = new ArrayList<Vacation>();
    }

    public List<Vacation> allVacations() {
        return vacationList;
    }

    public Vacation getVacation(long vacationId) {
        return vacationList.get(0);
    }

    public void addVacation(Vacation vacation) {
        vacationList.add(vacation);
    }

    public void addVacationFromRequest(VacationInput vacationInput)  {
        SimpleDateFormat formatter
                = new SimpleDateFormat("yyyy-MM-dd");

        Vacation vacation = new Vacation(1, new User(vacationInput.getUserId(), "dummy"));

        try {
            vacation.setStartDate(formatter.parse(vacationInput.getStartDate()));
            vacation.setEndDate(formatter.parse(vacationInput.getStartDate()));
            addVacation(vacation);
        } catch (ParseException e) {
            //TODO: thow bad request
            e.printStackTrace();
        }
    }


}
