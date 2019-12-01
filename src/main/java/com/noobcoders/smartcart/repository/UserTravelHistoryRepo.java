package com.noobcoders.smartcart.repository;

import com.noobcoders.smartcart.model.User;
import com.noobcoders.smartcart.model.UserTravelHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserTravelHistoryRepo extends JpaRepository<UserTravelHistory, Integer> {
    List<UserTravelHistory> getAllByUserId(User userId);

    @Query("SELECT SUM (DATEDIFF(minute, travelStartDate, travelEndDate)) From UserTravelHistory where DAYOFWEEK(travelStartDate) = ?1")
    Long getAnalysis1(Integer day);

    @Query("SELECT SUM (DATEDIFF(minute, travelStartDate, travelEndDate)) From UserTravelHistory where userId = ?1 AND DAYOFWEEK(travelStartDate) = ?2")
    Long getAnalysis1(User user, Integer day);

    @Query("SELECT SUM(his.fare) FROM UserTravelHistory his, Transport t, TransportationMode tm where his.transportId = t.transportId And t.transportationMode = tm.transportId AND tm.transportType = ?1")
    Double getAnalysis2(String transportType);

    @Query("SELECT SUM(his.fare) FROM UserTravelHistory his, Transport t, TransportationMode tm where his.transportId = t.transportId And t.transportationMode = tm.transportId AND tm.transportType = ?2 AND his.userId = ?1")
    Double getAnalysis2(User user, String transportType);
}
