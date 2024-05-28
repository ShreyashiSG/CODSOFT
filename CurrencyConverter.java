package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Converter 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Currency Selection
        System.out.println("Currency Converter");
        System.out.println("Select base currency (e.g., USD, EUR, GBP):");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Select target currency (e.g., USD, EUR, GBP):");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Currency Rates
        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        // Amount Input
        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        // Currency Conversion
        double convertedAmount = convertCurrency(amount, exchangeRate);

        // Display Result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }

    // Method to fetch exchange rate from a reliable API
    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            String apiKey = "YOUR_API_KEY"; // Replace this with your API key
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parsing JSON response
                String jsonResponse = response.toString();
                double exchangeRate = Double.parseDouble(jsonResponse
                        .split("\"" + targetCurrency + "\":")[1]
                        .split(",")[0]);

                return exchangeRate;
            } else {
                System.out.println("Error: Unable to fetch exchange rate. HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return 0.0;
    }

    // Method to convert currency
    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}

/*

OUTPUT: 

Currency Converter
Select base currency (e.g., USD, EUR, GBP):
USD
Select target currency (e.g., USD, EUR, GBP):
INR
Enter the amount to convert:
100
Converted amount: 8315.0 INR

*/
