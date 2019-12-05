<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Details</title>
</head>
<body>
    <h2>Flight Details:</h2>

    Airlines: ${reservation.flight.operatingAirlines}<br>
    Flight No: ${reservation.flight.flightNumber}<br>
    Departure City: ${reservation.flight.departureCity}<br>
    Arrival City: ${reservation.flight.arrivalCity}<br>
    Date Of Departure: ${reservation.flight.dateOfDeparture}<br>
    Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}

    <h2>Passenger Details</h2>

    First Name: ${reservation.passenger.firstName}<br>
    Last Name: ${reservation.passenger.lastName}<br>
    Email: ${reservation.passenger.email}<br>
    Phone: ${reservation.passenger.phone}<br>

    <form action="completeCheckIn" method="post">
        Enter Number Of Bags you want to checkin :<input type="text" name="numberOfBags"><br>
        <input type="hidden" value="${reservation.id}" name="reservationIdcomp"><br>
        <input type="submit" value="Check In">
    </form>



</body>
</html>
