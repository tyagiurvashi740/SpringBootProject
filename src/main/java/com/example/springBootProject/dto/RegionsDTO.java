package com.example.springBootProject.dto;

import java.util.HashMap;
import java.util.List;

public class RegionsDTO {

    private List<Countries> countries;

    static class Countries {
        private int id;
        private String country;
        private List<States> states;
    }

       static  class States{
        private int id;
        private String state;

        }

        HashMap<String,String> country; //1,India   2,USA
        HashMap<String,String> states;  //1,Delhi    2,28 states


    }

