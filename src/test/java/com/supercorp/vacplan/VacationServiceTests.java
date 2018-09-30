package com.supercorp.vacplan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class VacationServiceTests {

    @Test
    public void dateParsing() throws ParseException, JsonProcessingException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "2018-10-01";
        Date date = df.parse(toParse);

        VacationInput input = new VacationInput(1, toParse ,toParse);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(input);

        System.out.println(result);
        assertThat(result, containsString(toParse));
    }


}
