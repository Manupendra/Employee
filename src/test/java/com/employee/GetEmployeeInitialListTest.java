package com.employee;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class GetEmployeeInitialListTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


//    @Test
//    public void getEmployeeListTest() throws JSONException {
//        String url = "http://localhost:"+port+"/employees/get";
//        JSONObject getEmployee = new JSONObject();
//        getEmployee.get("{\n" +
//                "\t\"employeeList\": [\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": 1,\n" +
//                "\t\t\t\"firstName\": \"Prem\",\n" +
//                "\t\t\t\"lastName\": \"Tiwari\",\n" +
//                "\t\t\t\"email\": \"chapradreams@gmail.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": 2,\n" +
//                "\t\t\t\"firstName\": \"Vikash\",\n" +
//                "\t\t\t\"lastName\": \"Kumar\",\n" +
//                "\t\t\t\"email\": \"abc@gmail.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": 3,\n" +
//                "\t\t\t\"firstName\": \"Ritesh\",\n" +
//                "\t\t\t\"lastName\": \"Ojha\",\n" +
//                "\t\t\t\"email\": \"asdjf@gmail.com\"\n" +
//                "\t\t}\n" +
//                "\t]\n" +
//                "}");
//        JSONAssert.assertEquals(getEmployee.toString(),testRestTemplate.getForObject(url,String.class),true);
//    }
}
