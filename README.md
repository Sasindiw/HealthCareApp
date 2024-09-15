# Doc-Connect Healthcare Application

## Project Objective
The goal of this project is to implement core Object-Oriented Programming (OOP) principles to design a specific functionality of a healthcare application for patient management.

## Core Functionalities
- **Doctor Availability Management**: 
  - Doctors can input their availability (day, month, year) for appointments. By default, the system assumes doctors are available from 5 PM to 10 PM if a specific time is not provided.
  - The system will support different availability slots for various dates and times.
  
- **Appointment Slots**: 
  - Two types of appointments: General and Referral.
  - Appointments are scheduled at 1-hour intervals.
  - Slots are dynamically calculated based on the doctor's availability.
  
- **Patient Booking**: 
  - Patients can select a doctor and desired appointment date from a list of available time slots.
  - The system prevents multiple bookings for the same time slot.
  
- **Slot Time Calculation**: 
  - The system calculates the next available slot dynamically with 30-minute increments for each booked appointment.
  
- **Doctor and Patient Information**: 
  - Doctors can view a list of registered doctors and their patients' scheduled appointments for a specific date.

## Technologies Used
- **Java**: Core programming language.
- **IDE**: Eclipse, IntelliJ IDEA.
