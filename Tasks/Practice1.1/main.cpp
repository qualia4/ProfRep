#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <limits>
#include <sstream>

// Function to find the largest negative number in a list
double findLargestNegative(const std::vector<double>& numbers) {
    double largest = -std::numeric_limits<double>::infinity();
    bool foundNegative = false;

    for (double num : numbers) {
        if (num < 0 && num > largest) {
            largest = num;
            foundNegative = true;
        }
    }

    return foundNegative ? largest : 0;
}

// Function to calculate roots of a quadratic equation
void quadraticRoots(double a, double b, double c) {
    double discriminant = b * b - 4 * a * c;

    if (discriminant > 0) {
        double root1 = (-b + std::sqrt(discriminant)) / (2 * a);
        double root2 = (-b - std::sqrt(discriminant)) / (2 * a);
        std::cout << "Two distinct real roots: " << root1 << " and " << root2 << std::endl;
    } else if (discriminant == 0) {
        double root = -b / (2 * a);
        std::cout << "One real root: " << root << std::endl;
    } else {
        double realPart = -b / (2 * a);
        double imaginaryPart = std::sqrt(-discriminant) / (2 * a);
        std::cout << "Two complex roots: " << std::endl;
        std::cout << realPart << " + " << imaginaryPart << "i" << std::endl;
        std::cout << realPart << " - " << imaginaryPart << "i" << std::endl;
    }
}

void handleLargestNumberRequest() {
    std::vector<double> numbers;
    std::string inputLine;
    
    std::cout << "Enter numbers separated by spaces: ";
    std::cin.ignore(); // Clear the input buffer
    std::getline(std::cin, inputLine);
    
    std::stringstream ss(inputLine);
    double num;
    while (ss >> num) {
        numbers.push_back(num);
    }
    
    double result = findLargestNegative(numbers);
    if (result < 0) {
        std::cout << "The largest negative number is: " << result << std::endl;
    } else {
        std::cout << "No negative numbers found." << std::endl;
    }
}

void handleQuadraticRootsRequest() {
    double a, b, c;
    std::cout << "Enter coefficients a, b, and c for ax^2 + bx + c:" << std::endl;
    std::cout << "a: ";
    std::cin >> a;
    std::cout << "b: ";
    std::cin >> b;
    std::cout << "c: ";
    std::cin >> c;
    quadraticRoots(a, b, c);
}

int main() {
    int choice;
    bool ended = false;
    while (!ended) {
        std::cout << "Choose an operation:" << std::endl;
        std::cout << "1. Find largest negative number" << std::endl;
        std::cout << "2. Calculate quadratic equation roots" << std::endl;
        std::cout << "Or anything else to close the app" << std::endl;
        std::cout << "Enter your choice (1 or 2): ";
        std::cin >> choice;

        if (choice == 1) {
            handleLargestNumberRequest();
        } else if (choice == 2) {
            handleQuadraticRootsRequest();
        } else {
            ended = true;
            std::cout << "Program ended" << std::endl;
        }
    }

    return 0;
}
