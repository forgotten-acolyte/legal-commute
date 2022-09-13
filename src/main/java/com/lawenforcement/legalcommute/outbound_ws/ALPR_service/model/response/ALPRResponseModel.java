package com.lawenforcement.legalcommute.outbound_ws.ALPR_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
public class ALPRResponseModel {

    private double processing_time;
    private ArrayList<Result> results;
    private String filename;
    private int version;
    private Object camera_id;
    private Date timestamp;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Jacksonized
    private static class Box{
        private int xmin;
        private int ymin;
        private int xmax;
        private int ymax;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Jacksonized
    private static class Candidate{
        private double score;
        private String plate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Jacksonized
    private static class Region{
        private String code;
        private double score;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Jacksonized
    private static class Result{
        private Box box;
        private String plate;
        private Region region;
        private double score;
        private ArrayList<Candidate> candidates;
        private double dscore;
        private Vehicle vehicle;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Jacksonized
    private static class Vehicle{
        private double score;
        private String type;
        private Box box;
    }


}
