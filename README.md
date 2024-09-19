# CineSuggest

CineSuggest is a sleek and intuitive movie suggestion app that helps users discover popular and upcoming movies. Whether you're in the mood for a blockbuster hit or curious about what's coming soon to theaters, CineSuggest has you covered!

## Features

- **Popular Movies**: Get a list of the most popular movies based on trending data.
- **Upcoming Movies**: Stay ahead with a curated list of movies that will hit theaters soon.
- **Movie Details**: View detailed information about each movie including synopsis, release date, genre, and more.
- **User-Friendly Interface**: Clean and simple UI for seamless movie browsing.
- **Offline Use**: This app, once loaded can also be used offine to view and explore movies. 


### Built With

- **Jetpack Compose** - For building the UI declaratively.
- **Kotlin** - Primary language for the app.
- **TMDb API** - The Movie Database API for fetching movie data (optional, add this based on your API).
- **Retrofit** - This Libary is used for API Calls.
- **Dagger Hilt** - This Libary is used for Dependency Injection.
- **Room Database** - Room Database is used to provide offine movie discovering exprience. 

## Usage

1. **Discover Popular Movies**:
    - On launch, the app displays a list of trending and popular movies.
    
2. **Browse Upcoming Releases**:
    - Navigate to the upcoming section to see movies that will be released soon.

3. **View Movie Details**:
    - Tap on a movie to get detailed information, including its release date, synopsis, and more.


## Screenshots

<img src="https://github.com/user-attachments/assets/acfcb9fd-709b-4f56-8b06-c65835ed8685" alt="App Screenshot" width="400"/>

<img src="https://github.com/user-attachments/assets/f64069af-5504-474e-b654-8d983fa1224b" alt="App Screenshot" width="400"/>

<img src="https://github.com/user-attachments/assets/eed5a9de-71b0-415e-9aec-b91045b83373" alt="App Screenshot" width="400"/>



# Contributing

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Android Studio or a compatible IDE
- JDK 8+
- Gradle 7.x.x (usually bundled with Android Studio)

### Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/yourusername/cinesuggest.git
    ```

2. Open the project in Android Studio:

    - Go to **File > Open**, and navigate to the project directory.

3. Sync the Gradle files:

    - Once the project is opened, Android Studio will prompt you to sync the Gradle files. Click **Sync Now**.

4. Run the app:

    - Choose an Android Virtual Device (AVD) or connect a physical device, and click the **Run** button in Android Studio.



## API Integration

CineSuggest uses the [TMDb API](https://www.themoviedb.org/documentation/api) to fetch movie data. To use the API, follow these steps:

1. Sign up for an API key from TMDb.
2. Add your API key in the app's configuration file. Example:

    ```kotlin
    const val API_KEY = "your_api_key_here"
    ```


Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
