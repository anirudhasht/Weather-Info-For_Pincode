🌦️ Weather Info For Pincode API

A Spring Boot backend application that fetches real-time weather information using Indian pincodes, integrates with an external weather API, stores results in PostgreSQL, and exposes clean REST endpoints for accessing weather data.

📌 Features

✅ Get weather details using pincode-based search

✅ External Weather API integration

✅ Stores weather data in PostgreSQL

✅ Clean layered architecture
(Controller → Service → Client → Repository)

✅ Environment variable–based configuration (secure)

✅ RESTful API design

🧱 Tech Stack

Java 21

Spring Boot 3

Spring Data JPA

PostgreSQL

Maven

External Weather API

REST APIs

📂 Project Structure
controller/
service/
repository/
entity/
dto/
client/
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


Update properties if required inside:

src/main/resources/application.properties

4️⃣ Run the Application

Using Maven:

mvn spring-boot:run


OR run directly from IDE:

WeatherInfoForPincodeApplication.java


Server starts at:

http://localhost:8086

📡 API Endpoints
🌍 Get Weather By Pincode
POST /api/getWeather

Example Request
{
  "pinCode": "560085",
  "forDate": "2025-03-12T10:00:00"
}

Example Response
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

🔐 Environment Variables Used
DB_PASSWORD
WEATHER_API_KEY

📄 Postman API Documentation

Interactive API documentation is available here:

👉 https://documenter.getpostman.com/view/43458909/2sBXcBnhGh

Includes:

Ready-to-use requests

Example responses

Endpoint descriptions

👨‍💻 Author

Anirudh Ashrit

GitHub: https://github.com/anirudhasht
