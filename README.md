# Distance and Duration Calculation API

## Overview

This project is a REST API built using Spring Boot that calculates the distance and travel duration between two pin codes by integrating with the Google Maps API. The API also caches responses to optimize performance and reduce external API calls.

### Features
- Fetch distance and duration between two pin codes using Google Maps API.
- Cache responses to avoid repeated calls to Google Maps for the same pincode pair.
- Store route information along with distance and duration in the database.
- Optional: Save pincode details (latitude, longitude, polygon) in the database.
- REST-compliant API (Testable with Postman).
- Test-driven development (TDD) with JUnit.
  
## Prerequisites

- Java 17+
- Maven 3.8+
- Google Maps API Key (you need an API key with access to the Distance Matrix or Directions API)
- MySQL, PostgreSQL, or H2 Database (In-memory or other relational DB)
  
## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/your-username/distance-calculation-api.git
cd distance-calculation-api

