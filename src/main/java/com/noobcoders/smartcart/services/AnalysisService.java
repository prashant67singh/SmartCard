package com.noobcoders.smartcart.services;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.repository.UserTravelHistoryRepo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AnalysisService {

    private final UserTravelHistoryRepo travelHistoryRepo;
    private final String[] week = {"", "sun", "mon", "tue", "wed", "thu", "fri", "sat"};

    public AnalysisService(UserTravelHistoryRepo travelHistoryRepo) {
        this.travelHistoryRepo = travelHistoryRepo;
    }

    // Analysis 1 : for Total time spend for travel per day weekly
    public HashMap<String, Object> getAnalysis1() {
        HashMap<String, Object> map = new HashMap<>();
        for (int day_of_week = 1; day_of_week <= 7; day_of_week++) {
            map.put(week[day_of_week], travelHistoryRepo.getAnalysis1(day_of_week));
        }
        return map;
    }

    public HashMap<String, Object> getAnalysis1(User user) {
        HashMap<String, Object> map = new HashMap<>();
        for (int day_of_week = 1; day_of_week <= 7; day_of_week++) {
            map.put(week[day_of_week], travelHistoryRepo.getAnalysis1(user, day_of_week));
        }
        return map;
    }

    // Analysis 2 :
    public HashMap<String, Object> getAnalysis2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Metro", travelHistoryRepo.getAnalysis2("Metro"));
        map.put("Bus", travelHistoryRepo.getAnalysis2("Bus"));
        return map;
    }

    public HashMap<String, Object> getAnalysis2(User user) {
        HashMap<String, Object> map = new HashMap<>();

        return map;
    }

    // Analysis 3 :
    public HashMap<String, Object> getAnalysis3() {
        HashMap<String, Object> map = new HashMap<>();

        return map;
    }

    public HashMap<String, Object> getAnalysis3(User user) {
        HashMap<String, Object> map = new HashMap<>();

        return map;
    }

}
