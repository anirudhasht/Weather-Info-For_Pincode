# 🌤️ Weather Info For Pincode API

A Spring Boot backend application that fetches real-time weather information using Indian pincodes, converts pincode to geo-coordinates, integrates with an external Weather API, stores results in PostgreSQL, and exposes REST APIs for querying weather data.

📌 Features

✅ Fetch weather data using Indian Pincode
✅ External Weather API integration
✅ Convert Pincode → Latitude/Longitude
✅ Store weather data in PostgreSQL database
✅ Clean layered architecture (Controller → Service → Client → Repository)
✅ Optimized API usage (Avoid unnecessary external calls)
✅ Environment variable based secrets (secure)
✅ Unit Testing with Mockito & JUnit
✅ Postman API Collection ready

🧱 Tech Stack

Java 21

Spring Boot 3

Spring Data JPA

PostgreSQL

Maven

OpenWeather API

JUnit + Mockito

📂 Project Structure
controller/
service/
client/
repository/
entity/
dto/
config/

⚙️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/anirudhasht/Weather-Info-For_Pincode.git
cd Weather-Info-For_Pincode

2️⃣ Configure Environment Variables

⚠️ Secrets are NOT stored in the repository.

Windows PowerShell
$env:DB_PASSWORD="your_db_password"
$env:WEATHER_API_KEY="your_api_key"

CMD
set DB_PASSWORD=your_db_password
set WEATHER_API_KEY=your_api_key

Mac/Linux
export DB_PASSWORD=your_db_password
export WEATHER_API_KEY=your_api_key

3️⃣ Configure PostgreSQL

Create database:

weather_db


Update configuration if needed:

src/main/resources/application.properties

4️⃣ Run the Application

Using Maven:

mvn spring-boot:run


OR run from IDE:

WeatherInfoForPincodeApplication.java


Server runs at:

http://localhost:8086

📡 API Endpoints
🌍 Get Weather By Pincode
POST /api/getWeather


Example Request:

{
  "pinCode": "560085",
  "forDate": "2025-03-12T10:00:00"
}


Example Response:

{
  "id": 8,
  "pinCode": "560085",
  "forDate": "2025-03-12T10:00:00",
  "temp": 295.43,
  "humidity": 63.0,
  "windSpeed": 3.6,
  "condition": "Clear",
  "description": "clear sky",
  "fetchedAt": "2026-02-13T22:55:29.1657424"
}

🧪 Running Tests
mvn test


Includes:

Service layer unit tests

Mocked external API validation

Optimized API call verification

🔐 Security Notes

Secrets are NOT stored in repository.

Environment variables used:

DB_PASSWORD
WEATHER_API_KEY

📄 Postman Documentation

👉 https://documenter.getpostman.com/view/43458909/2sBXcBnhGh

👨‍💻 Author

Anirudh Ashrit

GitHub: https://github.com/anirudhasht
